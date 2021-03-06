package com.nbp.bear.components.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NBP_PATIENTS")
public class NbpPatient {
    @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY)
    @NotNull()
    private int patientId;
    private String patientCode;
    private String patientName;
    private String patientLassName;
    private String patientBirthday;
    private int patientAge;
    private String patientSexe;
    private String patientAddress;
    private int patientPostcode;
    private String patientInfoSuppl;
    private String patientEmail;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String patientPhoneNumber;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String patientFixNumber;
    private String patientDiseases;
//    @OneToMany(targetEntity=NbpPatient.class, mappedBy="diseases",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<NbpDiseases> diseases;

}
