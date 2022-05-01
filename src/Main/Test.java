package Main;

import ProgLang.Cache;
import ProgLang.Context;
import ProgLang.Error.ProgError;
import ProgLang.Interpreter;
import ProgLang.Lexer.Lexer;
import ProgLang.Lexer.Token;
import ProgLang.Node.ProgNode;
import ProgLang.Object.ProgBaseInstance;
import ProgLang.Parser.Parser;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static ProgBaseInstance timeExecution(String file) throws ProgError {
        var a = System.currentTimeMillis();

        Context context = new Context();
        Interpreter interpreter = new Interpreter();
        ArrayList<Token> tokens = Lexer.tokenize(file);

        // Check for actual parsing
        if (tokens.size() <= 0) {
            return Cache.NOTHING;
        }

        Parser parser = new Parser(tokens);
        ProgNode program = parser.parseExpression();

        ProgBaseInstance result = program.implement(interpreter);

        var b = (System.currentTimeMillis() - a) / 1000;

        System.out.println("Execution took; " + b + "s");

        return result;
    }

    public static void main(String[] args) throws ProgError {
        Scanner in = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print(">>> ");
            input = in.nextLine();

            if (input.equals("quit")) {
                break;
            } else {
                var e = timeExecution(input);

                if (!e.equals(Cache.NOTHING)) {
                    System.out.println(e.stringRepresent());
                }
            }
        }
    }
}
