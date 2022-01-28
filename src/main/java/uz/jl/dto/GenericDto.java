package uz.jl.dto;


import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GenericDto implements BaseGenericDto {
    @BsonProperty(value = "_id")
    private String id;
}
