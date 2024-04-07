package com.orive.Hr.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Hr.Dto.Attandance;
import com.orive.Hr.Service.AttandanceDetailsService;

@RestController
@RequestMapping(value = "/attandance")
public class AttandanceDetailsController {

	private Logger logger=LoggerFactory.getLogger(AttandanceDetailsController.class);
	
	@Autowired
	private AttandanceDetailsService attandanceService;
	
	@PostMapping(value = "/create")
    public ResponseEntity<Attandance> createAttendance(@RequestBody Attandance attandance) {
        logger.info("Creating a new attendance record");
        Attandance createdAttendance = attandanceService.createAttendance(attandance);
        if (createdAttendance != null) {
            logger.info("Attendance record created with ID: {}", createdAttendance.getAttandanceId());
            return new ResponseEntity<>(createdAttendance, HttpStatus.CREATED);
        } else {
            logger.error("Failed to create attendance record");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getbyid/{attandanceId}")
    public ResponseEntity<Attandance> getAttendanceById(@PathVariable Long attandanceId) {
        logger.info("Fetching attendance record with ID: {}", attandanceId);
        Attandance attendance = attandanceService.getAttendanceById(attandanceId);
        if (attendance != null) {
            logger.info("Attendance record found: {}", attendance);
            return new ResponseEntity<>(attendance, HttpStatus.OK);
        } else {
            logger.warn("Attendance record with ID {} not found.", attandanceId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update/{attandanceId}")
    public ResponseEntity<Attandance> updateAttendance(@PathVariable Long attandanceId, @RequestBody Attandance attandance) {
        logger.info("Updating attendance record with ID: {}", attandanceId);
        Attandance updatedAttendance = attandanceService.updateAttendance(attandanceId, attandance);
        if (updatedAttendance != null) {
            logger.info("Attendance record updated: {}", updatedAttendance);
            return new ResponseEntity<>(updatedAttendance, HttpStatus.OK);
        } else {
            logger.warn("Attendance record with ID {} not found.", attandanceId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete/{attandanceId}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long attandanceId) {
        logger.info("Deleting attendance record with ID: {}", attandanceId);
        attandanceService.deleteAttendance(attandanceId);
        logger.info("Attendance record deleted with ID: {}", attandanceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<Attandance>> getAllAttendance() {
        logger.info("Fetching all attendance records");
        List<Attandance> attendanceList = attandanceService.getAllAttendance();
        logger.info("Fetched {} attendance records", attendanceList.size());
        return new ResponseEntity<>(attendanceList, HttpStatus.OK);
    }
}
