package com.andrejzaha.dentistappointment.controller.api;

import com.andrejzaha.dentistappointment.model.frontend.ReasonChoiceModel;
import com.andrejzaha.dentistappointment.service.ReasonChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReasonChoiceController {

    @Autowired
    private ReasonChoiceService reasonChoiceService;

    @GetMapping("/get-reason-choice-model")
    public ReasonChoiceModel getReasonChoiceModel() {
        return reasonChoiceService.getReasonChoiceModel();
    }

}
