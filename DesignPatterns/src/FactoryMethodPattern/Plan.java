package FactoryMethodPattern;
//This is the plan abstract class. it will be used by concrete subclasses later.
public abstract class Plan {
    protected double rate;

    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}
