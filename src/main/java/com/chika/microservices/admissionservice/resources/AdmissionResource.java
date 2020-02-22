package com.chika.microservices.admissionservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chika.microservices.admissionservice.models.DiseasesList;
import com.chika.microservices.admissionservice.models.EmployeesList;
import com.chika.microservices.admissionservice.models.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionResource {
	
	@Autowired
	private RestTemplate restTemplate;

	List<Patient> patients = Arrays.asList(
			new Patient("P1", "Gabor", "Hungarian"),
			new Patient("P2", "Emeka", "Nigerian"),
			new Patient("P3", "Emily", "American")
			);
	
	@RequestMapping("/diseases")
	public DiseasesList getDiseases() {
		//DiseasesList diseasesList= restTemplate.getForObject("http://localhost:8083/pathology/diseases", DiseasesList.class);
		DiseasesList diseasesList= restTemplate.getForObject("http://pathology-service/pathology/diseases", DiseasesList.class);
		return diseasesList;
	}
	
	@RequestMapping("/physicians")
	public EmployeesList getPhysicians() {
		//EmployeesList employeesList= restTemplate.getForObject("http://localhost:8084/hr/employees", EmployeesList.class);
		EmployeesList employeesList= restTemplate.getForObject("http://hr-service/hr/employees", EmployeesList.class);
		return employeesList;
	}
	
	@RequestMapping("/patients")
	public List<Patient> getPatients(){
		return patients;
				
		
	}
	@RequestMapping("/patients/{Id}")
	public Patient getPatientById(@PathVariable ("Id")String Id) {
		
		Patient p = patients.stream().filter(patient -> Id.equals(patient.getId()))
				.findAny()
				.orElse(null);
		return p;
		
		
	}

}
