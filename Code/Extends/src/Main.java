public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Dog dog = new Dog(12,"a");
        Dog dog1 = new Dog(13,"b");
        Dog.getNameComparator().compare(dog,dog1);
    }
}