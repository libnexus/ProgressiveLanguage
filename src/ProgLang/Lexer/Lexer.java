package ProgLang.Lexer;

import ProgLang.Error.ProgError;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class Lexer {
    public final String file;
    public final String path;


    public Lexer(String file, String path) {
        this.file = file;
        this.path = path;
    }

    public static ArrayList<Token> tokenize(String text) throws ProgError {
        ArrayList<Token> tokens = new ArrayList<>();
        var column = 0;
        var file = text;

        Matcher match;

        while (column < file.length()) {
            if (text.startsWith("\n")) {
                tokens.add(new Token(TT.NEW_LINE, "$<new line>", column));
                column++;
            } else if ((match = PATTERN.WHITE_SPACE.matcher(text)).lookingAt()) {
                column += match.group().length();
            } else if ((match = PATTERN.FLOAT.matcher(text)).lookingAt()) {
                tokens.add(new Token(TT.FLOAT, match.group(), column));
                column += match.group().length();
            } else if ((match = PATTERN.INTEGER.matcher(text)).lookingAt()) {
                tokens.add(new Token(TT.INTEGER, match.group(), column));
                column += match.group().length();
            } else if (text.startsWith("+")) {
                tokens.add(new Token(TT.ADDITION, "+", column));
                column++;
            } else if (text.startsWith("**")) {
                tokens.add(new Token(TT.EXPONENTIATION, "**", column));
                column += 2;
            } else if (text.startsWith("//")) {
                tokens.add(new Token(TT.FLOOR, "//", column));
                column += 2;
            } else if (text.startsWith("*")) {
                tokens.add(new Token(TT.MULTIPLICATION, "*", column));
                column++;
            } else if (text.startsWith("-")) {
                tokens.add(new Token(TT.SUBTRACTION, "-", column));
                column++;
            } else if (text.startsWith("/")) {
                tokens.add(new Token(TT.DIVISION, "/", column));
                column++;
            } else if (text.startsWith("(")) {
                tokens.add(new Token(TT.R_BRACES_O, "(", column));
                column++;
            } else if (text.startsWith(")")) {
                tokens.add(new Token(TT.R_BRACES_C, ")", column));
                column++;
            } else {
                throw new ProgError("Can't recognise current expression " + text);
            }
            text = file.substring(column);
        }

        return tokens;
    }

}