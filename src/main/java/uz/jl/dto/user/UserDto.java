package uz.jl.dto.user;

import lombok.Builder;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import uz.jl.dto.GenericDto;
import uz.jl.entity.Quiz;
import uz.jl.entity.base.Auditable;
import uz.jl.enums.Language;
import uz.jl.enums.Role;
import uz.jl.enums.Status;

import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 11:14 PM. 1/26/2022
 */
@Builder(builderMethodName = "childBuilder")
public class UserDto extends GenericDto {

    @BsonProperty(value = "full_name")
    private String fullName;

    @BsonProperty(value = "user_name")
    private String userName;

    private String password;

    private String language;

    private String role;

    private String status;

}
