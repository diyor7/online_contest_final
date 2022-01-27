package uz.jl.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GenericDto implements BaseGenericDto {
    private String id;
}
