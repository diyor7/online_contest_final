package uz.jl.repository.base;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import uz.jl.configs.ApplicationContextHolder;
import uz.jl.entity.base.BaseGenericEntity;
import uz.jl.mappers.BaseGenericMapper;

public abstract class AbstractRepository<E extends BaseGenericEntity, M extends BaseGenericMapper> implements BaseGenericRepository {

    protected MongoCollection<E> collection;
    protected final M mapper;

    protected AbstractRepository(Class<E> clazz, M mapper) {
        this.mapper = mapper;
        MongoDatabase db = ApplicationContextHolder.getBean(MongoDatabase.class);
        this.collection = db.getCollection(clazz.getSimpleName(), clazz);
    }

}
