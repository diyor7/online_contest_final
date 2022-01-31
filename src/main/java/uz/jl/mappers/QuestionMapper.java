package uz.jl.mappers;

import org.bson.types.ObjectId;
import uz.jl.dto.question.QuestionCreateDto;
import uz.jl.dto.question.QuestionDto;
import uz.jl.dto.question.QuestionUpdateDto;
import uz.jl.entity.Question;
import uz.jl.enums.Category;
import uz.jl.enums.Language;
import uz.jl.enums.Level;
import uz.jl.mappers.base.GenericMapper;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionMapper extends GenericMapper<Question, QuestionDto, QuestionCreateDto, QuestionUpdateDto> {

    @Override
    public Question fromCreateDto(QuestionCreateDto dto) {
        return Question
                .childBuilder()
                .title(dto.getTitle())
                .answers(dto.getAnswers())
                .language(Language.valueOf(dto.getLanguage()))
                .category(Category.valueOf(dto.getCategory()))
                .level(Level.valueOf(dto.getLevel()))
                .mark(dto.getMark())
                .createdAt(new Date())
                .build();
    }

    @Override
    public Question fromUpdateDto(QuestionUpdateDto dto) {
        return Question
                .childBuilder()
                .title(dto.getTitle())
                .category(dto.getCategory())
                .level(dto.getLevel())
                .language(dto.getLanguage())
                .mark(dto.getMark())
                .answers(dto.getAnswers())
                .id(new ObjectId(dto.getId()))
                .build();
    }

    @Override
    public QuestionDto toDto(Question entity) {
        QuestionDto questionDto = QuestionDto
                .childBuilder()
                .title(entity.getTitle())
                .level(String.valueOf(entity.getLevel()))
                .category(String.valueOf(entity.getCategory()))
                .language(String.valueOf(entity.getLanguage()))
                .mark(String.valueOf(entity.getMark()))
                .answers(entity.getAnswers())
                .build();
        questionDto.setId(String.valueOf(entity.getId()));
        return questionDto;
    }

    @Override
    public List<QuestionDto> toDto(List<Question> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Question fromDto(QuestionDto dto) {
        return null;
    }

    @Override
    public List<Question> fromDto(List<QuestionDto> dtoList) {
        return null;
    }
}
