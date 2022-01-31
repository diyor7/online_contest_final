package uz.jl.dto.quiz;

import lombok.*;
import uz.jl.dto.BaseGenericDto;
import uz.jl.entity.Question;
import uz.jl.enums.Category;
import uz.jl.enums.Language;
import uz.jl.enums.Level;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizCreateDto implements BaseGenericDto {
    private String userId;

    private String language;

    private String category;

    private String level;

//    private List<Question> questions;

//    private int duration;

}