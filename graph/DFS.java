package graph;
import java.util.*;

public class DFS {
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs) {
        storeDfs.add(node); 
        vis[node] = true; 
        for(Integer it: adj.get(node)) {
            if(vis[it] == false) {
                dfs(it, vis, adj, storeDfs); 
            }
        }
    }
    public static void dfsSearch(int V, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans,int source)
    {
         
        boolean vis[] = new boolean[V+1]; 
        
            if(vis[source]==false){
                 dfs(source, vis, adj, ans); 
            }
         
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
     boolean[] vis=new boolean[n+1];

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
     dfsSearch(n,graph,ans,source); 
//Iterate graph using Breadth first search
     System.out.println(ans);

    }
}