package MyJavaProject.DemoJava.Entity.Dto.Converter;

import MyJavaProject.DemoJava.Entity.Dto.CandidateDto;
import MyJavaProject.DemoJava.Entity.Candidate;

import java.util.List;

public class CandidateConverter {
    public static CandidateDto convertCandidate(Candidate source)
    {
        return CandidateDto.builder()
                .id(source.getId())
                .age(source.getAge())
                .name(source.getName())
                .surname(source.getSurname())
                .skillsDescription(source.getSkillsDescription())
                //.recommendations(source.getRecommendations())
                .build();
    }

    public static Candidate convertDto(CandidateDto source)
    {
        return Candidate.builder()
                .id(source.getId())
                .age(source.getAge())
                .name(source.getName())
                .surname(source.getSurname())
                .skillsDescription(source.getSkillsDescription())
                //.recommendations(source.getRecommendations())
                .build();
    }

    public static List<CandidateDto> ConverCandidates(List<Candidate> source)
    {
        return source.stream()
                .map(CandidateConverter::convertCandidate)
                .toList();
    }

    public static List<Candidate> ConverDtos(List<CandidateDto> source)
    {
        return source.stream()
                .map(CandidateConverter::convertDto)
                .toList();
    }
}
