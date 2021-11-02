package backtracking.combination;
import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner min=new Scanner(System.in);
		int M=min.nextInt();
		Scanner num=new Scanner(System.in);
		int N=num.nextInt();
		Scanner count=new Scanner(System.in);
		int K=count.nextInt();
		for(int i=1;i<N;i++){
		    K+=K;
            System.out.println(K);
		}
		if(K<M){
		    System.out.println("YES");
		}else{
		    System.out.println("NO");
		}
    }
}
