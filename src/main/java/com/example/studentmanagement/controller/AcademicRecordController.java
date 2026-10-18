
package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.AcademicRecord;
import com.example.studentmanagement.service.AcademicRecordService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/academic-records")
public class AcademicRecordController {

    private final AcademicRecordService academicRecordService;

    public AcademicRecordController(
            AcademicRecordService academicRecordService) {
        this.academicRecordService = academicRecordService;
    }

    // Add academic record
    @PostMapping("/student/{studentId}")
    public AcademicRecord addAcademicRecord(
            @PathVariable Integer studentId,
            @Valid @RequestBody AcademicRecord record) {

        return academicRecordService.addAcademicRecord(
                studentId, record);
    }

    // Get all records of a student
    @GetMapping("/student/{studentId}")
    public List<AcademicRecord> getRecordsByStudent(
            @PathVariable Integer studentId) {

        return academicRecordService.getRecordsByStudent(studentId);
    }

    // Search records by subject
    @GetMapping("/subject/{subject}")
    public List<AcademicRecord> getRecordsBySubject(
            @PathVariable String subject) {

        return academicRecordService.getRecordsBySubject(subject);
    }

    // Get records by student and exam
    @GetMapping("/student/{studentId}/exam")
    public List<AcademicRecord> getRecordsByStudentAndExam(
            @PathVariable Integer studentId,
            @RequestParam String examName) {

        return academicRecordService
                .getRecordsByStudentAndExam(studentId, examName);
    }

}
