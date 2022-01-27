package uz.jl;

import uz.jl.configs.ApplicationContextHolder;
import uz.jl.security.SecurityHolder;
import uz.jl.ui.AuthUI;
import uz.jl.ui.MenuUI;
import uz.jl.ui.UserUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.util.Objects;

public class Application {
    private static final MenuUI menu = ApplicationContextHolder.getBean(MenuUI.class);
    private static final AuthUI authUI = ApplicationContextHolder.getBean(AuthUI.class);
    private static final UserUI userUI = ApplicationContextHolder.getBean(UserUI.class);

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        String opt = Input.getStr();
        if (Objects.isNull(SecurityHolder.user)) {
//            menu.authMenu();
            if (opt.equals("1")) {
                authUI.login();
            } else if (opt.equals("2")) {
                userUI.create();
            }
        }
        if (opt.equals("0")) {
            Print.println(Color.RED, "Bopti");
            return;
        }
        run();
    }

}
