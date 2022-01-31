package uz.jl.configs;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import uz.jl.entity.Question;
import uz.jl.entity.QuestionAnswer;
import uz.jl.entity.User;
import uz.jl.mappers.QuestionAnswerMapper;
import uz.jl.mappers.QuestionMapper;
import uz.jl.mappers.QuizMapper;
import uz.jl.mappers.UserMapper;
import uz.jl.repository.AuthUserRepository;
import uz.jl.repository.QuestionAnswerRepository;
import uz.jl.repository.QuestionRepository;
import uz.jl.repository.UserRepository;
import uz.jl.service.AuthUserService;
import uz.jl.service.QuestionAnswerService;
import uz.jl.service.QuestionService;
import uz.jl.service.UserService;
import uz.jl.ui.AuthUI;
import uz.jl.ui.QuestionAnswerUI;
import uz.jl.ui.QuestionUI;
import uz.jl.ui.UserUI;
import uz.jl.utils.BaseUtils;
import uz.jl.validators.QuestionAnswerValidator;
import uz.jl.validators.QuestionValidator;
import uz.jl.validators.UserValidator;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ApplicationContextHolder {

    private static MongoDatabase db;

    private static final BaseUtils baseUtils;

    private static final UserMapper userMapper;
    private static final QuizMapper quizMapper;
    private static final QuestionMapper questionMapper;
    private static final QuestionAnswerMapper questionAnswerMapper;

    private static final UserValidator userValidator;
    private static final QuestionValidator questionValidator;
    private static final QuestionAnswerValidator questionAnswerValidator;

    private static final UserRepository userRepository;
    private static final AuthUserRepository authUserRepository;
    private static final QuestionRepository questionRepository;
    private static final QuestionAnswerRepository questionAnswerRepository;

    private static final UserService userService;
    private static final AuthUserService authUserService;
    private static final QuestionService questionService;
    private static final QuestionAnswerService questionAnswerService;

    private static final AuthUI authUI;
    private static final UserUI userUI;
    private static final QuestionUI questionUI;
    private static final QuestionAnswerUI questionAnswerUI;

    static {
        connect();

        baseUtils = new BaseUtils();

        userMapper = new UserMapper();
        quizMapper = new QuizMapper();
        questionMapper = new QuestionMapper();
        questionAnswerMapper = new QuestionAnswerMapper();

        userValidator = new UserValidator();
        questionValidator = new QuestionValidator();
        questionAnswerValidator = new QuestionAnswerValidator();

        authUserRepository = new AuthUserRepository(User.class);
        userRepository = new UserRepository(User.class);
        questionRepository = new QuestionRepository(Question.class);
        questionAnswerRepository = new QuestionAnswerRepository(Question.class);

        userService = new UserService(userRepository, userMapper, userValidator);
        authUserService = new AuthUserService(authUserRepository, userMapper, userValidator);
        questionService = new QuestionService(questionRepository, questionMapper, questionValidator);
        questionAnswerService = new QuestionAnswerService(questionAnswerRepository, questionAnswerMapper, questionAnswerValidator);

        authUI = new AuthUI(authUserService);
        userUI = new UserUI(userService);
        questionUI = new QuestionUI(questionService);
        questionAnswerUI = new QuestionAnswerUI(questionAnswerService);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getBean(clazz.getSimpleName());
    }

    private static <T> T getBean(String name) {
        return switch (name) {
            case "MongoDatabase" -> (T) db;

            case "UserRepository" -> (T) userRepository;
            case "AuthUserRepository" -> (T) authUserRepository;
            case "QuestionRepository" -> (T) questionRepository;
            case "QuestionAnswerRepository" -> (T) questionAnswerRepository;

            case "UserService" -> (T) userService;
            case "AuthUserService" -> (T) authUserService;
            case "QuestionService" -> (T) questionService;
            case "QuestionAnswerService" -> (T) questionAnswerService;

            case "UserMapper" -> (T) userMapper;
            case "QuizMapper" -> (T) quizMapper;
            case "QuestionMapper" -> (T) questionMapper;
            case "QuestionAnswerMapper" -> (T) questionAnswerMapper;

            case "UserValidator" -> (T) userValidator;
            case "QuestionValidator" -> (T) questionValidator;
            case "questionAnswerValidator" -> (T) questionAnswerValidator;

            case "UserUI" -> (T) userUI;
            case "AuthUI" -> (T) authUI;
            case "QuestionUI" -> (T) questionUI;
            case "QuestionAnswerUI" -> (T) questionAnswerUI;

            case "BaseUtils" -> (T) baseUtils;

            default -> throw new RuntimeException("Bean Not Found Exception");
        };
    }


    private static void connect() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();

        Logger rootLogger = Logger.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.OFF);
        try {
            MongoClient mongoClient = MongoClients.create(clientSettings);
            db = mongoClient.getDatabase("online-contest");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
