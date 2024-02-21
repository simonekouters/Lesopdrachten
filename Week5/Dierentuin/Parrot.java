public class Parrot extends AbstractAnimal {
    private String featherColor;
    
    public Parrot(String name, int age, String featherColor) {
        super(name, age);
        this.featherColor = featherColor;
    }
    
    public String getFeatherColor() {
        return featherColor;
    }
    
    public void mimicSound() {
        System.out.println(super.getName() + " mimics sound");
    }

    @Override
    public void makeSound() {
        System.out.println("Squawk");
    }
}