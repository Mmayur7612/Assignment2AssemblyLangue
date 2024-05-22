package com.example.assignment2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment2.Service.ProgramInfoService;
import com.example.assignment2.entity.ProgramInfo;

@RestController
public class ProgramController {
	
	@Autowired
	ProgramInfoService programInfoService;
	
    @PostMapping("/add/program")
     public String addProgram(@RequestBody ProgramInfo requestbody) {
    	return programInfoService.saveProgram(requestbody);
    }

}
