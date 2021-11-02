package graph;
import java.util.*;

public class kosarajus {
    public static void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int vis[]) {
		vis[node] = 1;
		for(Integer it : adj.get(node)) {
			if(vis[it] == 0) {
				dfs(it, st, adj, vis); 
			}
		}

		st.push(node); 
	}

    public static void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, int vis[]) {
		vis[node] = 1;
		System.out.print(node + " "); 
		for(Integer it : transpose.get(node)) {
			if(vis[it] == 0) {
				revDfs(it, transpose, vis); 
			}
		}
	}

  public static  void kosaRaju(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int vis[] = new int[n]; 
        Stack<Integer> st = new Stack<Integer>(); 
        for(int i = 1;i<n;i++) {
        	if(vis[i] == 0) {
        		dfs(i, st, adj, vis); 
        	}
        }

        ArrayList<ArrayList<Integer> > transpose = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 1; i < n; i++) 
			transpose.add(new ArrayList<Integer>());

		for(int i = 1;i<n;i++) {
			vis[i] = 0; 
			for(Integer it: adj.get(i)) {
				transpose.get(it).add(i); 
			}
		}

		while(st.size() > 0) {
			int node = st.peek(); 
			st.pop(); 
			if(vis[node] == 0) {
				System.out.print("SCC: "); 
				revDfs(node, transpose, vis);
				System.out.println(); 
			}
		}

    }
    public static void main(String[] args) {

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
 Integer[] vis=new Integer[n+1];
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
 for (int i = 0; i <=n; i++) { 
    for (int j = 0; j < graph.get(i).size(); j++) {
        System.out.print("("+i+"-"+graph.get(i).get(j) + "), ");
    } 
}
  
       kosaRaju(graph,n); 
   }
}