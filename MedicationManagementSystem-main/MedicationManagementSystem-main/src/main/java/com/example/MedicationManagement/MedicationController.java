package com.example.MedicationManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// this class will handle the HTTP requests for the Medication entity
// controller to expose CRUD endpoints.
@Controller
@RequestMapping("/medications") // Base URL for all endpoints
public class MedicationController {

    @Autowired // Inject the MedicationService dependency
    private MedicationService medicationService;

    // Home Page
    @GetMapping("/home")
    public String home() {
        return "index"; // returns index.html
    }

    // List all medications
    @GetMapping
    public String getAllMedications(Model model) {
        model.addAttribute("medications", medicationService.getAllMedication());
        return "medications"; // returns medications.html
    }

    // Show Add Medication Form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("medication", new Medication());
        return "addMedication"; // returns addMedication.html
    }

    // Save Medication
    @PostMapping
    public String saveMedication(@ModelAttribute Medication medication) {
        medicationService.createMedication(medication);
        return "redirect:/medications"; // Redirect to the medications list
    }

    // Show Edit Medication Form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("medication", medicationService.getMedicationById(id).orElseThrow(() -> new RuntimeException("Medication not found")));
        return "editMedication"; // returns editMedication.html
    }

    // Update Medication
    @PostMapping("/update/{id}")
    public String updateMedication(@PathVariable int id, @ModelAttribute Medication medication) {
        medication.setId(id);
        medicationService.updateMedication(id, medication);
        return "redirect:/medications";    // Redirect to the medications list
    }

//    // Update a medication
//    @PutMapping("/{id}")
//    public Medication updateMedication(@PathVariable int id, @RequestBody Medication updatedMedication){
//        return medicationService.updateMedication(id, updatedMedication);
//    }

    // Delete Medication
    @GetMapping("/delete/{id}")
    public String deleteMedication(@PathVariable int id) {
        medicationService.deleteMedication(id);
        return "redirect:/medications"; // Redirect to the medications list
    }

//    // Delete a medication
//    @DeleteMapping("/{id}")
//    public void deleteMedication(@PathVariable int id){
//        medicationService.deleteMedication(id);
//    }

//    // Create a new medication
//    @PostMapping
//    public Medication createMedication(@RequestBody Medication medication){ // Request body is the medication object
//        return medicationService.createMedication(medication);
//    }
//
//    // Get a medication by ID
//    @GetMapping("/{id}")
//    public Optional<Medication> getMedicationById(@PathVariable int id){
//        return medicationService.getMedicationById(id);
//    }
//
//    // Get all medications
//    @GetMapping
//    public List<Medication> getAllMedication(){
//        return medicationService.getAllMedication();
//    }


}
