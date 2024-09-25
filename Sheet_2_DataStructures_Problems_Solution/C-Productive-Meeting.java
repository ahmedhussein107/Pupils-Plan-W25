import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Main {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
   static int n;

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            ArrayList<Pair> al = new ArrayList<>();
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++)
                if (arr[i] > 0) pq.add(new Pair(arr[i], i + 1));
            while (pq.size() > 1) {
                Pair p1 = pq.poll();
                Pair p2 = pq.poll();
                al.add(new Pair(p1.b, p2.b));
                if(p1.a > 1) pq.add(new Pair(p1.a - 1, p1.b));
                if(p2.a > 1) pq.add(new Pair(p2.a-1,p2.b));
            }
            System.out.println(al.size());
            for (Pair p : al) System.out.println(p.a + " " + p.b);
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
            return (int)(-a+o.a);
//            if(o.a==a && o.b==b)return o.c-c;

//
//            if (a == o.a) return (int)(c-o.c);
//            return (int)(a-o.a);
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
