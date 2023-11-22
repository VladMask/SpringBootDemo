package MyJavaProject.DemoJava.Entity.Dto.Converter;

import MyJavaProject.DemoJava.Entity.Dto.RecommendationDto;
import MyJavaProject.DemoJava.Entity.Dto.VacancyDto;
import MyJavaProject.DemoJava.Entity.Recommendation;
import MyJavaProject.DemoJava.Entity.Vacancy;

import java.util.List;

public class RecommendationConverter {

    public static RecommendationDto convertRecommendation(Recommendation source)
    {
        return RecommendationDto.builder()
                .id(source.getId())
                .recommendationText(source.getRecommendationText())
                .candidate(source.getCandidate())
                .personCompany(source.getPersonCompany())
                .personName(source.getPersonName())
                .personSurname(source.getPersonSurname())
                .build();
    }

    public static Recommendation convertDto(RecommendationDto source)
    {
        return Recommendation.builder()
                .id(source.getId())
                .recommendationText(source.getRecommendationText())
                .candidate(source.getCandidate())
                .personCompany(source.getPersonCompany())
                .personName(source.getPersonName())
                .personSurname(source.getPersonSurname())
                .build();
    }

    public static List<RecommendationDto> convertRecommendations(List<Recommendation> source)
    {
        return source.stream()
                .map(RecommendationConverter::convertRecommendation)
                .toList();
    }

    public static List<Recommendation> convertDtos(List<RecommendationDto> source)
    {
        return source.stream()
                .map(RecommendationConverter::convertDto)
                .toList();
    }
}
