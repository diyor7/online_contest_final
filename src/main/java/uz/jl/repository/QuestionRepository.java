package uz.jl.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import uz.jl.entity.Question;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.GenericCrudRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionRepository extends AbstractRepository<Question> implements
        GenericCrudRepository<Question, ObjectId> {

    public QuestionRepository(Class<Question> clazz) {
        super(clazz);
    }

    @Override
    public ObjectId create(Question entity) {
        collection.insertOne(entity);
        return entity.getId();
    }

    @Override
    public void update(Question entity) {
        BasicDBObject query = new BasicDBObject();
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = mapper.convertValue(entity, new TypeReference<>() {
        });
        query.append("$set", new BasicDBObject(map));
        Bson filter = Filters.eq("_id", new ObjectId(String.valueOf(entity.getId())));
        collection.updateOne(filter, query);
    }


    @Override
    public void delete(ObjectId id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public Question get(ObjectId id) {
        return collection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public List<Question> getAll() {
        List<Question> questionList = new ArrayList<>();
        FindIterable<Question> questions = collection.find();
        for (Question question : questions) questionList.add(question);
        return questionList;
    }
}
