package com.example.assignment2.Service;

import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment2.Controller.AssemblyController;
import com.example.assignment2.Repository.ProgramInfoRepository;
import com.example.assignment2.entity.ProgramInfo;

@Service
public class ProgramInfoService {
	private static final Logger logger = LogManager.getLogger(AssemblyController.class);

	@Autowired
	ProgramInfoRepository programInfoRepository;

	public String saveProgram(ProgramInfo p) {
		logger.info("Program Cames to Save");
		ProgramInfo result = programInfoRepository.save(p);
		logger.info("Program Saved ");
		return result.getUuid().toString();

	}

	public Optional<ProgramInfo> find(String programId) {
		logger.info("Finding Program With Id:",programId);
		return programInfoRepository.findById(UUID.fromString(programId));
	}

}
