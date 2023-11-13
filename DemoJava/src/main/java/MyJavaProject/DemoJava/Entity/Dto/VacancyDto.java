package MyJavaProject.DemoJava.Entity.Dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
public class VacancyDto {

    private long id;
    private String companyName;
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
