import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Main {
 
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
   static int n;
 
 
 
 
    public static void main(String[] args) throws IOException {
        
       String s = sc.nextLine();
       n = s.length();
      int open[] = new int[n];
      int farLeftOpen[] = new int[n];
      Arrays.fill(farLeftOpen,n);
      Stack<Integer> stack = new Stack<>(); // for stroing indices of "("

      int mx = 0;
      int cnt = 1;
      for(int i=0;i<n;i++){
         if(s.charAt(i)=='('){
            stack.add(i);
         }
         else if(!stack.isEmpty()){
            // found a regular
            open[i] = stack.pop();
               //    (.......)
            int start = Math.min(open[i],farLeftOpen[open[i]]);

            //(......... )()
            if(i+1<n && s.charAt(i+1)=='('){
               farLeftOpen[i+1] = start;
            }
            // ()(
            //

            int curLen = i - start + 1;
            if(mx == curLen){
                cnt++;
            }else if(mx<curLen){
               mx = curLen;
               cnt = 1;
            }

         }
         
      }
       
       System.out.println(mx+" "+cnt);
        
    }
}
