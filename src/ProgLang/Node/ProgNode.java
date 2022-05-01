package ProgLang.Node;

import ProgLang.Error.ProgError;
import ProgLang.Interpreter;
import ProgLang.Object.ProgBaseInstance;

public abstract class ProgNode {
    public ProgBaseInstance implement(Interpreter interpreter) throws ProgError {
        return null;
    }
}
