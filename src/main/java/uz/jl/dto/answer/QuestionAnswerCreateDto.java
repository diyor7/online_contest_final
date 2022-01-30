package uz.jl.dto.answer;

import lombok.*;
import uz.jl.dto.BaseGenericDto;

/**
 * @author Doston Bokhodirov, Sat 6:06 PM. 1/29/2022
 */
@Getter
@Setter
@ToString
@Builder
public class QuestionAnswerCreateDto implements BaseGenericDto {
    private String answer;
    private boolean right;
}
