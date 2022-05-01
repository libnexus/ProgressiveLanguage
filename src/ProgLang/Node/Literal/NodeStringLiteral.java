package ProgLang.Node.Literal;

import ProgLang.Cache;
import ProgLang.Interpreter;
import ProgLang.Node.ProgNode;
import ProgLang.Object.ProgBaseInstance;

public class NodeStringLiteral extends ProgNode {
    private final String string;

    public NodeStringLiteral(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }

    public ProgBaseInstance implement(Interpreter interpreter) {
        return Cache.value(this.string);
    }
}
