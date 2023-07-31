
// C++ program to find prime factorization of a
// number n in O(Log n) time with precomputation
// allowed.
#include "bits/stdc++.h"
using namespace std;
 
// stores smallest prime factor for every number
 
// Calculating SPF (Smallest Prime Factor) for every
// number till MAXN.
// Time Complexity : O(nloglogn)
const int N=15;
int spf[N];
vector<int> primes;
void sieve() {
  for(int i = 2; i < N; i++) {
    if (spf[i] == 0) spf[i] = i, primes.push_back(i);
    int sz = primes.size();
    for (int j = 0; j < sz && i * primes[j] < N && primes[j] <= spf[i]; j++) {
      spf[i * primes[j]] = primes[j];
    }
  }
}
 
// A O(log n) function returning primefactorization
// by dividing by smallest prime factor at every step
vector<int> getFactorization(int x)
{
    vector<int> ret;
    while (x != 1) {
        ret.push_back(spf[x]);
        x = x / spf[x];
    }
    return ret;
}
 
// driver program for above function
int main(int argc, char const* argv[])
{
    // precalculating Smallest Prime Factor
    sieve();
    int x = 14;
    cout << "prime factorization for " << x << " : ";
 
    // calling getFactorization function
    vector<int> p = getFactorization(x);
 
    for (int i = 0; i < p.size(); i++)
        cout << p[i] << " ";
    cout << endl;
    return 0;
}