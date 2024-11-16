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
	static final int N = (int) 1e6;
	static boolean[] sieve = new boolean[N + 1];
	static TreeSet<Long> primes_sq = new TreeSet<>();

	static void sieve() { // array sieve[i] is true if i is composite
		sieve[0] = sieve[1] = true;
		for (long i = 4; i * i <= N; i += 2)
			sieve[(int) i] = true;
		for (long i = 3; i * i <= N; i += 2) {
			if (sieve[(int) i])
				continue;
			for (long j = 2 * i; j <= N; j += i)
				sieve[(int) j] = true;
		}

		primes_sq.add(4l);
		for (int i = 3; i <= N; i += 2)
			if (!sieve[i])
				primes_sq.add((long) i * i);
	}

	static void solve() throws IOException {
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			long x = sc.nextLong();
			if (primes_sq.contains(x))
				pw.println("YES");
			else
				pw.println("NO");
		}
	}

	public static void main(String[] args) throws IOException {
		sieve();
		int t = 1;
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