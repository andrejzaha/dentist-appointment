package com.andrejzaha.dentistappointment.service;

import com.andrejzaha.dentistappointment.model.DateInterval;
import com.andrejzaha.dentistappointment.model.PeriodCode;

public interface PeriodCodeService {

    DateInterval calculateDateIntervalByPeriodCode(PeriodCode periodCode);

}
