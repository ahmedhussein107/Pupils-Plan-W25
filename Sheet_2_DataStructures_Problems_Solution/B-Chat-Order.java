import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Main {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
   static int n;

    public static void main(String[] args) throws IOException {

        n = sc.nextInt();
        String arr [] = new String[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.next();

        HashMap<String,Boolean> mp = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            Boolean isSeen = mp.getOrDefault(arr[i],false);
            if(!isSeen){
                System.out.println(arr[i]);
            }
            mp.put(arr[i],true);
        }
    }


    static class Pair implements Comparable<Pair> {
        long a;long b;int c;
        public Pair(long a,long b,int c){this.a=a;this.b=b;this.c=c;}
        public Pair() {a = 0;b = 0;}
        public Pair(long a, long b) {this.a = a;this.b = b;this.c=0;}

        @Override
        public int compareTo(Pair o) {
//            if(b==o.b)return (int)(-a+o.a);
//            return (int)(-b+o.b);
//            if(o.a==a && o.b==b)return o.c-c;


            if (a == o.a) return (int)(c-o.c);
            return (int)(a-o.a);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;if (!(o instanceof Pair)) return false;return ((Pair) o).a == a && ((Pair) o).b == b;}

        @Override
        public String toString() {return "( " + a + " " + b + " )";}

        @Override
        public int hashCode() {long hash = 7;hash = 31 * hash + a;hash = 31 * hash + b;
            //  hash=31*hash+c;
            return (int) hash;}

    }

}
