import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	static void solve() throws IOException {
		int n = sc.nextInt(), q = sc.nextInt();
		int[] cnt = new int[n + 1];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			cnt[x]++;
		}
		for (int i = 1; i <= n; i++)
			cnt[i] += cnt[i - 1];
		int[] ans = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int k = n / i;
			int l = 0, r = i - 1, res = i - 1;
			while (l <= r) {
				int mid = (l + r) / 2;
				int c = 0;
				for (int j = 0; j <= k; j++)
					c += cnt[Math.min(n, i * j + mid)] - cnt[Math.max(1, i * j) - 1];
				if (c > n / 2) {
					res = mid;
					r = mid - 1;
				} else
					l = mid + 1;
			}
			ans[i] = res;
		}

		while (q-- > 0) {
			int x = sc.nextInt();
			pw.print(ans[x] + " ");
		}
		pw.println();
	}

	public static void main(String[] args) throws IOException {
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