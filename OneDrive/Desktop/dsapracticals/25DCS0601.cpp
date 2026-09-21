#include <iostream>
using namespace std;

void showRepeated(int a[], int n)
{
    if(n == 0)
    {
        cout << "No data" << endl;
        return;
    }

    cout << "Repeated badge id:" << endl;

    bool found = false;

    for(int i = 0; i < n; i++)
    {
        bool already = false;

        for(int j = 0; j < i; j++)
        {
            if(a[j] == a[i])
            {
                already = true;
                break;
            }
        }

        if(already)
            continue;

        int count = 0;

        for(int j = 0; j < n; j++)
        {
            if(a[j] == a[i])
                count++;
        }

        if(count > 1)
        {
            cout << a[i] << " -> "
                 << count << " occurrences" << endl;

            found = true;
        }
    }

    if(!found)
        cout << "No repeated IDs" << endl;
}

void sortingarray(int a[], int n)
{
    for(int i = 0; i < n - 1; i++)
    {
        for(int j = 0; j < n - i - 1; j++)
        {
            if(a[j] > a[j + 1])
            {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
}

int linearSearch(int a[], int n, int key)
{
    for(int i = 0; i < n; i++)
    {
        if(a[i] == key)
            return i;
    }

    return -1;
}

int binarySearch(int a[], int n, int key)
{
    int low = 0;
    int high = n - 1;

    while(low <= high)
    {
        int mid = low + (high - low) / 2;

        if(a[mid] == key)
            return mid;

        if(key < a[mid])
            high = mid - 1;
        else
            low = mid + 1;
    }

    return -1;
}

int main()
{
    int n;

    cout << "Enter number of ids: ";
    cin >> n;

    if(n <= 0)
    {
        cout << "Invalid input" << endl;
        return 0;
    }

    int *original = new int[n];
    int *sorted = new int[n];

    cout << "Enter IDs:" << endl;

    for(int i = 0; i < n; i++)
    {
        cin >> original[i];
        sorted[i] = original[i];
    }

    showRepeated(original, n);

    sortingarray(sorted, n);

    cout << "Sorted badges:" << endl;

    for(int i = 0; i < n; i++)
        cout << sorted[i] << " ";

    cout << endl;

    int q;

    cout << "Enter number of queries: ";
    cin >> q;

    for(int i = 0; i < q; i++)
    {
        int key;

        cout << "Enter id to search: "<<endl;
        cin >> key;

        int linear = linearSearch(original, n, key);
        int binary = binarySearch(sorted, n, key);

        cout << "Badge ID: " << key << endl;

        if(linear != -1)
            cout << "Linear Search: Found at index "
                 << linear << endl;
        else
            cout << "Linear Search: Not Found" << endl;

        if(binary != -1)
            cout << "Binary Search: Found at index "
                 << binary << " in sorted array" << endl;
        else
            cout << "Binary Search: Not Found" << endl;
    }

    delete[] original;
    delete[] sorted;

    return 0;
}