public class Lion extends AbstractAnimal {
    private int maneLength;
    
    public Lion(String name, int age, int maneLength) {
        super(name, age);
        this.maneLength = maneLength;
    }
    
    public int getManeLength() {
        return maneLength;
    }
    
    public void hunt() {
        System.out.println(super.getName() + " hunts");
    }

    @Override
    public void makeSound() {
        System.out.println("Roar");
    }
}