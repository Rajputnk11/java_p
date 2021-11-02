package graph;
import java.util.*;
 
public class bipartiteGraphBFS { 
    public static boolean bitpartite(int n, ArrayList<ArrayList<Integer>> graph) {
        Integer[] color=new Integer[n+1];
        for(int i=0;i<=n;i++){
            color[i]=-1;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                q.add(i);
                color[i]=1;
                while(!q.isEmpty()){
                    int node=q.poll();
                    for(int j: graph.get(node)){
                        if(color[j]==-1){
                            color[j]=1-color[node];
                            q.add(j);
                        }
                        if(color[j]==color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        System.out.println("Enter the size of arraylist  : ");
        Scanner size=new Scanner(System.in);
        int n=size.nextInt();
     System.out.println("Enter the numbers of edges construct  : ");
     Scanner edges=new Scanner(System.in);
     int m=edges.nextInt();
     ArrayList<ArrayList<Integer>> graph= new ArrayList<ArrayList<Integer>>(); 
     for (int i = 0; i <=n; i++){
            graph.add(new ArrayList<Integer>());
     }
     for(int i=1;i<=m;i++){
        System.out.println("Enter the "+ i +" edge of row : ");
        Scanner row=new Scanner(System.in);
        int u=row.nextInt();
        System.out.println("Enter the "+ i +" edges of column : ");
        Scanner column=new Scanner(System.in);
        int v=column.nextInt();
        graph.get(u).add(v);
        graph.get(v).add(u);
     }  
     System.out.println("Enter the source : ");
        Scanner src=new Scanner(System.in);
        int source=src.nextInt();
     for (int i = 0; i <n; i++) {
        System.out.print(i+" => ");
        for (int j = 0; j < graph.get(i).size(); j++) {
            System.out.print(graph.get(i).get(j) + ", ");
        }
        System.out.println();
    }
     if(bitpartite(n,graph)){ 
     System.out.println("Yes, It's bipartite graph");
     }else{
        System.out.println("Graph is not bipartite graph");
     }
    }
    
}