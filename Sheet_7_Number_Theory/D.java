import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	static final int N = 32000;
	static boolean[] sieve = new boolean[N + 1];
	static ArrayList<Integer> primes;

	static void sieve() {
		sieve[0] = sieve[1] = true;
		for (long i = 4; i * i <= N; i += 2)
			sieve[(int) i] = true;
		for (long i = 3; i * i <= N; i += 2) {
			if (sieve[(int) i])
				continue;
			for (long j = 2 * i; j <= N; j += i)
				sieve[(int) j] = true;
		}

		primes = new ArrayList<>();
		primes.add(2);
		for (int i = 3; i <= N; i += 2)
			if (!sieve[i])
				primes.add(i);
	}

	static ArrayList<Pair> factor(int n) {
		ArrayList<Pair> res = new ArrayList<>();
		for (int p : primes) {
			int e = 0;
			while (n % p == 0) {
				n /= p;
				e++;
			}
			if (e > 0)
				res.add(new Pair(p, e));
		}
		if (n != 1)
			res.add(new Pair(n, 1));
		return res;
	}

	static long gcd(long a, long b) {
		while (b != 0) {
			long tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}

	static long lcm(long a, long b) {
		return a / gcd(a, b) * b;
	}

	static void solve() throws IOException {
		int x = sc.nextInt();
		if (x % 2 == 0) {
			pw.println(x / 2 + " " + x / 2);
			return;
		}

		ArrayList<Pair> fx = factor(x);
		int sz1 = 1;
		for (Pair p : fx)
			sz1 *= p.second + 1;
		int[] divs = new int[sz1];
		divs[0] = 1;
		int idx = 1;
		for (Pair tmp : fx) {
			int p = tmp.first, c = tmp.second;
			for (int i = 1; i <= c; i++)
				for (int ci = 0; ci < c * idx; ci += idx)
					for (int j = 0; j < idx; j++)
						divs[j + ci + idx] = p * divs[j + ci];
			idx *= c + 1;
		}

		int a = (int) -1e9, b = 20;
		for (int i = 0; i < sz1; i++) {
			int g = divs[i];
			int l = x - g;
			if (l == 0 || gcd(g, l) != g || lcm(g, l) != l)
				continue;
			l /= g;
			ArrayList<Pair> tmp = factor(l);
			int[] facs = new int[tmp.size()];
			for (int j = 0; j < tmp.size(); j++) {
				facs[j] = 1;
				for (int k = 0; k < tmp.get(j).second; k++)
					facs[j] *= tmp.get(j).first;
			}

			int sz2 = tmp.size();
			for (int mask = 0; mask < 1 << sz2; mask++) {
				int z = 1;
				for (int j = 0; j < sz2; j++)
					if ((mask >> j & 1) != 0)
						z *= facs[j];
				int y = l / z;
				if (g * Math.abs(z - y) < Math.abs(a - b)) {
					a = g * z;
					b = g * y;
				}
			}
		}

		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		pw.println(a + " " + b);
	}

	public static void main(String[] args) throws IOException {
		sieve();
		int t = sc.nextInt();
		while (t-- > 0)
			solve();
		pw.close();
	}

	static class Pair {
		int first, second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
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