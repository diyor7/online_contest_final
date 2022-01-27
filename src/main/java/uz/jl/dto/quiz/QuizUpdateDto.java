package uz.jl.dto.quiz;

import lombok.*;
import uz.jl.dto.GenericDto;
import uz.jl.entity.Question;
import uz.jl.enums.Category;
import uz.jl.enums.Level;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizUpdateDto extends GenericDto {
    private int mark;

    private Level level;

    private Category category;

    private List<Question> questions;

    private boolean closed;

    private int duration;
}
