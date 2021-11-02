package graph;

import java.util.*;

public class implementationAdj {
    
public static void main(String[] args) { 
    System.out.println("Enter the number of nodes : ");
    Scanner nodes=new Scanner(System.in);
    int n=nodes.nextInt();
    System.out.println("Enter the number of edges : ");
    Scanner edge=new Scanner(System.in);
    int m=edge.nextInt();
    int[][] matrix=new int[n+1][n+1];
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
         matrix[i][j]=0;
         matrix[j][i]=0;
        }
    }
    //undirected graph
    for(int i=0;i<m;i++){
        System.out.println("Enter the "+ i +" edge row : ");
        Scanner row=new Scanner(System.in);
        int u=row.nextInt();
        System.out.println("Enter the "+ i +" edges column : ");
        Scanner col=new Scanner(System.in);
        int v=col.nextInt();
        matrix[u][v]=1;
        matrix[v][u]=1;
    }
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            System.out.print("|");
            System.out.print(matrix[i][j]);
            System.out.print("|");
        }
        System.out.println(" ");
    }
    
}
    
}