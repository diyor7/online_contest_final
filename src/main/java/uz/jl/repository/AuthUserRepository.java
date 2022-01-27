package uz.jl.repository;

import com.mongodb.client.model.Filters;
import uz.jl.entity.User;
import uz.jl.enums.HttpStatus;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.exception.CustomSQLException;
import uz.jl.mappers.user.UserMapper;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.utils.validators.user.UserValidator;

/**
 * @author Doston Bokhodirov, Thu 12:11 AM. 1/27/2022
 */
public class AuthUserRepository extends AbstractRepository<User, UserMapper> {
    UserValidator validator;

    public AuthUserRepository(Class<User> clazz, UserMapper mapper, UserValidator validator) {
        super(clazz, mapper);
        this.validator =  validator;
    }

    public User login(String username, String password) {
        try {
            User user = collection.find(Filters.and(Filters.eq("user_name", username),
                    Filters.eq("password", password))).first();
            validator.validOnSessionUser(user);
            return user;
        } catch (ApiRuntimeException e) {
            throw new CustomSQLException(e.getMessage(), HttpStatus.UNDEFINED, "you can not login");
        }
    }
}
