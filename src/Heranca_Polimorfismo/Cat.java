package Heranca_Polimorfismo;

public class Cat extends Animal{
    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void meow(){
        System.out.println("meow");
    }
}
