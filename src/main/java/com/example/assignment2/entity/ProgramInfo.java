package com.example.assignment2.entity;

import java.util.UUID;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProgramInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid;
	
	String programName;
	String programOwner;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramOwner() {
		return programOwner;
	}
	public void setProgramOwner(String programOwner) {
		this.programOwner = programOwner;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	String status;
	

}
