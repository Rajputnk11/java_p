 package thread;
  class thrd1 implements Runnable {
     public void run() {
int j=0;        
while(j<300){
    System.out.println("fdg");
    j++;
}
} 
}

  class thrd2 implements Runnable {
     public void run() {
        int i=0;
    while(i<300){
        System.out.println("fdg ffdhb hr hytyu trty");
        i++;
    }
} 
    }

public class thrd {
    public static void main(String[] args) {
        thrd1 bullet1=new thrd1();
          Thread gun1=new Thread(bullet1);
        thrd2 bullet2=new thrd2();
        Thread gun2=new Thread(bullet2);
        gun1.start();
        gun2.start();
    }
}
