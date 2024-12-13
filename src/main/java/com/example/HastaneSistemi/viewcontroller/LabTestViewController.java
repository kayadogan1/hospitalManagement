package com.example.HastaneSistemi.viewcontroller;

import com.example.HastaneSistemi.model.LabTests;
import com.example.HastaneSistemi.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lab-tests")
public class LabTestViewController {

    @Autowired
    private LabTestService labTestsService;

    @GetMapping
    public String getLabTests(Model model) {
        model.addAttribute("labTests", labTestsService.getAllLabTests());
        return "lab-tests-list";
    }

    @GetMapping("/add")
    public String showAddLabTestForm(Model model) {
        model.addAttribute("labTest", new LabTests());
        return "lab-test-form";
    }

    @PostMapping
    public String addLabTest(@ModelAttribute LabTests labTest) {
        labTestsService.addLabTest(labTest);
        return "redirect:/lab-tests";
    }

    @DeleteMapping
    public String deleteLabTest(@RequestParam Integer id) {
        labTestsService.deleteLabTest(id);
        return "redirect:/lab-tests";
    }
}
