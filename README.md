# Customizable Tic Tac Toe Game
**Overview**<br/>
This project was created using Java. It consists of an advanced Tic Tac Toe game. There are 2 game modes: Manual (vs another human player) and Automatic (vs PC). Moreover, the user will get to choose the dimensions of the board (width and height, which both represent the number of squares). After the game ends, the user will be asked if they want to replay their game lifetime from one point to another point (a replay of all the turns played from both users to show up on the screen for the user to analyze their game round if desired).

![image](https://user-images.githubusercontent.com/42348385/129166189-5703725d-eb16-4055-88cd-c514a63b16dd.png)<br/> 
**Inputs**<br/> 
The user will first have to choose the Game Mode, either ‘M’ or ‘A’. Then, they will be asked to enter the desired width(m), height (n) and number of symbols required to win (k) of the Tic Tac Toe game. Validations are used to ensure that the user does not input any illogical or invalid value.

![image](https://user-images.githubusercontent.com/42348385/129165230-11cd8f51-f8df-4067-b401-2dd57abb89de.png)<br/>
**Assumptions**<br/>
* In Manual mode, first player uses ‘X’ Symbol, and second player uses ‘O’ symbol.
* In Automatic mode, User uses ‘X’ symbol and Computer uses ‘O’ symbol.
* If number of symbols of same type repeated for k times, either vertically, horizontally, diagonally, or anti-diagonally, player is declared as a winner and the other player, is the loser.
* If number of turns equals the board size, it is a draw between the 2 players.

**Algorithm used in Automatic mode** <br/>
* The very first move of the computer is random. 
* Starting from the 2nd computer move, the algorithm will check if there is a vertically available chance to win, i.e.: if one O is left for the computer to win the game vertically, it places an O in the needed cell to win the game.
* In case the algorithm wasn’t able to find a scenario, where it is 1 symbol away from winning vertically, the algorithm will then check the array to analyze if the user enemy has 1 symbol left away from winning the game. If detected, the computer algorithm blocks the cell. This checking is done horizontally, vertically, diagonally, and anti- diagonally within all array cells so that it will be hard for user to complete k number of Xs. For example, if a user has 2 ‘X’ symbols beside each other and 3 symbols are needed to win, the algorithm will detect this and block it by inputting an ‘O’ in the column next or before these series of symbols in order to prevent the user from winning.
* If the computer was still not able to find a scenario, where the user is 1 symbol away from winning, it will play a move through an algorithm. This algorithm defines the move to be 2 cells below the row containing the Furthest away O. In case, this decided cell was not empty, we keep adding 1 cell below till we find an empty cell. In the case, there was no empty cells till the end of the game array, we start counting from the first index in the array and we move 1 cell to the right till we find an empty slot for the computer to play the move.

**Replay Feature** <br/>
After one of the players wins, the game will allow the user to replay the game from one point in the game to another point, where the user will input the values of the 2 points.

**How to run** <br/>
There are 2 folders in the directory.
One folder has the game code and the other folder has the code with Junit for testing.<br/>
*NB: In order to run the Game code with junit, you must have its libraries installed berforehand
in the IDE that you are going to use*
