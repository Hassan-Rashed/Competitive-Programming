#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#define int ll
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
    int t = 1;
 // cin >> t;
    for (int i = 1; i <= t; i++) {
        hassan();
    }
    return 0;
}
