import java.util.*;
import java.io.*;

public class G {

    static Scanner sc=new Scanner(System.in);
    static PrintWriter pw=new PrintWriter(System.out);

    static int lowestBit(int x){
        return x & -x;
    }

    static void solve() throws Exception{
        int x = sc.nextInt(), y = sc.nextInt();
        int xor = x ^ y;
        pw.println(lowestBit(xor));
    }

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        while (t-- > 0){
            solve();
        }
        pw.close();
    }

    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }
    }
}