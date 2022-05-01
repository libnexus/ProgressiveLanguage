package ProgLang.Node.Binary;

import ProgLang.Error.ProgError;
import ProgLang.Interpreter;
import ProgLang.Node.ProgNode;
import ProgLang.Object.ProgBaseInstance;

public class NodeBinaryOperation extends ProgNode {
    public final Operation operation;
    public final ProgNode left;
    public final ProgNode right;

    public NodeBinaryOperation(Operation operation, ProgNode left, ProgNode right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public ProgBaseInstance implement(Interpreter interpreter) throws ProgError {
        ProgBaseInstance left = this.left.implement(interpreter);
        ProgBaseInstance right = this.right.implement(interpreter);

        return switch (this.operation) {

            case Addition -> left.callableNumberAddition(right);

            case Multiplication -> left.callableNumberMultiplication(right);

            case Subtraction -> left.callableNumberSubtraction(right);

            case Division -> left.callableNumberDivision(right);

            case Exponentiation -> left.callableNumberExponentiation(right);

            case Modulus -> left.callableNumberModulus(right);

            case FloorDivision -> left.callableNumberFloorDivision(right);

            default -> throw new ProgError("Unexpected value: " + this.operation);
        };
    }
}