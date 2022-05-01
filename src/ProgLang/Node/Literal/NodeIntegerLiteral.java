package ProgLang.Node.Literal;

import ProgLang.Cache;
import ProgLang.Interpreter;
import ProgLang.Node.ProgNode;
import ProgLang.Object.ProgBaseInstance;

public class NodeIntegerLiteral extends ProgNode {
    private final int number;

    public NodeIntegerLiteral(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public ProgBaseInstance implement(Interpreter interpreter) {
        return Cache.value(this.number);
    }
}
