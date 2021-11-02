package graph;
import java.util.*;
public class bipartiteGraphDFS {
    public static boolean checkBipartite(int n, Integer[] color, ArrayList<ArrayList<Integer>> graph) {
        if(color[n]==-1){
            color[n]=1;
        };
        for(int i:graph.get(n)){
            if(color[i]==-1){
                color[i]=1-color[n];
                 if(!checkBipartite(i,color,graph)) return false;
            }else if(color[i]==color[n]) return false;
        }
        return true;
    }
    public static boolean bipartite(int n,ArrayList<ArrayList<Integer>> graph) {
        Integer[] color=new Integer[n+1];
        for(int i=0;i<=n;i++){
            color[i]=-1;
        }
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
             if(!checkBipartite(n,color,graph)){
                 return false;
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
     if(bipartite(n,graph)){ 
     System.out.println("Yes, It's bipartite graph");
     }else{
        System.out.println("Graph is not bipartite graph");
     }
    }
}
