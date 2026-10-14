#include<iostream>
using namespace std;

void insertionsort(int arr[], int n)
{
    for(int i = 1; i < n; i++)
    {
        int curr = arr[i];
        int prev = i - 1;

        while(prev >= 0 && arr[prev] > curr)
        {
            arr[prev + 1] = arr[prev];
            prev--;
        }

        arr[prev + 1] = curr;
    }
}

void displayarray(int arr[], int n)
{
    for(int i = 0; i < n; i++)
    {
        cout << arr[i] << endl;
    }
}

int main()
{
    int arr[5] = {4, 6, 1, 2, 3};
    int n = 5;

    insertionsort(arr, n);
    displayarray(arr, n);

    return 0;
}