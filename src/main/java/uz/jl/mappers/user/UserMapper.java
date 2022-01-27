package uz.jl.mappers.user;

import uz.jl.dto.user.UserCreateDto;
import uz.jl.dto.user.UserDto;
import uz.jl.dto.user.UserUpdateDto;
import uz.jl.entity.User;
import uz.jl.enums.Language;
import uz.jl.enums.Status;
import uz.jl.mappers.BaseGenericMapper;
import uz.jl.mappers.GenericMapper;

/**
 * @author Doston Bokhodirov, Wed 11:10 PM. 1/26/2022
 */
public class UserMapper extends GenericMapper<User, UserDto, UserCreateDto, UserUpdateDto> implements BaseGenericMapper {

    @Override
    public User fromCreateDto(UserCreateDto dto) {
        return User
                .childBuilder()
                .userName(dto.getUsername())
                .fullName(dto.getFullName())
                .password(dto.getPassword())
                .status(Status.NO_ACTIVE)
                .language(Language.EN)
                .role(dto.getRole())
                .build();
    }

    @Override
    public User fromUpdateDto(UserUpdateDto dto) {
        return null;
    }
}
