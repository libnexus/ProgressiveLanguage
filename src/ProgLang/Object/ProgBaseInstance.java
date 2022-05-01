package ProgLang.Object;

import ProgLang.Error.ProgError;

public abstract class ProgBaseInstance {
    public String stringRepresent() throws ProgError {
        throw new ProgError("Instance of type " + this.getClass().getName() + " has no default case for 0.1");
    }

    public boolean booleanRepresentation() {
        return true;
    }

    public ProgBaseInstance callableNumberAddition(ProgBaseInstance number) throws ProgError {
        throw new ProgError("Instance of type " + this.getClass().getName() + " has no default case for 0.2");
    }

    public ProgBaseInstance callableNumberMultiplication(ProgBaseInstance number) throws ProgError {
        throw new ProgError("Instance of type " + this.getClass().getName() + " has no default case for 0.3");
    }

    public ProgBaseInstance callableNumberSubtraction(ProgBaseInstance number) throws ProgError {
        throw new ProgError("Instance of type " + this.getClass().getName() + " has no default case for 0.4");
    }

    public ProgBaseInstance callableNumberDivision(ProgBaseInstance number) throws ProgError {
        throw new ProgError("Instance of type " + this.getClass().getName() + " has no default case for 0.5");
    }

    public ProgBaseInstance callableNumberExponentiation(ProgBaseInstance number) throws ProgError {
        throw new ProgError("Instance of type " + this.getClass().getName() + " has no default case for 0.7");
    }

    public ProgBaseInstance callableNumberFloorDivision(ProgBaseInstance number) throws ProgError {
        throw new ProgError("Instance of type " + this.getClass().getName() + " has no default case for 0.8");
    }

    public ProgBaseInstance callableNumberModulus(ProgBaseInstance number) throws ProgError {
        throw new ProgError("Instance of type " + this.getClass().getName() + " has no default case for 0.9");
    }
}
