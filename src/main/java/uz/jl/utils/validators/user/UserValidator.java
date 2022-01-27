package uz.jl.utils.validators.user;

import org.bson.types.ObjectId;
import uz.jl.dto.user.UserCreateDto;
import uz.jl.dto.user.UserUpdateDto;
import uz.jl.entity.User;
import uz.jl.enums.HttpStatus;
import uz.jl.enums.Status;
import uz.jl.exception.ApiRuntimeException;
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
        if (Objects.isNull(dto.getUsername()) || Objects.isNull(dto.getFullName()) || Objects.isNull(dto.getPassword())) {
            throw new CustomSQLException("BAD_REQUEST", HttpStatus.HTTP_400, "");
        }
    }

    @Override
    public void validOnUpdate(UserUpdateDto dto) throws IllegalArgumentException {

    }

    public void validOnSessionUser(User user) {
        if (Objects.isNull(user)) {
            throw new ApiRuntimeException("Bad credentials", HttpStatus.HTTP_404);
        }
        if (user.getStatus().equals(Status.NO_ACTIVE) || user.getStatus().equals(Status.BLOCKED)) {
            throw new ApiRuntimeException("User not ACTIVE", HttpStatus.HTTP_401);
        }

    }
}
