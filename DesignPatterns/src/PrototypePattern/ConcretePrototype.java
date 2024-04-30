package PrototypePattern;

public class ConcretePrototype implements Prototype{

    private int id;

    public ConcretePrototype(int id) {
        this.id = id;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.id);
    }
    
}
