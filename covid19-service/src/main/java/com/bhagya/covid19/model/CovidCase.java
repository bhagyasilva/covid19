package com.bhagya.covid19.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "TBL_COVID_CASES")
@DynamicUpdate
public class CovidCase
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false, unique = true)
	private long id;

	@Column(name = "DIST_CODE", nullable = false, updatable = false, unique = true)
	private String districtCode;

	@Column(name = "DIST_NAME", nullable = false)
	private String districtName;

	@Column(name = "TOTAL_COUNT")
	private int totalCount = 0;

	public CovidCase()
	{
	}

	public CovidCase( long id, String districtCode, String districtName, int totalCount )
	{
		this.id = id;
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.totalCount = totalCount;
	}

	public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
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
