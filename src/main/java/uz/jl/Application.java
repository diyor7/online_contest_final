package uz.jl;

import org.bson.types.ObjectId;
import uz.jl.configs.ApplicationContextHolder;
import uz.jl.entity.User;
import uz.jl.repository.UserRepository;
import uz.jl.ui.AuthUI;
import uz.jl.ui.MenuUI;
import uz.jl.ui.UserUI;

public class Application {

    public static void main(String[] args) {
        MenuUI.menu();
    }

}
