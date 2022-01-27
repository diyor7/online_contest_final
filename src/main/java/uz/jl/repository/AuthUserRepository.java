package uz.jl.repository;

import uz.jl.entity.User;
import uz.jl.mappers.user.UserMapper;
import uz.jl.repository.base.AbstractRepository;

/**
 * @author Doston Bokhodirov, Thu 12:11 AM. 1/27/2022
 */
public class AuthUserRepository extends AbstractRepository<User, UserMapper> {

    public AuthUserRepository(Class<User> clazz, UserMapper mapper) {
        super(clazz, mapper);
    }

    public User login(String username, String password) {
        return null;
    }
}
