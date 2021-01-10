package com.andrejzaha.dentistappointment.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Entity
public class Reason {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;

    private Integer durationInMinutes;

    @OneToMany(mappedBy = "reason", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appointments = new HashSet<>();

    public Reason(String description, Integer durationInMinutes) {
        this.description = description;
        this.durationInMinutes = durationInMinutes;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public Set<Appointment> getAppointments() {
        return Objects.isNull(this.appointments)
                ? Collections.emptySet()
                : new HashSet<>(this.appointments);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void addAppointment(Appointment appointment) {
        appointment.setReason(this);
        this.appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointment.setReason(null);
        this.appointments.remove(appointment);
    }

}
