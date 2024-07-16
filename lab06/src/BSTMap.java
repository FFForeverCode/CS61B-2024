import com.google.common.graph.Traverser;
import edu.princeton.cs.algs4.BST;
import org.apache.commons.lang3.ObjectUtils;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * @author KiKidog
 * {@code @date}  2024/6/26 上午8:23
 */
public class BSTMap <K extends Comparable<K>,V extends Comparable<V>>implements Map61B<K,V>{
    private BSTNode root;
    private int size;
    private class BSTNode{
        private K key;
        private V value;
        public BSTNode left;
        public BSTNode right;

        public BSTNode(){}
        public BSTNode(K key,V value) {
            this.value=value;
            this.key=key;

        }

        public BSTNode(K key, V value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * 获取
         * @return key
         */
        public K getKey() {
            return key;
        }

        /**
         * 设置
         * @param key
         */
        public void setKey(K key) {
            this.key = key;
        }

        /**
         * 获取
         * @return value
         */
        public V getValue() {
            return value;
        }

        /**
         * 设置
         * @param value
         */
        public void setValue(V value) {
            this.value = value;
        }

        /**
         * 获取
         * @return left
         */
        public BSTNode getLeft() {
            return left;
        }

        /**
         * 设置
         * @param left
         */
        public void setLeft(BSTNode left) {
            this.left = left;
        }

        /**
         * 获取
         * @return right
         */
        public BSTNode getRight() {
            return right;
        }

        /**
         * 设置
         * @param right
         */
        public void setRight(BSTNode right) {
            this.right = right;
        }

        public String toString() {
            return "BSTNode{key = " + key + ", value = " + value + ", left = " + left + ", right = " + right + "}";
        }
    }

    /**
     * 无参构造函数
     */
    public BSTMap(){
        root=null;
        size=0;
    }

    /**
     * 有参构造函数 构造root
     * @param key
     * @param value
     */
    public BSTMap(K key,V value){
        root=new BSTNode(key,value);
        size=1;
    }

    /**
     * 递归寻找Node
     * @param key
     * @param root
     * @return
     */
    public BSTNode Find(K key,BSTNode root){
        if(root==null){
            return null;
        }
        int com = key.compareTo(root.key);
        if(com<0){
           return  Find(key,root.left);
        }else if(com>0){
            return Find(key,root.right);
        }
        return root;
    }

    /**
     * 二叉树插入、更新节点
     * @param key
     * @param value
     * @param root
     * @return
     */
    public BSTNode Insert(K key,V value,BSTNode root){
        if(root==null){
            return new BSTNode(key,value);
        }
        int com = key.compareTo(root.key);
        if(com>0){
            root.right=Insert(key,value,root.right);
        }else if(com<0){
            root.left=Insert(key,value,root.left);
        }else{
            root.value=value;//如果 root.key = key 则将更新 root.value -> value
        }
        return root;
    }
    /**
     * Associates the specified value with the specified key in this map.
     * If the map already contains the specified key, replaces the key's mapping
     * with the value specified.
     *
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        if(size==0){
            root=new BSTNode(key,value);
            size++;
            return;
        }
        BSTNode p = Find(key,root);//先查 再插 如果 树中含有key 节点 则 size不再增加
        Insert(key,value,root);//插入：1.插入新的节点 2.更新节点的值
        if(p != null){
            return;
        }
        size++;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key
     */
    @Override
    public V get(K key) {
        BSTNode p = Find(key,root);
        if(p==null){
            return null;
        }
        return p.value;
    }

    /**
     * Returns whether this map contains a mapping for the specified key.
     *
     * @param key
     */
    @Override
    public boolean containsKey(K key) {
        return Find(key, root) != null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes every mapping from this map.
     */
    @Override
    public void clear() {
        root=null;
        size=0;
    }

    /**
     * Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException.
     */
    @Override
    public Set<K> keySet() {
        Set<K>set=new TreeSet<>();
        TravelSet(root,set);
        return set;
    }
    private void TravelSet(BSTNode root,Set<K>keySet){
        if(root==null){
            return;
        }
        keySet.add(root.key);
        TravelSet(root.left,keySet);
        TravelSet(root.right,keySet);
    }

    /**
     * Removes the mapping for the specified key from this map if present,
     * or null if there is no such mapping.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException.
     *
     * @param key
     */
    @Override
    public V remove(K key) {
        V value = get(key);
        if(get(key)!=null){
            size--;
        }
        root=deleteNode(key,root);
        return value;

    }
   private BSTNode deleteNode(K key,BSTNode root){
        if(root == null){
            return null;
        }
        int com = key.compareTo(root.key);
        if(com > 0){
            root.right = deleteNode(key,root.right);
        }else if(com < 0){
            root.left = deleteNode(key,root.left);
        }else{
            if(root.left==null){
                return root.right;
            }else if(root.right ==null){
                return root.left;
            }else{
                root.key=minVal(root).key;
                root.value=minVal(root).value;
                root.right=deleteNode(minVal(root).key,root.right);
            }
        }
        return root;
    }
    private BSTNode minVal(BSTNode root){
        BSTNode r = root.right;
        while(r.left!=null){
            r=r.left;
        }
        return r;
    }
    private BSTNode maxVal(BSTNode root){
        BSTNode l = root.left;
        while(l.right!=null){
            l=l.right;
        }
        return l;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<K> iterator() {
        return new Itera();
    }
    public class Itera implements Iterator<K>{

        private int wizPos;
        public Itera(){
            wizPos=0;
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return size>wizPos;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public K next() {
            ArrayList<K> arr = new ArrayList<>();
            Trvel(root, arr);
            K key= arr.get(wizPos);
            wizPos++;
            return key;
        }
        public void Trvel(BSTNode root,ArrayList<K>arr){
            if(root==null){
                return;
            }
            arr.add(root.key);
            Trvel(root.left,arr);
            Trvel(root.right,arr);
        }
    }
}
