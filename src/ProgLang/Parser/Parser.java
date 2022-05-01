package ProgLang.Parser;

import ProgLang.Error.ProgError;
import ProgLang.Lexer.TT;
import ProgLang.Lexer.Token;
import ProgLang.Node.Binary.NodeBinaryOperation;
import ProgLang.Node.Binary.Operation;
import ProgLang.Node.Code.NodeStatements;
import ProgLang.Node.Literal.NodeFloatLiteral;
import ProgLang.Node.Literal.NodeIntegerLiteral;
import ProgLang.Node.Literal.NodeStringLiteral;
import ProgLang.Node.ProgNode;

import java.util.ArrayList;

public class Parser {
    public final Token endOfFile;
    private final ArrayList<Token> tokens;
    private int currentTokenIndex = 0;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.endOfFile = new Token(TT.END, "", tokens.get(tokens.size() - 1).column());
    }

    private Token getCurrentToken() {
        if (this.currentTokenIndex < this.tokens.size()) {
            return this.tokens.get(this.currentTokenIndex);
        } else {
            return this.endOfFile;
        }
    }

    private void advance(Integer amount) {
        this.currentTokenIndex += amount;
    }

    private void advance() {
        this.advance(1);
    }

    public ProgNode parseProgram() throws ProgError {
        return this.parseStatements();
    }

    public ProgNode parseStatements() throws ProgError {
        ArrayList<ProgNode> statements = new ArrayList<>();

        while (!this.getCurrentToken().matches(TT.END)) {
            statements.add(this.parseBlockStatement());
        }

        return new NodeStatements(statements);
    }

    public ProgNode parseBlockStatement() throws ProgError {
        return this.parseLineStatement();
    }

    public ProgNode parseLineStatement() throws ProgError {
        return this.parseExpression();
    }

    public ProgNode parseExpression() throws ProgError {
        return this.parseBoolOr();
    }

    public ProgNode parseBoolOr() throws ProgError {
        var left = this.parseBoolAnd();
        while (this.getCurrentToken().matches(TT.BOOL_OR)) {
            this.advance();
            left = new NodeBinaryOperation(Operation.BooleanOr, left, this.parseBoolAnd());
        }
        return left;
    }

    public ProgNode parseBoolAnd() throws ProgError {
        var left = this.parseBitwiseXOr();
        while (this.getCurrentToken().matches(TT.BOOL_AND)) {
            this.advance();
            left = new NodeBinaryOperation(Operation.BooleanAnd, left, this.parseBitwiseXOr());
        }
        return left;
    }

    public ProgNode parseBitwiseXOr() throws ProgError {
        var left = this.parseBoolEquality();
        while (this.getCurrentToken().matches(TT.BIT_OR)) {
            this.advance();
            left = new NodeBinaryOperation(Operation.BitwiseOr, left, this.parseBoolEquality());
        }
        return left;
    }

    public ProgNode parseBoolEquality() throws ProgError {
        var left = this.parseBoolRelational();
        while (
                this.getCurrentToken().matches(TT.BOOL_EQUALS) ||
                        this.getCurrentToken().matches(TT.BOOL_NOT_EQUALS)) {
            var operator = this.getCurrentToken();
            this.advance();
            left = new NodeBinaryOperation(this.getOperationOf(operator), left, this.parseBoolRelational());
        }
        return left;
    }

    public ProgNode parseBoolRelational() throws ProgError {
        var left = this.parseBitwiseShift();
        while (
                this.getCurrentToken().matches(TT.BOOL_LESS_THAN) ||
                        this.getCurrentToken().matches(TT.BOOL_MORE_THAN) ||
                        this.getCurrentToken().matches(TT.BOOL_LESS_THAN_EQUALS) ||
                        this.getCurrentToken().matches(TT.BOOL_MORE_THAN_EQUALS) ||
                        this.getCurrentToken().matches(TT.BOOL_IS) ||
                        this.getCurrentToken().matches(TT.BOOL_IS_IN) ||
                        this.getCurrentToken().matches(TT.BOOL_IS_NOT) ||
                        this.getCurrentToken().matches(TT.BOOL_IS_NOT_IN)
        ) {
            var operator = this.getCurrentToken();
            this.advance();
            left = new NodeBinaryOperation(this.getOperationOf(operator), left, this.parseBitwiseShift());
        }
        return left;
    }

    public ProgNode parseBitwiseShift() throws ProgError {
        var left = this.parseAdditive();
        while (
                this.getCurrentToken().matches(TT.BIT_L_SHIFT) ||
                        this.getCurrentToken().matches(TT.BIT_R_SHIFT)) {
            var operator = this.getCurrentToken();
            this.advance();
            left = new NodeBinaryOperation(this.getOperationOf(operator), left, this.parseAdditive());
        }
        return left;
    }

    public ProgNode parseAdditive() throws ProgError {
        var left = this.parseMultiplicative();
        while (
                this.getCurrentToken().matches(TT.ADDITION) ||
                        this.getCurrentToken().matches(TT.SUBTRACTION)) {
            var operator = this.getCurrentToken();
            this.advance();
            left = new NodeBinaryOperation(this.getOperationOf(operator), left, this.parseMultiplicative());
        }
        return left;
    }

    public ProgNode parseMultiplicative() throws ProgError {
        var left = this.parseFactor();
        while (
                this.getCurrentToken().matches(TT.MULTIPLICATION) ||
                        this.getCurrentToken().matches(TT.DIVISION) ||
                        this.getCurrentToken().matches(TT.FLOOR) ||
                        this.getCurrentToken().matches(TT.MODULUS) ||
                        this.getCurrentToken().matches(TT.EXPONENTIATION)) {
            var operator = this.getCurrentToken();
            this.advance();
            left = new NodeBinaryOperation(this.getOperationOf(operator), left, this.parseFactor());
        }
        return left;
    }

    public ProgNode parseFactor() throws ProgError {
        return this.parseComprehensiveFactorOperation();
    }

    public ProgNode parseComprehensiveFactorOperation() throws ProgError {
        return this.parsePostFactorOperation();
    }

    public ProgNode parsePostFactorOperation() throws ProgError {
        return this.parseAtomicFactor();
    }

    public ProgNode parseAtomicFactor() throws ProgError {
        var token = this.getCurrentToken();

        if (token.matches(TT.INTEGER)) {
            this.advance();
            return new NodeIntegerLiteral(Integer.parseInt(token.value()));
        } else if (token.matches(TT.FLOAT)) {
            this.advance();
            return new NodeFloatLiteral(Float.parseFloat(token.value()));
        } else if (token.matches(TT.STRING)) {
            this.advance();
            return new NodeStringLiteral(token.value());
        } else {
            throw new ProgError("Unexpected token type in atomic position: " + token.type().toString() + "'" + token.value() + "'");
        }
    }

    public Operation getOperationOf(Token token) throws ProgError {
        return switch (token.type()) {
            case ADDITION -> Operation.Addition;
            case SUBTRACTION -> Operation.Subtraction;
            case MULTIPLICATION -> Operation.Multiplication;
            case DIVISION -> Operation.Division;
            case MODULUS -> Operation.Modulus;
            case EXPONENTIATION -> Operation.Exponentiation;
            case FLOOR -> Operation.FloorDivision;
            case BOOL_AND -> Operation.BooleanAnd;
            case BOOL_OR -> Operation.BooleanOr;
            case BOOL_EQUALS -> Operation.Equals;
            case BOOL_NOT_EQUALS -> Operation.NotEquals;
            case BOOL_LESS_THAN -> Operation.LessThan;
            case BOOL_LESS_THAN_EQUALS -> Operation.LessThanEquals;
            case BOOL_MORE_THAN -> Operation.MoreThan;
            case BOOL_MORE_THAN_EQUALS -> Operation.MoreThanEquals;
            case BIT_AND -> Operation.BitwiseAnd;
            case BIT_OR -> Operation.BitwiseOr;
            case BIT_XOR -> Operation.XOr;
            case BIT_L_SHIFT -> Operation.LeftShift;
            case BIT_R_SHIFT -> Operation.RightShift;
            default -> throw new ProgError("Unmatched operation " + token.type());
        };
    }
}
