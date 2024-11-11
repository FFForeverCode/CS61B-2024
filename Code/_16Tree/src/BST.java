import org.w3c.dom.Node;

/**
 * @author KiKidog
 * {@code @date}  2024/6/26 上午8:23
 */

/**
 * 二叉树 相关代码实现
 */
public class BST {
    public  int item;
    public BST left;
    public BST right;
    public BST(int item,BST left, BST right){
        this.item=item;
        this.left=left;
        this.right=right;
    }
    public BST(int item){
        this.item=item;
    }

    /**
     * 二叉树的 查找
     * left < Node <right
     * 时间复杂度 log n；
     * @param item
     * @param Node
     * @return
     */
    static BST Find(int item,BST Node){
        if(Node == null){
            return null;
        }else if(item == Node.item){
            return Node;
        }else if(item<Node.item){
            return Find(item,Node.left);
        }else{
            return Find(item,Node.right);
        }
    }

    /**
     * 搜索二叉树的插入
     * left < Node <right
     * @param item
     * @param Node
     * @return
     */
    static BST Insert(int item,BST Node){
        if(Node == null){
            Node = new BST(item);
            return Node;
        }
        if(item<Node.item){
            Node.left=Insert(item,Node.left);
        }else if(item>Node.item){
            Node.right=Insert(item,Node.right);
        }
        return Node;//重要
    }
}
