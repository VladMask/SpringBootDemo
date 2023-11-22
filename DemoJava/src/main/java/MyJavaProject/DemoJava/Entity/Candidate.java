package MyJavaProject.DemoJava.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "candidate")

public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "skills_description")
    private String skillsDescription;
    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    @Column(name = "recommendations")
    @JsonManagedReference
    private List<Recommendation> recommendations;

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Candidate: ").append(this.name).append(" ").append(this.surname).
                append("\nAge: ").append(this.age).append("\nSkills: ").append(this.skillsDescription);
        return sb.toString();
    }
}
