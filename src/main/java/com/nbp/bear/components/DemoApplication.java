package com.nbp.bear.components;

import com.nbp.bear.components.model.NbpDiseases;
import com.nbp.bear.components.model.NbpPatient;
import com.nbp.bear.components.repository.NbpMaladieRepository;
import com.nbp.bear.components.repository.NbpPatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {

		ApplicationContext ctx= SpringApplication.run(DemoApplication.class, args);
		NbpPatientRepository patientRepository=ctx.getBean(NbpPatientRepository.class);
		NbpMaladieRepository maladieRepository=ctx.getBean(NbpMaladieRepository.class);

//		List<NbpDiseases> nbpDiseases = Stream.of(
//				new NbpDiseases(0, "", ""),
//				new NbpDiseases(0, "", ""),
//				new NbpDiseases(0, "", "")
//		).collect(Collectors.toList());

		patientRepository.save(new NbpPatient(777,"cfh","fhh","vggvjgv","gjg",8,"M","ddd",6,"jj","olikdl",null,null, new ArrayList<NbpDiseases>()));
		patientRepository.save(new NbpPatient(778,"gxg","uc","gvjvj","jvjj",9,"M","ddd",6,"jj","olikdl",null,null, new ArrayList<NbpDiseases>()));
		patientRepository.save(new NbpPatient(457,"fhh","vchcho","gjj","jgj",8,"M","ddd",6,"jj","olikdl",null,null, new ArrayList<NbpDiseases>()));
		patientRepository.save(new NbpPatient(455,"ghxd","vvuvv","jgjgvj","gjgjgjggj",7,"M","ddd",6,"jj","olikdl",null,null, new ArrayList<NbpDiseases>()));
		maladieRepository.save(new NbpDiseases(1, "Maleria", "Descrizion Maleria", new NbpPatient()));
	//	patientRepository.deleteById(3);
	}

}

