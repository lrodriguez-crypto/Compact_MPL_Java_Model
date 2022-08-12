# Compact_MPL_Java_Model


Java model of the Montomery Powering Ladder, and Montomery Multiplication.
To run this project it is required:
		
- This project was tested on Ubuntu 20.04.4
- JDK (tested on openjdk 17.0.4, java version for this project is set in the `build.gradle.kts` file)
	- `sudo apt install openjdk-17-jdk`
	- `sudo apt install openjdk-17-jre`

(Note: Previos version Tag 1.0.0 uses Ant and Ivy to build the project.)

Command:
	
```
./gradlew cleanTest test --info 		(To run MPL tests)
./gradlew tasks					(To shows options)
./gradlew run					(To run main, not used in this project)
```

It is posible to edit the file src/test/resources/log4j2.xml to change logs level to `debug` or `trace` or `info` to show verbose information:

	<Root level="info">


Common problems:
- Ensure to have the correct java version
	
```
java --version
	openjdk 17.0.4 2022-07-19
```
