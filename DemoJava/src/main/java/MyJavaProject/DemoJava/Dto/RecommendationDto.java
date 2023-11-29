package MyJavaProject.DemoJava.Dto;

import MyJavaProject.DemoJava.Entity.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendationDto {

    private long id;
    private String personName;
    private String personSurname;
    private String personCompany;
    private String recommendationText;
    @JsonIgnore
    private Candidate candidate;

}