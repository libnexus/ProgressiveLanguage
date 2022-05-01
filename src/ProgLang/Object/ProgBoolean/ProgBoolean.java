package ProgLang.Object.ProgBoolean;

import ProgLang.Object.ProgBaseInstance;

public class ProgBoolean extends ProgBaseInstance {
    public final boolean bool;

    public ProgBoolean(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String stringRepresent() {
        return String.valueOf(this.bool);
    }

    @Override
    public boolean booleanRepresentation() {
        return this.bool;
    }
}
