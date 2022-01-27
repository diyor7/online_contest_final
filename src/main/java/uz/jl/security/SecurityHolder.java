package uz.jl.security;

import uz.jl.entity.User;

/**
 * @author Doston Bokhodirov, Thu 12:17 AM. 1/27/2022
 */
public class SecurityHolder {
    public static User user;

    public static void setUser(User authUser) {
        user = authUser;
    }
    public static void killUser() {
        user = null;
    }
}
