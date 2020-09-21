package com.bhagya.covid19.repository;

import com.bhagya.covid19.model.CovidCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidCaseRepository extends JpaRepository<CovidCase, Long>
{
}
