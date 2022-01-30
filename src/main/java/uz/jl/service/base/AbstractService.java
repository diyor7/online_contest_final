package uz.jl.service.base;

import uz.jl.mappers.base.BaseGenericMapper;
import uz.jl.repository.base.BaseGenericRepository;
import uz.jl.validators.base.BaseGenericValidator;

/**
 * @author Doston Bokhodirov, Wed 11:25 PM. 1/26/2022
 */
public abstract class AbstractService<
        R extends BaseGenericRepository,
        M extends BaseGenericMapper, V extends BaseGenericValidator> implements BaseGenericService{

    protected R repository;
    protected M mapper;
    protected V validator;

    public AbstractService(R repository, M mapper, V validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }
}
