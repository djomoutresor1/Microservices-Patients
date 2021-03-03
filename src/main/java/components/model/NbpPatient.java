package components.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NBP_PATIENTS")
public class NbpPatient {
    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    @NotNull()
    private Integer patientId;
    private String patientCode;
    private String patientName;
    private String patientLassName;
    private String patientBirthday;
    private int patientAge;
    private String patientSexe;
    private String patientAddress;
    private Integer patientPostcode;
    private String patientInfoSuppl;
    private String patientEmail;
    private BigInteger patientPhoneNumber;
    private BigInteger patientFixNumber;
    private String patientDiseases;
    @OneToMany(targetEntity=NbpPatient.class, mappedBy="nbpPatient",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NbpDiseases> diseases;

}
