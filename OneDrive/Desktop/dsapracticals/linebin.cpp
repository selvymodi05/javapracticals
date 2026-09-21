#include<iostream>
using namespace std;

void binarysearch(int arr[], int n)
{
    int key;

    cout << "Enter the key to find: ";
    cin >> key;

    int start = 0;
    int end = n - 1;
    int pos = -1;

    while(start <= end)
    {
        int mid = start + (end - start) / 2;

        if(arr[mid] == key)
        {
            pos = mid;
            break;
        }
        else if(arr[mid] < key)
        {
            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }

    if(pos == -1)
    {
        cout << "Not found" << endl;
    }
    else
    {
        cout << "Found at index: " << pos << endl;
        cout << "Found at position: " << pos + 1 << endl;
    }
}
#include<iostream>
using namespace std;

void linearsearch(int arr[], int n)
{
    int key;
    
    cout << "Enter the element to search: ";
    cin >> key;

    int pos = -1;

    for(int i = 0; i < n; i++)
    {
        if(arr[i] == key)
        {
            pos = i;
            break;
        }
    }

    if(pos == -1)
    {
        cout << "Element not found";
    }
    else
    {
        cout << "Element found at index: " << pos << endl;
        cout << "Position: " << pos + 1;
    }
}



int main()
{
    int n;

    cout << "Enter the size of array: ";
    cin >> n;

    int arr[n];

    cout << "Enter sorted elements: ";

    for(int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    binarysearch(arr, n);

    return 0;
}