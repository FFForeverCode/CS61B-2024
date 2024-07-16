import java.util.Scanner;

public class UnionFind {
    // TODO: Instance variables
    private int[]parents;
    private int size;
    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        // TODO: YOUR CODE HERE
        if(N<0){
            throw new IllegalArgumentException("The N is invalid!");
        }
        parents=new int[N];
        size=N;
        for(int i=0;i<N;i++){
            parents[i]=-1;
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        // TODO: YOUR CODE HERE
        int parent=find(v);
        return Math.abs(parents[parent]);

    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        // TODO: YOUR CODE HERE
        int r=v;
        if(parents[r]<0){
            return parents[r];
        }
        while(parents[r]>=0){
            r=parents[r];
        }
        return r;
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO: YOUR CODE HERE
        int pv1=find(v1);
        int pv2=find(v2);
        return pv1==pv2;

    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */

    /**
     *
     *使用递归得到根节点，且使各个叶节点连接到根节点
     * @param v
     * @return parent
     */
    public int find(int v) {
        // TODO: YOUR CODE HERE
        if(v<0||v>=parents.length){
            throw new IllegalArgumentException("The v is outIndex!");
        }
        if(parents[v]<0){
            return v;
        }
        int next=parents[v];
        parents[v]=find(next);
        return find(next);

    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        int root1=find(v1);
        int root2=find(v2);
        int size1=Math.abs(parents[root1]);
        int size2=Math.abs(parents[root2]);
        if(root1==root2){
           return;
        }
        if(size1>size2){
            parents[root1]+=parents[root2];
            parents[root2]=root1;
        }else if(size2>size1){
            parents[root2]+=parents[root1];
            parents[root1]=root2;
        }else if(size1==size2){
            parents[root2]+=parents[root1];
            parents[root1]=root2;
        }
    }
    public void print(){
        System.out.println("Hello,World!");
        System.out.print("Hello World!");
    }


}
