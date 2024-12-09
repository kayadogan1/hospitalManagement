package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.Nurse;
import com.example.HastaneSistemi.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {
    @Autowired
    private NurseRepository nurseRepository;

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public Optional<Nurse> getNurseById(Integer id) {
        return nurseRepository.findById(id);
    }

    public Nurse createNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public Nurse updateNurse(Integer id, Nurse updatedNurse) {
        return nurseRepository.findById(id)
                .map(existingNurse -> {
                    existingNurse.setName(updatedNurse.getName());
                    existingNurse.setSurname(updatedNurse.getSurname());
                    existingNurse.setIdentityNo(updatedNurse.getIdentityNo());
                    existingNurse.setAddress(updatedNurse.getAddress());
                    existingNurse.setTitle(updatedNurse.getTitle());
                    existingNurse.setClinic(updatedNurse.getClinic());
                    return nurseRepository.save(existingNurse);
                })
                .orElseThrow(() -> new RuntimeException("Nurse not found with id: " + id));
    }

    public void deleteNurse(Integer id) {
        if (!nurseRepository.existsById(id)) {
            throw new RuntimeException("Nurse not found with id: " + id);
        }
        nurseRepository.deleteById(id);
    }
}
