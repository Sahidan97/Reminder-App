package com.example.MedicationManagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity // Annotation for JPA to create a table in the database
public class Medication {

    @Id // Annotation for JPA to recognize this as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generate the ID
    private int id;

    private String name; // Name of medication
    private String dosage; // Dosage amount
    private String unit; // Unit of dosage
    private String frequency; // Frequency of intake
    private LocalDate startDate; // Start date of medication
    private LocalDate endDate; // End date of medication (optional)

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
