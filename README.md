# Compact_MPL_Java_Model


Java model of the Montomery Powering Ladder, and Montomery Multiplication.
To run this project it is required:
		
- This project was implemented on Ubuntu 20.04.4
(Java is multiplataform and it is expected to run on windows, mac, unix, etc).
- Gradle (tested on 7.2)
	- `sudo snap install gradle --classic`
- JDK (tested on openjdk 17.0.4, it is possible to change java version for this project on the `build.gradle.kts` file)
	- `sudo apt install openjdk-17-jdk`
	- `sudo apt install openjdk-17-jre`

(Note: Previos version Tag 1.0.0 uses Ant and Ivy to build the project.)

Command:
	
```
gradle cleanTest test --info 			(To run MPL tests)
gradle tasks					(To shows options)
gradle run					(To run main, not used in this project)
```


It is posible to edit the file src/test/resources/log4j2.xml to change logs level to `debug` or `trace` or `info` to show verbose information:

	<Root level="info">


Common problems:
- Ensure to have have gradle, java and javac:
	
```
java --version
	openjdk 17.0.4 2022-07-19

javac --version
	javac 17.0.4
	
gradle --version
	------------------------------------------------------------
	Gradle 7.2
	------------------------------------------------------------
```
