package ProgLang.Object.ProgFloat;

import ProgLang.Cache;
import ProgLang.Error.ProgError;
import ProgLang.Object.ProgBaseInstance;
import ProgLang.Object.ProgInteger.ProgInteger;

public class ProgFloat extends ProgBaseInstance {
    public final float number;

    public ProgFloat(Float number) {
        this.number = number;
    }

    @Override
    public String stringRepresent() {
        return String.valueOf(this.number);
    }

    @Override
    public ProgBaseInstance callableNumberAddition(ProgBaseInstance number) throws ProgError {
        if (number instanceof ProgFloat) {
            return Cache.value(this.number + ((ProgFloat) number).number);
        } else if (number instanceof ProgInteger) {
            return Cache.value(this.number + ((ProgInteger) number).number);
        } else {
            throw new ProgError(this.stringRepresent() + " cannot add object of type " + number.getClass().getCanonicalName());
        }
    }

    @Override
    public ProgBaseInstance callableNumberMultiplication(ProgBaseInstance number) throws ProgError {
        if (number instanceof ProgFloat) {
            return Cache.value(this.number * ((ProgFloat) number).number);
        } else if (number instanceof ProgInteger) {
            return Cache.value(this.number * ((ProgInteger) number).number);
        } else {
            throw new ProgError(this.stringRepresent() + " cannot be multiplied by object of type " + number.getClass().getCanonicalName());
        }
    }

    @Override
    public ProgBaseInstance callableNumberSubtraction(ProgBaseInstance number) throws ProgError {
        if (number instanceof ProgFloat) {
            return Cache.value(this.number - ((ProgFloat) number).number);
        } else if (number instanceof ProgInteger) {
            return Cache.value(this.number - ((ProgInteger) number).number);
        } else {
            throw new ProgError(this.stringRepresent() + " cannot be subtracted by object of type " + number.getClass().getCanonicalName());
        }
    }

    @Override
    public ProgBaseInstance callableNumberDivision(ProgBaseInstance number) throws ProgError {
        if (number instanceof ProgFloat) {
            if (((ProgFloat) number).number == 0) {
                throw new ProgError("Cannot divide " + this.stringRepresent() + " by zero");
            } else {
                return Cache.value(this.number / ((ProgFloat) number).number);
            }
        } else if (number instanceof ProgInteger) {
            if (((ProgInteger) number).number == 0) {
                throw new ProgError("Cannot divide " + this.stringRepresent() + " by zero");
            } else {
                return Cache.value(this.number / ((ProgInteger) number).number);
            }
        } else {
            throw new ProgError(this.stringRepresent() + " cannot be divided by object of type " + number.getClass().getCanonicalName());
        }
    }

    @Override
    public ProgBaseInstance callableNumberExponentiation(ProgBaseInstance number) throws ProgError {
        if (number instanceof ProgFloat) {
            return Cache.value((float) Math.pow(this.number, ((ProgFloat) number).number));
        } else if (number instanceof ProgInteger) {
            return Cache.value((float) Math.pow(this.number, ((ProgInteger) number).number));
        } else {
            throw new ProgError(this.stringRepresent() + " cannot be subtracted by object of type " + number.getClass().getCanonicalName());
        }
    }

    @Override
    public ProgBaseInstance callableNumberFloorDivision(ProgBaseInstance number) throws ProgError {
        if (number instanceof ProgFloat) {
            if (((ProgFloat) number).number == 0) {
                throw new ProgError("Cannot divide " + this.stringRepresent() + " by zero");
            } else {
                return Cache.value(Math.floorDiv((int) this.number, (int) ((ProgFloat) number).number));
            }
        } else if (number instanceof ProgInteger) {
            if (((ProgInteger) number).number == 0) {
                throw new ProgError("Cannot divide " + this.stringRepresent() + " by zero");
            } else {
                return Cache.value(Math.floorDiv((int) this.number, ((ProgInteger) number).number));
            }
        } else {
            throw new ProgError(this.stringRepresent() + " cannot be divided by object of type " + number.getClass().getCanonicalName());
        }
    }

    @Override
    public ProgBaseInstance callableNumberModulus(ProgBaseInstance number) throws ProgError {
        if (number instanceof ProgFloat) {
            if (((ProgFloat) number).number == 0) {
                throw new ProgError("Cannot divide " + this.stringRepresent() + " by zero");
            } else {
                return Cache.value(this.number % ((ProgFloat) number).number);
            }
        } else if (number instanceof ProgInteger) {
            if (((ProgInteger) number).number == 0) {
                throw new ProgError("Cannot divide " + this.stringRepresent() + " by zero");
            } else {
                return Cache.value(Math.floorDiv((int) this.number, ((ProgInteger) number).number));
            }
        } else {
            throw new ProgError(this.stringRepresent() + " cannot be divided by object of type " + number.getClass().getCanonicalName());
        }
    }

}
