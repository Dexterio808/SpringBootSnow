package nl.belastingdienst.SpringBootSnow.mappers;

import nl.belastingdienst.SpringBootSnow.domain.Lesson;
import nl.belastingdienst.SpringBootSnow.dtos.LessonDto;

public class LessonMapper {

    public static LessonDto mapToDto(Lesson lesson) {
        LessonDto dto = new LessonDto();

        dto.setId(lesson.getId());
        dto.setDiscipline(lesson.getDiscipline());
        dto.setStartDate(lesson.getStartDate());
        dto.setEndDate(lesson.getEndDate());
        return dto;
    }

    public static Lesson mapToEntity(LessonDto lessonDto) {
        return mapToEntity(new Lesson(), lessonDto);
    }

    public static Lesson mapToEntity(Lesson lesson, LessonDto lessonDto) {
        lesson.setDiscipline(lessonDto.getDiscipline());
        lesson.setStartDate(lessonDto.getStartDate());
        lesson.setEndDate(lessonDto.getEndDate());
        return lesson;
    }
}
