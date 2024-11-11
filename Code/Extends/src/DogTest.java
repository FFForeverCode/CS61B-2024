import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DogTest {

    @Test
    public void compare() {
        Dog d1=new Dog(20,"a");
        Dog d4=new Dog(20,"d");
        Dog d2=new Dog(30,"b");
        Dog d3=new Dog(40,"c");
        int expected1=1;
        int expected2=0;
        int expected3=-1;
        int actual1=d2.compare(d1);
        int actual2=d1.compare(d4);
        int actual3=d1.compare(d3);
        assertEquals(expected1,actual1);
        assertEquals(expected2,actual2);
        assertEquals(expected3,actual3);
    }
}