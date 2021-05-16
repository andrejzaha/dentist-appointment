package com.andrejzaha.dentistappointment.model;

import java.time.LocalDate;

public class DateInterval {
    private LocalDate start;

    private LocalDate end;

    public DateInterval(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return cloneLocalDate(this.start);
    }

    public LocalDate getEnd() {
        return cloneLocalDate(this.end);
    }

    private LocalDate cloneLocalDate(LocalDate localDate) {
        return LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
    }
}
