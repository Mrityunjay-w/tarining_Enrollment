package com.yil.trainingenrollment.controller;

import com.yil.trainingenrollment.model.Enrollment;
import com.yil.trainingenrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private com.yil.trainingenrollment.service.TrainingService trainingService;

    @GetMapping("/form")
    public String showEnrollmentForm(Model model) {
        List<com.yil.trainingenrollment.model.Training> trainings = trainingService.getAllTrainings();
        model.addAttribute("trainings", trainings);
        model.addAttribute("enrollment", new Enrollment());
        return "enroll_form";
    }

    @PostMapping("/submit")
    public String submitEnrollmentForm(@ModelAttribute("employee") Enrollment enrollment, RedirectAttributes redirectAttributes) {
        try {
            boolean enrolled = enrollmentService.saveEnrollment(enrollment);
            if (enrolled) {
                redirectAttributes.addFlashAttribute("success", true);
            } else {
                redirectAttributes.addFlashAttribute("error", "The selected training batch is full.");
            }
            return "redirect:/enrollment/form?success";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/enrollment/form?error";
        }
    }


}
