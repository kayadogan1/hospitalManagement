package com.example.HastaneSistemi.controller;

import com.example.HastaneSistemi.model.LabTests;
import com.example.HastaneSistemi.service.LabTestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labtests")
public class LabTestController {

    private final LabTestService labTestsService;

    @Autowired
    public LabTestController(LabTestService labTestsService) {
        this.labTestsService = labTestsService;
    }

    @GetMapping
    public ResponseEntity<List<LabTests>> getAllLabTests() {
        return ResponseEntity.ok(labTestsService.getAllLabTests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabTests> getLabTestById(@PathVariable int id) {
        return ResponseEntity.ok(labTestsService.getLabTestById(id));
    }

    @PostMapping
    public ResponseEntity<LabTests> addLabTest(@RequestBody LabTests labTest) {
        return ResponseEntity.ok(labTestsService.addLabTest(labTest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabTests> updateLabTest(@PathVariable int id, @RequestBody LabTests labTest) {
        return ResponseEntity.ok(labTestsService.updateLabTest(id, labTest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabTest(@PathVariable int id) {
        labTestsService.deleteLabTest(id);
        return ResponseEntity.noContent().build();
    }
}
