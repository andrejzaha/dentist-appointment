package com.andrejzaha.dentistappointment;

import com.andrejzaha.dentistappointment.model.Availability;
import com.andrejzaha.dentistappointment.model.Doctor;
import com.andrejzaha.dentistappointment.model.Patient;
import com.andrejzaha.dentistappointment.model.Reason;
import com.andrejzaha.dentistappointment.repository.DoctorRepository;
import com.andrejzaha.dentistappointment.repository.PatientRepository;
import com.andrejzaha.dentistappointment.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    public static final String FULL_NAME_SEPARATOR = " ";
    public static final String REASON_SEPARATOR = " ";

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ReasonRepository reasonRepository;

    @Override
    public void run(String... args) throws Exception {
        generateDoctors();
        generatePatients();
        generateReasons();
    }

    private void generateDoctors() {
        Stream.of(
                "Bill" + FULL_NAME_SEPARATOR + "Mason",
                "Jack" + FULL_NAME_SEPARATOR + "Warden",
                "Stuart" + FULL_NAME_SEPARATOR + "Little"
        )
                .forEach(this::saveDoctor);
    }

    private void saveDoctor(String doctorFullName) {
        if (isInvalidFullName(doctorFullName)) {
            return;
        }

        String[] name = doctorFullName.split(FULL_NAME_SEPARATOR);

        Doctor doctor = new Doctor(name[0], name[1]);

        Availability availability = new Availability(
                LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT.plusHours(9)),
                LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT.plusHours(17))
        );
        doctor.addAvailability(availability);

        doctorRepository.save(doctor);
    }

    private void generatePatients() {
        Stream.of(
                "English" + FULL_NAME_SEPARATOR + "Patient-E",
                "French" + FULL_NAME_SEPARATOR + "Patient-F"
        )
                .forEach(this::savePatient);
    }

    private void savePatient(String patientFullName) {
        if (isInvalidFullName(patientFullName)) {
            return;
        }

        String[] name = patientFullName.split(FULL_NAME_SEPARATOR);
        String email = name[0].toLowerCase() + "@yahoo.com";

        patientRepository.save(new Patient(name[0], name[1], email));
    }

    private boolean isInvalidFullName(String doctorFullName) {
        return Objects.isNull(doctorFullName)
                || !doctorFullName.contains(FULL_NAME_SEPARATOR);
    }

    private void generateReasons() {
        Stream.of(
                "Reason_1" + REASON_SEPARATOR + "15",
                "Reason_2" + FULL_NAME_SEPARATOR + "30",
                "Reason_3" + FULL_NAME_SEPARATOR + "120"
        )
                .forEach(this::saveReason);
    }

    private void saveReason(String reasonAsString) {
        if (isInvalidReasonAsString(reasonAsString)) {
            return;
        }

        String[] reasonSplit = reasonAsString.split(REASON_SEPARATOR);

        reasonRepository.save(new Reason(reasonSplit[0], Integer.parseInt(reasonSplit[1])));
    }

    private boolean isInvalidReasonAsString(String reasonAsString) {
        return Objects.isNull(reasonAsString)
                || !reasonAsString.contains(REASON_SEPARATOR);
    }

}
