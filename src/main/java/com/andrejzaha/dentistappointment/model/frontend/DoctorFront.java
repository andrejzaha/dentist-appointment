package com.andrejzaha.dentistappointment.model.frontend;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DoctorFront {

    private Long id;

    private String displayedName;

    public void setDisplayedName(String lastName, String firstName) {
        this.displayedName = "Dr. " + lastName + " " + firstName;
    }

}
