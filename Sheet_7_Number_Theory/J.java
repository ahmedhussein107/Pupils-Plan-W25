import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
	static final int N = (int) 5e6;
	static int[] lpf = new int[N + 1];
	static int[] pre = new int[N + 1];

	static void sieveLargestPrimeFactor() {
		for (int i = 2; i <= N; i += 2)
			lpf[i] = 2;
		for (int i = 3; i <= N; i += 2) {
			if (lpf[i] != 0)
				continue;
			for (int j = i; j <= N; j += i)
				lpf[j] = (int) i;
		}

		for (int i = 2; i <= N; i++) {
			pre[i] = pre[i - 1];
			int tmp = i;
			while (tmp != 1) {
				pre[i]++;
				tmp /= lpf[tmp];
			}
		}
	}

	static void solve() throws IOException {
		int a = sc.nextInt(), b = sc.nextInt();
		pw.println(pre[a] - pre[b]);
	}

	public static void main(String[] args) throws IOException {
		sieveLargestPrimeFactor();
		int t = sc.nextInt();
		while (t-- > 0)
			solve();
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String file) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(file));
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
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}