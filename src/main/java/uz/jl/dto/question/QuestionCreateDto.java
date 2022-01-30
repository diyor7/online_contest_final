package uz.jl.dto.question;

import lombok.*;
import uz.jl.dto.BaseGenericDto;
import uz.jl.entity.QuestionAnswer;
import uz.jl.enums.Category;
import uz.jl.enums.Language;
import uz.jl.enums.Level;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionCreateDto implements BaseGenericDto {
    private String title;
    private List<QuestionAnswer> answers;
    private String level;
    private String language;
    private String category;
    private int mark;
}
