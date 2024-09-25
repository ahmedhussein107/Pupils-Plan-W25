import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Main {
 
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
   static int n;
 
 
 
 
    public static void main(String[] args) throws IOException {
        
       n = sc.nextInt();
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<n;i++){
            int x = sc.nextInt();
            map.put(x,map.getOrDefault(x, 0)+1);
       }
       int ans = 0;
       // log(n) times
        // i is the power of 2
        for(Integer key: map.keySet()){
                boolean found = false;
                int pow = 1;
                for(int i=0;i<31;i++){
                    pow*=2;
                 if(map.containsKey(pow-key)){
                    if(pow-key == key && map.get(key)==1)continue;
                 found = true;
            }

        }
        if(!found)ans+=map.get(key);
       }
       
       System.out.println(ans);
               
       
        
    }
}
