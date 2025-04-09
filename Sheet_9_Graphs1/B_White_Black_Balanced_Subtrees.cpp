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
const int N = 4e3 + 5;

int n;
vector<vector<int>> adj(N);
vector<pair<int, int>> subs(N);
string color;


int dfs(int node) {
    int balanced = 0;
    int w = color[node - 1] == 'W';
    int b = color[node - 1] == 'B';
    for (auto neighbour : adj[node]) {
        int child = dfs(neighbour);
        w += subs[neighbour].first;
        b += subs[neighbour].second;
        balanced += child;
    }

    subs[node] = {w, b};
    if (w == b){ 
        balanced++;
        // cout << node << '\n';
    }
    return balanced;
} 

void Eft7_Elkahraba(int testcase) {
    cin >> n;
    for (int i = 2, x; i <= n; ++i) {
        cin >> x;
        adj[x].push_back(i);
    }    
    cin >> color;

    int ans = dfs(1);
    cout << ans << '\n'; 

    for (int i = 0; i <= n; ++i){ 
        subs[i] = {0, 0};
        adj[i].clear();
    }
}

signed main() {
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);
    Wl3_ElNor
    int T = 1;
    cin >> T;
    for (int testcase = 1; testcase <= T; ++testcase) {
          // cout << "Case #" << testcase << ": ";
          Eft7_Elkahraba(testcase);
    }

    return 0;
}