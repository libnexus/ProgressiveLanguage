package ProgLang;

import ProgLang.Object.Symbols;

public class Context {
    public Symbols symbols = new Symbols("global");
    private final Symbols globals = symbols;
}
