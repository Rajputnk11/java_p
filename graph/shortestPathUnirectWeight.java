package graph;
import java.util.*;
class PairsNode{
    private int v;
    private int w;
    PairsNode(int v,int w){
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
public class shortestPathUnirectWeight { 
    public static void shortestPath(int n,ArrayList<Integer> ans, ArrayList<ArrayList<PairsNode>> graph,int source){
        for(int i=0;i<=n;i++){
            ans.add(Integer.MAX_VALUE);
          }
          Queue<Integer> q=new LinkedList<>();
          ans.set(source,0);
          q.add(source);
          while(!q.isEmpty()){
              int node=q.poll();
              for(PairsNode i:graph.get(node)){
                  if(ans.get(node)+i.getweight()<ans.get(i.getnode())){
                      ans.set(i.getnode(),ans.get(node)+i.getweight());
                      q.add(i.getnode());
                  }
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
     ArrayList<ArrayList<PairsNode>> graph= new ArrayList<ArrayList<PairsNode>>(); 
     for (int i = 0; i <=n; i++){
            graph.add(new ArrayList<PairsNode>());
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
        graph.get(u).add(new PairsNode(v,w));
        graph.get(v).add(new PairsNode(u,w)); 
     }  
     System.out.println("Enter the source : ");
        Scanner src=new Scanner(System.in);
        int source=src.nextInt();
        for (int i = 0; i <=n; i++) {
            System.out.print(i+" => ");
            for (PairsNode j : graph.get(i)) {
                System.out.print("vertex "+ i +"-"+ j.getnode() +" { Weight => "+j.getweight()+" } ,");
            }
            System.out.println();
        }

          shortestPath(n,ans,graph,source);
          System.out.println(ans);
    }
}
