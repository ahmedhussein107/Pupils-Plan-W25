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
const int N = 50;

int n, m;
vector<int> adj[N];
vector<int> colors(N);
vector<bool> vis(N);
map<int, vector<int>> ans;

void dfs(int node, int color) {
    vis[node] = true;
    colors[node] = color;

    for (auto neighbour : adj[node]) {
        if (!vis[neighbour]) {
            dfs(neighbour, color);
        }
    }
}


void Eft7_Elkahraba(int testcase) {
    cin >> n >> m;
    for (int i = 0, u, v; i < m; ++i) {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }    

    int color = 1;

    for (int i = 1; i <= n; ++i) {
        if (vis[i]) continue;
        dfs(i, color);
        color++;
    }

    for (int i = 1; i <= color; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (colors[j] == i) {
                ans[i].push_back(j);
            }
        }
    }

    for (auto &[i, j] : ans) {
        if (sz(j) > 3) retv(-1);
    } 
    vector<vector<int>> threes;
    vector<pair<int, int>> twos;
    vector<int> ones;

    for (auto &[i, j] : ans) {
        if (sz(j) == 3) {
            vector<int> tmp;
            for (auto v : j) tmp.push_back(v);
            threes.push_back(tmp);
        } ef(sz(j) == 2) {
            pair<int, int> tmp = {j[0], j[1]};
            twos.push_back(tmp);
        } else {
            int tmp = j[0];
            ones.push_back(tmp);
        }
    }


    if (sz(ones) < sz(twos)) retv(-1);

    for (auto v : threes) {
        for (auto i : v) cout << i << sp;

        cout << '\n';
    }

    int sz = sz(twos);
    for (int i = 0; i < sz; ++i) {
        cout << twos[i].first << sp << twos[i].second << sp << ones.back() << '\n';
        ones.pop_back();
    }

    for (int i = 0; i + 2 < sz(ones); i += 3) {
        cout << ones[i] << sp << ones[i + 1] << sp << ones[i + 2] << '\n';
    }
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