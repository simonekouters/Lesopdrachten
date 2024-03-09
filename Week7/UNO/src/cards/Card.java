package cards;

public class Card {
    private Color color;
    private Number number;
    private Action action;
    private final String description;

    public Card (Color color, Number number) {
        this.color = color;
        this.number = number;
        this.description = color.name + " " + number.value;
    }

    public Card (Color color, Action action) {
        this.color = color;
        this.action = action;
        this.description = color.name + " " + action.name;
    }
    
    public Card (Action action) {
        this.action = action;
        this.description = action.name;
    }
    
    public Number getNumber() {
        return number;
    }
    
    public Color getColor() {
        return color;
    }
    
    public Action getAction() {
        return action;
    }
    
    public boolean isActionCard() {
        return action != null;
    }
    
    public boolean isWildCard() {
        return action == Action.WILD || action == Action.WILD_DRAW_FOUR;
    }
    
    @Override
    public String toString() {
        return ConsoleColor.getColor(color, description);
    }
}
