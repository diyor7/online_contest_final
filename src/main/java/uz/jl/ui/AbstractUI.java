package uz.jl.ui;

import com.google.gson.GsonBuilder;
import uz.jl.service.base.BaseGenericService;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

/**
 * @author Doston Bokhodirov, Thu 12:05 AM. 1/27/2022
 */
public abstract class AbstractUI<S extends BaseGenericService> {

    protected S service;

    public AbstractUI(S service) {
        this.service = service;
    }

    protected <T> void showResponse(T response) {
        showResponse(Color.RED, response);
    }

    protected <T> void showResponse(String color, T response) {
        Print.println(color, new GsonBuilder().serializeNulls().create().toJson(response));
    }
}
