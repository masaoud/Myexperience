package com.myexperience.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexperience.domain.Experience;
import com.myexperience.repository.ExperienceRepository;

@Service
public class ExperienceService
{
	@Autowired
	private ExperienceRepository experienceRepository;
	
	public void add(Experience experience)
	{
		String experienceBody = experience.getBody();
		if (experienceBody.length() > 50)
		{
			experienceRepository.save(experience);
		}
	}
	
	public List<Experience> findAll()
	{
		return this.experienceRepository.findAll();
	}
	
}
