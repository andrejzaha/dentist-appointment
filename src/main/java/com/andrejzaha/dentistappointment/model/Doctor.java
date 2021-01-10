package com.andrejzaha.dentistappointment.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Availability> availabilities = new HashSet<>();

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appointments = new HashSet<>();

    public Doctor() {

    }

    public Doctor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAvailability(Availability availability) {
        availability.setDoctor(this);
        this.availabilities.add(availability);
    }

    public void removeAvailability(Availability availability) {
        availability.setDoctor(null);
        this.availabilities.remove(availability);
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Set<Availability> getAvailabilities() {
        return Objects.isNull(this.availabilities)
                ? Collections.emptySet()
                : new HashSet<>(this.availabilities);
    }

}
