
package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.AcademicRecord;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.repository.AcademicRecordRepository;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicRecordService {

    private final AcademicRecordRepository academicRecordRepository;
    private final StudentRepository studentRepository;

    public AcademicRecordService(
            AcademicRecordRepository academicRecordRepository,
            StudentRepository studentRepository) {
        this.academicRecordRepository = academicRecordRepository;
        this.studentRepository = studentRepository;
    }

    // Add academic record for a student
    public AcademicRecord addAcademicRecord(
            Integer studentId, AcademicRecord record) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(
                        () -> new StudentNotFoundException(studentId)
                );

        // Validate marks
        if (record.getTotalMarks() == null
                || record.getTotalMarks().signum() <= 0) {
            throw new IllegalArgumentException(
                    "Total marks must be greater than zero"
            );
        }

        if (record.getMarksObtained() == null
                || record.getMarksObtained().signum() < 0) {
            throw new IllegalArgumentException(
                    "Marks obtained cannot be negative"
            );
        }

        if (record.getMarksObtained()
                .compareTo(record.getTotalMarks()) > 0) {
            throw new IllegalArgumentException(
                    "Marks obtained cannot exceed total marks"
            );
        }

        record.setStudent(student);

        return academicRecordRepository.save(record);
    }

    // Get all academic records for one student
    public List<AcademicRecord> getRecordsByStudent(Integer studentId) {

        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(studentId);
        }

        return academicRecordRepository.findByStudentId(studentId);
    }

    // Search records by subject
    public List<AcademicRecord> getRecordsBySubject(String subject) {
        return academicRecordRepository.findBySubjectIgnoreCase(subject);
    }

    // Get a student's records for a particular exam
    public List<AcademicRecord> getRecordsByStudentAndExam(
            Integer studentId, String examName) {

        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(studentId);
        }

        return academicRecordRepository
                .findByStudentIdAndExamNameIgnoreCase(studentId, examName);
    }
}
