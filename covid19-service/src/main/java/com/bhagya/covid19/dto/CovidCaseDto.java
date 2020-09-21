package com.bhagya.covid19.dto;

public class CovidCaseDto
{
	private String districtCode;
	private String districtName;
	private int totalCount = 0;

	public CovidCaseDto()
	{
	}

	public CovidCaseDto( String districtCode, String districtName, int totalCount )
	{
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.totalCount = totalCount;
	}

	public String getDistrictCode()
	{
		return districtCode;
	}

	public void setDistrictCode( String districtCode )
	{
		this.districtCode = districtCode;
	}

	public String getDistrictName()
	{
		return districtName;
	}

	public void setDistrictName( String districtName )
	{
		this.districtName = districtName;
	}

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount( int totalCount )
	{
		this.totalCount = totalCount;
	}
}
