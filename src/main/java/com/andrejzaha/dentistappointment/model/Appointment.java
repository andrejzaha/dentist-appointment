package com.andrejzaha.dentistappointment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime startDate;

    @Transient
    private LocalDateTime toDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Reason reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Patient patient;

}
