package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.model.PeriodCode;
import com.andrejzaha.dentistappointment.model.frontend.PeriodCodeFront;
import com.andrejzaha.dentistappointment.service.PeriodService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeriodServiceImpl implements PeriodService {

    @Override
    public List<PeriodCodeFront> findAllPeriods() {
        return Arrays.stream(PeriodCode.values())
                .map(this::getPeriodCodeFront)
                .collect(Collectors.toList());
    }

    private PeriodCodeFront getPeriodCodeFront(PeriodCode periodCode) {
        PeriodCodeFront periodCodeFront = new PeriodCodeFront();

        periodCodeFront.setLabel(periodCode.getCode());

        return periodCodeFront;
    }

}
