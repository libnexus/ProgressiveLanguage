package ProgLang.Node.Literal;

import ProgLang.Cache;
import ProgLang.Interpreter;
import ProgLang.Node.ProgNode;
import ProgLang.Object.ProgBaseInstance;

public class NodeFloatLiteral extends ProgNode {
    private final float number;

    public NodeFloatLiteral(float number) {
        this.number = number;
    }

    public float getNumber() {
        return this.number;
    }

    public ProgBaseInstance implement(Interpreter interpreter) {
        return Cache.value(this.number);
    }
}
