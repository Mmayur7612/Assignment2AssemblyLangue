package com.example.assignment2.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment2.entity.ProgramInfo;

@Repository
public interface ProgramInfoRepository  extends JpaRepository<ProgramInfo, UUID>{

	
}
