package com.bhagya.covid19.controller;

import com.bhagya.covid19.dto.CovidCaseDto;
import com.bhagya.covid19.model.CovidCase;
import com.bhagya.covid19.service.IDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DashboardController
{

	@Autowired
	private IDashboardService dashboardService;

	@GetMapping("/district")
	public ResponseEntity<List<CovidCaseDto>> getAllDistrictCount()
	{
		List<CovidCase> allDistrictCount = dashboardService.getAllDistrictCount();

		List<CovidCaseDto> covidCaseDtos = new ArrayList<CovidCaseDto>();
		allDistrictCount.forEach( covidCase -> covidCaseDtos.add( new CovidCaseDto( covidCase.getDistrictCode(), covidCase.getDistrictName(), covidCase.getTotalCount() ) ) );

		//		return new ResponseEntity<>( new ArrayList<CovidCaseDto>(), HttpStatus.BAD_GATEWAY);
		return new ResponseEntity<>( covidCaseDtos, HttpStatus.OK );
	}

}
