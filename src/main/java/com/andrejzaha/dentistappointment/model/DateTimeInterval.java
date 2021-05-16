package com.andrejzaha.dentistappointment.model;

import java.time.LocalDateTime;

public class DateTimeInterval {

    private LocalDateTime start;

    private LocalDateTime end;

    public DateTimeInterval(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return cloneLocalDateTime(this.start);
    }

    public LocalDateTime getEnd() {
        return cloneLocalDateTime(this.end);
    }

    private LocalDateTime cloneLocalDateTime(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime());
    }

}
