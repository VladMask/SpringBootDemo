package MyJavaProject.DemoJava.Entity.Dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
public class CandidateDto {
    private long id;
    private int age;
    private String name;
    private String surname;
    private String skillsDescription;
}
