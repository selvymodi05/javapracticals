#include<iostream>
using namespace std;
int main()
{
int n;
cout<<"enter the size"<<endl;
cin>>n;
int arr[n];
for(int i=0;i<n;i++)
{
    cin>>arr[i];
}
int h;
cout<<"enter the number of hours"<<endl;
cin>>h;
int k = h % n;
cout<<"final rotated array is: "<<endl;
for(int i = k ;i<n;i++)
{
    cout<<arr[i]<<" ";
}
for(int i = 0;i<k;i++)
{
    cout<<arr[i]<<" ";
}
return 0;
}
