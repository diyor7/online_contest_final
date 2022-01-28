package uz.jl.dto.user;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import uz.jl.dto.BaseGenericDto;
import uz.jl.enums.Role;

/**
 * @author Doston Bokhodirov, Wed 10:45 PM. 1/26/2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto implements BaseGenericDto {

    @BsonProperty(value = "full_name")
    @SerializedName("full_name")
    private String fullName;

    private String username;

    private String password;

    private Role role;
}
