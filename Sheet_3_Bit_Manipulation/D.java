import java.util.*;
import java.io.*;

public class D {

    static Scanner sc=new Scanner(System.in);
    static PrintWriter pw=new PrintWriter(System.out);

    final static int N = 31;

    static void solve() throws Exception{
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n], cnt = new int[N];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            for (int j = 0; j < N; j++) {
                if ((arr[i] & (1 << j)) != 0) cnt[j]++;
            }
        }
        int ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (n - cnt[i] <= k){
                ans |= (1 << i);
                k -= (n - cnt[i]);
            }
        }
        pw.println(ans);
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