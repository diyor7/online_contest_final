package uz.jl.mappers.base;

import java.util.List;

public abstract class GenericMapper<E, D, CD, UD> implements BaseGenericMapper {

    public abstract E fromCreateDto(CD dto);

    public abstract E fromUpdateDto(UD dto);

    public abstract D toDto(E entity);

    public abstract List<D> toDto(List<E> entityList);

    public abstract E fromDto(D dto);

    public abstract List<E> fromDto(List<D> dtoList);
}
