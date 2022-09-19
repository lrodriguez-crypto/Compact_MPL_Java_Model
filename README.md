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
./gradlew cleanTest test --info	(To run MPL tests used in hw)
./gradlew tasks					(To shows options)

examples to run:

./gradlew run --args='9e281106452ee93 b24da3dcbe17c3d7 2f7ce3d20af64195'
./gradlew run --args='fa1f00bf7d171ec 71df9c3d09fefd4 666dadd7e4b83c7'
```

It is posible to edit the log4j2.xml files to change logs level to `debug`, `trace` or `info` to show verbose information:

	<Root level="info">

Common problems:
- Ensure to have the correct java version
- in the run task take care of the integer input sizes

	
```
java --version
	openjdk 17.0.4 2022-07-19
```
