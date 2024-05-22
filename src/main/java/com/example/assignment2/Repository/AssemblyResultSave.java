package com.example.assignment2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment2.entity.ProgramData;

public interface AssemblyResultSave extends JpaRepository<ProgramData, Long> {
	

}
