package uz.jl.entity;

import lombok.*;
import uz.jl.entity.base.Auditable;
import uz.jl.enums.Category;
import uz.jl.enums.Language;
import uz.jl.enums.Level;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Quiz extends Auditable {
    private int mark;
    private int maxMark;
    private Level level;
    private Category category;
    private Language language;
    private List<Question> questions;
    private boolean closed;
    /**
     * in minutes
     */
    private long duration;

}
