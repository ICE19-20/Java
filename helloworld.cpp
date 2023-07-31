#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;cin>>n;int a[n];
    long long sum=0;int mn=0;
    for(int i=0;i<n;i++)
    {
        int x;cin>>x;
        if(x<0)mn+=x;
        else sum+=x;
    }
    cout<<sum-mn<<endl;
}