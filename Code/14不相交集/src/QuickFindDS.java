public class QuickFindDS implements DisjoinSets{
    private int[]id;
    @Override
    public void connect(int p, int q) {
        int pid=id[p];
        int qid=id[q];
        for(int i=0;i<id.length;i++){
            if(id[i]==qid){
                id[i]=pid;
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return id[p]==id[q];
    }
    public QuickFindDS(){
        for (int i = 0; i < id.length; i++) {
            id[i]=i;
        }
    }
}
