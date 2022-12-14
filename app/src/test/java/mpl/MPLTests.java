package mpl;

import mpl.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.Random;


@SpringBootTest
@ContextConfiguration(locations = "../beans.xml")
public class MPLTests {

	private static Logger log = LogManager.getLogger(MPLTests.class);
	
	@Autowired 
    @Qualifier("montgomeryExp")
    private MontgomeryExp mont;

	//Test for hwardware verification (fixed values)
	@Test
	public void test_fixed_values(){
		log.info("Running Fixed Values Test");
		int size = 1024;
		int k = 16;
		
		BigInteger g    = new BigInteger("e230b360ef1d7fe50d361f1d4139a8a9af9280e00e0c25f088711e7e50bf754cfbe37d1b5122647d2e74f8aeb4990dc541d1448c312d8f91ff28140129219e156a46d6a31a34f8a89bdb438e5ae149bce79eed55ebd5be3e3015923ce12a976acb7d77422f863388a598927dd8d959f54e8e9c532bd25d601d5c1b1c81b6337", 16);
		BigInteger exp  = new BigInteger("9f2c3e85d65eb0048a01bead9db882c72ff2b63f49d50c3764db2ec5fd0941491a50218f9a8cb9725e354e32b2afdc38d1aadbf7b6fdec546e347f23851cf047915b8d14bfaae1f2994019118d6a31e9afabe36cc7998a9b61623c828d5dc4a938b1d217da37cee37c8389e99aa7bf73b9e02e4941e85d31c68651780154b823", 16);
		BigInteger p    = new BigInteger("2c5255031376b8ea2df1d33ee3c56e59a495401551039cfa5d1b9475c95031d56468e137a7b9a66dbd3f283f55afca57244bc2520d73cbd0675899b89f542161226148f1aadbe1a1a3b7d05b1800247441b2e6a7f257dce969f6b087bbe361c92d272921f6b72d5223c7f0248379425ec3a33021f64b862cb6b089221cbce2b3", 16);

		BigInteger tested_data = mont.modularExponentiation(g, exp, p , size , k);
		BigInteger golden_data = g.modPow(exp, p);

		log.info("Golden data         : " + golden_data.toString(16));
		assertEquals(tested_data, golden_data, "Modular exponentiation Match!");
	}

	//@RepeatedTest(10)
	@RepeatedTest(1)
    public void test_random(){
		log.info("Running Random Test");

		int size = 64; //32 64 128 256 512 1024 etc.
		int k = 16;		
				
		BigInteger x   = new BigInteger(size-4, 100, new Random());
		BigInteger exp = new BigInteger(size  , 100, new Random());
		BigInteger p   = new BigInteger(size-2, 100, new Random());

		BigInteger tested_data = mont.modularExponentiation(x, exp, p , size , k);
		BigInteger golden_data = x.modPow(exp, p);

		log.info("Golden data         : " + golden_data.toString(16));
		assertEquals(tested_data, golden_data, "Modular exponentiation Match!");
    }
}
