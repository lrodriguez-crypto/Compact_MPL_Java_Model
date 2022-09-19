package mpl;

import java.math.BigInteger;
import mpl.util.*;
import mpl.MontgomeryMult;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class WalterMontgomeryMult implements MontgomeryMult{

	private static Logger log = LogManager.getLogger(WalterMontgomeryMult.class);

	// Walter's Algorithm
	public BigInteger mult(BigInteger X, BigInteger Y, BigInteger M, int numBits, int k, BigInteger Mprima) {
		
		BigInteger A = new BigInteger("0");
		BigInteger B = new BigInteger("2").pow(k);
		BigInteger qi = new BigInteger("0");
		int n = numBits / k;

		BigInteger X0 = BIUtil.getDigit(X, 0, k);
		BigInteger A0, Yi, XY, qiM;

		for (int i = 0; i < n; i++) {
			A0 = BIUtil.getDigit(A, 0, k);
			Yi = BIUtil.getDigit(Y, i, k);

			qi = (A0.add(X0.multiply(Yi)).multiply(Mprima)).mod(B);

			XY = X.multiply(Yi);
			qiM = qi.multiply(M);
			A = (A.add(XY).add(qiM)).divide(B);
		}
		return A;
	}

}
