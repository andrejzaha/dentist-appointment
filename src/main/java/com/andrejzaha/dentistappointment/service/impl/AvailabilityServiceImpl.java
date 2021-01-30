package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.model.Availability;
import com.andrejzaha.dentistappointment.model.frontend.AvailabilityFront;
import com.andrejzaha.dentistappointment.service.AvailabilityService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    @Override
    public List<AvailabilityFront> getAvailabilitiesForFront(Set<Availability> availabilities,
                                                             int durationInMinutes,
                                                             LocalDate fromDate, LocalDate toDate) {
        List<Availability> sortedAvailabilities = new ArrayList<>(availabilities);
        sortedAvailabilities.sort(Comparator.comparing(Availability::getStartDate));
        return sortedAvailabilities
                .stream()
                .filter(a -> this.isAvailabilityContainedIntoRequiredInterval(a, fromDate, toDate))
                .filter(a -> this.isAvailabilityOfNeededLength(a, durationInMinutes))
                .map(a -> this.transformToAvailabilitiesForFront(a, durationInMinutes))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private boolean isAvailabilityContainedIntoRequiredInterval(Availability a,
                                                                LocalDate fromDate, LocalDate toDate) {
        return Objects.nonNull(a)
                && availabilityDateIsContainedInInterval(a, fromDate, toDate);
    }

    private boolean availabilityDateIsContainedInInterval(Availability a, LocalDate fromDate, LocalDate toDate) {
        return fromDateIsBeforeOrEqualToAvailabilityStartDate(a, fromDate)
                && toDateIsEqualOrAfterAvailabilityEndDate(a, toDate);
    }

    private boolean fromDateIsBeforeOrEqualToAvailabilityStartDate(Availability a, LocalDate fromDate) {
        return fromDate.isBefore(a.getStartDate().toLocalDate())
                || fromDate.equals(a.getStartDate().toLocalDate());
    }

    private boolean toDateIsEqualOrAfterAvailabilityEndDate(Availability a, LocalDate toDate) {
        return toDate.equals(a.getEndDate().toLocalDate())
                || toDate.isAfter(a.getEndDate().toLocalDate());
    }

    private boolean isAvailabilityOfNeededLength(Availability a, int durationInMinutes) {
        return Objects.nonNull(a)
                && Objects.nonNull(a.getStartDate())
                && Objects.nonNull(a.getEndDate())
                && a.getLengthInMinutes() >= durationInMinutes;
    }

    private List<AvailabilityFront> transformToAvailabilitiesForFront(Availability availability,
                                                                      int durationInMinutes) {
        List<AvailabilityFront> result = new ArrayList<>();

        LocalDateTime tempFrom = availability.getStartDate();
        LocalDateTime tempTo = availability
                                .getStartDate()
                                .plus(durationInMinutes, ChronoUnit.MINUTES);

        int count = 1;
        while (tempFrom.isBefore(availability.getEndDate())) {
            result.add(getAvailabilityFront(tempFrom, tempTo));

            tempFrom = LocalDateTime.from(tempTo);
            tempTo = calculateNextIntervalEndDate(availability, durationInMinutes, ++count);
        }

        return result;
    }

    private AvailabilityFront getAvailabilityFront(LocalDateTime tempFrom, LocalDateTime tempTo) {
        AvailabilityFront availabilityFront = new AvailabilityFront();

        availabilityFront.setDayOfWeek(tempFrom.getDayOfWeek().toString());

        availabilityFront.setFormattedDate(getFormattedDate(tempFrom));

        availabilityFront.setFromHour(String.valueOf(tempFrom.getHour()));
        availabilityFront.setFromMinute(String.valueOf(tempFrom.getMinute()));

        availabilityFront.setToHour(String.valueOf(tempTo.getHour()));
        availabilityFront.setToMinute(String.valueOf(tempTo.getMinute()));
        return availabilityFront;
    }

    private String getFormattedDate(LocalDateTime tempFrom) {
        return Objects.nonNull(tempFrom)
                ? tempFrom.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                : "";
    }

    private LocalDateTime calculateNextIntervalEndDate(Availability availability,
                                                       int durationInMinutes,
                                                       int intervalNumber) {
        LocalDateTime localDateTime = availability
                .getStartDate()
                .plus(durationInMinutes * intervalNumber, ChronoUnit.MINUTES);

        return localDateTime.isAfter(availability.getEndDate())
                ? availability.getEndDate()
                : localDateTime;
    }

}
