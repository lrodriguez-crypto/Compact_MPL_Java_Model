package mpl;

import java.math.BigInteger;

public interface MontgomeryMult{

	public BigInteger mult(BigInteger X, BigInteger Y, BigInteger M, int numBits, int k, BigInteger Mprima);

}
