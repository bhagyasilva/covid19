package com.bhagya.covid19;

import com.bhagya.covid19.model.CovidCase;
import com.bhagya.covid19.repository.CovidCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Covid19Application
{

	@Autowired
	private CovidCaseRepository covidCaseRepository;

	public static void main( String[] args )
	{
		SpringApplication.run( Covid19Application.class, args );
	}

	@PostConstruct
	public void initCovidCases()
	{
		Random random = new Random();
		List<CovidCase> covidCases = Stream
				.of( new CovidCase( 1, "lk-bc", "Batticaloa", random.nextInt( 900 ) ), new CovidCase( 2, "lk-mb", "Mannar", random.nextInt( 900 ) ), new CovidCase( 3, "lk-ja", "Jaffna", random.nextInt( 900 ) ), new CovidCase( 4, "lk-kl", "Kilinochchi", random.nextInt( 900 ) ),
						new CovidCase( 5, "lk-ky", "Kandy", random.nextInt( 900 ) ), new CovidCase( 6, "lk-mt", "Matale", random.nextInt( 900 ) ), new CovidCase( 7, "lk-nw", "Nuwara Eliya", random.nextInt( 900 ) ), new CovidCase( 8, "lk-ap", "Ampara", random.nextInt( 900 ) ),
						new CovidCase( 9, "lk-pr", "Polonnaruwa", random.nextInt( 900 ) ), new CovidCase( 10, "lk-tc", "Trincomalee", random.nextInt( 900 ) ), new CovidCase( 11, "lk-ad", "Anuradhapura", random.nextInt( 900 ) ), new CovidCase( 12, "lk-va", "Vavuniya", random.nextInt( 900 ) ),
						new CovidCase( 13, "lk-mp", "Mulativu", random.nextInt( 900 ) ), new CovidCase( 14, "lk-kg", "Kurunegala", random.nextInt( 900 ) ), new CovidCase( 15, "lk-px", "Puttalam", random.nextInt( 900 ) ), new CovidCase( 16, "lk-rn", "Ratnapura", random.nextInt( 900 ) ),
						new CovidCase( 17, "lk-gl", "Galle", random.nextInt( 900 ) ), new CovidCase( 18, "lk-hb", "Hambantota", random.nextInt( 900 ) ), new CovidCase( 19, "lk-mh", "Matara", random.nextInt( 900 ) ), new CovidCase( 20, "lk-bd", "Badulla", random.nextInt( 900 ) ),
						new CovidCase( 21, "lk-mj", "Monaragala", random.nextInt( 900 ) ), new CovidCase( 22, "lk-ke", "Kegalla", random.nextInt( 900 ) ), new CovidCase( 23, "lk-co", "Colombo", random.nextInt( 900 ) ), new CovidCase( 24, "lk-gq", "Gampaha", random.nextInt( 900 ) ),
						new CovidCase( 25, "lk-kt", "Kalutara", random.nextInt( 900 ) ) ).collect( Collectors.toList() );

		covidCaseRepository.saveAll( covidCases );
	}

}
