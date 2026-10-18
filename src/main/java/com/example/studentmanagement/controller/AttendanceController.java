
package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Attendance;
import com.example.studentmanagement.entity.AttendanceStatus;
import com.example.studentmanagement.service.AttendanceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/mark")
    public Attendance markAttendance(
            @RequestParam Integer studentId,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date,
            @RequestParam AttendanceStatus status) {

        return attendanceService.markAttendance(
                studentId, date, status);
    }

    @GetMapping("/student/{studentId}")
    public List<Attendance> getStudentAttendance(
            @PathVariable Integer studentId) {

        return attendanceService.getStudentAttendance(studentId);
    }

    @GetMapping("/date")
    public List<Attendance> getAttendanceByDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return attendanceService.getAttendanceByDate(date);
    }
}
