package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.LabTests;
import com.example.HastaneSistemi.repository.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabTestService {

    private final LabTestRepository labTestsRepository;

    @Autowired
    public LabTestService(LabTestRepository labTestsRepository) {
        this.labTestsRepository = labTestsRepository;
    }

    public List<LabTests> getAllLabTests() {
        return labTestsRepository.findAll();
    }

    public LabTests getLabTestById(int id) {
        return labTestsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LabTest not found with id: " + id));
    }

    public LabTests addLabTest(LabTests labTest) {
        return labTestsRepository.save(labTest);
    }

    public LabTests updateLabTest(int id, LabTests updatedLabTest) {
        LabTests existingTest = getLabTestById(id);
        existingTest.setTest_name(updatedLabTest.getTest_name());
        existingTest.setTest_description(updatedLabTest.getTest_description());
        existingTest.setLabResult(updatedLabTest.getLabResult());
        return labTestsRepository.save(existingTest);
    }

    public void deleteLabTest(int id) {
        labTestsRepository.deleteById(id);
    }
}
