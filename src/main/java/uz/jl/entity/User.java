package uz.jl.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import uz.jl.entity.base.Auditable;
import uz.jl.enums.Language;
import uz.jl.enums.Role;
import uz.jl.enums.Status;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(builderMethodName = "childBuilder")
public class User extends Auditable {

    @BsonProperty(value = "full_name")
    @SerializedName("full_name")
    private String fullName;

    @BsonProperty(value = "user_name")
    @SerializedName("user_name")
    private String userName;

    private String password;
    private Language language;
    private Role role;
    private Status status;
    private List<Quiz> quizzes;
    private Quiz currentQuiz;

}
