Specification
==============
Baby-Q is a game in which the human player attempts to navigate the ship, named E, from one corner of the galaxy to the star gate in the opposite corner, allowing exploration of other galaxies. The computer attempts to prevent this by laying K-mines at random in the galaxy. The players take turns, starting with the human player. The player has 100 moves to reach the star gate.
The E ship

The E ship has an energy level, starting at 100 units.

The amount of energy consumed moving from sector s1 to s2 requires 100 times the distance between the two sectors.

If the energy level falls below 20 units, life support fails and the player loses.

On a given turn, the player can:

    stay in place, increasing the energy level by 10%
    move to another sector, with a corresponding decrease in the energy level

K-mines

After the player moves, the computer lays a K-mine at random in the galaxy. If the K-mine lands on the E ship, the K-mine self destructs, E's energy level is decreased by 30% and E is returned to the start position.

If the K-mine lands on one of the stars protecting the star gate, it is destroyed without further effect. Similarly, if it lands on the star gate, it is whisked to another galaxy and rendered harmless in the process.

Initial state

|9|-|-|-|-|-|-|-|*|-|  
|8|-|-|-|-|-|-|-|*|*|
|7|-|-|-|-|-|-|-|-|-|
|6|-|-|-|-|-|-|-|-|-|
|5|-|-|-|-|-|-|-|-|-|
|4|-|-|-|-|-|-|-|-|-| 
|3|-|-|-|-|-|-|-|-|-|  
|2|-|-|-|-|-|-|-|-|-|
|1|E|-|-|-|-|-|-|-|-|
| |1|2|3|4|5|6|7|8|9| 

After several moves

|9|-|-|-|-|-|K|-|*|-|  
|8|-|-|-|-|-|-|-|*|*|
|7|-|-|-|-|-|-|-|-|-|
|6|-|-|-|-|-|-|-|-|-|
|5|-|-|-|-|-|-|-|-|-|
|4|-|-|E|-|-|-|-|K|-| 
|3|-|-|-|-|-|K|-|-|-|  
|2|-|-|-|-|-|-|-|-|-|
|1|-|-|-|-|-|-|-|-|-|
| |1|2|3|4|5|6|7|8|9| 

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

Example Execution
==============
Run the following to compile the program:

`make`

Once the program is compiled run:

`make run`

Run the following to remove the compiled files:

`make clean`

    

Test Cases
==============

