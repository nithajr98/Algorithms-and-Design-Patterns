package PrototypePattern;

public class Main {
    public static void main(String[] args) {
        ConcretePrototype c1 = new ConcretePrototype(1);

        //using clone to create a new object
        ConcretePrototype c2 = (ConcretePrototype) c1.clone();
    }
}
