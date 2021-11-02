package backtracking.subset;
import java.util.*;
public class subsetsLexiography {
    public static void subset(ArrayList<Integer> arr,ArrayList<Integer> temp,int idx,ArrayList<ArrayList<Integer>> ans){
      if(idx==arr.size()){
          ans.add(new ArrayList<Integer>(temp));
          return;
      }

      subset(arr,temp,idx+1,ans);
      temp.add(arr.get(idx));
      subset(arr,temp,idx+1,ans);
      temp.remove(temp.size()-1);
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
        Collections.sort(A);
        subset(A,new ArrayList<Integer>(),0,res); 
            System.out.println(res);
            Collections.sort(res, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
                for (int i = 0; i < first.size() && i < second.size(); i++) {
                    if (first.get(i) < second.get(i))
                        return -1;
                    if (first.get(i) > second.get(i))
                        return 1;
                }
                if (first.size() > second.size())
                    return 1;
                return -1;
            });
            System.out.println(res);
    }
}
