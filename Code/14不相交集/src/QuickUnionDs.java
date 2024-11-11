public class QuickUnionDs implements DisjoinSets {
    private int[]parent;
    public QuickUnionDs(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=-1;
        }
    }
    public int find(int p){
        int r=p;
        while(parent[r]>=0){
            r=parent[r];
        }
        return r;

    }
    @Override
    public void connect(int p, int q) {
        int ip=find(p);
        int iq=find(q);
        parent[iq]=ip;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }
}
