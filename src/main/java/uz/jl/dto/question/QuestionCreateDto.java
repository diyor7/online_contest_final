package uz.jl.dto.question;

import uz.jl.dto.BaseGenericDto;
import uz.jl.entity.QuestionAnswer;
import uz.jl.enums.Category;
import uz.jl.enums.Language;
import uz.jl.enums.Level;

import java.util.List;

public class QuestionCreateDto implements BaseGenericDto {
    private String title;
    private List<QuestionAnswer> answers;
    private Level level;
    private Language language;
    private Category category;
    private int mark;
}
