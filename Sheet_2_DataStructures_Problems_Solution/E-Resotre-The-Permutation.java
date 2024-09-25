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
            int ans [] = new int[n];
            TreeSet<Integer> treeset = new TreeSet<>();
            for(int i=1;i<=n;i++)treeset.add(i);

            n/=2; 
            int arr [] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                treeset.remove(arr[i]);
            }
            boolean ok = treeset.size()==n;
            for(int i=n-1;i>=0;i--){
                Integer x = treeset.lower(arr[i]);
                if(x != null){
                    treeset.remove(x);
                    ans[2*i] = x;
                    ans[2*i+1] = arr[i];
                }
                else{
                   ok = false;
                }
            }
            if(ok){
                for(int e:ans)pw.print(e+" ");
                pw.println();
            }
            else pw.println(-1);

        }
        pw.close();
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
