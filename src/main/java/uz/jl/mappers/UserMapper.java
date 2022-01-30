package uz.jl.mappers;

import org.bson.types.ObjectId;
import uz.jl.dto.user.UserCreateDto;
import uz.jl.dto.user.UserDto;
import uz.jl.dto.user.UserUpdateDto;
import uz.jl.entity.User;
import uz.jl.enums.Language;
import uz.jl.enums.Status;
import uz.jl.mappers.base.BaseGenericMapper;
import uz.jl.mappers.base.GenericMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Doston Bokhodirov, Wed 11:10 PM. 1/26/2022
 */
public class UserMapper extends GenericMapper<User, UserDto, UserCreateDto, UserUpdateDto> implements BaseGenericMapper {
    @Override
    public User fromCreateDto(UserCreateDto dto) {
        return User
                .childBuilder()
                .username(dto.getUsername())
                .fullName(dto.getFullName())
                .password(dto.getPassword())
                .status(Status.NO_ACTIVE)
                .language(Language.EN)
                .role(dto.getRole())
                .build();
    }

    @Override
    public User fromUpdateDto(UserUpdateDto dto) {
        return User
                .childBuilder()
                .username(dto.getUsername())
                .fullName(dto.getFullName())
                .password(dto.getPassword())
                .status(dto.getStatus())
                .language(dto.getLanguage())
                .role(dto.getRole())
                .id(new ObjectId(dto.getId()))
                .build();
    }

    @Override
    public UserDto toDto(User entity) {
        UserDto userDto = UserDto
                .childBuilder()
                .userName(entity.getUsername())
                .password(entity.getPassword())
                .fullName(entity.getFullName())
                .role(String.valueOf(entity.getRole()))
                .status(String.valueOf(entity.getStatus()))
                .language(String.valueOf(entity.getLanguage()))
                .build();
        userDto.setId(String.valueOf(entity.getId()));
        return userDto;
    }

    @Override
    public List<UserDto> toDto(List<User> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public User fromDto(UserDto dto) {
        return null;
    }

    @Override
    public List<User> fromDto(List<UserDto> dtoList) {
        return null;
    }

}
