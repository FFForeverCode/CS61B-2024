public class WeightQuickunionDs {
    private int[]parents;
    private int size;
    WeightQuickunionDs(int n) {
        size=n;
        parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i]=-n;
        }
    }
    public void connect(int p,int q){
        int pi=find(p);
        int qi=find(q);
        int psize=pi+size+1;
        int qsize=qi+size+1;
        if(psize>=qsize){//小树连接到大树上
            parents[q]=p;
            p=p+qsize;
        }else{
            parents[p]=q;
        }

    }
    public boolean isConnect(int p,int q){
        int pi=find(p);
        int qi=find(q);
        return pi==qi;
    }
    public int find(int p){
        int r=p;
        while(parents[r]>=0){
            r=parents[r];
        }
        return r;
    }
}
