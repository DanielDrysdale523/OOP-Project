# TypingRaceSimulator

Object Oriented Programming Project — ECS414U

## Project Structure

```
TypingRaceSimulator/
├── Part1/    # Textual simulation (Java, command-line)
└── Part2/    # GUI simulation (to be completed)
```

## Part 1 — Textual Simulation

### How to compile

```bash
cd Part1
javac Typist.java TypingRace.java
```
### To run the program:
```bash
java TypingRace.java
```

### How it Works
The text based simulation will give you a basic example run with prebuilt Typists. To alter the statistics of the runners, alter them directly in the java file - changing the following lines:
```java
        Typist a = new Typist('7', "75%", 0.75);
        Typist b = new Typist('5', "50%", 0.5);
        Typist c = new Typist('2', "25%", 0.25);
```
For each line, the single character represents their symbol for display, the percentage the name of the typist and the number their accuracy as a fraction.

## Part 2 — GUI Simulation

The graphical version is started by calling `startRaceGUI()`.
This function is found in the raceGUI class.

### How to compile

```bash
cd Part2
javac Typist.java TypingRace2.java Typist2.java raceGUI.java typistHistory.java
```
### To run the program:
```bash
java raceGUI.java



## Dependencies

- Java Development Kit (JDK) 11 or higher
- No external libraries required for Part 1
- Java Swing is required
- All other imports are under java.x or javax.swing.x