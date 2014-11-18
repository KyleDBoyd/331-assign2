Assignment 3
===========================
Specification
---------------------------

Baby-Zap extends and changes Baby-Q as follows:

#####Space size

In Baby-Zap space is 11 rows by 15 columns. The Star Gate is in Row 11, Column 15 and is surrounded by stars as before.

#####Initial E-ship energy

In Baby-Zap the E-ship starts with 115 energy units, not 100.

#####Rest move energy change

In Baby-Zap the E-ship increases its energy by 9%, not 10%.

#####K-mine damage

In Baby-Zap K-mine damage is 35%, not 30%.

#####Status display

The game window should include the current number of moves, the current E-ship energy level, and an indication of what happened on the most recent move.

It is acceptable to generate debugging output to System.out or System.err.

#####Restart game

It should be possible to restart the game either by clicking a button or hitting a menu item.

#####L-Mines
If a new K-mine lands on top of an existing K-mine it is converted to a L-mine. When an L-mine hits the E-ship directly, the L-mine acts exactly like a K-mine. L-mines can hit the E-ship using "ray guns" that only act in directions parallel to the X or Y axes (that is, not diagonally) and only have an effect up to two units of distance. Rather than blowing the E-ship back to the start, the L-mine depletes the E-ship's energy by 20/DL %, where DL is the distance between the L-mine and the E-ship. After zapping the E-ship, the L-mine reverts to a K-mine.
Moves don't consume energy

Unlike in Baby-Q, moving the E-ship in Baby-Zap does not consume energy. The amount of energy required to make a move is 105 times the distance between the positions, not 100.
Animation

Upon winning the game, a celebratory animation should be shown to the player. Be creative.

File List
---------------------------
* makefile
* games/
    * BabyGame.java
    * DashBoard.java
    * Location.java
    * Ship.java
    * StarGate.java
    * BabyQ.java
    * GameGrid.java
    * Mine.java
    * Sprite.java
    * Animation.java

Class Design
---------------------------
* BabyQ - Implements a top level window and initializes the game (Main)
* GameGrid - Builds the game grid
* Location - Implements a button that knows its location in a grid of buttons
* BabyGame - Handles all of the game logic and click events
* Animation - Handles the game animations
* Sprite - Sprites that are drawn on the grid
    * Mine
    * Ship
    * StarGate

Example Execution
---------------------------
Run the following to compile the program:

`$make`

Once the program is compiled, run the following command to start the game:

`$make run`

Run the following to remove the compiled files:

`$make clean`

Assignment 2
===========================
Specification
---------------------------
Baby-Q is a game in which the human player attempts to navigate the ship, named E, from one corner of the galaxy to the star gate in the opposite corner, allowing exploration of other galaxies. The computer attempts to prevent this by laying K-mines at random in the galaxy. The players take turns, starting with the human player. The player has 100 moves to reach the star gate.
The E ship

The E ship has an energy level, starting at 100 units.

The amount of energy consumed moving from sector s1 to s2 requires 100 times the distance between the two sectors.

If the energy level falls below 20 units, life support fails and the player loses.

On a given turn, the player can:

Stay in place, increasing the energy level by 10%

Move to another sector, with a corresponding decrease in the energy level

K-mines

After the player moves, the computer lays 3 K-mines at random in the galaxy. If the K-mine lands on the E ship, the K-mine self destructs, E's energy level is decreased by 30% and E is returned to the start position.

If the K-mine lands on one of the stars protecting the star gate, it is destroyed without further effect. Similarly, if it lands on the star gate, it is whisked to another galaxy and rendered harmless in the process.

Initial State

| 9 | - | - | - | - | - | - | - | * |   |
|---|---|---|---|---|---|---|---|---|---|
| 8 | - | - | - | - | - | - | - | * | * |
| 7 | - | - | - | - | - | - | - | - | - |
| 6 | - | - | - | - | - | - | - | - | - |
| 5 | - | - | - | - | - | - | - | - | - |
| 4 | - | - | - | - | - | - | - | - | - |
| 3 | - | - | - | - | - | - | - | - | - |
| 2 | - | - | - | - | - | - | - | - | - |
| 1 | E | - | - | - | - | - | - | - | - |
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |

After Several Moves

| 9 | - | - | - | - | - | K | - | * |   |
|---|---|---|---|---|---|---|---|---|---|
| 8 | - | - | - | - | - | - | - | * | * |
| 7 | - | - | - | - | - | - | - | - | - |
| 6 | - | - | - | - | - | - | - | - | - |
| 5 | - | - | - | - | - | - | - | - | - |
| 4 | - | - | E | - | - | - | - | K | - |
| 3 | - | - | - | - | - | K | - | - | - |
| 2 | - | - | - | - | - | - | - | - | - |
| 1 | - | - | - | - | - | - | - | - | - |
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |

This game is taken from: [Dwyer 80] Dwyer, Thomas and Margot Critchfield. TRS-80 Programming in Style, Radio Shack, 1980.

File List
---------------------------
* makefile
* games/
    * BabyGame.java
    * DashBoard.java
    * Location.java
    * Ship.java
    * StarGate.java
    * BabyQ.java
    * GameGrid.java
    * Mine.java
    * Sprite.java

Class Design
---------------------------
* BabyQ - Implements a top level window and initializes the game (Main)
* GameGrid - Builds the game grid
* Location - Implements a button that knows its location in a grid of buttons
* BabyGame - Handles all of the game logic and click events
* Sprite - Sprites that are drawn on the grid
    * Mine
    * Ship
    * StarGate

Example Execution
---------------------------
Run the following to compile the program:

`$make`

Once the program is compiled, run the following command to start the game:

`$make run`

Run the following to remove the compiled files:

`$make clean`


Test Cases
---------------------------
Move around the grid => Energy descrease and K-mines spawn

Move on the first move (Insufficient Energy) => Game over.

Stay in place => Energy increased by 10%. 

Move and have insufficient energy => Game over.

Move onto a K-mine => Lose 30% health and sent to start. Potential game over.

K-mine spawns on ship => Lose 30% health and sent to start. Potential game over.

Exceed move limit => Game over.

Reach end with sufficient energy => Win!

Reach end with insufficient energy => Game over.

Reach end, but exceed move limit => Game over.

Move on top of star => Not allowed. Move denied.

Move away from gate => Energy correctly decreases


I started implementing class specific unit tests with JUnit, but I didn't finish them due to time constraints. I plan to integrate this into assigment #3 when we extend this game.

Additional Notes
---------------------------
See https://github.com/KyleDBoyd/331-assign2/ for a nicely formatted readme with Markdown.




