import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Main {


    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
   static int n;

    public static void main(String[] args) throws IOException {

        n = sc.nextInt();
        String s = sc.next();
        HashMap<String,Integer> mp = new HashMap<>();
        int mx = -1;
        int ind = -1;
        for(int i=0;i<n-1;i++) {
            int tmp = mp.getOrDefault(s.substring(i, i + 2), 0);
            if(tmp>mx){
                mx = tmp;
                ind = i;
            }
            mp.put(s.substring(i, i + 2), tmp + 1);
        }

        System.out.println(s.substring(ind,ind+2));
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
