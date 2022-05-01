package ProgLang.Node.Literal;

import ProgLang.Cache;
import ProgLang.Interpreter;
import ProgLang.Node.ProgNode;
import ProgLang.Object.ProgBaseInstance;

public class NodeNothingLiteral extends ProgNode {
    @Override
    public ProgBaseInstance implement(Interpreter interpreter) {
        return Cache.NOTHING;
    }
}
