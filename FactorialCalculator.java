import java.math.BigInteger;
import java.lang.IllegalArgumentException;

class FactorialCalculator {
    static BigInteger calcFactorial(int inVal) {
        if (inVal == 0) {
            return BigInteger.valueOf(0);
        }
        if (inVal < 0) { // inVal must be positive
            throw new IllegalArgumentException();
        }
        return calcFactorialHelper(BigInteger.valueOf(Long.valueOf(inVal)));
    }

    static BigInteger calcFactorialHelper(BigInteger inVal) {
        if (inVal.equals(BigInteger.ONE)) {
            return inVal;
        } else {
            return inVal.multiply(calcFactorialHelper(inVal.subtract(BigInteger.valueOf(1))));
        }
    }

    public static void main(String[] args) {
        System.out.println(calcFactorial(10));
    }
}