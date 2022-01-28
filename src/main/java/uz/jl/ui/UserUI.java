package uz.jl.ui;

import com.mongodb.MongoException;
import org.bson.types.ObjectId;
import uz.jl.dto.user.UserCreateDto;
import uz.jl.dto.user.UserDto;
import uz.jl.dto.user.UserUpdateDto;
import uz.jl.enums.Role;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.security.SecurityHolder;
import uz.jl.service.UserService;
import uz.jl.utils.Color;
import uz.jl.utils.Input;

import java.util.List;
import java.util.Objects;

/**
 * @author Doston Bokhodirov, Thu 12:05 AM. 1/27/2022
 */
public class UserUI extends AbstractUI<UserService> {

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
            ResponseEntity<Data<ObjectId>> response = service.create(dto);
            showResponse(Color.BLUE, response);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void get() {
        try {
            String id = Input.getStr("Enter id: ");
            ResponseEntity<Data<UserDto>> response = service.get(new ObjectId(id));
            showResponse(Color.BLUE, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void update() {
        try {
            String id = Input.getStr("Enter id: ");
            String username = Input.getStr("Enter username: ");
            String fullName = Input.getStr("Enter fullName: ");
            UserUpdateDto userUpdateDto = UserUpdateDto
                    .childBuilder()
                    .username(username)
                    .fullName(fullName)
                    .build();
            userUpdateDto.setId(id);
            service.update(userUpdateDto);
            showResponse(Color.BLUE, service.get(new ObjectId(userUpdateDto.getId())).getBody());
        } catch (ApiRuntimeException | MongoException e) {
            showResponse(e.getMessage());
        }
    }

    public void delete() {
        try {
            if (Objects.isNull(SecurityHolder.user) || !SecurityHolder.user.getRole().equals(Role.ADMIN)) {
                showResponse("PERMISSION_DENIED");
                return;
            }
            String id = Input.getStr("Enter id: ");
            service.delete(new ObjectId(id));
            showResponse(Color.BLUE, "USER_SUCCESSFULLY_DELETED");
        } catch (ApiRuntimeException | MongoException e) {
            showResponse(e.getMessage());
        }
    }

    public void getAll() {
        try {
            ResponseEntity<Data<List<UserDto>>> response = service.getAll();
            showResponse(Color.BLUE, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

}
