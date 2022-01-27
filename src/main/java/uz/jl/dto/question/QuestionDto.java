package uz.jl.dto.question;

import uz.jl.dto.GenericDto;
import uz.jl.entity.QuestionAnswer;
import uz.jl.enums.Category;
import uz.jl.enums.Language;
import uz.jl.enums.Level;

import java.util.List;

public class QuestionDto extends GenericDto {
    private String id;
    private String title;
    private String answers;
    private String level;
    private String language;
    private String category;
    private String mark;
}
