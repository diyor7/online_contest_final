package uz.jl.ui;

import uz.jl.configs.ApplicationContextHolder;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

public class MenuUI {
    private static final AuthUI authUI = ApplicationContextHolder.getBean(AuthUI.class);
    private static final UserUI userUI = ApplicationContextHolder.getBean(UserUI.class);

    public static void menu() {
        Print.println(Color.BLUE, "1. Login");
        Print.println(Color.BLUE, "2. Register");
        Print.println(Color.BLUE, "3. Get User");
        Print.println(Color.BLUE, "4. GetAll Users");
        Print.println(Color.BLUE, "5. Update User");
        Print.println(Color.BLUE, "6. Delete User");
        Print.println(Color.BLUE, "0. Exit");

        String str = Input.getStr("Enter choice: ");

        switch (str) {
            case "1" -> authUI.login();
            case "2" -> userUI.create();
            case "3" -> userUI.get();
            case "4" -> userUI.getAll();
            case "5" -> userUI.update();
            case "6" -> userUI.delete();
            case "0" -> {
                Print.println(Color.YELLOW, "Bye");
                return;
            }
            default -> Print.println(Color.RED, "Wrong choice");
        }
        menu();
    }
}
