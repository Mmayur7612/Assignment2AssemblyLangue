package com.example.assignment2.Service;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment2.Controller.AssemblyController;
import com.example.assignment2.Repository.AssemblyResultSave;
import com.example.assignment2.customException.OperaationNotFoundException;
import com.example.assignment2.entity.ProgramData;

@Service
public class AssemblyService {
	private static final Logger logger = LogManager.getLogger(AssemblyController.class);

	@Autowired
	AssemblyResultSave assemblyresultSave;

	public String executeAssemblyOperation(String[] lines, String program) {
		Map<String, Integer> registers = new HashMap<>();
		ProgramData programData = new ProgramData();
		programData.setProgram(program);
		try {
			for (String instruction : lines) {
				String[] parts = instruction.replace(",", "").split(" ");
				String operation = parts[0];
				String operand1 = parts[1];

				logger.info("Instructions :", instruction);

				switch (operation) {
				case "MV":
					logger.info("Mv Operation");
					registers.put(parts[1], Integer.parseInt(parts[2].substring(1)));
					break;
				case "ADD":
					logger.info("Add operation");
					if (parts[2].startsWith("#")) {
						registers.put(operand1, registers.get(operand1) + Integer.parseInt(parts[2].substring(1)));
					} else if (parts[2].startsWith("REG")) {
						registers.put(parts[1], registers.get(parts[1]) + registers.get(parts[2]));
					} else {
						registers.put(parts[1], registers.get(parts[1]) + Integer.parseInt(parts[2]));

					}
					break;
				case "SHOW":
					logger.info("Show Operation");
					programData.setRegisters(registers.get(parts[1]).toString());
					logger.info("Saving the Result to DB");
					assemblyresultSave.save(programData);
					return String.valueOf(registers.get(parts[1]));
				default:
					logger.error("Inavlid Operation");
					throw new OperaationNotFoundException("Invalid Operation");

				}
			}
		} catch (Exception e) {
			throw new OperaationNotFoundException("Wrong Value provided");
		}
		throw new OperaationNotFoundException("Something went Wrong");
	}
}
