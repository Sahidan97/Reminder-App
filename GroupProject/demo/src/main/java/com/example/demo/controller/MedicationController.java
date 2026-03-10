package com.example.demo.controller;

import com.example.demo.medication.Medication;
import com.example.demo.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medications")
@CrossOrigin(origins = "*") // Allows frontend access
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    // Get all medications
    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }

    // Get medication by ID
    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable int id) {
        Optional<Medication> medication = medicationService.getMedicationById(id);
        return medication.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add new medication
    @PostMapping
    public Medication addMedication(@RequestBody Medication medication) {
        return medicationService.addMedication(medication);
    }

    // Update medication
    @PutMapping("/{id}")
    public ResponseEntity<Medication> updateMedication(@PathVariable int id, @RequestBody Medication medication) {
        return ResponseEntity.ok(medicationService.updateMedication(id, medication));
    }

    // Delete medication
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable int id) {
        medicationService.deleteMedication(id);
        return ResponseEntity.noContent().build();
    }
}
