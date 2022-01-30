package uz.jl.ui;

import org.bson.types.ObjectId;
import uz.jl.dto.question.QuestionCreateDto;
import uz.jl.dto.question.QuestionDto;
import uz.jl.dto.question.QuestionUpdateDto;
import uz.jl.entity.QuestionAnswer;
import uz.jl.enums.Role;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.security.SecurityHolder;
import uz.jl.service.QuestionService;
import uz.jl.utils.Color;
import uz.jl.utils.Input;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class QuestionUI extends AbstractUI<QuestionService> {

    public QuestionUI(QuestionService service) {
        super(service);
    }

    public void create() {
        if (Objects.isNull(SecurityHolder.user)) {
            showResponse("PLEASE_LOGIN");
            return;
        }
        if (!SecurityHolder.user.getRole().equals(Role.TEACHER)) {
            showResponse("PERMISSION_DENIED");
            return;
        }
        try {
            String title = Input.getStr("Enter title: ");
            String level = Input.getStr("Enter level: ");
            String language = Input.getStr("Enter language: ");
            String category = Input.getStr("Enter category: ");
            Integer mark = Input.getNum("Enter mark: ");
            List<QuestionAnswer> answers = new ArrayList<>();
            createQuestionAnswer(answers);
            while (true) {
                String choice = Input.getStr("More answer (y/n): ");
                if (choice.equalsIgnoreCase("n")) break;
                createQuestionAnswer(answers);
            }
            QuestionCreateDto dto = QuestionCreateDto
                    .builder()
                    .title(title)
                    .level(level)
                    .answers(answers)
                    .language(language)
                    .category(category)
                    .mark(mark)
                    .build();
            ResponseEntity<Data<ObjectId>> response = service.create(dto);
            showResponse(Color.BLUE, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    private void createQuestionAnswer(List<QuestionAnswer> answers) {
        String answer = Input.getStr("Enter answer: ");
        QuestionAnswer questionAnswer = new QuestionAnswer(new ObjectId(), new Date(), answer, false);
        String type = Input.getStr("Is Correct? (y/n): ");
        if (type.equalsIgnoreCase("y")) questionAnswer.setRight(true);
        answers.add(questionAnswer);
    }

    public void update() {
        try {
            String id = Input.getStr("Enter id: ");
            String title = Input.getStr("Enter title: ");
            QuestionUpdateDto dto = QuestionUpdateDto.
                    childBuilder()
                    .title(title)
                    .build();
            dto.setId(id);
            ResponseEntity<Data<Void>> response = service.update(dto);
            showResponse(Color.BLUE, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }

    }

    public void delete() {
        if (Objects.isNull(SecurityHolder.user)) {
            showResponse("PLEASE_LOGIN");
            return;
        }
        if (!SecurityHolder.user.getRole().equals(Role.TEACHER)) {
            showResponse("PERMISSION_DENIED");
            return;
        }
        try {
            String id = Input.getStr("Enter id: ");
            service.delete(new ObjectId(id));
            showResponse(Color.BLUE, "QUESTION_SUCCESSFULLY_DELETED");
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void get() {
        if (Objects.isNull(SecurityHolder.user)) {
            showResponse("PLEASE_LOGIN");
            return;
        }
        if (SecurityHolder.user.getRole().equals(Role.STUDENT)) {
            showResponse("PERMISSION_DENIED");
            return;
        }
        try {
            String id = Input.getStr("Enter id: ");
            ResponseEntity<Data<QuestionDto>> response = service.get(new ObjectId(id));
            showResponse(Color.BLUE, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void getAll() {
        if (Objects.isNull(SecurityHolder.user)) {
            showResponse("PLEASE_LOGIN");
            return;
        }
        if (SecurityHolder.user.getRole().equals(Role.STUDENT)) {
            showResponse("PERMISSION_DENIED");
            return;
        }
        try {
            ResponseEntity<Data<List<QuestionDto>>> response = service.getAll();
            showResponse(Color.BLUE, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }
}
