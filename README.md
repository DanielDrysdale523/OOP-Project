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

To be implemented as part of the coursework. Place all GUI-related source files in this folder. The graphical version is started by calling `startRaceGUI()`.

## Dependencies

- Java Development Kit (JDK) 11 or higher
- No external libraries required for Part 1
- Part 2 may use Java Swing (included in standard JDK) or JavaFX

## Notes

- All code should compile and run using standard command-line tools without any IDE-specific configuration.
- The starter code in Part1 was originally written by Ty Posaurus. It contains known issues — finding and fixing them is part of the coursework.
