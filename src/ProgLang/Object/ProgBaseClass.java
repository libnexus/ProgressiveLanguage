package ProgLang.Object;

import ProgLang.Error.ProgError;

import java.lang.reflect.Method;
import java.util.HashMap;

public class ProgBaseClass {
    private final HashMap<String, Method> methods = new HashMap<>();

    public static String stringRepresent(ProgBaseInstance self) throws ProgError {
        throw new ProgError("Class instance " + self.getClass().getName() + "cannot be represented by a string");
    }

    public static ProgBaseInstance callableNumberAddition(ProgBaseInstance self, ProgBaseInstance number) throws ProgError {
        throw new ProgError("Class instance " + self.getClass().getName() + "cannot be operated on using '+'");
    }

    public static ProgBaseInstance callableNumberMultiplication(ProgBaseInstance self, ProgBaseInstance number) throws ProgError {
        throw new ProgError("Class instance " + self.getClass().getName() + "cannot be operated on using '*'");
    }

    public static ProgBaseInstance callableNumberSubtraction(ProgBaseInstance self, ProgBaseInstance number) throws ProgError {
        throw new ProgError("Class instance " + self.getClass().getName() + "cannot be operated on using '-'");
    }

    public static ProgBaseInstance callableNumberDivision(ProgBaseInstance self, ProgBaseInstance number) throws ProgError {
        throw new ProgError("Class instance " + self.getClass().getName() + "cannot be operated on using '/'");
    }

    public void registerMethod(String name, Method method) {
        methods.put(name, method);
    }

    public Method getMethod(String name) {
        return this.methods.get(name);
    }
}
