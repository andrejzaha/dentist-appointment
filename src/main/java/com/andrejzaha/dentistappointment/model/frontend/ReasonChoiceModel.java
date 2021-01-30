package com.andrejzaha.dentistappointment.model.frontend;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ReasonChoiceModel {

    private List<DoctorFront> doctors;

    private List<ReasonFront> reasons;

    private List<PeriodCodeFront> periodCodes;

}
