
package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.AcademicRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicRecordRepository
        extends JpaRepository<AcademicRecord, Integer> {

    List<AcademicRecord> findByStudentId(Integer studentId);

    List<AcademicRecord> findBySubjectIgnoreCase(String subject);

    List<AcademicRecord> findByStudentIdAndExamNameIgnoreCase(
            Integer studentId, String examName);
}
