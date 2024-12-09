package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.Prescription;
import com.example.HastaneSistemi.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Optional<Prescription> getPrescriptionById(Integer id) {
        return prescriptionRepository.findById(id);
    }

    public Prescription createPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public Prescription updatePrescription(Integer id, Prescription updatedPrescription) {
        return prescriptionRepository.findById(id)
                .map(existingPrescription -> {
                    existingPrescription.setTitle(updatedPrescription.getTitle());
                    existingPrescription.setDescription(updatedPrescription.getDescription());
                    existingPrescription.setDate(updatedPrescription.getDate());
                    existingPrescription.setTime(updatedPrescription.getTime());
                    existingPrescription.setPatient(updatedPrescription.getPatient());
                    existingPrescription.setDoctor(updatedPrescription.getDoctor());
                    return prescriptionRepository.save(existingPrescription);
                })
                .orElseThrow(() -> new RuntimeException("Prescription not found with id: " + id));
    }

    public void deletePrescription(Integer id) {
        if (!prescriptionRepository.existsById(id)) {
            throw new RuntimeException("Prescription not found with id: " + id);
        }
        prescriptionRepository.deleteById(id);
    }
}
