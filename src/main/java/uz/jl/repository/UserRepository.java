package uz.jl.repository;

import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;
import uz.jl.dto.user.UserCreateDto;
import uz.jl.dto.user.UserUpdateDto;
import uz.jl.entity.User;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.GenericCrudRepository;
import uz.jl.utils.validators.UserValidator;

import java.util.List;


public class UserRepository extends AbstractRepository<User>
        implements GenericCrudRepository<User, ObjectId> {

    public UserRepository(Class<User> clazz) {
        super(clazz);
    }

    @Override
    public ObjectId create(User entity) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(ObjectId id) {

    }

    @Override
    public User get(ObjectId id) {
        return collection.find(Filters.eq("_id", id), User.class).first();
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
