package com.yil.trainingenrollment.controller;


import com.yil.trainingenrollment.model.Enrollment;
import com.yil.trainingenrollment.model.Training;
import com.yil.trainingenrollment.service.EnrollmentService;
import com.yil.trainingenrollment.service.TrainingService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private TrainingService trainingService;

    @GetMapping("/login")
    public String showLogin(Model model) {
        return "admin_login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes) {
        // Dummy check - replace with actual authentication logic
        if ("admin".equals(username) && "Pass#yil12345".equals(password)) {
            // Redirect to the admin dashboard or another page
            return "redirect:/admin/dashboard";
        } else {
            redirectAttributes.addFlashAttribute("error", true);
            return "redirect:/admin/login";
        }
    }

    @GetMapping("/dashboard")
    public String showAdminDashboard() {
        // Show admin dashboard or other admin-related page
        return "admin_dashboard";
    }

    @GetMapping("/enrollments")
    public String viewAllEnrollments(Model model) {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        model.addAttribute("enrollments", enrollments);
        return "view_enrollments";
    }

    @GetMapping("/trainings")
    public String viewAllTrainings(Model model) {
        List<Training> trainings = trainingService.getAllTrainings();
        model.addAttribute("trainings", trainings);
        return "view_trainings";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadData() throws IOException {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Enrollments");

            // Create header row
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Company");
            header.createCell(1).setCellValue("Country");
            header.createCell(2).setCellValue("Employee ID");
            header.createCell(3).setCellValue("Employee Name");
            header.createCell(4).setCellValue("Email");
            header.createCell(5).setCellValue("Training");

            // Populate data
            int rowNum = 1;
            for (Enrollment enrollment : enrollments) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(enrollment.getCompany());
                row.createCell(1).setCellValue(enrollment.getCountry());
                row.createCell(2).setCellValue(enrollment.getEmployeeId());
                row.createCell(3).setCellValue(enrollment.getName());
                row.createCell(4).setCellValue(enrollment.getEmail());
                row.createCell(5).setCellValue(enrollment.getTraining().getName());
            }

            // Write the output to a byte array
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                workbook.write(baos);
                byte[] bytes = baos.toByteArray();

                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=enrollments.xlsx");
                headers.add(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

                return ResponseEntity.ok().headers(headers).body(bytes);
            }
        }
    }

}
