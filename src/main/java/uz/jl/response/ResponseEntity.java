package uz.jl.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.jl.enums.HttpStatus;

/**
 * @author Doston Bokhodirov, Tue 8:25 PM. 1/25/2022
 */
@Getter
@Setter
@ToString
public class ResponseEntity<D> {
    private D body;
    private Integer status;

    public ResponseEntity(D body) {
        this(body, HttpStatus.HTTP_200);
    }

    public ResponseEntity(D body, HttpStatus status) {
        this.body = body;
        this.status = status.getCode();
    }
}
