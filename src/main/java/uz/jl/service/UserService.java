package uz.jl.service;

import org.bson.types.ObjectId;
import uz.jl.configs.ApplicationContextHolder;
import uz.jl.dto.user.UserCreateDto;
import uz.jl.dto.user.UserDto;
import uz.jl.dto.user.UserUpdateDto;
import uz.jl.entity.User;
import uz.jl.enums.HttpStatus;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.mappers.user.UserMapper;
import uz.jl.repository.UserRepository;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.service.base.AbstractService;
import uz.jl.service.base.GenericCrudService;
import uz.jl.service.base.GenericService;

import java.util.List;
import java.util.Objects;

/**
 * @author Doston Bokhodirov, Wed 11:27 PM. 1/26/2022
 */
public class UserService extends AbstractService<UserRepository> implements GenericService<UserDto, ObjectId>,
        GenericCrudService<UserCreateDto, UserUpdateDto, ObjectId> {

    private final UserMapper mapper = ApplicationContextHolder.getBean(UserMapper.class);

    public UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<ObjectId>> create(UserCreateDto dto) {
        try {
            ObjectId objectId = repository.create(dto);
            return new ResponseEntity<>(new Data<>(objectId));
        } catch (IllegalArgumentException e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.HTTP_400);
        }
    }

    @Override
    public ResponseEntity<Data<Void>> update(UserUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<UserDto>> get(ObjectId id) {
        User user = repository.get(id);
        if (Objects.isNull(user)) {
            throw new ApiRuntimeException("User not found", HttpStatus.HTTP_404);
        }
        UserDto dto = mapper.toDto(user);
        return new ResponseEntity<>(new Data<>(dto));
    }

    @Override
    public ResponseEntity<Data<List<UserDto>>> getAll() {
        return null;
    }
}
