#include<iostream>
using namespace std;
void countsort(int arr[],int n)
{
   int k = arr[0];
   for(int i=0;i<n;i++)
   {
    k = max(k,arr[i]);
   }
   int count[10]={0};
   for(int i=0;i<n;i++)
   {
    count[arr[i]]++;
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
   int arr[] = {1,4,1,2,7,5,2};
   countsort(arr,7);
   for(int i=0;i<7;i++)
   {
    cout<<arr[i]<<" ";
   }
   return 0;
}