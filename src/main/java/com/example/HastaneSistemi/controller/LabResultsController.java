package com.example.HastaneSistemi.controller;

import com.example.HastaneSistemi.model.LabResults;
import com.example.HastaneSistemi.service.LabResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labresults")
public class LabResultsController {

    private final LabResultService labResultsService;

    @Autowired
    public LabResultsController(LabResultService labResultsService) {
        this.labResultsService = labResultsService;
    }

    @GetMapping
    public ResponseEntity<List<LabResults>> getAllLabResults() {
        return ResponseEntity.ok(labResultsService.getAllLabResults());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabResults> getLabResultById(@PathVariable int id) {
        return ResponseEntity.ok(labResultsService.getLabResultById(id));
    }

    @PostMapping
    public ResponseEntity<LabResults> addLabResult(@RequestBody LabResults labResults) {
        return ResponseEntity.ok(labResultsService.addLabResult(labResults));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabResults> updateLabResult(@PathVariable int id, @RequestBody LabResults labResults) {
        return ResponseEntity.ok(labResultsService.updateLabResult(id, labResults));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabResult(@PathVariable int id) {
        labResultsService.deleteLabResult(id);
        return ResponseEntity.noContent().build();
    }
}
