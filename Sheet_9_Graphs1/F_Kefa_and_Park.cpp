//      ﷽

#include <bits/stdc++.h>

using namespace std;

// 48-57 -> 0-9  65-90 -> A-Z 97-122 -> a-z
#define Wl3_ElNor       ios::sync_with_stdio(0),cin.tie(0),cout.tie(0);
#define int             long long
#define all(vec)        vec.begin(), vec.end()
#define rall(vec)       vec.rbegin(), vec.rend()
#define ef              else if
#define retv(x)         return void(cout << (x) << '\n')
#define sp              " "
#define SetPre(n, x)    cout << fixed << setprecision(n) << x << '\n'
#define sz(s)           (int)(s).size()
#define ceil(n, m)      (((n) + (m) - 1) / (m))
#define add_mod(a, b, m) (((a % m) + (b % m)) % m)
#define sub_mod(a, b, m) (((a % m) - (b % m) + m) % m)
#define mul_mod(a, b, m) (((a % m) * (b % m)) % m)
constexpr int INF = 1 << 30, Mod = 1e9 + 7;
constexpr int LINF = 1LL << 62;


// constexpr int dx[] = {0, 0, 1, -1};
// constexpr int dy[] = {1, -1, 0, 0};
// constexpr char di[] = {'R', 'L', 'D', 'U'};
// const int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
// const int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
const int N = 1e5 + 5;

int n, m;
vector<bool> isCat(N);
vector<int> adj[N];


int dfs(int node, int parent, int catsSoFar) {
    if (isCat[node]) catsSoFar++;
    else             catsSoFar = 0;

    if (catsSoFar > m) return false;

    if (sz(adj[node]) == 1 and node ^ 1) return true;

    int ans = 0;

    for (auto neighbour : adj[node]) {
        if (neighbour == parent) continue;

        ans += dfs(neighbour, node, catsSoFar);

    }

    return ans; 
}

void Eft7_Elkahraba(int testcase) {
    cin >> n >> m;
    for (int i = 0, x; i < n && cin >> x; ++i) {isCat[i + 1] = x;}

    for (int i = 0, x, y; i + 1 < n; ++i) {
        cin >> x >> y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }

    
    cout << dfs(1, 1, 0);
}

signed main() {
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);
    Wl3_ElNor
    int T = 1;
    // cin >> T;
    for (int testcase = 1; testcase <= T; ++testcase) {
          // cout << "Case #" << testcase << ": ";
          Eft7_Elkahraba(testcase);
    }

    return 0;
}
