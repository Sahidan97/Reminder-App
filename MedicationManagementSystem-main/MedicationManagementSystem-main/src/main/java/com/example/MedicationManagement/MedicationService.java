package com.example.MedicationManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// A service class with methods for CRUD operations on the Medication entity.
@Service // Annotation for Spring to recognize this as a service class
public class MedicationService {

    @Autowired // Inject the MedicationRepository dependency
    private MedicationRepository medicationRepository;

    // Create a new medication record
    public Medication createMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    // Get a medication by ID
    public Optional<Medication> getMedicationById(int id) {
        return medicationRepository.findById(id);
    }

    // Get all medication
    public List<Medication> getAllMedication() {
        return medicationRepository.findAll();
    }

    // Update a medication
    public Medication updateMedication(int id, Medication updatedMedication) {
        updatedMedication.setId(id); // Ensure the ID Matches
        return medicationRepository.save(updatedMedication); // Save the updated medication
    }

    //Delete a medication
    public void deleteMedication(int id) {
        medicationRepository.deleteById(id);
    }

}
