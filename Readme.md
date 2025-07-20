#  Dice Game Simulation (Java)

This is a simple Java-based Dice Game simulation involving multiple players. Each player rolls a die, and the one with the highest number wins the round. The game can be played for multiple rounds, and the user is prompted after each round whether to continue or view the results.

---

##  Features

- Two or more players can participate.
- Fair die roll simulation using `java.util.Random`.
- Play as many rounds as you like.
- View cumulative scores after any round.
- Interactive command-line interface (CLI).
- Clean object-oriented design with multiple classes.
- Scanner handling done safely to avoid input issues.

---

##  Project Structure

```bash
DiceGameSimulation/
├── Dice.java           # Class to simulate a die roll
├── Player.java         # Class representing a player
├── GameEngine.java     # Core game logic, round control
├── Executer.java       # Entry point, handles player input and game loop
└── README.md           # You're here!
