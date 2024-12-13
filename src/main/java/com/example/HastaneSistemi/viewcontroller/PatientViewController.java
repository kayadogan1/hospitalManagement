package com.example.HastaneSistemi.viewcontroller;

import com.example.HastaneSistemi.model.Patient;
import com.example.HastaneSistemi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientViewController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private AppointmentService appointmentService;



    @GetMapping
    public String getPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients-list";
    }
    @GetMapping("/add")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("doctors",doctorService.getAllDoctor());
        model.addAttribute("invoices",invoiceService.getAllInvoices());
        model.addAttribute("prescriptions",prescriptionService.getAllPrescriptions());
        model.addAttribute("appointments",appointmentService.getAllAppointment());
        return "patient-form";
    }
    @PostMapping
    public String addPatient(@ModelAttribute Patient patient) {
        patientService.createPatient(patient);
        return "redirect:/patients";
    }
    @DeleteMapping
    public String deletePatient(@RequestParam Integer id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
}
