import java.util.*;
import java.io.*;

public class C {

    static Scanner sc=new Scanner(System.in);
    static PrintWriter pw=new PrintWriter(System.out);
    final static int INF = (int) 1e7, N = 1 << 3;

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int val[] = new int[N];
        for (int i = 1; i < N; i++) {
            val[i] = INF;
        }
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            String s = sc.next();
            int mask = 0;
            for (int j = 0; j < s.length(); j++) {
                mask |= 1 << (s.charAt(j) - 'A');
            }
            val[mask] = Math.min(val[mask], v);
        }
        int ans = INF;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) { //111
                    if ((i | j | k) != N - 1) continue;
                    ans = Math.min(ans, val[i] + val[j] + val[k]);
                }
            }
        }
        pw.println(ans < INF ? ans : -1);
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