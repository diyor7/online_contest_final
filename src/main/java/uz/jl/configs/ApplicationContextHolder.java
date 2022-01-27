package uz.jl.configs;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import uz.jl.entity.User;
import uz.jl.mappers.UserMapper;
import uz.jl.repository.AuthUserRepository;
import uz.jl.repository.UserRepository;
import uz.jl.service.AuthUserService;
import uz.jl.service.UserService;
import uz.jl.ui.AuthUI;
import uz.jl.ui.MenuUI;
import uz.jl.ui.UserUI;
import uz.jl.utils.BaseUtils;
import uz.jl.utils.validators.UserValidator;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ApplicationContextHolder {

    private static MongoDatabase db;

    private static final BaseUtils baseUtils;

    private static final UserMapper userMapper;
    private static final UserValidator userValidator;

    private static final UserRepository userRepository;
    private static final AuthUserRepository authUserRepository;

    private static final UserService userService;
    private static final AuthUserService authUserService;

    private static final AuthUI authUI;
    private static final UserUI userUI;

    private static final MenuUI menuUI;

    static {
        connect();

        baseUtils = new BaseUtils();

        userMapper = new UserMapper();
        userValidator = new UserValidator();

        authUserRepository = new AuthUserRepository(User.class);
        userRepository = new UserRepository(User.class);

        userService = new UserService(userRepository, userMapper, userValidator);
        authUserService = new AuthUserService(authUserRepository, userMapper, userValidator);

        menuUI = new MenuUI();
        authUI = new AuthUI(authUserService);
        userUI = new UserUI(userService);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getBean(clazz.getSimpleName());
    }

    private static <T> T getBean(String name) {
        return switch (name) {
            case "MongoDatabase" -> (T) db;

            case "UserRepository" -> (T) userRepository;
            case "AuthUserRepository" -> (T) authUserRepository;

            case "UserService" -> (T) userService;
            case "AuthUserService" -> (T) authUserService;

            case "UserMapper" -> (T) userMapper;

            case "UserValidator" -> (T) userValidator;

            case "UserUI" -> (T) userUI;
            case "AuthUI" -> (T) authUI;
            case "MenuUI" -> (T) menuUI;

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
