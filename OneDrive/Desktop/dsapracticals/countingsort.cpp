#include<iostream>
#include<algorithm>
using namespace std;
void countingsort(int arr[],int n)
{
    for(int i=0;i<n;i++)
    {
        int max = 0;
        if(arr[i]>max)
        {
            max = a[i];
        }
    }
    int k = max+1;
    int ca[k] ={0}
    for(int i=0;i<n;i++)
    {
        ca[arr[i]]++;
    }
    for(int i=1;i<=k;i++)
   {
    count[i] = count[i] + count[i-1];
   }
   int out[n];
   for(int i=n-1;i>=0;i--)
   {
    count[arr[i]] = count[arr[i]] - 1;
    out[count[arr[i]]] = arr[i];
   }
   for(int i=0;i<n;i++)
   {
    arr[i] = out[i];
   }
}
int main()
{
    int arr[6] = {2,3,4,2,,4,5};
    int n =6;
    countingsort(arr,6);
    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<endl;
    }
    return 0;
}