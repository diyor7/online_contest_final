package uz.jl.service;

import uz.jl.entity.User;
import uz.jl.enums.HttpStatus;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.exception.CustomSQLException;
import uz.jl.repository.AuthUserRepository;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.security.SecurityHolder;
import uz.jl.service.base.AbstractService;

import static uz.jl.security.SecurityHolder.user;

/**
 * @author Doston Bokhodirov, Thu 12:08 AM. 1/27/2022
 */
public class AuthUserService extends AbstractService<AuthUserRepository> {

    public AuthUserService(AuthUserRepository repository) {
        super(repository);
    }

    public ResponseEntity<Data<Boolean>> login(String username, String password) {
        try {
            User user = repository.login(username, password);
            SecurityHolder.setUser(user);
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(),e.getCause());
        }

    }

//    public ResponseEntity<Data<Void>> logout() {
//        SecurityHolder.killUser();
//    }
}
