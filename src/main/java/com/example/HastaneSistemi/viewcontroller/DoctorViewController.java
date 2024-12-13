package com.example.HastaneSistemi.viewcontroller;

import com.example.HastaneSistemi.model.Clinic;
import com.example.HastaneSistemi.model.Doctor;
import com.example.HastaneSistemi.service.ClinicService;
import com.example.HastaneSistemi.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorViewController {

    private final DoctorService doctorService;
    private final ClinicService clinicService; // Klinik servis eklendi

    public DoctorViewController(DoctorService doctorService, ClinicService clinicService) {
        this.doctorService = doctorService;
        this.clinicService = clinicService;
    }

    // Doktorları listelemek için
    @GetMapping
    public String listDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctor();
        model.addAttribute("doctors", doctors);
        return "doctor-list";  // doctor-list.html'yi render et
    }

    // Yeni doktor eklemek için form
    @GetMapping("/add")
    public String showDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor()); // Yeni doktor
        model.addAttribute("clinics", clinicService.getAllClinics()); // Klinik listesi
        return "doctor-form";  // doctor-form.html sayfasını render et
    }

    // Yeni doktoru kaydetmek için
    @PostMapping
    public String saveDoctor(@ModelAttribute Doctor doctor, @RequestParam("clinicId") Integer clinicId) {
        Clinic selectedClinic = clinicService.getClinicById(clinicId);
        doctor.setClinic(selectedClinic); // Seçilen klinik ilişkilendirildi
        if(doctor.getIdentityNo()==null||doctor.getIdentityNo().isEmpty() || doctor.getIdentityNo()==null || doctor.getIdentityNo().isEmpty())
            throw new IllegalArgumentException("Identity Number cannot be null or empty");
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";  // Kaydettikten sonra doktorlar sayfasına yönlendir
    }

    // Doktor silmek için
    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctorById(id);
        return "redirect:/doctors";  // Silme işleminden sonra doktorlar sayfasına yönlendir
    }
}
