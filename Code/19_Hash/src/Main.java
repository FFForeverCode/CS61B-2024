import java.util.HashMap;

/**
 * @author KiKidog
 * @date 2024/7/16
 */
public class Main {
    public static void main(String[] args) {

        /**
         * 总结
         * 1.散列 即哈希表
         * 由 Key 与 values 组成
         * 2.基本原理：
         * Key  经过哈希函数运算 得到 唯一的int索引值 即 hashcode 哈希值
         * 在链表数组中 在i索引处存储values值
         * 3.哈希函数
         * 哈希函数非常重要，其为key得到对应value存储索引的函数运算
         * 一个好的哈希函数可以减少哈希冲突的出现以及使得元素均匀分布
         * 3.哈希冲突
         * 哈希冲突是无法避免的
         * 哈希运算无法避免不同的key得到相同的索引 hashcode
         * 此种现象为哈希冲突
         * 解决方法：values 设置为链表形式 在对应的索引处 链表形式增加value
         * 4.负载因子
         * 当values 底层数组过少时即索引过少时，哈希冲突的出现概率更大
         * 导致单个索引有过长的链表的情况，此时查找指定value的速度变慢
         * 因此 要扩大底层数组的容量 使得value均匀分布 维持查询速度为O(1)
         * 负载因子 load factor：N(value的总个数)/M(底层数组的个数)
         * java中 为 0.75
         */
    }

    /**
     * First try
     */
    public class DataIntEgerSet
    {
        /**
         * 使用布尔数组 索引代表值 true代表含有此值 false代表不含有此值
         * 缺点：浪费大量空间 需要使用的空间太大
         * 并且只能插入表示整数的值
         */
        public boolean[]present;
        public DataIntEgerSet(){
            present = new boolean[1000000];
        }

        /**
         * 向表中添加值 i i代表索引
         * @param i 添加的整数值 i
         */
        public void add(final int i) {
            present[i]=true;
        }

        /**
         * 查看表中是否含有此值 i
         * 若含有返回 true 不含有返回false
         * @param i 要查询的整数
         * @return 含有返回true 不含有返回false
         */
        public boolean contains(int i){
            return present[i];
        }
    }
    /**
     * Second try, Using HashAlgorithm
     * 实现插入字符串 小写字母
     */
    public class DataIndexedWordSet{
        private boolean[]present;
        public DataIndexedWordSet(){
            present = new boolean[20000000];
        }

        /**
         * 获取字符串 i 索引处字符代表的数字
         * @param s 字符串s
         * @param i 索引i
         * @return 返回索引i处 字符的值
         */
        public static int letterNum(final String s,final int i){
            int ithChar = s.charAt(i);
            if((ithChar)<'a'||(ithChar>'z')){
                throw new IllegalArgumentException();
            }
            return ithChar - 'a' + 1;
        }

        /**
         * 利用哈希算法 获取字符串代表的整数值索引
         * @param s 目标字符串
         * @return 返回其索引整数值
         */
        public static int englishToInt(String s){
            int intRep = 0;
            for (int i = 0; i < s.length(); i++) {
                intRep*=27;
                intRep+=letterNum(s,i);
                //27 为最大数 可以避免 小数*大数 = 大数*小数的情况
            }
            return intRep;
        }

        /**
         * 向数组中添加字符串s
         * @param s 添加的字符串
         */
        public void add(String s){
            present[englishToInt(s)] = true;
        }

        /**
         * 查看字符串 s 是否再列表中
         * @param s 查询的字符串
         * @return 在列表中返回 true 反之为false
         */
        public boolean contains(String s){
            return present[englishToInt(s)];
        }

    }
    /**
     * Third try
     * 实现插入 大小写字母 利用ASCII表
     */
    public class DataIndexedStringSet
    {
        private boolean[] present;
        public DataIndexedStringSet(){
            present = new boolean[200000];
        }
        /**
         * 获取元素对应的key值
         * @param s 目标字符串
         * @return 返回的key
         */
        public static int asciiToInt(String s){
            int intRep = 0;
            for(int i =0;i<s.length();i++){
                intRep*=126;
                intRep+=s.charAt(i);
            }
            return intRep;
        }
        /**
         * 添加元素
         * @param s 添加的元素
         */
        public void add(String s){
            present[asciiToInt(s)]=true;
        }
        /**
         * @param s 查询的字符串
         * @return 有返回true 反之为false
         */
        public boolean contains(String s){
            return present[asciiToInt(s)];
        }
    }

}