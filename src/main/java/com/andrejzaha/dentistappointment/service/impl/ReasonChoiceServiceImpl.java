package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.model.frontend.ReasonChoiceModel;
import com.andrejzaha.dentistappointment.service.DoctorService;
import com.andrejzaha.dentistappointment.service.ReasonChoiceService;
import com.andrejzaha.dentistappointment.service.ReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReasonChoiceServiceImpl implements ReasonChoiceService {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ReasonService reasonService;

    @Autowired
    private PeriodServiceImpl periodService;

    @Override
    public ReasonChoiceModel getReasonChoiceModel() {
        ReasonChoiceModel reasonChoiceModel = new ReasonChoiceModel();

        reasonChoiceModel.setDoctors(doctorService.findAllDoctorsForFront());
        reasonChoiceModel.setReasons(reasonService.findAllReasons());
        reasonChoiceModel.setPeriodCodes(periodService.findAllPeriods());

        return reasonChoiceModel;
    }
}
