package uz.jl.dto.answer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.jl.dto.GenericDto;

/**
 * @author Doston Bokhodirov, Sat 6:08 PM. 1/29/2022
 */
@Getter
@Setter
@ToString
@Builder(builderMethodName = "childBuilder")
public class QuestionAnswerUpdateDto extends GenericDto {
    private String answer;
    private boolean right;
}
