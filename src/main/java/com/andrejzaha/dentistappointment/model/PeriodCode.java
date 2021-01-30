package com.andrejzaha.dentistappointment.model;

public enum PeriodCode {
    A_DAY("A day"),
    THREE_DAYS("Three days"),
    A_WEEK("A week");

    private String code;

    PeriodCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
