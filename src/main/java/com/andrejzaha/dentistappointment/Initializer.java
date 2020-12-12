package com.andrejzaha.dentistappointment;

import com.andrejzaha.dentistappointment.model.Doctor;
import com.andrejzaha.dentistappointment.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    public static final String DOCTOR_FULL_NAME_SEPARATOR = " ";

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void run(String... args) throws Exception {
        Stream.of(
                "Bill" + DOCTOR_FULL_NAME_SEPARATOR + "Mason",
                "Jack" + DOCTOR_FULL_NAME_SEPARATOR + "Warden",
                "Stuart" + DOCTOR_FULL_NAME_SEPARATOR + "Little"
        )
                .forEach(this::saveDoctor);
    }

    private void saveDoctor(String doctorFullName) {
        if (isInvalidDoctorFullName(doctorFullName)) {
            return;
        }

        String[] name = doctorFullName.split(DOCTOR_FULL_NAME_SEPARATOR);

        doctorRepository.save(new Doctor(name[0], name[1]));
    }

    private boolean isInvalidDoctorFullName(String doctorFullName) {
        return Objects.isNull(doctorFullName)
                || !doctorFullName.contains(DOCTOR_FULL_NAME_SEPARATOR);
    }

}
