package MyJavaProject.DemoJava.Dto;

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
