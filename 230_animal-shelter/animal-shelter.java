/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/animal-shelter
@Language: Java
@Datetime: 17-01-05 16:55
*/

public class AnimalShelter {

    private Queue<String> cats;
    private Queue<String> dogs;
    private int index;
    private String getName(String name) {
        return name.substring(name.indexOf("#") + 1, name.length());
    }
    private int getTime(String name) {
        return Integer.parseInt(name.substring(0, name.indexOf("#")));
    }
    
    public AnimalShelter() {
        // do initialize if necessary
        cats = new LinkedList<String>();
        dogs = new LinkedList<String>();
        index = 0;
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
        index++;
        if (type == 0) {
            cats.offer(index + "#" + name);
        } else {
            dogs.offer(index + "#" + name);
        }
    }

    public String dequeueAny() {
        // Write your code here
        if (cats.isEmpty()) {
            return getName(dogs.poll());
        } else if (dogs.isEmpty()) {
            return getName(cats.poll());
        } else {
            String cat = cats.peek();
            String dog = dogs.peek();
            if (getTime(cat) < getTime(dog)) {
                return getName(cats.poll());
            } else {
                return getName(dogs.poll());
            }
        }
    }

    public String dequeueDog() {
        // Write your code here
        return getName(dogs.poll());
    }

    public String dequeueCat() {
        // Write your code here
        return getName(cats.poll());
    }
}
