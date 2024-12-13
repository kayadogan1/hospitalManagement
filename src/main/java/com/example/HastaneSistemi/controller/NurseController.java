package com.example.HastaneSistemi.controller;

import com.example.HastaneSistemi.model.Nurse;
import com.example.HastaneSistemi.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/nurses")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @GetMapping
    public ResponseEntity<List<Nurse>> getAllNurses() {
        List<Nurse> nurses = nurseService.getAllNurses();
        return ResponseEntity.ok(nurses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable Integer id) {
        return nurseService.getNurseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Nurse> createNurse(@RequestBody Nurse nurse) {

        try {
            Nurse createdNurse = nurseService.createNurse(nurse);
            return ResponseEntity.ok(createdNurse);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable Integer id, @RequestBody Nurse updatedNurse) {
        try {
            Nurse updated = nurseService.updateNurse(id, updatedNurse);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNurse(@PathVariable Integer id) {
        try {
            nurseService.deleteNurse(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
