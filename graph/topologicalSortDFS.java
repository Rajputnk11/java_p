package graph;
import java.util.*;
public class topologicalSortDFS {
    public static void checkTopologicalSort(int n, Stack<Integer> s, boolean[] vis, ArrayList<ArrayList<Integer>> graph){
        vis[n]=true;
        for(int i : graph.get(n)){
            if(vis[i]==false){
                checkTopologicalSort(i,s,vis,graph);
            }
        }
        s.push(n);
    }
    public static void topological(int n, ArrayList<ArrayList<Integer>> graph,ArrayList<Integer> ans) {
        Stack<Integer> s=new Stack<>();
        boolean[] vis=new boolean[n+1];
        Arrays.fill(vis,false);
        for(int i=1;i<=n;i++){
            if(vis[i]==false){
               checkTopologicalSort(i,s,vis,graph);
            }
        }
        while(!s.isEmpty()){
            int temp=s.pop();
            ans.add(temp);
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
