package com.example.HastaneSistemi.service;

import com.example.HastaneSistemi.model.LabResults;
import com.example.HastaneSistemi.repository.LabResultsRepository;
import com.example.HastaneSistemi.repository.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabResultService {

    private final LabResultsRepository labResultsRepository;
    private final LabTestRepository labTestRepository;

    @Autowired
    public LabResultService(LabResultsRepository labResultsRepository, LabTestRepository labTestRepository) {
        this.labResultsRepository = labResultsRepository;
        this.labTestRepository = labTestRepository;
    }

    public List<LabResults> getAllLabResults() {
        return labResultsRepository.findAll();
    }

    public LabResults getLabResultById(int id) {
        return labResultsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LabResult not found with id: " + id));
    }

    public LabResults addLabResult(LabResults labResults) {
        labTestRepository.save(labResults.getLabTest());
        return labResultsRepository.save(labResults);
    }

    public LabResults updateLabResult(int id, LabResults updatedLabResult) {
        LabResults existingResult = getLabResultById(id);
        existingResult.setResult(updatedLabResult.getResult());
        existingResult.setNotes(updatedLabResult.getNotes());
        existingResult.setLabTest(updatedLabResult.getLabTest());
        return labResultsRepository.save(existingResult);
    }

    public void deleteLabResult(int id) {
        labResultsRepository.deleteById(id);
    }
}
