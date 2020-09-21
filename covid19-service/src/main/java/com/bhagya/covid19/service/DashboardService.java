package com.bhagya.covid19.service;

import com.bhagya.covid19.model.CovidCase;
import com.bhagya.covid19.repository.CovidCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService implements IDashboardService
{

	@Autowired
	private CovidCaseRepository covidCaseRepository;

	@Override
	public List<CovidCase> getAllDistrictCount()
	{
		return covidCaseRepository.findAll();
	}
}
