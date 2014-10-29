Specification
==============
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
==============
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
==============
* BabyQ - Implements a top level window and initializes the game (Main)
* GameGrid - Builds the game grid
* Location - Implements a button that knows its location in a grid of buttons
* BabyGame - Handles all of the game logic and click events
* Sprite - Sprites that are drawn on the grid
    * Mine
    * Ship
    * StarGate

Example Execution
==============
Run the following to compile the program:

`$make`

Once the program is compiled run:

`$make run`

Run the following to remove the compiled files:

`$make clean`


Test Cases
==============
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
==============
See https://github.com/KyleDBoyd/331-assign2/ for a nicely formatted readme with Markdown.




