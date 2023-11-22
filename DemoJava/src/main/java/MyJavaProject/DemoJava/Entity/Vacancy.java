package MyJavaProject.DemoJava.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "vacancy")


public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "description")
    private String description;

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Company: ").append(this.companyName).
                append("\nDescription: ").append(this.description);
        return stringBuilder.toString();
    }

}
