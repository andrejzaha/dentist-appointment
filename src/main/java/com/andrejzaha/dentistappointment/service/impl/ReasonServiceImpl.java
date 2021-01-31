package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.model.Reason;
import com.andrejzaha.dentistappointment.model.frontend.ReasonFront;
import com.andrejzaha.dentistappointment.repository.ReasonRepository;
import com.andrejzaha.dentistappointment.service.ReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReasonServiceImpl implements ReasonService {

    @Autowired
    private ReasonRepository reasonRepository;

    @Override
    public Optional<Reason> findById(Long reasonId) {
        return reasonRepository.findById(reasonId);
    }

    @Override
    public List<ReasonFront> findAllReasons() {
        return reasonRepository.findAll().stream()
                .map(this::getReasonFront)
                .collect(Collectors.toList());
    }

    private ReasonFront getReasonFront(Reason reason) {
        ReasonFront reasonFront = new ReasonFront();

        reasonFront.setId(reason.getId());
        reasonFront.setDescription(reason.getDescription());
        reasonFront.setDurationInMinutes(reason.getDurationInMinutes());

        return reasonFront;
    }

}
