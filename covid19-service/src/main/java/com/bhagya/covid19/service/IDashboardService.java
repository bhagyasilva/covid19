package com.bhagya.covid19.service;

import com.bhagya.covid19.model.CovidCase;

import java.util.List;

public interface IDashboardService
{
	List<CovidCase> getAllDistrictCount();
}
