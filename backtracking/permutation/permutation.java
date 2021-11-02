package backtracking.permutation;
import java.util.*;
public class permutation {
    
    private static void permuteHelper(ArrayList<Integer> arr, int index,ArrayList<ArrayList<Integer>> ans){
        if(index >= arr.size() - 1){ //If we are at the last element - nothing left to permute
            //System.out.println(Arrays.toString(arr));
            //Print the array
             ans.add(new ArrayList<Integer>(arr));
            return;
        }
    
        for(int i = index; i < arr.size(); i++){ //For each index in the sub array arr[index...end]
    
            //Swap the elements at indices index and i
            Collections.swap(arr, index, i);
    
            //Recurse on the sub array arr[index+1...end]
            permuteHelper(arr, index+1,ans);
    
            //Swap the elements back
            Collections.swap(arr, index, i);
            
        }
    }
    public static void main(String[] args) {
       
         System.out.println("Enter the array size : ");
        Scanner size=new Scanner(System.in);
        int n=size.nextInt();
        ArrayList<Integer> A=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            System.out.println("Enter the "+ (i+1) +" array elements");
           Scanner a=new Scanner(System.in);
            A.add(a.nextInt()); 
        } 
        permuteHelper(A, 0,ans);
        System.out.println("all possible permutation are : "+ ans.size());
        System.out.println(ans);
        System.out.println("element => "+ans.get(2).get(0));
    }
}
