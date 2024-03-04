package cards;

public enum Action {
    DRAW_TWO("Draw Two"), REVERSE("Reverse"), SKIP("Skip"), WILD("Wild Card"), WILD_DRAW_FOUR("Wild Draw Four Card");
        
    public final String name;
    private Action(String name) {
        this.name = name;
    }
}