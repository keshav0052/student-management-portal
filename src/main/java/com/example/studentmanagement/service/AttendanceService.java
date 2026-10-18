
package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Attendance;
import com.example.studentmanagement.entity.AttendanceStatus;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.repository.AttendanceRepository;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.example.studentmanagement.entity.AttendanceStatus;
import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;

    public AttendanceService(
            AttendanceRepository attendanceRepository,
            StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
    }

    public Attendance markAttendance(
            Integer studentId,
            LocalDate date,
            AttendanceStatus status) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException(studentId));

        boolean alreadyMarked =
                !attendanceRepository
                        .findByStudentAndAttendanceDate(student, date)
                        .isEmpty();

        if (alreadyMarked) {
            throw new IllegalArgumentException(
                    "Attendance already marked for this student on " + date);
        }

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setAttendanceDate(date);
        attendance.setStatus(status);

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getStudentAttendance(Integer studentId) {

        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(studentId);
        }

        return attendanceRepository.findByStudentId(studentId);
    }

    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByAttendanceDate(date);
    }
}
