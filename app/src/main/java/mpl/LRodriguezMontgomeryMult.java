package mpl;

import java.math.BigInteger;
import mpl.util.*;
import mpl.MontgomeryMult;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LRodriguezMontgomeryMult implements MontgomeryMult{


	private static Logger log = LogManager.getLogger(LRodriguezMontgomeryMult.class);

	// L-Rodríguez's Algorithm
	public BigInteger mult(BigInteger X, BigInteger Y, BigInteger M, int numBits, int k, BigInteger Mprima) {

		BigInteger A = new BigInteger("0");
		BigInteger B = new BigInteger("2").pow(k);
		BigInteger qi = new BigInteger("0");
		BigInteger c;

		int index = 0;
		int n = numBits / k;

		for (int i = 0; i < n; i++) {
			c = new BigInteger("0");
			for (int j = 0; j < n; j++) {
				BigInteger sj = BIUtil.getDigit(A, j, k).add(
						BIUtil.getDigit(X, j, k).multiply(BIUtil.getDigit(Y, i, k)));
				if (j == 0)
					qi = BIUtil.getDigit(sj.multiply(Mprima), 0, k); // k-LSB

				BigInteger rj = qi.multiply(BIUtil.getDigit(M, j, k));

				BigInteger t6j = sj.add(rj.add(c)); // {c+1,t6j} = sj + rj + cj
				c = t6j.shiftRight(k);

				if (j > 0)
					A = BIUtil.setDigit(A, j - 1, k, t6j);

				//log.trace("A -> " + A.toString(16));
			}
			A = BIUtil.setDigit(A, n - 1, k, c);

			log.trace("End iteration A -> " + A.toString(16));
		}
		return A;
	}

}
