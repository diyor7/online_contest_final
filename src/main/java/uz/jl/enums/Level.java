package uz.jl.enums;

public enum Level {
    EASY, MEDIUM, HARD;

    public static Level getLevelByName(String levelStr) {
        for (Level level : Level.values()) {
            if (level.toString().equalsIgnoreCase(levelStr)) return level;
        }
        return null;
    }
    }
