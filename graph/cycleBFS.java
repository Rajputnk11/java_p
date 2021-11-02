package graph;
import java.util.*;

class node {
int curr;
int parent;
node(int curr,int parent){
    this.curr=curr;
    this.parent=parent;
}
    
}
public class cycleBFS {
    public static boolean isCycle(int s, ArrayList<ArrayList<Integer>> graph,boolean[] vis) {
        Queue<node> q=new LinkedList<>();
        q.add(new node(s,-1));
        vis[s]=true;
        while(!q.isEmpty()){
            int currNode=q.peek().curr;
            int par=q.peek().parent;
            q.remove();
            for(Integer i:graph.get(currNode)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(new node(i,currNode));
                }else if(i!=par){
                  return true;
                }
            }
        }
         return false;
    }
    public static boolean cycledetect(int n, ArrayList<ArrayList<Integer>> graph){
        boolean[] vis=new boolean[n+1];
        Arrays.fill(vis,false);
        for(int i=1;i<=n;i++){
            if(vis[i]==false){
                if(isCycle(i,graph,vis)){
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
        graph.get(v).add(u);
     }  
     
     for (int i = 0; i <=n; i++) {
        System.out.print(i+" => ");
        for (int j = 0; j < graph.get(i).size(); j++) {
            System.out.print(graph.get(i).get(j) + ", ");
        }
        System.out.println();
    }
     if(cycledetect(n,graph)){
        System.out.println("Graph contain a cycle");
     }else{
        System.out.println("no cycle");
     }
     
    }
}
