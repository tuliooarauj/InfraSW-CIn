package Heranca_Polimorfismo;

public class Dog extends Animal {
    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public void bark(){
        System.out.println("au au au au");
    }
}
