package com.example.MedicationManagement;

import org.springframework.data.jpa.repository.JpaRepository;

// A repository interface that extends JpaRepository to handle CRUD operations for the Medication entity.
public interface MedicationRepository extends JpaRepository<Medication, Integer> {
}
