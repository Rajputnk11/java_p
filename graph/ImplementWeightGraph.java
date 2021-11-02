package graph;
import java.util.*;
 
 class Pairnode{
    private int v;
    private int w;
    Pairnode(int v,int w){
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
public class ImplementWeightGraph { 
     
    public static void main(String[] args) { 
         
        ArrayList<Integer> ans=new ArrayList<Integer>();
        System.out.println("Enter the size of arraylist  : ");
        Scanner size=new Scanner(System.in);
        int n=size.nextInt();
     System.out.println("Enter the numbers of edges construct  : ");
     Scanner edges=new Scanner(System.in);
     int m=edges.nextInt();
     ArrayList<ArrayList<Pairnode>> graph= new ArrayList<ArrayList<Pairnode>>(); 
     for (int i = 0; i <=n; i++){
            graph.add(new ArrayList<Pairnode>());
     }
     for(int i=1;i<=m;i++){
        System.out.println("Enter the "+ i +" edge of row : ");
        Scanner row=new Scanner(System.in);
        int u=row.nextInt();
        System.out.println("Enter the "+ i +" edges of column : ");
        Scanner column=new Scanner(System.in);
        int v=column.nextInt();
        System.out.println("Enter the "+ i +" edges weight between "+ u +" - "+ v +" : ");
        Scanner weight=new Scanner(System.in);
        int w=weight.nextInt();
        graph.get(u).add(new Pairnode(v,w));
        graph.get(v).add(new Pairnode(u,w));
     }  
     System.out.println("Enter the source : ");
        Scanner src=new Scanner(System.in);
        int source=src.nextInt();
     for (int i = 0; i <=n; i++) {
        System.out.print(i+" => ");
        for (Pairnode j : graph.get(i)) {
            System.out.print("vertex "+ i +"-"+ j.getnode() +" { Weight => "+j.getweight()+" } ,");
        }
        System.out.println();
    }
    
     
    }
}