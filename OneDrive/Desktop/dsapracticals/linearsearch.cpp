#include<iostream>
using namespace std;
int main()
{
    int n;
    cout<<"enter the size:"<<endl;
    cin>>n;
    int arr[n];
    cout<<"enter the elements:"<<endl;
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }
    int key;
    cout<<"enter the key to find"<<endl;
    cin>>key;
    int pos = -1;
    int low = 0;
    int high =n-1;
   
    while(low<=high)
    {
        int mid = (low+high)/2;
        
        if(arr[mid] == key)
        {
            pos = mid;
            break;
        }
        else if(arr[mid]<key)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }

    }
    if(pos == -1)
    {
        cout<<"not found"<<endl;
    }
    else
    {
        cout<<"found the position "<<pos<<endl;
    }
    return 0;
}