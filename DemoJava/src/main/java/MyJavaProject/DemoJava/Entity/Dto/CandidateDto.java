package MyJavaProject.DemoJava.Entity.Dto;

import MyJavaProject.DemoJava.Entity.Recommendation;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class CandidateDto {
    private long id;
    private int age;
    private String name;
    private String surname;
    private String skillsDescription;
    private List<RecommendationDto> recommendations;
}
