package com.jtb.taxpayerws;
import com.jtb.taxpayerws.dto.ProjectManagerDto;
import com.jtb.taxpayerws.service.ProjectManagerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;


@SpringBootApplication
@EnableJpaAuditing
public class TaxpayerWsApplication {

//	private final ProjectManagerService projectManagerService;
//
//	public TaxpayerWsApplication(ProjectManagerService projectManagerService) {
//		this.projectManagerService = projectManagerService;
//	}


	public static void main(String[] args) {
		SpringApplication.run(TaxpayerWsApplication.class, args);
	}



//	@Override
//	public void run(String... args) throws Exception {
//
//
//		ProjectManagerDto projectManagerDto = new ProjectManagerDto();
//
//		projectManagerDto.setAssignProjectName("task management system");
//		projectManagerDto.setDepartment("ICT");
//		projectManagerDto.setProjectComplete("70%");
//		projectManagerDto.setProjectStatus("progress");
//		projectManagerDto.setFirstName("mike");
//		projectManagerDto.setLastName("james");
//		projectManagerDto.setMiddleName("rotimi");
//		projectManagerDto.setProjectStartDate(LocalDate.of(2021,05,04));
//		projectManagerDto.setProjectFinishDate(LocalDate.of(2021,06,02));
//
//		projectManagerService.createProjectManager(projectManagerDto);
//
//
//	}
//


}
