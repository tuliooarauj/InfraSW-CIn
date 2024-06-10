package Interfaces;

import Heranca_Polimorfismo.Cat;
import Heranca_Polimorfismo.Dog;

public class Main {
    public static void main(String[] args) {
        //Animal animal = new Animal(12, "Max");

        //Herança
        Cat newCat = new Cat(18, "Bytes");
        System.out.println("Informaçãoes do gato: ");
        System.out.println("Nome: "+newCat.name);
        System.out.println("Idade: "+newCat.age);
        System.out.println("O gato faz: ");
        newCat.meow();

        System.out.println("==============================");

        Dog newDog = new Dog(18, "Bob");
        System.out.println("Informações do cachorro:");
        System.out.println("Nome: "+newDog.name);
        System.out.println("Idade: "+newDog.age);
        System.out.println("O cachorro faz: ");
        newDog.bark();
    }


}
