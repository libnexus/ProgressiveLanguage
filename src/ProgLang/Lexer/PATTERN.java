package ProgLang.Lexer;

import java.util.regex.Pattern;

public class PATTERN {
    public static final Pattern INTEGER = Pattern.compile("^[0-9]+");
    public static final Pattern FLOAT = Pattern.compile("^[0-9]+\\.[0-9]+");
    public static final Pattern WHITE_SPACE = Pattern.compile("^[ \t]+");
}