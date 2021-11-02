package graph;
import java.util.*;
class PairNodes{
    private int v;
    private int w;
    PairNodes(int v,int w){
        this.v=v;
        this.w=w;
    }
    int getnode(){
        return v;
    }
    int getweight(){
        return w;
    }
}
public class shortestPathDirectGraph {
    public static void topologicalSort(int n, Stack<Integer> s, boolean[] vis, ArrayList<ArrayList<PairNodes>> graph){
        vis[n]=true;
        for(PairNodes i : graph.get(n)){
            if(vis[i.getnode()]==false){
                topologicalSort(i.getnode(),s,vis,graph);
            }
        }
        s.add(n);
    }
    public static void shortestPath(int n,ArrayList<Integer> ans, ArrayList<ArrayList<PairNodes>> graph,int source){
         Stack<Integer> s=new Stack<>();
        boolean[] vis=new boolean[n+1];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                topologicalSort(i,s,vis,graph);
            }
        }
         
        for(int i=0;i<=n;i++){
           ans.add(Integer.MAX_VALUE);
        }  
        ans.set(source,0); 
        while(!s.isEmpty()){
           int node=(int) s.pop();
           if(ans.get(node)!=Integer.MAX_VALUE){
               for(PairNodes j:graph.get(node)){
                   if(ans.get(node)+j.getweight()<ans.get(j.getnode())){
                     ans.set(j.getnode(),ans.get(node)+j.getweight());
                   }
               }
           }
        }
        for(int i=0;i<n;i++){
            if(ans.get(i)==Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(ans.get(i)+ " ");
            }
        }
    }
//First apply topological sort on the ArrayList of ArrayList of Pair  
//Then add the stack element in a Array
//Now iterate the array and apply BFS
// and if parent node weight+weight between parent to current node < current node then add in queue and also add in ans list
//return ans list
    public static void main(String[] args) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        System.out.println("Enter the size of arraylist  : ");
        Scanner size=new Scanner(System.in);
        int n=size.nextInt();
     System.out.println("Enter the numbers of edges construct  : ");
     Scanner edges=new Scanner(System.in);
     int m=edges.nextInt();
     ArrayList<ArrayList<PairNodes>> graph= new ArrayList<ArrayList<PairNodes>>(); 
     for (int i = 0; i <=n; i++){
            graph.add(new ArrayList<PairNodes>());
     }
     for(int i=0;i<m;i++){
        System.out.println("Enter the "+ i +" edge of row : ");
        Scanner row=new Scanner(System.in);
        int u=row.nextInt();
        System.out.println("Enter the "+ i +" edges of column : ");
        Scanner column=new Scanner(System.in);
        int v=column.nextInt();
        System.out.println("Enter the "+ i +" edges weight between "+ u +" - "+ v +" : ");
        Scanner weight=new Scanner(System.in);
        int w=weight.nextInt();
        graph.get(u).add(new PairNodes(v,w)); 
     }  
     System.out.println("Enter the source : ");
        Scanner src=new Scanner(System.in);
        int source=src.nextInt();
        for (int i = 0; i <=n; i++) {
            System.out.print(i+" => ");
            for (PairNodes j : graph.get(i)) {
                System.out.print("vertex "+ i +"-"+ j.getnode() +" { Weight => "+j.getweight()+" } ,");
            }
            System.out.println();
        }

          shortestPath(n,ans,graph,source);
          System.out.println(ans);
    }
}