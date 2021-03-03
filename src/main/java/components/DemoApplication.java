package components;

import components.model.NbpDiseases;
import components.model.NbpPatient;
import components.repository.NbpMaladieRepository;
import components.repository.NbpPatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

		patientRepository.save(new NbpPatient(777,"cfh","fhh","vggvjgv","gjg",8,"M","ddd",6,"jj","olikdl",null,null, "cholera,mal de tete,mal de dents", new ArrayList<NbpDiseases>()));
		patientRepository.save(new NbpPatient(778,"gxg","uc","gvjvj","jvjj",9,"M","ddd",6,"jj","olikdl",null,null,null, new ArrayList<NbpDiseases>()));
		patientRepository.save(new NbpPatient(457,"fhh","vchcho","gjj","jgj",8,"M","ddd",6,"jj","olikdl",null,null,null, new ArrayList<NbpDiseases>()));
		patientRepository.save(new NbpPatient(455,"ghxd","vvuvv","jgjgvj","gjgjgjggj",7,"M","ddd",6,"jj","olikdl",null,null,null, new ArrayList<NbpDiseases>()));
		maladieRepository.save(new NbpDiseases(1, "Maleria", "Descrizion Maleria", new NbpPatient()));
	//	patientRepository.deleteById(3);
	}

}

