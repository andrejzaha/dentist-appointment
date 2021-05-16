package com.andrejzaha.dentistappointment.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum PeriodCode {
    A_DAY("A day", 1),
    THREE_DAYS("Three days", 3),
    A_WEEK("A week", 7);

    public static Optional<PeriodCode> getEnumByCode(String code) {
        return Stream.of(values())
                .filter(value -> value.code.equals(code))
                .findFirst();
    }

    private String code;
    private int nbDays;

    PeriodCode(String code, int nbDays) {
        this.code = code;
        this.nbDays = nbDays;
    }

    public String getCode() {
        return this.code;
    }

    public int getNbDays() {
        return this.nbDays;
    }

}
