public class Zoo {
    public static void main(String[] args) {
        Lion simba = new Lion("Simba", 10, 50);
        Parrot bob = new Parrot("Bob", 3, "green");
        
        System.out.println("Bob's feather color: " + bob.getFeatherColor());
        simba.eat();
        bob.makeSound();
        
    }
}