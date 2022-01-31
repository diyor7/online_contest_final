package uz.jl.dto.quiz;

import uz.jl.dto.GenericDto;
import uz.jl.dto.question.QuestionDto;
import uz.jl.entity.Question;
import uz.jl.enums.Category;
import uz.jl.enums.Level;

import java.util.List;

public class QuizDto extends GenericDto {

    private int mark;

    private String level;

    private String  category;

    private List<QuestionDto> questions;

    private boolean closed;

    private int duration;

}