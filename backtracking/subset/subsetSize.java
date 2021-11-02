package backtracking.subset;
import java.util.*;
public class subsetSize {
    public static void subset(ArrayList<Integer> arr,int n,ArrayList<Integer> temp,int idx,ArrayList<ArrayList<Integer>> ans){
      if(temp.size()==n){
          ans.add(new ArrayList<Integer>(temp));
          return;
      }
        if(arr.size()==idx ){
          return;
      }
       
      subset(arr,n,temp,idx+1,ans); 
      temp.add(arr.get(idx)); 
      subset(arr,n,temp,idx+1,ans); 
      temp.remove(temp.size()-1);
    }
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
         System.out.println("Enter the array size : ");
        Scanner size=new Scanner(System.in);
        int n=size.nextInt();
        System.out.println("Enter the size of subset : ");
        Scanner ss=new Scanner(System.in);
        int sSize=ss.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter the "+ (i+1) +" array elements");
           Scanner a=new Scanner(System.in);
            A.add(a.nextInt()); 
        }
        subset(A,sSize,new ArrayList<Integer>(),0,res);
        System.out.println("All possible subsets are : "+ res.size() +"");
                System.out.println(res); 
           
         
    }
}
