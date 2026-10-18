
package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Attendance;
import com.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository
        extends JpaRepository<Attendance, Integer> {

    List<Attendance> findByStudentId(Integer studentId);

    List<Attendance> findByAttendanceDate(LocalDate date);

    List<Attendance> findByStudentAndAttendanceDate(
            Student student, LocalDate date);
}
