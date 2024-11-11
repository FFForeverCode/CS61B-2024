import java.util.ArrayList;
import java.util.List;

/**
 * @author KiKidog
 * @date 2024/7/3
 */
public class BTree {
    private BTreeNode root;//根节点
    private final int t;//B树的最小度数
    public static class BTreeNode{
        List<Integer> keys;//储存节点的键值
        List<BTreeNode>Children;//储存子节点
        boolean leaf;//是否为叶子节点
        public BTreeNode(boolean leaf){
            this.keys=new ArrayList<>();
            this.Children=new ArrayList<>();
            this.leaf = leaf;
        }
    }
    public BTree(int t){
        this.root = new BTreeNode(true);
        this.t=t;
    }
    //递归搜索操作
    public boolean search(int key){
        return searchHelp(root,key);
    }
    private boolean searchHelp(BTreeNode root,int key){
        int i=0;
        while(i<root.keys.size() && key>root.keys.get(i)){
            i++;
        }
        if(i < root.keys.size()&&root.keys.get(i)==key){
            return true;
        }
        if(root.leaf){
            return false;
        }else{
            return searchHelp(root.Children.get(i),key);
        }
    }
    //插入操作
    public void insert(int key){
        BTreeNode r= root;
        if (r.keys.size() == 2 * t - 1) {
            BTreeNode s = new BTreeNode(false);
            root = s;
            s.Children.add(r);
            splitChild(s, 0);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }


    }
    private void insertNonFull(BTreeNode node ,int key){
        int i = node.keys.size() - 1;
        if(node.leaf){
            while(i>=0 && key < node.keys.get(i)){
                i--;
            }
            node.keys.add(i+1,key);
        }else{
            while(i>=0 && key < node.keys.get(i)){
                i--;
            }
            i++;
            if(node.Children.get(i).keys.size()== 2*t-1){
                splitChild(node,i);
                if(key > node.keys.get(i)){
                    i++;
                }
            }
            insertNonFull(node.Children.get(i),key);
        }
    }
    //分裂子节点
    private void splitChild(BTreeNode x, int i){
        BTreeNode z = new BTreeNode(x.Children.get(i).leaf);
        BTreeNode y = x.Children.get(i);
        x.Children.add(i + 1, z);
        x.keys.add(i, y.keys.get(t - 1));
        z.keys = new ArrayList<>(y.keys.subList(t, 2 * t - 1));
        y.keys.subList(t - 1, 2 * t - 2).clear();
        if (!y.leaf) {
            z.Children = new ArrayList<>(y.Children.subList(t, 2 * t));
            y.Children.subList(t - 1, 2 * t - 1).clear();
        }

    }
}
