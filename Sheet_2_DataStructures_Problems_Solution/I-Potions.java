import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
 
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
   static int n;
 
 
 
 
    public static void main(String[] args) throws IOException {
        
       n = sc.nextInt();
      int  ans = 0;
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      long sum = 0;
      for(int i=0;i<n;i++){
         int x = sc.nextInt();
         sum+=x;
         pq.add(x);
         ans++;
         while(sum<0){
            sum-=pq.poll();
            ans--;
         }
         
      }
       
       System.out.println(ans);        
    }
}









