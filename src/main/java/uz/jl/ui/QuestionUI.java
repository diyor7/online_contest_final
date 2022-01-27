package uz.jl.ui;

import uz.jl.entity.Question;
import uz.jl.service.QuestionService;

public class QuestionUI extends AbstractUI<QuestionService> {

    public QuestionUI(QuestionService service) {
        super(service);
    }
}
