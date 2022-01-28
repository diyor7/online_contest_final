package uz.jl.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import uz.jl.dto.GenericDto;
import uz.jl.entity.Quiz;
import uz.jl.enums.Language;
import uz.jl.enums.Role;
import uz.jl.enums.Status;

import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 10:54 PM. 1/26/2022
 */
@Getter
@Setter
@Builder(builderMethodName = "childBuilder")
public class UserUpdateDto extends GenericDto {

    @BsonProperty(value = "full_name")
    private String fullName;

    private String username;

    private String password;

    private Role role;

    private Language language;

    private Status status;

    private List<Quiz> quizzes;

    private Quiz currentQuiz;
}
