package uz.jl.service.base;

import uz.jl.dto.GenericDto;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface GenericService<D extends GenericDto , K extends Serializable> {

    ResponseEntity<Data<D>> get(K id);

    ResponseEntity<Data<List<D>>> getAll();

}
