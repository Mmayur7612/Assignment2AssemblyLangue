package com.example.assignment2.Controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment2.Service.AssemblyService;
import com.example.assignment2.Service.ProgramInfoService;
import com.example.assignment2.customException.ProgramNotFoundException;
import com.example.assignment2.entity.ProgramInfo;

@RestController
public class AssemblyController {
	private static final Logger logger = LogManager.getLogger(AssemblyController.class);

	@Autowired
	AssemblyService assemblyService;

	@Autowired
	ProgramInfoService programInfoService;

	@PostMapping("/execute/program/{programId}")
	public String executeProgram(@PathVariable String programId, @RequestBody String input) {

		logger.info("Execute Assembly Language Request Cames :", input);
		Optional<ProgramInfo> programInfo = programInfoService.find(programId);
		if (!programInfo.isEmpty()) {
			logger.info("Program found going to start Operation");
			String[] lines = input.split("[\\r\\n]+");
			logger.info("Splitting the Operation", lines);
			return assemblyService.executeAssemblyOperation(lines, programId);
		} else {
			logger.error("Program not found");

			throw new ProgramNotFoundException("Program Not Found");
		}

	}
}
