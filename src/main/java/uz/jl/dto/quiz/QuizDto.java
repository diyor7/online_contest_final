package uz.jl.dto.quiz;

import uz.jl.dto.GenericDto;
import uz.jl.entity.Question;
import uz.jl.enums.Category;
import uz.jl.enums.Level;

import java.util.List;

public class QuizDto extends GenericDto {

    private int mark;

    private Level level;

    private Category category;

    private List<Question> questions;

    private boolean closed;

    private int duration;

}