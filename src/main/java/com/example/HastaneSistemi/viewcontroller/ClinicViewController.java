package com.example.HastaneSistemi.viewcontroller;
import com.example.HastaneSistemi.model.Clinic;
import com.example.HastaneSistemi.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clinics")
public class ClinicViewController {
    private final ClinicService clinicService;
    public ClinicViewController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }
    @GetMapping
    public String listClinics(Model model) {
        List<Clinic> clinics= clinicService.getAllClinics();
        model.addAttribute("clinics", clinics);
        return "clinics-list";
    }
    @GetMapping("/register")
    public String showClinicForm(Model model) {
        model.addAttribute("clinic", new Clinic());
        return "clinics-form";
    }
    @PostMapping
    public String saveClinic(@ModelAttribute Clinic  clinic){
        clinicService.addClinic(clinic);
        return "redirect:/clinics";

    }
    @DeleteMapping("/delete/{id}")
    public String deleteClinic(@PathVariable Integer id){
        clinicService.deleteClinic(id);
        return "redirect:/clinics";
    }

}
