package uz.jl.entity;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import uz.jl.entity.base.Auditable;
import uz.jl.enums.Language;
import uz.jl.enums.Role;
import uz.jl.enums.Status;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends Auditable {

    @BsonProperty(value = "full_name")
    private String fullName;

    @BsonProperty(value = "user_name")
    private String username;

    private String password;
    private Language language;
    private Role role;
    private Status status;
    private List<Quiz> quizzes;
    private Quiz currentQuiz;

    @Builder(builderMethodName = "childBuilder")
    public User(ObjectId id, Date createdAt, String fullName, String username, String password, Language language, Role role, Status status, List<Quiz> quizzes, Quiz currentQuiz) {
        super(id, createdAt);
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.language = language;
        this.role = role;
        this.status = status;
        this.quizzes = quizzes;
        this.currentQuiz = currentQuiz;
    }
}
