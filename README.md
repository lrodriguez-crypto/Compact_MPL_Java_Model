# Compact_MP_Java_Model

	Java model of the Montomery Powering Ladder, and Montomery Multiplication.
	To run this project it is required:
		
		- Ant (tested on 1.10.7 )
		- Ivy (tested on 2.5 )
		- JDK (tested on openjdk 1.8.0)
		- This project was implemented on Ubuntu 20.04.4
		  (Java is multiplataform and it is expected to run on windows, mac, unix, etc).

	To run this project it is required to have ant, java, javac on your PATH.

	Command:

		ant -p			(To shows options)
		ant resolve		(To download and install required libraries)
		ant				(To compile and run the project)


	It is posible to edit the file log4j2.xml to change logs level to `debug` ot `trace` to show verbose information:

		<Root level="info">

