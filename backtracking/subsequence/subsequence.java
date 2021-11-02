package backtracking.subsequence;

 import java.util.*;
public class subsequence{
    public static void subset(ArrayList<Integer> arr,ArrayList<Integer> temp,int idx,ArrayList<ArrayList<Integer>> ans){
      if(idx==arr.size()){
          // if current array size is greator then 0 that means
          // we consider only those elements who choose to include on the time of choice of include or exclude
          if(temp.size()>0){
           ans.add(new ArrayList<Integer>(temp));
          }
          return;
      }else{
       
      subset(arr,temp,idx+1,ans); 
      temp.add(arr.get(idx)); 
      subset(arr,temp,idx+1,ans); 
      temp.remove(temp.size()-1);
    }
}
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
         System.out.println("Enter the array size : ");
        Scanner size=new Scanner(System.in);
        int n=size.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter the "+ (i+1) +" array elements");
           Scanner a=new Scanner(System.in);
            A.add(a.nextInt()); 
        }
        subset(A,new ArrayList<Integer>(),0,res);
        System.out.println("All possible subsets are : "+ res.size() +"");
                System.out.println(res); 
           
         
    }
}

