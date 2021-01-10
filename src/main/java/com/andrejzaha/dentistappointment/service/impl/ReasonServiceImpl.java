package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.model.Reason;
import com.andrejzaha.dentistappointment.repository.ReasonRepository;
import com.andrejzaha.dentistappointment.service.ReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReasonServiceImpl implements ReasonService {

    @Autowired
    private ReasonRepository reasonRepository;

    @Override
    public Optional<Reason> findById(Long reasonId) {
        return reasonRepository.findById(reasonId);
    }

}
