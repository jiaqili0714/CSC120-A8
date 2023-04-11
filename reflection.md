Use this file to record your reflection on this assignment.

- Tell me about your class! What does it represent?
- What additional methods (if any) did you implement alongside those listed in the interface?
- What worked, what didn't, what advice would you give someone taking this course in the future?


The GamePlayer class implements the Contract interface. This class models a player character in a game and provides methods for the player to interact with the game world.

The class has several attributes, including fuel, health, positionX, positionY,size,inventory,lastAction. These attributes represent the player's fuel level for flying, health status, current position, last action in the game world. 

The inventory is a bag, which player could add and remove items from it. 

The lastAction attribute keep track of the player's recent last action, which can be undone using the undo() method.

The GamePlayer class provides several methods that allow the player to interact with the game world. 

The grab(String item) method simulates the player picking up an item in the game world. 
The drop(String item) method simulates the player dropping an item they are carrying. 
The examine(String item) method simulates the player examining an item in the game world to gain information about it. 
The use(String item) method simulates the player using an item they are carrying. The walk(String direction) method simulates the player walking in a specific direction. 
The fly(int x, int y) method simulates the player flying to a specific location in the game world.

The shrink() and grow() methods adjust the size of the player character, which could have gameplay implications. The rest() method allows the player character to regain health points.

Finally, the undo() method allows the player to undo their most recent action, whether it was walking, flying, or any other action in the game world. This is achieved by removing the most recent action from the history list and performing the opposite action to return the player to their previous state.

I also added getHealth(), getPostionX(), getPostionY() accessors so I could check if the program actually works in the Main file.
