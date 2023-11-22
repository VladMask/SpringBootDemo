package MyJavaProject.DemoJava.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "person_name")
    private String personName;
    @Column(name = "person_surname")
    private String personSurname;
    @Column(name = "person_company")
    private String personCompany;
    @Column(name = "recommendation_text")
    private String recommendationText;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="candidate_id", referencedColumnName = "id")
    private Candidate candidate;

}
