package ProgLang.Object.ProgModule;

import ProgLang.Object.ProgBaseInstance;

public class ProgModule extends ProgBaseInstance {

    public final String path;

    public ProgModule(String path) {
        this.path = path;
    }

    @Override
    public String stringRepresent() {
        return "<module '" + this.path + "'>";
    }

    @Override
    public boolean booleanRepresentation() {
        return true;
    }
}
