package uz.jl.utils.validators.user;

import org.bson.types.ObjectId;
import uz.jl.dto.user.UserCreateDto;
import uz.jl.dto.user.UserUpdateDto;
import uz.jl.enums.HttpStatus;
import uz.jl.exception.CustomSQLException;
import uz.jl.utils.validators.GenericValidator;

import java.util.Objects;

/**
 * @author Doston Bokhodirov, Wed 11:17 PM. 1/26/2022
 */
public class UserValidator extends GenericValidator<UserCreateDto, UserUpdateDto, ObjectId> {

    @Override
    public void validKey(ObjectId id) throws IllegalArgumentException {

    }

    @Override
    public void validOnCreate(UserCreateDto dto) throws IllegalArgumentException {
        if (Objects.isNull(dto.getUsername())||Objects.isNull(dto.getFullName())||Objects.isNull(dto.getPassword())) {
            throw new CustomSQLException("BAD_REQUEST", HttpStatus.HTTP_400,"");
        }
    }

    @Override
    public void validOnUpdate(UserUpdateDto dto) throws IllegalArgumentException {

    }
}
