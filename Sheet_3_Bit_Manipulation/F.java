import java.util.*;
import java.io.*;

public class F {

    static Scanner sc=new Scanner(System.in);
    static PrintWriter pw=new PrintWriter(System.out);

    static int lowestBit(int x){
        return x & -x;
    }

    static void solve1() throws Exception {
        int sum = sc.nextInt(), limit = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = limit; i > 0 && sum > 0 ; i--) {
            if (lowestBit(i) <= sum) {
                a.add(i);
                sum -= lowestBit(i);
            }
        }
        if (sum != 0) {
            pw.println(-1);
            return;
        }
        pw.println(a.size());
        for (int x: a) pw.print(x + " ");
    }

    static void solve2() throws Exception {
        int sum = sc.nextInt(), limit = sc.nextInt();
        Integer arr[] = new Integer[limit];
        for (int i = 0; i < limit; i++) {
            arr[i] = i + 1;
        }
        Arrays.sort(arr, (x, y) -> lowestBit(y) - lowestBit(x));
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < limit && sum > 0 ; i++) {
            if (lowestBit(arr[i]) <= sum) {
                a.add(arr[i]);
                sum -= lowestBit(arr[i]);
            }
        }
        if (sum != 0) {
            pw.println(-1);
            return;
        }
        pw.println(a.size());
        for (int x: a) pw.print(x + " ");
    }

    public static void main(String[] args) throws Exception {
        solve1();
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