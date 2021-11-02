package graph;
import java.util.*;
public class CycleDirectGraphDFS {
    public static boolean detectCycle(int n, boolean[] vis, boolean[] dfsVis, ArrayList<ArrayList<Integer>> graph) {
        vis[n]=true;
        dfsVis[n]=true;
        for(int i:graph.get(n)){
            if(vis[i]==false){
                if(detectCycle(i, vis, dfsVis, graph)) return true;
            }else if(dfsVis[i]==true) return true;
        }
        dfsVis[n]=false;
        return false;       
    }
    public static boolean isCycle(int n, ArrayList<ArrayList<Integer>> graph){
     boolean[] vis=new boolean[n+1];
     boolean[] dfsVis=new boolean[n+1];
     Arrays.fill(vis,false);
     Arrays.fill(dfsVis,false);
     for(int i=1;i<=n;i++){
         if(vis[i]==false){
             if(detectCycle(n,vis,dfsVis,graph)){
                 return true;
             }
         }
     }
     return false;
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
 if(isCycle(n,graph)){
    System.out.println("Graph is contain a Cycle"); 
 }else{
 System.out.println("Graph not contain a cycle");
      }
}

   }
