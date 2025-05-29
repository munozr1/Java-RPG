# Java-RPG

A simple, turn-based, text-based RPG game implemented in Java. Players can create characters, select weapons, and battle on a grid-based map. The game features character creation (manual or random stats), weapon selection, and basic combat mechanics.

## Features
- **Character Creation:** Create up to two players with custom or random stats (Strength, Dexterity, Constitution).
- **Weapons System:** Choose from a list of weapons loaded from a CSV file (`weapons.csv`). Each weapon has a name, dice type (e.g., `1d12`), and bonus damage.
- **Grid Map:** Players move on a 25x25 grid map. The map displays player positions and empty spaces.
- **Combat:** Players can attack or attempt to disarm each other. Attacks are resolved using dice rolls and weapon stats.
- **Utility Functions:** Includes dice rolling, stat randomization, and screen clearing utilities.

## File Structure
- `edu/uta/CSE1325/`
  - `Game.java`: Main entry point. Handles the game loop and menu.
  - `Player.java`: Player class with stats, movement, and combat methods.
  - `Weapon.java`: Weapon class with dice and bonus attributes.
  - `Map.java`: 25x25 grid map for player movement.
  - `GameUtility.java`: Static utility methods for dice, character creation, and more.
  - `PlayerTest.java`, `WeaponTest.java`: Simple test classes for Player and Weapon.
- `weapons.csv`: List of available weapons in the format `Name,DiceType,Bonus`.
- `phase1UML.png`: UML diagram of the project structure.
- `docs/`: Javadoc-generated documentation for all classes.

## Getting Started

### Prerequisites
- Java 18 or later

### Compiling
```sh
javac edu/uta/CSE1325/*.java
```

### Running the Game
```sh
java edu.uta.CSE1325.Game weapons.csv
```

### Running Tests
```sh
java edu.uta.CSE1325.PlayerTest
java edu.uta.CSE1325.WeaponTest weapons.csv
```

## Weapons File Format
Example (`weapons.csv`):
```
Greataxe,1d12,0
Longsword,1d10,1
Warhammer,1d8,2
Shortsword,1d6,3
Dagger,1d4,4
```

## Documentation
- Javadoc HTML documentation is available in the `docs/` folder. Open `docs/index.html` in your browser.
- See `phase1UML.png` for a UML diagram of the main classes.

## License
This project is for educational purposes.
