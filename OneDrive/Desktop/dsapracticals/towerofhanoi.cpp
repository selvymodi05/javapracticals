#include<iostream>
using namespace std;

void towerofhanoi(int n, char source, char helper, char destination)
{
    if(n == 1)
    {
        cout << "Disk 1 goes from "
             << source << " to " << destination << endl;
        return;
    }

    towerofhanoi(n - 1, source, destination, helper);

    cout << "Disk " << n << " goes from "
         << source << " to " << destination << endl;

    towerofhanoi(n - 1, helper, source, destination);
}

int main()
{
    int n;

    cout << "Enter number of disks: ";
    cin >> n;

    towerofhanoi(n, 'A', 'B', 'C');

    return 0;
}