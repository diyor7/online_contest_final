package uz.jl;

import uz.jl.configs.ApplicationContextHolder;
import uz.jl.ui.AuthUI;
import uz.jl.ui.QuestionUI;
import uz.jl.ui.UserUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

public class Application {
    private static final AuthUI authUI = ApplicationContextHolder.getBean(AuthUI.class);
    private static final UserUI userUI = ApplicationContextHolder.getBean(UserUI.class);
    private static final QuestionUI questionUI = ApplicationContextHolder.getBean(QuestionUI.class);

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Print.println(Color.BLUE, "1. Login");
        Print.println(Color.BLUE, "2. Register");
        Print.println(Color.BLUE, "3. Get User");
        Print.println(Color.BLUE, "4. GetAll Users");
        Print.println(Color.BLUE, "5. Update User");
        Print.println(Color.BLUE, "6. Delete User");
        Print.println(Color.BLUE, "7. Create Question");
        Print.println(Color.BLUE, "8. Update Question");
        Print.println(Color.BLUE, "9. Delete Question");
        Print.println(Color.BLUE, "10. Get Question");
        Print.println(Color.BLUE, "11. Get All Questions");
        Print.println(Color.BLUE, "0. Exit");

        String str = Input.getStr("Enter choice: ");

        switch (str) {
            case "1" -> authUI.login();
            case "2" -> userUI.create();
            case "3" -> userUI.get();
            case "4" -> userUI.getAll();
            case "5" -> userUI.update();
            case "6" -> userUI.delete();
            case "7" -> questionUI.create();
            case "8" -> questionUI.update();
            case "9" -> questionUI.delete();
            case "10" -> questionUI.get();
            case "11" -> questionUI.getAll();
            case "0" -> {
                Print.println(Color.YELLOW, "Bye");
                return;
            }
            default -> Print.println(Color.RED, "Wrong choice");
        }
        run();
    }

}
