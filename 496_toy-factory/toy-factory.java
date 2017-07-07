/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/toy-factory
@Language: Java
@Datetime: 17-03-02 22:23
*/

/**
 * Your object will be instantiated and called as such:
 * ToyFactory tf = new ToyFactory();
 * Toy toy = tf.getToy(type);
 * toy.talk();
 */
interface Toy {
    void talk();
}

class Dog implements Toy {
    // Write your code here
    @Override
    public void talk() {
        System.out.println("Wow");
    }
}

class Cat implements Toy {
    // Write your code here
    @Override
    public void talk() {
        System.out.println("Meow");
    }
}

public class ToyFactory {
    /**
     * @param type a string
     * @return Get object of the type
     */
    public Toy getToy(String type) {
        // Write your code here
        if (type.equals("Dog")) {
            return new Dog();
        }
        if (type.equals("Cat")) {
            return new Cat();
        }
        return null;
    }
}