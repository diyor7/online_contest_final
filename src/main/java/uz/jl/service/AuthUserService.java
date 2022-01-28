package uz.jl.service;

import uz.jl.entity.User;
import uz.jl.enums.HttpStatus;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.mappers.UserMapper;
import uz.jl.repository.AuthUserRepository;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.security.SecurityHolder;
import uz.jl.service.base.AbstractService;
import uz.jl.utils.validators.UserValidator;

import java.util.Objects;

/**
 * @author Doston Bokhodirov, Thu 12:08 AM. 1/27/2022
 */
public class AuthUserService extends AbstractService<AuthUserRepository, UserMapper, UserValidator> {

    public AuthUserService(AuthUserRepository repository, UserMapper mapper, UserValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<Data<Boolean>> login(String username, String password) {
        User user = repository.login(username, password);
        if (Objects.isNull(user)) {
            throw new ApiRuntimeException("USER_NOT_FOUND", HttpStatus.HTTP_404);
        }
        SecurityHolder.setUser(user);
        return new ResponseEntity<>(new Data<>(true));
    }

//    public ResponseEntity<Data<Void>> logout() {
//        SecurityHolder.killUser();
//    }
}
