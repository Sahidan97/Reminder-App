package com.example.demo.service;

import com.example.demo.medication.Medication;
import com.example.demo.repo.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    // Get all medications
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    // Get medication by ID
    public Optional<Medication> getMedicationById(int id) {
        return medicationRepository.findById(id);
    }

    // Add new medication
    public Medication addMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    // Update medication
    public Medication updateMedication(int id, Medication updatedMedication) {
        return medicationRepository.findById(id).map(medication -> {
            medication.setMedName(updatedMedication.getMedName());
            medication.setDosage(updatedMedication.getDosage());
            medication.setFrequency(updatedMedication.getFrequency());
            medication.setStartDate(updatedMedication.getStartDate());
            medication.setEndDate(updatedMedication.getEndDate());
            return medicationRepository.save(medication);
        }).orElseThrow(() -> new RuntimeException("Medication not found"));
    }

    // Delete medication
    public void deleteMedication(int id) {
        medicationRepository.deleteById(id);
    }
}
