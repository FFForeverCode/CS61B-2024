import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HexFormat;

/**
 * @author KiKidog
 * @date 2024/8/4
 */
class minHeapTest {

    /**
     * 在堆中添加元素
     * the strategy
     * 1.最小的
     * 2.最大的
     * 3.与根相同的
     */
    @Test
    void add() {
        minHeap minheap = new minHeap();
        /**
         * 1.空 expected:null
         */
        Object[]expected = new Object[minheap.getCAPACITY()];
        Assertions.assertArrayEquals(expected,minheap.getKeys());
        /**
         * 添加一个元素
         * expected:null , 2
         */
        minheap.add(2);
        expected[0]=null;
        expected[1]=2;
        Assertions.assertArrayEquals(expected,minheap.getKeys());
        /**
         * 添加大的元素
         * expected:null,2,3
         */
        minheap.add(3);
        expected[2]=3;
        Assertions.assertArrayEquals(expected,minheap.getKeys());
        /**
         * 添加最小元素
         * 最小元素:expected:0
         * 最大元素:expected:3 tips:无意义 左右没大小关系
         */
        minheap.add(0);
        System.out.println(Arrays.toString(minheap.getKeys()));
        Assertions.assertEquals(0,minheap.getKeys()[1]);
        /**
         * 添加与根大小相同的元素
         * expected:0,0
         */
        minheap.add(0);
        Assertions.assertArrayEquals(new Object[]{0,0},new Object[]{minheap.getKeys()[1],minheap.getKeys()[2]});


    }

    /**
     *获得堆中最小的元素
     * the strategy
     * 1.在空堆中获取
     * 2.在单个元素中获取
     * 3.在多个元素的堆中获取
     */
    @Test
    void getSmallest() {
        minHeap heap = new minHeap();
        /**
         * 空堆
         * expected:null....
         */
        Assertions.assertNull(heap.getSmallest());
        /**
         * 单个元素
         * expected:1
         */
        heap.add(1);
        Assertions.assertEquals(1,heap.getSmallest());
        /**
         * 多个元素
         * expected:-2
         */
        heap.add(2);
        heap.add(4);
        heap.add(1);
        heap.add(-1);
        heap.add(-2);
        heap.add(-3);
        Assertions.assertEquals(-3,heap.getSmallest());
        System.out.println(Arrays.toString(heap.getKeys()));
    }

    /**
     * 删除最小的元素
     * the strategy
     * 1.空堆中删除
     * 2.单个
     * 3.多个
     */
    @Test
    void removeSmallest() {

        minHeap heap = new minHeap();
        Object[]expected=new Object[heap.getCAPACITY()];
        /**
         * 空堆
         * expected:throw Error;
         */
        //heap.removeSmallest();
        /**
         * 单个
         * expected:1 空
         */
        heap.add(1);
        Assertions.assertEquals(1,heap.removeSmallest());
        Assertions.assertArrayEquals(expected,heap.getKeys());
        /**
         * 多个
         * expected: -2
         */
        heap.add(1);
        heap.add(2);
        heap.add(6);
        heap.add(-2);
        heap.add(10);
        System.out.println(Arrays.toString(heap.getKeys()));
        Assertions.assertEquals(-2,heap.removeSmallest());
        System.out.println(Arrays.toString(heap.getKeys()));

    }
}