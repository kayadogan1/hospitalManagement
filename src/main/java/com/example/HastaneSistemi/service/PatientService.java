package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.Patient;
import com.example.HastaneSistemi.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Integer id) {
        return patientRepository.findById(id);
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Integer id, Patient updatedPatient) {
        return patientRepository.findById(id)
                .map(existingPatient -> {
                    existingPatient.setFirstName(updatedPatient.getFirstName());
                    existingPatient.setLastName(updatedPatient.getLastName());
                    existingPatient.setGender(updatedPatient.getGender());
                    existingPatient.setVisitors(updatedPatient.getVisitors());
                    existingPatient.setAppointments(updatedPatient.getAppointments());
                    existingPatient.setInvoice(updatedPatient.getInvoice());
                    existingPatient.setPrescription(updatedPatient.getPrescription());
                    return patientRepository.save(existingPatient);
                })
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public void deletePatient(Integer id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }

}
