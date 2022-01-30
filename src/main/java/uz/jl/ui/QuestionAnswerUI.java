package uz.jl.ui;

import uz.jl.service.QuestionAnswerService;
import uz.jl.utils.Input;

/**
 * @author Doston Bokhodirov, Sat 5:50 PM. 1/29/2022
 */
public class QuestionAnswerUI extends AbstractUI<QuestionAnswerService> {

    public QuestionAnswerUI(QuestionAnswerService service) {
        super(service);
    }

    public void create() {
        String answer = Input.getStr("Enter answer: ");
    }
}
