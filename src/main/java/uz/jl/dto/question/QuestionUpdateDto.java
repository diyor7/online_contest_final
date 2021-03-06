package uz.jl.dto.question;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.jl.dto.GenericDto;
import uz.jl.entity.QuestionAnswer;
import uz.jl.enums.Category;
import uz.jl.enums.Language;
import uz.jl.enums.Level;

import java.util.List;

@Getter
@Setter
@ToString
@Builder(builderMethodName = "childBuilder")
public class QuestionUpdateDto extends GenericDto {
    private String title;
    private List<QuestionAnswer> answers;
    private Level level;
    private Language language;
    private Category category;
    private int mark;
}
