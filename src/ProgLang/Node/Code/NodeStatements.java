package ProgLang.Node.Code;

import ProgLang.Cache;
import ProgLang.Error.ProgError;
import ProgLang.Interpreter;
import ProgLang.Node.ProgNode;
import ProgLang.Object.ProgBaseInstance;

import java.util.ArrayList;

public class NodeStatements extends ProgNode {
    private final ArrayList<ProgNode> statements;

    public NodeStatements(ArrayList<ProgNode> statements) {
        this.statements = statements;
    }

    public ProgBaseInstance implement(Interpreter interpreter) throws ProgError {
        for (ProgNode statement : this.statements) {
            statement.implement(interpreter);
        }
        return Cache.NOTHING;
    }
}
