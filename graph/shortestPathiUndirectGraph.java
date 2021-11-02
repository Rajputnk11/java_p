package graph;
import java.util.*;
public class shortestPathiUndirectGraph {
    public static void ShortestPath(int n, ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> graph,int source) {
        for(int i=0;i<=n;i++){
          ans.add(Integer.MAX_VALUE);
        }
        Queue<Integer> q=new LinkedList<>();
        ans.set(source,0);
        q.add(source);
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i:graph.get(node)){
                if(ans.get(node)+1<ans.get(i)){
                    ans.set(i,ans.get(node)+1);
                    q.add(i);
                }
            }
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
     ShortestPath(n,ans,graph,source); 
//Iterate graph using Breadth first search
     System.out.println(ans);

    }
}
