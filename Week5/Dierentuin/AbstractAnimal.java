public abstract class AbstractAnimal implements Animal {
    private final String name;
    private final int age;
    
    public AbstractAnimal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void eat() {
        System.out.println(name + " eats"); 
    }
    
    public void sleep() {
        System.out.println(name + " sleeps");
    }
    
    public abstract void makeSound();
}