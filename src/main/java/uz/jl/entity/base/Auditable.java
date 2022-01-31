package uz.jl.entity.base;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Auditable implements BaseGenericEntity {
    @SerializedName("_id")
    @BsonProperty(value = "_id")
    private ObjectId id;

    private Date createdAt;
}
