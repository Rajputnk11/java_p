/*public class Solution {
    public static void Queens(boolean [][] board,int row,boolean [] cols,boolean [] ndiag,boolean [] rdiag,ArrayList<ArrayList<String>> ans,ArrayList<String> temp){
    if(row==board.length){
        ans.add(new ArrayList<String>(temp));
        return;
    }        
    for(int col=0;col<board[0].length;col++){
        if(cols[col]==false && ndiag[row+col]==false && ndiag[row-col+board.length-1]==false){
            board[row][col]=true;
            cols[col]=true;
            ndiag[row+col]=true;
            rdiag[row-col+board.length-1]=true;
            String s="\"";
            boolean check=false;
            for(int i=0;i<board.length;i++){
                if(i==col && check==false){
                    s=s+"Q";
                    check=true;
                }else{
                    s=s+".";
                }
            }
            s=s+"\",";
            temp.add(s);
            Queens(board,row+1,cols,ndiag,rdiag,ans,temp);
             board[row][col]=false;
            cols[col]=false;
            ndiag[row+col]=false;
            rdiag[row-col+board.length-1]=false;
        }
    }    
}
 public static ArrayList<ArrayList<String>> solveNQueens(int a) {
         boolean [][] board=new boolean [a][a];
         ArrayList<ArrayList<String>> ans=new ArrayList<ArrayList<String>>();
         boolean [] cols=new boolean[a];
         boolean [] ndiag=new boolean[2*a-1];
         boolean [] rdiag=new boolean[2*a-1];
         ArrayList<String> temp=new ArrayList<String>();
         Queens(board,0,cols,ndiag,rdiag,ans,temp);
         return ans;
    }
       	
}
package backtracking.combination;

public class temp {
    
}*/
