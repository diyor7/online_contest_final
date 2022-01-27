package uz.jl.dto.quiz;

import lombok.*;
import uz.jl.dto.BaseGenericDto;
import uz.jl.entity.Question;
import uz.jl.enums.Category;
import uz.jl.enums.Level;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizCreateDto implements BaseGenericDto {

    private Level level;

    private Category category;

    private List<Question> questions;

    private int duration;

}