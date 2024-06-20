import static org.junit.jupiter.api.Assertions.*;

import deque.ArrayDeque61B;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {
   @Test
   public void TestTostring(){
       ArrayDeque61B<Integer>array=new ArrayDeque61B<>();
       assertThat(array.toString()).isEqualTo("");
       array.addFirst(1);
       array.addFirst(2);
       array.addFirst(3);
       assertThat(array.toString()).isEqualTo("[3,2,1]");

   }
   @Test
    public void TestEquals(){
       ArrayDeque61B<Integer>array=new ArrayDeque61B<>();
       ArrayDeque61B<Integer>array1=new ArrayDeque61B<>();
       assertThat(array.equals(array1)).isTrue();
       array1.addFirst(1);
       assertThat(array.equals(array1)).isFalse();
       array1.addFirst(2);
       array1.addFirst(3);
       array.addFirst(1);
       array.addFirst(2);
       array.addFirst(3);
       assertThat(array.equals(array1)).isTrue();

   }


}
