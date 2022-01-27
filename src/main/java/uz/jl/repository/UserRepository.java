package uz.jl.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;
import uz.jl.dto.user.UserCreateDto;
import uz.jl.dto.user.UserUpdateDto;
import uz.jl.entity.User;
import uz.jl.mappers.user.UserMapper;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.GenericCrudRepository;
import uz.jl.utils.validators.user.UserValidator;

import java.util.List;
import java.util.Objects;


public class UserRepository extends AbstractRepository<User, UserMapper>
        implements GenericCrudRepository<User, UserCreateDto, UserUpdateDto, ObjectId> {

    private final UserValidator validator;

    public UserRepository(Class<User> clazz, UserMapper userMapper, UserValidator userValidator) {
        super(clazz, userMapper);
        this.validator = userValidator;
    }

    @Override
    public ObjectId create(UserCreateDto dto) {
        validator.validOnCreate(dto);
        User user = mapper.fromCreateDto(dto);
        collection.insertOne(user);
        return user.getId();
    }

    @Override
    public void update(UserUpdateDto dto) {

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
