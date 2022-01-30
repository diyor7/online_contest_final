package uz.jl.service;

import org.bson.types.ObjectId;
import uz.jl.dto.user.UserCreateDto;
import uz.jl.dto.user.UserDto;
import uz.jl.dto.user.UserUpdateDto;
import uz.jl.entity.User;
import uz.jl.enums.HttpStatus;
import uz.jl.enums.Role;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.mappers.UserMapper;
import uz.jl.repository.UserRepository;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.security.SecurityHolder;
import uz.jl.service.base.AbstractService;
import uz.jl.service.base.GenericCrudService;
import uz.jl.service.base.GenericService;
import uz.jl.validators.UserValidator;

import java.util.List;
import java.util.Objects;

/**
 * @author Doston Bokhodirov, Wed 11:27 PM. 1/26/2022
 */
public class UserService extends AbstractService<UserRepository, UserMapper, UserValidator> implements GenericService<UserDto, ObjectId>,
        GenericCrudService<UserCreateDto, UserUpdateDto, ObjectId> {

    public UserService(UserRepository repository, UserMapper mapper, UserValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public ResponseEntity<Data<ObjectId>> create(UserCreateDto dto) {
        try {
            validator.validOnCreate(dto);
            User user = mapper.fromCreateDto(dto);
            user.setId(new ObjectId());
            ObjectId objectId = repository.create(user);
            return new ResponseEntity<>(new Data<>(objectId));
        } catch (IllegalArgumentException | ApiRuntimeException e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.HTTP_400);
        }
    }

    @Override
    public ResponseEntity<Data<Void>> update(UserUpdateDto dto) {
        validator.validOnUpdate(dto);
        User user = mapper.fromUpdateDto(dto);
        repository.update(user);
        return new ResponseEntity<>(new Data<>(null));
    }


    @Override
    public ResponseEntity<Data<Void>> delete(ObjectId id) {
        repository.delete(id);
        return new ResponseEntity<>(new Data<>(null));
    }

    @Override
    public ResponseEntity<Data<UserDto>> get(ObjectId id) {
        User user = repository.get(id);
        if (Objects.isNull(user)) {
            throw new ApiRuntimeException("USER_NOT_FOUND", HttpStatus.HTTP_404);
        }
        UserDto dto = mapper.toDto(user);
        return new ResponseEntity<>(new Data<>(dto));
    }

    @Override
    public ResponseEntity<Data<List<UserDto>>> getAll() {
        if (Objects.isNull(SecurityHolder.user) || !SecurityHolder.user.getRole().equals(Role.ADMIN)) {
            throw new ApiRuntimeException("PERMISSION_DENIED", HttpStatus.HTTP_405);
        }
        List<User> userList = repository.getAll();
        List<UserDto> userDtoList = mapper.toDto(userList);
        return new ResponseEntity<>(new Data<>(userDtoList));
    }
}
