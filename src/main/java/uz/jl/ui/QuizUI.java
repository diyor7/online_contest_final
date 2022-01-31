package uz.jl.ui;

import org.bson.types.ObjectId;
import uz.jl.dto.quiz.QuizCreateDto;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.security.SecurityHolder;
import uz.jl.service.QuizService;
import uz.jl.utils.Input;

import static uz.jl.security.SecurityHolder.user;

public class QuizUI extends AbstractUI<QuizService> {
    public QuizUI(QuizService service) {
        super(service);
    }

    public void create(){
        String userId = user.getId().toString();
        String language = Input.getStr("Language: ");
        String category = Input.getStr("Category: ");
        String level = Input.getStr("Level: ");

        QuizCreateDto dto = new QuizCreateDto(userId,language, category, level);

        ResponseEntity<Data<ObjectId>> response = service.create(dto);




    }
}
