package mpl;

import java.math.BigInteger;
import java.util.Random;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import mpl.util.MontgomeryUtil;

public class Main {
	
	private static Logger log = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		log.info("To run MPL tests, please run (in your terminal):");
		log.info("'gradle cleanTest test --info'");
	}
}
