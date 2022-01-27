package uz.jl.entity;

import lombok.*;
import org.bson.types.ObjectId;
import uz.jl.entity.base.Auditable;
import uz.jl.enums.Category;
import uz.jl.enums.Language;
import uz.jl.enums.Level;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Question extends Auditable {
    private String title;
    private List<QuestionAnswer> answers;
    private Level level;
    private Language language;
    private Category category;
    private int mark;

    @Builder(builderMethodName = "childBuilder")
    public Question(ObjectId id, Date createdAt, String title, List<QuestionAnswer> answers, Level level, Language language, Category category, int mark) {
        super(id, createdAt);
        this.title = title;
        this.answers = answers;
        this.level = level;
        this.language = language;
        this.category = category;
        this.mark = mark;
    }
}
