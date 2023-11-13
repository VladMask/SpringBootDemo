package MyJavaProject.DemoJava.Entity.Dto.Converter;

import MyJavaProject.DemoJava.Entity.Dto.VacancyDto;
import MyJavaProject.DemoJava.Entity.Vacancy;

import java.util.List;

public class VacancyConverter {

    public static VacancyDto convertVacancy(Vacancy source)
    {
        return VacancyDto.builder()
                .id(source.getId())
                .companyName(source.getCompanyName())
                .description(source.getDescription()).build();
    }

    public static Vacancy convertDto(VacancyDto source)
    {
        return Vacancy.builder()
                .id(source.getId())
                .companyName(source.getCompanyName())
                .description(source.getDescription()).build();
    }

    public static List<VacancyDto> convertVacancies(List<Vacancy> source)
    {
        return source.stream()
                .map(VacancyConverter::convertVacancy)
                .toList();
    }

    public static List<Vacancy> convertDtos(List<VacancyDto> source)
    {
        return source.stream()
                .map(VacancyConverter::convertDto)
                .toList();
    }
}
