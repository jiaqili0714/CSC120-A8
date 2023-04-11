public class Main {
    
    public static void main(String[] args) {
        
        // Create a new GamePlayer object with the name "Alice".
        GamePlayer player = new GamePlayer();
        
        // Call the rest() method to restore the player's health.
        player.rest();
        
        // Output the player's current health value.
        System.out.println("Player's health is " + player.getHealth());
        
        // Call the walk() method to move the player.
        boolean walked = player.walk("east");
        
        // Output whether the player was able to walk or not.
        if (walked) {
            System.out.println("Player walked east.");
        } else {
            System.out.println("Player couldn't walk east.");
        }
        
        // Call the fly() method to move the player.
        boolean flew = player.fly(5, 5);
        
        // Output whether the player was able to fly or not.
        if (flew) {
            System.out.println("Player flew to coordinates (5, 5).");
        } else {
            System.out.println("Player couldn't fly to coordinates (5, 5).");
        }
        
        // Call the grab() method to pick up an item.
        player.grab("key");
        
        // Call the examine() method to look at the item.
        player.examine("key");
        
        // Call the use() method to use the item.
        player.use("key");
        
        // Call the drop() method to drop the item.
        player.drop("key");
        
        // Call the undo() method to undo the last action.
        player.undo();
        
        // Output the player's current position.
        System.out.println("Player's current position: (" + player.getPositionX() + ", " + player.getPositionY() + ")");
    }
}
