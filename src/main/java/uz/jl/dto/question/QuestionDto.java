package uz.jl.dto.question;

import lombok.Builder;
import uz.jl.dto.GenericDto;
import uz.jl.entity.QuestionAnswer;

import java.util.List;

@Builder(builderMethodName = "childBuilder")
public class QuestionDto extends GenericDto {
    private String title;
    private List<QuestionAnswer> answers;
    private String level;
    private String language;
    private String category;
    private String mark;
}
