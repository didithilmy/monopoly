# Engi's Monopoly
A mock of one of the world's most popular board game: Monopoly.

## Features

### House Rule
* Maximum of 4 players
* Players can buy lot, railroad, or utility
* Players can build houses if they collect a group of lot, maximum of 4 house on each lot. Each lot that have houses, have a different rent price
* Players need to use buttons to do their action
* Players roll two fair six-sided dice on each of their turns. The sum of the two dice determines how many spaces the player moves his or her game piece on the board.
* If the two dice roll the same number for three times, players must go to jail
* Players have 10 seconds to roll their dice, it will roll automatically if players didn't press the "Roll Dice" button after 10 seconds
* Players have 30 seconds to do their action
* Each time players token passes over "Start", they will get Rp200 salary
* Whenever players land on an unowned property, they can buy the property if they have enough money. If not, they need to "End Turn" their turn
* Players can get out of jail if they get two same dice or pay the bail price. After three turn and players didn't get two same dice, they will automatically get out of jail
* Players need to pay rent if they land on an owned lot. Each lot has different rent prices
* If players lands on "Free Parking", they will not get anything. Its only a free resting place
* Players are declared bankrupt if they have money below zero and can't pay their debt to the bank. They will automatically lose and can't continue their game

### Implemented Bonus
* Java Swing UI
* Singleton
* Exception

### Class
Its class uses :

* Inheritance
* Polymorphism
* Abstract Class / Interface
* Generic Class

### Build and Execution

Building this project requires Maven build tool and Java 8 (or newer).

```sh
$ mvn install
$ java -jar ./target/monopoly-1.0.jar
```

### Author
- Muhammad Aditya Hilmy, NIM 18217025
- Zalikha Adiera Gambetta, NIM 18217027
- Muhammad Yanza Hattari, NIM 18217043
- Claudia Renata Maharani D., NIM 18217048
