package graph;
import java.util.*;
public class KhansTopologicalSortBFS {
   
    public static void topological(int n, ArrayList<ArrayList<Integer>> graph,ArrayList<Integer> ans) { 
        Integer[] indegree=new Integer[n];
        for(int i=0;i<n;i++){
            indegree[i]=0;
        }
        for(int i=0;i<n;i++){
            for(int j: graph.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
          if(indegree[i]==0){
              q.add(i);
          }
        
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int j:graph.get(node)){
              indegree[j]--;
              if(indegree[j]==0){
                  q.add(j);
              }
            }
        }}

        
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
    topological(n,graph,ans);
        System.out.println(ans);
      
    }
}
