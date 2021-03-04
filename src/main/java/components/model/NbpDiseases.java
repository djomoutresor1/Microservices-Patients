package components.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NBP_DISEASES")
public class NbpDiseases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diseaseId;
    private String nameDiseases;
    private String descDiseases;

    @ManyToOne
    @JoinColumn(name="diseaseId", insertable = false, updatable = false)
    private NbpPatient nbpPatient;
}
