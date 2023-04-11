import java.util.ArrayList;
import java.util.List;

public class GamePlayer implements Contract {

    private int positionX;
    private int positionY;
    private int size;
    private int fuel;
    private int health;
    private List<String> inventory;
    private String lastAction; // to keep track of the last action performed
    
    public GamePlayer() {
        this.positionX = 0;
        this.positionY = 0;
        this.health = 20;
        this.size = 5;
        this.fuel = 10;
        this.lastAction = null;
        this.inventory = new ArrayList<>();
    }
    
    /**
     * Picks up an item and adds it to the player's inventory.
     * @param item The item to pick up.
     */
    @Override
    public void grab(String item) {
        System.out.println("You pick up the " + item + ".");
        this.inventory.add(item);
        this.lastAction = "grab";
    }
    
    /**
     * Drops an item from the player's inventory.
     * @param item The item to drop.
     * @return The item dropped.
     */
    @Override
    public String drop(String item) {
        if (this.inventory.contains(item)) {
            this.inventory.remove(item);
            System.out.println("You drop the " + item + ".");
            this.lastAction = "drop";
            return item;
        } else {
            System.out.println("You don't have a " + item + " to drop.");
            return null;
        }
    }
    
    /**
     * Examines an item in the player's inventory or the surrounding area.
     * @param item The item to examine.
     */
    @Override
    public void examine(String item) {
        if (this.inventory.contains(item)) {
            System.out.println("You examine the " + item + " in your inventory.");
            // Provide some information about the item in the inventory.
        } else {
            System.out.println("You examine the " + item + " in the surrounding area.");
            // Provide some information about the item in the surrounding area.
        }
    }
    
    /**
     * Uses an item from the player's inventory.
     * @param item The item to use.
     */
    @Override
    public void use(String item) {
        if (this.inventory.contains(item)) {
            System.out.println("You use the " + item + ".");
        } else {
            System.out.println("You don't have a " + item + " to use.");
        }
    }
    
    /**
     * Moves the player in the specified direction.
     * @param direction The direction to move in.
     * @return True if the move is successful, false otherwise.
     */
    @Override
    public boolean walk(String direction) {
        if (direction.equals("north")) {
            this.positionY++;
            this.health--;
            this.lastAction = "walkNorth";
        } else if (direction.equals("south")) {
            this.positionY--;
            this.health--;
            this.lastAction = "walkSouth";
        } else if (direction.equals("east")) {
            this.positionX++;
            this.health--;
            this.lastAction = "walkEast";
        } else if (direction.equals("west")) {
            this.positionX--;
            this.health--;
            this.lastAction = "walkWest";
        } else {
            return false;
        }
        System.out.println("You walk " + direction + ".");
        System.out.println("Your position is now (" + this.positionX + ", " + this.positionY + ").");
        // Modify the game state accordingly.
        return true;
    }
    
    /**
     * Flies the player to the specified coordinates.
     * @param x The x-coordinate to fly to.
     * @param y The y-coordinate to fly to.
     * @return True if the flight is successful, false otherwise.
     */
    @Override
    public boolean fly(int x, int y) {
        if (this.fuel <= 0) {
            System.out.println("Error: Not enough fuel to fly.");
            return false;
        }
        if (Math.abs(x - this.positionX) > 10 || Math.abs(y - this.positionY) > 10) {
            System.out.println("Error: Coordinates are too far away.");
            return false;
        }
        this.positionX = x;
        this.positionY = y;
        this.health -= 5;
        this.fuel -= 10;
        System.out.println("Flying to coordinates (" + x + ", " + y + ")...");
        this.lastAction = "fly";
        return true;
    }

    /**
     * Undoes the last action taken by the player.
     * If there are no actions to undo, does nothing.
     */
    @Override
    public void undo() {
        if (this.lastAction == null) {
            System.out.println("No previous action to undo.");
            return;
        }
        switch (this.lastAction) {
            case "walkNorth":
                this.positionY--;
                this.health++;
                System.out.println("Undoing last walk: North");
                break;
            case "walkSouth":
                this.positionY++;
                this.health++;
                System.out.println("Undoing last walk: South");
                break;
            case "walkEast":
                this.positionX--;
                this.health++;
                System.out.println("Undoing last walk: East");
                break;
            case "walkWest":
                this.positionX++;
                this.health++;
                System.out.println("Undoing last walk: West");
                break;
            case "fly":
                this.positionX = 0;
                this.positionY = 0;
                this.health += 5;
                System.out.println("Undoing last fly.");
                break;
            default:
                System.out.println("Unknown last action: " + this.lastAction);
                break;
        }
        lastAction = null; // reset the last action after undoing it
    }

    public void rest() {
        // The player rests and regains some health.
        this.health += 10;
        System.out.println("Player's health is now " + this.health);
    }

    public Number grow(){
        this.size++;
        return this.size;
    }

    public Number shrink(){
        this.size--;
        return this.size;
    }

    public Number getPositionX(){
        return this.positionX;
    }

    public Number getPositionY(){
        return this.positionY;
    }

    public Number getHealth(){
        return this.health;
    }
    
    
}
