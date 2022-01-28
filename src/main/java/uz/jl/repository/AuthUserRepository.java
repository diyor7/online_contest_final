package uz.jl.repository;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import uz.jl.entity.User;
import uz.jl.repository.base.AbstractRepository;

/**
 * @author Doston Bokhodirov, Thu 12:11 AM. 1/27/2022
 */
public class AuthUserRepository extends AbstractRepository<User> {

    public AuthUserRepository(Class<User> clazz) {
        super(clazz);
    }

    public User login(String username, String password) {
        Bson usernameFilter = Filters.eq("user_name", username);
        Bson passwordFilter = Filters.eq("password", password);
        return collection.find(Filters.and(usernameFilter, passwordFilter)).first();
    }
}
