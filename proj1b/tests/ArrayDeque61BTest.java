import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {
    /**
     * 1.assertThat(actual).isEqualTo(expected);
     * 2.assertWithMessage("actual is not expected")
     *     .that(actual)
     *     .isEqualTo(expected);
     *3.assertThat(actualList)
     *     .containsExactly(0, 1, 2, 3)
     *     .inOrder();
     *4.assertThat(actualList)
     *     .containsExactlyElementsIn(expected)  // `expected` is a List
     *     .inOrder();.
     */

     @Test
     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }
     @Test
    void AddFirst(){
         ArrayDeque61B<Integer>arr=new ArrayDeque61B<>();
         arr.addFirst(1);
         assertThat(arr.toList()).containsExactly(1);
         arr.addFirst(2);
         assertThat(arr.toList()).containsExactly(2,1);
         arr.addFirst(3);
         assertThat(arr.toList()).containsExactly(3,2,1);
         arr.addFirst(4);
         assertThat(arr.toList()).containsExactly(4,3,2,1);
     }
     @Test
    void AddLast(){
         ArrayDeque61B<Integer>arr=new ArrayDeque61B<>();
         arr.addLast(1);
         assertThat(arr.toList()).containsExactly(1);
         arr.addLast(2);
         assertThat(arr.toList()).containsExactly(1,2);
         arr.addLast(3);
         assertThat(arr.toList()).containsExactly(1,2,3);

     }
     @Test
    void removeFirst(){
         ArrayDeque61B<Integer>arr=new ArrayDeque61B<>();
         assertThat(arr.removeFirst()).isEqualTo(null);
         arr.addFirst(1);
         arr.addFirst(2);
         arr.addFirst(3);
         assertThat(arr.removeFirst()).isEqualTo(3);
         assertThat(arr.toList()).containsExactly(2,1);
         assertThat(arr.removeFirst()).isEqualTo(2);
         assertThat(arr.toList()).containsExactly(1);
     }
     @Test
    void removeLast(){
         ArrayDeque61B<Integer>arr=new ArrayDeque61B<>();
         assertThat(arr.removeLast()).isEqualTo(null);
         arr.addLast(1);//Now :1
         assertThat(arr.removeLast()).isEqualTo(1);// expected: 1 ; Now: null
         arr.addLast(2);//Now: 2
         arr.addLast(3);//Now: 2 3
         arr.addLast(4);//Now: 2 3 4
         assertThat(arr.removeLast()).isEqualTo(4);//expected: 4
         assertThat(arr.removeLast()).isEqualTo(3);
         assertThat(arr.removeLast()).isEqualTo(2);
     }
     @Test
    void get(){
         ArrayDeque61B<Integer>arr=new ArrayDeque61B<>();
         arr.addFirst(1);
         assertThat(arr.get(0)).isEqualTo(1);
         arr.addFirst(2);
         arr.addFirst(3);
         arr.addFirst(4);//Now:4 3 2 1
         assertThat(arr.get(1)).isEqualTo(3);
         assertThat(arr.get(2)).isEqualTo(2);
         assertThat(arr.get(3)).isEqualTo(1);

     }
     @Test
    void size(){
         ArrayDeque61B<Integer>arr=new ArrayDeque61B<>();
         arr.addFirst(1);
         arr.addFirst(2);
         arr.addFirst(3);
         assertThat(arr.size()).isEqualTo(3);
         arr.addLast(3);
         assertThat(arr.size()).isEqualTo(4);
         arr.removeLast();
         assertThat(arr.size()).isEqualTo(3);
         arr.removeFirst();
         assertThat(arr.size()).isEqualTo(2);
     }
     @Test
    void Empty(){
         ArrayDeque61B<Integer>arr=new ArrayDeque61B<>();
         assertThat(arr.isEmpty()).isEqualTo(true);
         arr.addFirst(1);
         assertThat(arr.isEmpty()).isEqualTo(false);
     }


}
