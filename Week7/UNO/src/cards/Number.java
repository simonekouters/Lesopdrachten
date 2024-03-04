package cards;

public enum Number {
    ZERO("Zero"), ONE("One"), TWO("Two"), THREE("Three"), FOUR("Four"), FIVE("Five"),
    SIX("Six"), SEVEN("Seven"), EIGHT("Eight"), NINE("Nine"); 

    public final String name;
    private Number(String name) {
        this.name = name;
    }
}