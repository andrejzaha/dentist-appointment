package com.andrejzaha.dentistappointment.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface TimeMachineService {

    LocalDate getNowLocalDate();

    LocalDateTime getNowLocalDateTime();

}
