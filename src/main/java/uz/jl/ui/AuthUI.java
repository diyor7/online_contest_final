package uz.jl.ui;

import uz.jl.configs.ApplicationContextHolder;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.security.SecurityHolder;
import uz.jl.service.AuthUserService;
import uz.jl.utils.Input;

/**
 * @author Doston Bokhodirov, Thu 12:08 AM. 1/27/2022
 */
public class AuthUI extends AbstractUI<AuthUserService> {
    private final AuthUserService authUserService = ApplicationContextHolder.getBean(AuthUserService.class);

    public AuthUI(AuthUserService service) {
        super(service);
    }

    public void login() {
        try {
            String username = Input.getStr("Enter username: ");
            String password = Input.getStr("Enter password: ");
            authUserService.login(username, password);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void logout() {
        try {
            SecurityHolder.killUser();
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }
}