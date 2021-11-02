package backtracking.combination;
import java.util.*;
public class TargetSumcombination {
    public static void combinations(ArrayList<Integer> arr,int target,int idx,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans){
      if(target==0){
          ans.add(new ArrayList<Integer>(temp));
          return;
      }
      if(target<0){
          return;
      }
      for(int i=idx;i<arr.size();i++){
         temp.add(arr.get(i));
         combinations(arr,target-arr.get(i),i,temp,ans);
         temp.remove(temp.size()-1);
      }
    }
    public static void main(String[] args) {
        System.out.println("Enter the array size : ");
        Scanner size=new Scanner(System.in);
        int n=size.nextInt();
        
        System.out.println("Enter the target sum : ");
        Scanner t=new Scanner(System.in);
        int target=t.nextInt();
        ArrayList<Integer> A=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            System.out.println("Enter the "+ (i+1) +" array elements");
           Scanner a=new Scanner(System.in);
            A.add(a.nextInt()); 
        } 
        combinations(A,target,0,new ArrayList<Integer>(),ans);
        System.out.println("all possible combination are : "+ ans.size());
        System.out.println(ans);
    }
}
