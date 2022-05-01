package ProgLang.Object;

import ProgLang.Error.ProgError;

import java.util.ArrayList;
import java.util.HashMap;

public class Symbols {
    private final HashMap<String, ProgBaseInstance> symbols = new HashMap<>();
    private final ArrayList<String> finals = new ArrayList<>();
    private final Symbols parent;
    private final String name;

    public Symbols(String name, Symbols parent) {
        this.name = name;
        this.parent = parent;
    }

    public Symbols(String name) {
        this.name = name;
        this.parent = null;
    }

    public String name() {
        return this.name;
    }

    public boolean contains(String name) {
        return this.symbols.containsKey(name);
    }

    public ProgBaseInstance get(String name) {
        if (this.contains(name)) {
            return this.symbols.get(name);
        } else if (!(this.parent == null)) {
            return this.parent.get(name);
        } else {
            return null;
        }
    }

    public void set(String name, ProgBaseInstance object, Boolean isFinal) throws ProgError {
        // First check finals
        if (this.finals.contains(name)) {
            throw new ProgError("<" + this.name() + "> cannot write over final variable " + name);
        }
        if (isFinal) {
            this.finals.add(name);
        }
        this.symbols.put(name, object);
    }

    public void set(String name, ProgBaseInstance object) throws ProgError {
        this.set(name, object, false);
    }

}
