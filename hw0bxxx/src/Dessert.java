public class Dessert {
    public int flavor;
    public int price;
    public static int numDessert;
    public Dessert(int flavor, int price) {
        this.flavor = flavor;
        this.price = price;
        numDessert++;//重要，第一次没注意，数量一直是0
    }
    public void printDessert(){
        System.out.println(flavor+" "+price+" "+numDessert);
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }

}
