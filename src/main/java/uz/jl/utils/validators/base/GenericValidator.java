package uz.jl.utils.validators.base;

import uz.jl.configs.ApplicationContextHolder;
import uz.jl.dto.BaseGenericDto;
import uz.jl.dto.GenericDto;
import uz.jl.utils.BaseUtils;

import java.io.Serializable;

/**
 * Info about this class
 *
 * @param <CD>
 * @param <UD>
 * @param <K>
 */
public abstract class GenericValidator<
        CD extends BaseGenericDto,
        UD extends GenericDto,
        K extends Serializable> implements BaseGenericValidator {

    protected BaseUtils utils = ApplicationContextHolder.getBean(BaseUtils.class);


    /**
     * @param id
     */
    public abstract void validKey(K id);

    /**
     * Info for this method
     *
     * @param dto
     */
    public abstract void validOnCreate(CD dto);

    /**
     * @param dto
     */
    public abstract void validOnUpdate(UD dto);

}
