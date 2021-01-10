package com.andrejzaha.dentistappointment.service;

import com.andrejzaha.dentistappointment.model.Availability;
import com.andrejzaha.dentistappointment.model.frontend.AvailabilityFront;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AvailabilityService {

    List<AvailabilityFront> getAvailabilitiesForFront(Set<Availability> availabilities,
                                                      int durationInMinutes,
                                                      LocalDate fromDate, LocalDate toDate);

}
