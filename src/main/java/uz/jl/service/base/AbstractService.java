package uz.jl.service.base;

import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.BaseGenericRepository;

/**
 * @author Doston Bokhodirov, Wed 11:25 PM. 1/26/2022
 */
public abstract class AbstractService<R extends BaseGenericRepository> implements BaseGenericService{

    protected R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }
}
