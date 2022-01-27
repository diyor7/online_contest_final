package uz.jl.mappers;

public abstract class GenericMapper<E, D, CD, UD> implements BaseGenericMapper {

    public abstract E fromCreateDto(CD dto);

    public abstract E fromUpdateDto(UD dto);

    public abstract D toDto(E entity);

    public abstract E fromDto(D dto);
}
