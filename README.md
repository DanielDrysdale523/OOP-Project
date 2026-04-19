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

The race is started by calling `startRace()` on a `TypingRace` object.
A simple way to test this is to add a `main` method to `TypingRace`, for example:

```java
public static void main(String[] args) {
    TypingRace race = new TypingRace(40);
    race.addTypist(new Typist('①', "TURBOFINGERS", 0.85), 1);
    race.addTypist(new Typist('②', "QWERTY_QUEEN",  0.60), 2);
    race.addTypist(new Typist('③', "HUNT_N_PECK",   0.30), 3);
    race.startRace();
}
```

Then run:

```bash
java TypingRace
```

For convinience however, I have already written a main method for the function, as such, one only need call

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

The graphical version is started by calling `startRaceGUI()` on a 'raceGUI' object.

You can also start it via the main() method of a 'raceGUI' object.

### How to compile

```bash
cd Part2
javac Typist.java TypingRace2.java Typist2.java raceGUI.java typistHistory.java
```
### To run the program:
```bash
java raceGUI.java
```



## Dependencies

- Java Development Kit (JDK) 11 or higher
- No external libraries required for Part 1
- Java Swing is required
- All other imports are under java.x or javax.swing.x
