import java.math.BigInteger;

public class Decimal extends Number implements Comparable<Decimal> {
    // Required properties
    private BigInteger intVal;
    private BigInteger scale;

    // Reference properties
    // Public reference properties
    public static final Decimal ZERO =
        new Decimal(BigInteger.ZERO, BigInteger.ZERO);
    public static final Decimal ONE =
        new Decimal(BigInteger.ONE, BigInteger.ZERO);
    public static final Decimal TWO =
        new Decimal(BigInteger.TWO, BigInteger.ZERO);
    public static final Decimal TEN =
        new Decimal(BigInteger.TEN, BigInteger.ZERO);
    // Private reference properties
    public Decimal(BigInteger intVal, BigInteger scale) {
        setScale(scale);
        setIntVal(intVal);
    }
    private Decimal(Decimal decimal) {
        setScale(decimal.scale);
        setIntVal(decimal.intVal);
    }

    // getIntVal and getScale purposefully removed, use unscaledValue and scale
    //     instead, respectively
    private void setIntVal(BigInteger intVal) {
        if (intVal == null) {
            throw new IllegalArgumentException("intVal is null");
        }
        this.intVal = intVal;
    }
    private void setScale(BigInteger scale) {
        if (scale == null) {
            throw new IllegalArgumentException("scale is null");
        }
        this.scale = scale;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Decimal)) {
            return false;
        }

        return equals((Decimal) obj);
    }
    public boolean equals(Decimal decimal) {
        if (decimal == null) {
            return false;
        }
        if (! decimal.scale.equals(this.scale)) {
            return false;
        }
        if (! decimal.intVal.equals(this.intVal)) {
            return false;
        }

        return true;
    }
    @Override
    public String toString() {
        return String.format("[%s, E%s]", intVal.toString(),
            scale.toString());
    }
    @Override
    public double doubleValue() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public float floatValue() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int intValue() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public long longValue() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int compareTo(Decimal o) {
        int result;

        result = this.scale.compareTo(o.scale);
        if (result != 0) {
            return result;
        }

        return this.intVal.compareTo(o.intVal);
    }
    // Basic accessors
    public BigInteger unscaledValue() {
        return intVal;
    }
    public BigInteger scale() {
        return scale;
    }
    // BigDecimal-esque methods
    public Decimal multiply(Decimal multiplicand) {
        Decimal result;
        BigInteger multiplicandFlat;
        BigInteger multiplicandScale;

        if (multiplicand == null) {
            throw new IllegalArgumentException();
        }
        result = new Decimal(this);
        multiplicandFlat = multiplicand.intVal;
        multiplicandScale = multiplicand.scale;
        result.setScale(result.scale.multiply(multiplicandScale));
        result.setIntVal(result.intVal.multiply(multiplicandFlat));

        return result;
    }
    // Helper methods
    private BigInteger adjustScale(BigInteger newIntVal) {
        if (newIntVal.signum() == 0) {
            return newIntVal;
        }
        // TODO: fill out

        return newIntVal;
    }
}
