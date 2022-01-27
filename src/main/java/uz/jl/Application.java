package uz.jl;

import uz.jl.configs.ApplicationContextHolder;
import uz.jl.ui.AuthUI;
import uz.jl.ui.MenuUI;
import uz.jl.ui.UserUI;

public class Application {
    private static final MenuUI menu = ApplicationContextHolder.getBean(MenuUI.class);
    private static final AuthUI authUI = ApplicationContextHolder.getBean(AuthUI.class);
    private static final UserUI userUI = ApplicationContextHolder.getBean(UserUI.class);

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        MenuUI.menu();
    }

}
