package com.meteoweb;

import com.meteoweb.domain.StationInformation;
import com.meteoweb.repository.StationInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeteoWebApplication implements CommandLineRunner {

	@Autowired
	private StationInformationRepository stationInformationRepository;

	public static void main(String[] args) {
		SpringApplication.run(MeteoWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		StationInformation stationInformation = new  StationInformation();
		stationInformation.setId("ac");
		stationInformation.setTmin("14");
		stationInformation.setDate("19800105");
		stationInformation.setTmax("40");
		stationInformation.setTavg("27");

		StationInformation stationInformation1 = new  StationInformation();
		stationInformation1.setId("ap");
		stationInformation1.setTmin("14");
		stationInformation1.setDate("19800104");
		stationInformation1.setTmax("40");
		stationInformation1.setTavg("27");

		StationInformation stationInformation2 = new  StationInformation();
		stationInformation2.setId("abbak");
		stationInformation2.setTmin("14");
		stationInformation2.setDate("19800115");
		stationInformation2.setTmax("40");
		stationInformation2.setTavg("27");

		stationInformationRepository.save(stationInformation);
		stationInformationRepository.save(stationInformation1);
		stationInformationRepository.save(stationInformation2);


	}
}
