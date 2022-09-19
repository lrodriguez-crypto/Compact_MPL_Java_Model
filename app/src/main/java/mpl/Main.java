package mpl;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import mpl.util.MontgomeryUtil;

public class Main {
	
	private static Logger log = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		log.info("Current input parameters: " + Arrays.toString(args));

		if(args.length != 3){
			log.error("There are required 3 integer input parameters");
			Main.help();
			System.exit(-1);
		}

		BigInteger x = new BigInteger("0", 16);
		BigInteger exp = new BigInteger("0", 16);
		BigInteger p = new BigInteger("0", 16);

		try{
			x   = new BigInteger(args[0], 16);
			exp = new BigInteger(args[1], 16);
			p   = new BigInteger(args[2], 16);
		}catch(Exception e){
			log.error("Input parameters error, there shoul be integer in hex representation.", e);
			Main.help();
			System.exit(-2);
		}

		int size =  Main.roundNextPowTwo(exp.bitCount());

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		MontgomeryExp mont = (MontgomeryExp) context.getBean("montgomeryExp");
	
		BigInteger result = mont.modularExponentiation(x, exp, p, size, 16);

		log.info("Result                : " + result.toString(16));
		log.info("Result BigInteger lib : " + (x.modPow(exp, p)).toString(16));

	}

	private static int roundNextPowTwo(int v){
		v--;
		v |= v >> 1;
		v |= v >> 2;
		v |= v >> 4;
		v |= v >> 8;
		v |= v >> 16;
		return ++v;
	}

	private static void help(){
		log.info("This program required 3 integer input values (hex): 'x exp p' (x^y mod p)");
	}
}

