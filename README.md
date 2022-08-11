# Compact_MP_Java_Model

	Java model of the Montomery Powering Ladder, and Montomery Multiplication.
	To run this project it is required:
		
		- This project was implemented on Ubuntu 20.04.4
		(Java is multiplataform and it is expected to run on windows, mac, unix, etc).

		- Gradle (tested on 7.2)
			- snap install gradle

		- JDK (tested on openjdk 17.0.4)
			- sudo apt install openjdk-17-jdk 
			- sudo apt install openjdk-17-jre

	Command:

		gradle tasks								(To shows options)
		gradle cleanTest test --info resolve		(To run MPL tests)
		gradle run									(To run main, not used in this project)


	It is posible to edit the file src/test/resources/log4j2.xml to change logs level to `debug` or `trace` or `info` to show verbose information:

		<Root level="info">


	Common problems:
		Ensure to have have gradle, java and javac:

		java --version
		javac --version
		gradle --version
