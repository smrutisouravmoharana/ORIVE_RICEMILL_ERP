package com.orive.Hr.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Hr.Dto.Attandance;
import com.orive.Hr.Entity.AttandanceDetails;
import com.orive.Hr.Repository.AttandanceDetailsRepository;

@Service
public class AttandanceDetailsService {

	private Logger logger=LoggerFactory.getLogger(AttandanceDetailsService.class);
	
	@Autowired
	private AttandanceDetailsRepository attandanceDetailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create a new attendance record
    public Attandance createAttendance(Attandance attandanceDto) {
        AttandanceDetails attandanceDetails = modelMapper.map(attandanceDto, AttandanceDetails.class);
        attandanceDetails = attandanceDetailsRepository.save(attandanceDetails);
        logger.info("Created new attendance record with ID: {}", attandanceDetails.getAttandanceId());
        return modelMapper.map(attandanceDetails, Attandance.class);
    }

    // Read an attendance record by ID
    public Attandance getAttendanceById(Long attandanceId) {
        Optional<AttandanceDetails> optionalAttendance = attandanceDetailsRepository.findById(attandanceId);
        if (optionalAttendance.isPresent()) {
            AttandanceDetails attandanceDetails = optionalAttendance.get();
            return modelMapper.map(attandanceDetails, Attandance.class);
        } else {
            logger.warn("Attendance record with ID {} not found.", attandanceId);
            return null;
        }
    }

    // Update an existing attendance record
    public Attandance updateAttendance(Long attandanceId, Attandance attandanceDto) {
        Optional<AttandanceDetails> optionalAttendance = attandanceDetailsRepository.findById(attandanceId);
        if (optionalAttendance.isPresent()) {
            AttandanceDetails existingAttendance = optionalAttendance.get();
            modelMapper.map(attandanceDto, existingAttendance);
            attandanceDetailsRepository.save(existingAttendance);
            logger.info("Updated attendance record with ID: {}", attandanceId);
            return modelMapper.map(existingAttendance, Attandance.class);
        } else {
            logger.warn("Attendance record with ID {} not found.", attandanceId);
            return null;
        }
    }

    // Delete an attendance record by ID
    public void deleteAttendance(Long attandanceId) {
        attandanceDetailsRepository.deleteById(attandanceId);
        logger.info("Deleted attendance record with ID: {}", attandanceId);
    }

    // List all attendance records
    public List<Attandance> getAllAttendance() {
        List<AttandanceDetails> attandanceDetailsList = attandanceDetailsRepository.findAll();
        return attandanceDetailsList.stream()
                .map(attandanceDetails -> modelMapper.map(attandanceDetails, Attandance.class))
                .collect(Collectors.toList());
    }
}
