package com.nbp.bear.components;

import com.nbp.bear.components.model.NbpDiseases;
import com.nbp.bear.components.model.NbpPatient;
import com.nbp.bear.components.repository.NbpMaladieRepository;
import com.nbp.bear.components.repository.NbpPatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {

		ApplicationContext ctx= SpringApplication.run(DemoApplication.class, args);
		NbpPatientRepository patientRepository=ctx.getBean(NbpPatientRepository.class);
		NbpMaladieRepository maladieRepository=ctx.getBean(NbpMaladieRepository.class);
		
		patientRepository.save(new NbpPatient(126,"14-949-9034","Hyacinth Ronnay", "Ronnay", "5/16/1950", 2, "F", "4 Paget Circle", 36866, "Trinity College Carmarthen", "hronnay1@time.com", "0062984168544", "4715162932","cholera"));
		patientRepository.save(new NbpPatient(668,"48-175-5458","Kennett Tomet", "Tomet", "11/27/1976", 3, "M", "75798 Carey Terrace", 34504, "Institute of Teachers Education, Tun Hussein Onn", "ktomet2@twitter.com", "0035512991", "9177032161","cholera"));
		patientRepository.save(new NbpPatient(497,"18-164-6281","Hillary Headrick", "Headrick", "6/16/1960", 4, "M", "68 Del Sol Parkway", 41797, "Elmira College", "hheadrick3@wunderground.com", "00624527612465", "0078717259","malaria"));
		patientRepository.save(new NbpPatient(742,"18-325-6501","Mavis Andrieux", "Andrieux", "9/30/2019", 5, "F", "6 Bunting Parkway", 32876, "Universidad del Tepeyac", "mandrieux4@unicef.org", "+1 763 914 2522", "7428089135","diarhea"));
		patientRepository.save(new NbpPatient(522,"19-342-8379","Carter Ivanusyev", "Ivanusyev", "11/14/1980", 6, "M", "5048 Northport Point", 27282, "London Metropolitan University", "civanusyev5@sohu.com", "+593 707 918 1321", "1102159779","diarhea"));
		patientRepository.save(new NbpPatient(422,"69-548-9258","Zedekiah McKnish", "McKnish", "11/15/2005", 7, "M", "48 Huxley Pass", 35164, "State University of New York Health Sience Centre Syracuse", "zmcknish6@sakura.ne.jp", "+1 109 348 8958", "6833130624","paludisme"));
		patientRepository.save(new NbpPatient(137,"48-019-8070","Diane-marie Menlove", "Menlove", "1/24/2009", 8, "F", "4 Oneill Circle", 41687, "Polytechnic Institute of Bari", "dmenlove7@utexas.edu", "+880 714 815 2806", "453121367222","paludisme"));
		patientRepository.save(new NbpPatient(552,"67-419-0499","Wanda Gilpillan", "Gilpillan", "2/21/1961", 9, "F", "263 Eastlawn Trail", 33920, "California State University, San Marcos", "wgilpillan8@fc2.com", "+382 945 465 3762", "4083993922","mal de tete"));
		patientRepository.save(new NbpPatient(980,"62-207-5767","Netti Perigeaux", "Perigeaux", "9/2/1983", 10, "F", "3 David Hill", 44882, "Mercer University", "nperigeaux9@jigsy.com", "0376 574 8658", "2957471990","mal d'os"));
	}

	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}

}

