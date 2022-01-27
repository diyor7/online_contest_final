package uz.jl.service.base;

import uz.jl.dto.BaseGenericDto;
import uz.jl.dto.GenericDto;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;

import java.io.Serializable;

/**
 * @author Doston Bokhodirov, Wed 11:26 PM. 1/26/2022
 */

/**
 *
 * @param <CD>
 * @param <UD>
 * @param <K>
 */
public interface GenericCrudService<
        CD extends BaseGenericDto,
        UD extends GenericDto,
        K extends Serializable> {

    ResponseEntity<Data<K>> create(CD dto);

    ResponseEntity<Data<Void>> update(UD dto);

    ResponseEntity<Data<Void>> delete(K id);

}
