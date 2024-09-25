import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Main {
 
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
   static int n;
 
 
 
 
    public static void main(String[] args) throws IOException {
        
        n = sc.nextInt();
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();
        int k = k1+k2;
        
        int[] a = new int[n];
        int[] b = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        for(int i=0;i<n;i++){
            b[i] = sc.nextInt();
            pq.add(Math.abs(a[i]-b[i]));
        }
        while(k-->0){
            int x = pq.poll();// biggner difference so far
            x--;
            x = Math.abs(x);
            pq.add(x);
       }
               
       long ans = 0;
       while(!pq.isEmpty()){
            int x = pq.poll();
            ans += x * 1L * x;
       }
       System.out.println(ans);

        
    }
}
