package uz.jl.repository.base;

import uz.jl.dto.BaseGenericDto;
import uz.jl.dto.GenericDto;
import uz.jl.entity.base.BaseGenericEntity;

import java.io.Serializable;

public interface GenericCrudRepository<E extends BaseGenericEntity,
        CD extends BaseGenericDto, UD extends GenericDto, K extends Serializable>
        extends GenericRepository<E, K> {

    K create(CD dto);

    void update(UD dto);

    void delete(K id);
}
