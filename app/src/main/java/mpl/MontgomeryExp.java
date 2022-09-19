package mpl;

import java.math.BigInteger;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import mpl.util.BIUtil;
import mpl.util.MontgomeryUtil;

public class MontgomeryExp {
	
	private static Logger log = LogManager.getLogger(MontgomeryExp.class);

	private MontgomeryMult montMult;

	public MontgomeryExp(MontgomeryMult montMult){
		this.montMult = montMult;
	}
	
	//MPL exponentiator, the partial multiplications can be accomplished with L-Rodriguez algorithm
	public BigInteger poweringLadder(BigInteger x , BigInteger exp, BigInteger p , int size , int k, BigInteger pPrima,BigInteger unoMont){		
		BigInteger R0 = unoMont; // R0 = 1 (Montgomery domain)
		BigInteger R1 = x;
		
		for(int i= exp.bitLength() - 1; i >= 0 ; --i){
			if( exp.testBit(i) ){				
				R0 = montMult.mult( R0 , R1 , p , size, k, pPrima);
				R1 = montMult.mult( R1 , R1 , p , size, k, pPrima); 
			}else{				
				R1 = montMult.mult( R0 , R1 , p , size, k, pPrima); 
				R0 = montMult.mult( R0 , R0 , p , size, k, pPrima); 
			}

			log.debug("R0 [" + i + "]->  RO * " + (exp.testBit(i)? "R1 -> ":"R0 -> ") + R0.toString(16));
			log.debug("R1 [" + i + "]->  R1 * " + (exp.testBit(i)? "R1 -> ":"R0 -> ") + R1.toString(16));
			log.debug("------------------------------------------------------");
		}			
		return R0;
	}

	//Full modular exponentiation (normal domain)
	public BigInteger modularExponentiation(BigInteger x, BigInteger exp , BigInteger p , int size , int k){

		BigInteger pPrima = MontgomeryUtil.computeMprima(p, k);

		log.info(" ************************ Montgomery exponentiation ************************ ");
		log.info("Operands size : " + size);
		log.info("Digits   size : " + k);

		log.info("------------------------------------------------- Input values");
		log.info("x   : " + x.toString(16));
		log.info("exp : " + exp.toString(16));
		log.info("p   : " + p.toString(16));
		
		BigInteger R = new BigInteger("2").pow(2*size).mod(p);          			  //R^2 mod p		
		BigInteger unoMontg  = montMult.mult(BigInteger.ONE, R, p, size, k, pPrima);  //1 Montgomery Domain Conversion
		BigInteger xMontg    = montMult.mult(     x        , R, p, size, k, pPrima);  //X Montgomery Domain Conversion
			
		log.info("------------------------------------------------- Computed values ");
		log.info("R^2 mod p : " + R.toString(16));
		log.info("oneMont   : " + unoMontg.toString(16));
		log.info("xMont     : " + xMontg.toString(16));
		log.info("pPrima    : " + pPrima.toString(16));
		
		BigInteger resultPrima =  poweringLadder(xMontg , exp, p, size, k, pPrima, unoMontg); 	//Montgomery Domain Exponentiation
		BigInteger result      =  montMult.mult(resultPrima, BigInteger.ONE, p, size,k , pPrima); //Normal Domain
			
		log.info("======================== Results ============================");
		log.info("Montgomery domain   : " + resultPrima.toString(16));
		log.info("Normal domain       : " + result.toString(16));
						
		return result;
	}	
}
