package uz.jl.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Locale;

@Getter
@RequiredArgsConstructor
public enum Language {
    UZ("UZ"), RU("RU"), EN("EN");

    Language(String code) {

    }

    public static Language getLanguageByCode(String code) {
        for (Language language : Language.values()) {
            if (language.toString().equalsIgnoreCase(code)) return language;
        }
        return null;
    }
}
