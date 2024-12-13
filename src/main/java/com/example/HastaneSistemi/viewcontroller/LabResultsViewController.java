package com.example.HastaneSistemi.viewcontroller;

import com.example.HastaneSistemi.model.LabResults;
import com.example.HastaneSistemi.service.LabResultService;
import com.example.HastaneSistemi.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lab-results")
public class LabResultsViewController {

    @Autowired
    private LabResultService labResultsService;

    @Autowired
    private LabTestService labTestsService;

    @GetMapping
    public String getLabResults(Model model) {
        model.addAttribute("labResults", labResultsService.getAllLabResults());
        return "lab-results-list";
    }

    @GetMapping("/add")
    public String showAddLabResultForm(Model model) {
        model.addAttribute("labResult", new LabResults());
        model.addAttribute("labTests", labTestsService.getAllLabTests());
        return "lab-result-form";
    }

    @PostMapping
    public String addLabResult(@ModelAttribute LabResults labResult) {
        labResultsService.addLabResult(labResult);
        return "redirect:/lab-results";
    }

    @DeleteMapping
    public String deleteLabResult(@RequestParam Integer id) {
        labResultsService.deleteLabResult(id);
        return "redirect:/lab-results";
    }
}
