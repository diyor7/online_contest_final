package uz.jl.ui;

import org.bson.types.ObjectId;
import uz.jl.configs.ApplicationContextHolder;
import uz.jl.dto.user.UserCreateDto;
import uz.jl.dto.user.UserDto;
import uz.jl.enums.Role;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.security.SecurityHolder;
import uz.jl.service.UserService;
import uz.jl.utils.Input;
import uz.jl.utils.Color;

import java.util.Objects;

/**
 * @author Doston Bokhodirov, Thu 12:05 AM. 1/27/2022
 */
public class UserUI extends AbstractUI<UserService> {
    private final UserService userService = ApplicationContextHolder.getBean(UserService.class);


    public UserUI(UserService service) {
        super(service);
    }

    public void create() {
        try {
            String username = Input.getStr("Enter username: ");
            String password = Input.getStr("Enter password: ");
            String fullName = Input.getStr("Enter fullName: ");
            UserCreateDto dto = UserCreateDto
                    .builder()
                    .username(username)
                    .password(password)
                    .fullName(fullName)
                    .build();
            if (Objects.isNull(SecurityHolder.user)) {
                dto.setRole(Role.STUDENT);
            } else if (SecurityHolder.user.getRole().equals(Role.ADMIN)) {
                dto.setRole(Role.TEACHER);
            }
            ResponseEntity<Data<ObjectId>> response = userService.create(dto);
            showResponse(Color.BLUE, response);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void get() {
        try {
            String idStr = Input.getStr("Enter id: ");
            ObjectId id = new ObjectId(idStr);
            ResponseEntity<Data<UserDto>> response = service.get(id);
            showResponse(response);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void update() {

    }

    public void delete() {

    }

    public void getAll() {

    }

}
