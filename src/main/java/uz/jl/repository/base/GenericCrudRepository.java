package uz.jl.repository.base;

import uz.jl.entity.base.BaseGenericEntity;

import java.io.Serializable;

public interface GenericCrudRepository<E extends BaseGenericEntity, K extends Serializable>
        extends GenericRepository<E, K> {

    K create(E entity);

    void update(E entity);

    void delete(K id);
}
