import java.util.*;
import java.io.*;

public class E {

    static Scanner sc=new Scanner(System.in);
    static PrintWriter pw=new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt(), x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) < 2) continue;
            int sum = 0, min = (int) 1e6, max = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                    min = Math.min(min, arr[j]);
                    max = Math.max(max, arr[j]);
                }
            }
            if (sum >= l && sum <= r && max - min >= x) ans++;
        }
        // O(n * 2 ^ n)
        pw.println(ans);
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