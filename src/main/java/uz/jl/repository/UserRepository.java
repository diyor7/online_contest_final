package uz.jl.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import uz.jl.entity.User;
import uz.jl.enums.Status;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.GenericCrudRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserRepository extends AbstractRepository<User>
        implements GenericCrudRepository<User, ObjectId> {

    public UserRepository(Class<User> clazz) {
        super(clazz);
    }

    @Override
    public ObjectId create(User entity) {
        collection.insertOne(entity);
        return entity.getId();
    }

    @Override
    public void update(User entity) {
        BasicDBObject query = new BasicDBObject();
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = mapper.convertValue(entity, new TypeReference<>() {});
        query.append("$set", new BasicDBObject(map));
        Bson filter = Filters.eq("_id", new ObjectId(String.valueOf(entity.getId())));
        collection.updateOne(filter, query);
    }

    @Override
    public void delete(ObjectId id) {
        Bson filter = Filters.eq("_id", id);
        Bson update = Updates.set("status", Status.DELETED);
        collection.updateOne(filter, update);
    }

    @Override
    public User get(ObjectId id) {
        return collection.find(Filters.eq("_id", id), User.class).first();
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        FindIterable<User> iterDoc = collection.find();
        for (User user : iterDoc) {
            userList.add(user);
        }
        return userList;
    }
}
