package cci.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

  static class Animal {
    protected int order = 0;
    protected String name;

    Animal(String name) {
      this.name = name;
    }
  }

  static class Dog extends Animal {
    Dog(String name) {
      super(name);
    }

    @Override
    public String toString() {
      return "Dog [order=" + order + ", name=" + name + "]";
    }
  }

  static class Cat extends Animal {
    Cat(String name) {
      super(name);
    }

    @Override
    public String toString() {
      return "Cat [order=" + order + ", name=" + name + "]";
    }
  }

  static class Shelter {
    int order = 0;
    Queue<Cat> cats = new LinkedList<>();
    Queue<Dog> dogs = new LinkedList<>();

    Animal dequeueAny() {
      Cat cat = cats.peek();
      Dog dog = dogs.peek();

      if(cat.order > dog.order){
        return dogs.poll();
      } else {
        return cats.poll();
      }
    }

    Cat dequeueCat() {
      return cats.poll();
    }

    Dog dequeueDog() {
      return dogs.poll();
    }

    void enqueu(Animal animal) {
      animal.order = ++order;

      if(animal instanceof Dog){
        dogs.add((Dog) animal);
      } else {
        cats.add((Cat) animal);
      }
    }

    @Override
    public String toString() {
      return "Shelter [order=" + order + ", cats=" + cats + ", dogs=" + dogs + "]";
    }

    
  }

  public static void main(String[] args) {
    Shelter shelter = new Shelter();
  
    shelter.enqueu(new Dog("a"));
    shelter.enqueu(new Dog("b"));
    shelter.enqueu(new Cat("c"));
    shelter.enqueu(new Dog("d"));
    shelter.enqueu(new Dog("e"));
    shelter.enqueu(new Cat("f"));
    shelter.enqueu(new Cat("g"));
    shelter.enqueu(new Dog("h"));
  

    System.out.println(shelter);

    System.out.println(shelter.dequeueAny());
    System.out.println(shelter.dequeueDog());
    System.out.println(shelter.dequeueDog());
    System.out.println(shelter.dequeueAny());
    System.out.println(shelter.dequeueAny());
    System.out.println(shelter.dequeueAny());

    System.out.println(shelter);
  }

}
