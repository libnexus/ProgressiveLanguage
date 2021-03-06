package ProgLang;

import ProgLang.Object.ProgBaseInstance;
import ProgLang.Object.ProgFloat.ProgFloat;
import ProgLang.Object.ProgInteger.ProgInteger;
import ProgLang.Object.ProgNothing.ProgNothing;
import ProgLang.Object.ProgString.ProgString;

import java.util.HashMap;

public final class Cache {
    public static final ProgNothing NOTHING = new ProgNothing();
    private static final HashMap<Float, ProgFloat> floats = new HashMap<>();
    private static final HashMap<Integer, ProgInteger> integers = new HashMap<>();
    private static final HashMap<String, ProgString> strings = new HashMap<>();

    private static void LogValue(String state, ProgBaseInstance object) {
        System.out.println("(CacheAccess) : " + state + " ; " + object.objectId);
    }

    public static ProgInteger value(Integer number) {
        if (integers.containsKey(number)) {
            LogValue("Got Integer", integers.get(number));
            return integers.get(number);
        } else {
            ProgInteger n = new ProgInteger(number);
            integers.put(number, n);
            LogValue("Made Integer", n);
            return n;
        }
    }

    public static ProgFloat value(Float number) {
        if (floats.containsKey(number)) {
            LogValue("Got Float", floats.get(number));
            return floats.get(number);
        } else {
            ProgFloat n = new ProgFloat(number);
            floats.put(number, n);
            LogValue("Made Float", n);
            return n;
        }
    }

    public static ProgString value(String string) {
        if (strings.containsKey(string)) {
            LogValue("Got String", strings.get(string));
            return strings.get(string);
        } else {
            ProgString s = new ProgString(string);
            strings.put(string, s);
            LogValue("Made String", s);
            return s;
        }
    }
}
