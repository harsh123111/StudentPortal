package com.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AttendanceRecord;


public interface AttendanceDao extends JpaRepository<AttendanceRecord, Long> {
	//void updateAttendanceBySubjectAndRollAndDate(Long subjectId,Long rollNumber,LocalDate date);
	List<AttendanceRecord> findBySubjectIdAndDateAndSession(Long subjectId, LocalDate date,String session);
	List<AttendanceRecord> findBySubjectIdAndSession(Long subjectId,String session);
	Optional<AttendanceRecord> findByRollNumberAndSubjectIdAndDateAndSession(Long rollNumber, Long subjectId, LocalDate date,String session);
}
 