package uz.jl.ui;

import uz.jl.configs.ApplicationContextHolder;
import uz.jl.security.SecurityHolder;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.util.Objects;

public class MenuUI {
    private static final AuthUI authUI = ApplicationContextHolder.getBean(AuthUI.class);
    private static final UserUI userUI = ApplicationContextHolder.getBean(UserUI.class);

    public static void menu() {
        if (Objects.isNull(SecurityHolder.user)) {
            Print.println(Color.BLUE, "1. Login");
            Print.println(Color.BLUE, "2. Register");
            Print.println(Color.BLUE, "0. Exit");

            String str = Input.getStr("Enter choice: ");

            switch (str) {
                case "1" -> authUI.login();
                case "2" -> userUI.create();
                case "0" -> {
                    Print.println(Color.YELLOW, "Bye");
                    return;
                }
                default -> Print.println(Color.RED, "Wrong choice");
            }
        } else {
            switch (SecurityHolder.user.getRole()) {
                case STUDENT:
                    studentMenu();
                    break;
                case TEACHER:

                    break;
                case ADMIN:

                    break;
            }
        }
        menu();
    }

    private static void studentMenu() {

        Print.println("1. Quizzes");
        Print.println("2. Solved Quizzes");
        Print.println("3. Settings ");
        Print.println("0. Logout");

        String str = Input.getStr("Enter choice: ");

        switch (str) {
//            case "1" -> quizzesMenu();
            case "2" -> allSolvedQuizzesMenu();
            case "3" -> settingsMenu();
            case "0" -> {
                SecurityHolder.killUser();
            }
            default -> {
                Print.println(Color.RED, "Wrong choice");
                studentMenu();
            }
        }
    }

    private static void settingsMenu() {

    }

    private static void allSolvedQuizzesMenu() {

    }

}
