import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
 

public class Main {
 
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
   static int n;
 
 
 
 
    public static void main(String[] args) throws IOException {
        
        String s = sc.next();
        n = s.length();
        Stack<Character> t = new Stack<>();
        int min [] = new int[n];
        min[n-1] = s.charAt(n-1);
        for(int i=n-2;i>=0;i--)
            min[i] = Math.min(s.charAt(i),min[i+1]);
       
        
         for(int i=0;i<s.length();i++){

            while(!t.isEmpty() && min[i] >= t.peek())
                pw.print(t.pop());
            t.add(s.charAt(i));

        }
        while(!t.isEmpty())
            pw.print(t.pop());
        pw.close();
        
    }
 
 
 
 
    static class Pair implements Comparable<Pair> {
        long a;long b;int c;
        public Pair(long a,long b,int c){this.a=a;this.b=b;this.c=c;}
        public Pair() {a = 0;b = 0;}
        public Pair(long a, long b) {this.a = a;this.b = b;this.c=0;}
 
        @Override
        public int compareTo(Pair other) {
           if(other.a==a){
            return (int)(b-other.b);
           }
           return (int)(a-other.a);
        }
        // { (1,2),(1,3),(2,4),(5,2),(1,-1)}
        // { (1,-1), (1,2),(1,3), (2,4),(5,2)}
 
        @Override
        public boolean equals(Object o) {
            if (o == this) return true;if (!(o instanceof Pair)) return false;return ((Pair) o).a == a && ((Pair) o).b == b;}
 
        @Override
        public String toString() {return "( " + a + " " + b + " )";}
 
        @Override
        public int hashCode() {
            long hash = 7;hash = 31 * hash + a;hash = 31 * hash + b;
            // hasht = (7(31)+a)*31+b
            //  hash=31*hash+c;
            return (int) hash;}
 
    }
 
}
