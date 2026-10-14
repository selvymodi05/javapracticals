#include<iostream>
using namespace std;

void selectionsort(int arr[], int n)
{
    for(int i = 0; i < n - 1; i++)
    {
        int smallindx = i;

        for(int j = i + 1; j < n; j++)
        {
            if(arr[j] < arr[smallindx])
            {
                smallindx = j;
            }
        }

        swap(arr[i], arr[smallindx]);
    }
}

void displayarray(int arr[], int n)
{
    for(int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
}

int main()
{
    int arr[11] = {200,69,7,100,90,60,47,87,66,55,44};
    int n = 11;

    selectionsort(arr, n);
    displayarray(arr, n);

    return 0;
}