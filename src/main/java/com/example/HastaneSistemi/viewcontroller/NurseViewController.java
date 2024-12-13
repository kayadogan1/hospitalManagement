package com.example.HastaneSistemi.viewcontroller;

import com.example.HastaneSistemi.model.Nurse;
import com.example.HastaneSistemi.service.ClinicService;
import com.example.HastaneSistemi.service.NurseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nurses")
public class NurseViewController {
    private final NurseService nurseService;
    private final ClinicService clinicService;
    NurseViewController(ClinicService clinicService, NurseService nurseService) {
        this.clinicService = clinicService;
        this.nurseService= nurseService;
    }
    @GetMapping
    public String showNurses(Model model) {
        List<Nurse> nurses = nurseService.getAllNurses();
        model.addAttribute("nurses",nurses);
        return "nurse-list";
    }
    @GetMapping("/add")
    public String showClinicForm(Model model) {
        model.addAttribute("nurse", new Nurse());
        model.addAttribute("clinics", clinicService.getAllClinics());
        return "nurse-form";
    }
    @PostMapping()
    public String saveNurse(@ModelAttribute("nurse") Nurse nurse) {
        nurseService.createNurse(nurse);
        return "redirect:/nurses";
    }
   @DeleteMapping("/delete/{nurseId}")
    public String deleteNurse(@PathVariable Integer nurseId) {
        nurseService.deleteNurse(nurseId);
        return "redirect:/nurses";
    }

}
