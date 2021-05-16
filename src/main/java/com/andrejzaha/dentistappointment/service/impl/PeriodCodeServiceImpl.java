package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.model.DateInterval;
import com.andrejzaha.dentistappointment.model.PeriodCode;
import com.andrejzaha.dentistappointment.service.PeriodCodeService;
import com.andrejzaha.dentistappointment.service.TimeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodCodeServiceImpl implements PeriodCodeService {

    @Autowired
    private TimeMachineService timeMachineService;

    @Override
    public DateInterval calculateDateIntervalByPeriodCode(PeriodCode periodCode) {
        return new DateInterval(
                timeMachineService.getNowLocalDate(),
                timeMachineService.getNowLocalDate().plusDays(periodCode.getNbDays())
        );
    }

}
