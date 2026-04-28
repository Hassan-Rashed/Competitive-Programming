#include <bits/stdc++.h>
using namespace std;
 
using ll = long long;
#define all(x) (x).begin(), (x).end()
#define Mem(x) cout << x / 1024.0 / 1024.0 << " MB\n";
#define el '\n'
#define int ll
const int oo = 2e9 + 5;
const ll OO = 1e17 + 5;
const int N = 1e5 + 100;
const int M = 2e4 + 5;
const int mod = 1e9 + 7; // 1e9+7 ,  998244353
const int mod2 = 1e9 + 9;
const double eps = 1e-9;
#define Graph vector<vector<int>>
int dx8[8] = {0, 0, 1, -1, 1, 1, -1, -1};
int dy8[8] = {1, -1, 0, 0, 1, -1, 1, -1};
 
void hassan() {
    int n;cin >>n;
    cout << n<<" ";
    while (n!=1) {
        if (n&1) {
            n = n*3+1;
        }
        else {
            n = n/2;
        }
        cout << n << " ";
    }
}
 
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
 
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);
    int t = 1;
 //   cin >> t;
    for (int i = 1; i <= t; i++) {
        //  cout << "Case " << i << ":\n";
        //  cout << "Test " << i << ":\n";
        hassan();
        //if (i < t)cout << "\n";
    }
    return 0;
}
