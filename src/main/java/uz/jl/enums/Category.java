package uz.jl.enums;

public enum Category {
    MATH, CHEMISTRY, GEOGRAPHY, ENGLISH;

    public static Category getCategoryByName(String category) {
        for (Category value : Category.values()) {
            if (value.toString().equalsIgnoreCase(category)) return value;
        }
        return null;
    }
}
