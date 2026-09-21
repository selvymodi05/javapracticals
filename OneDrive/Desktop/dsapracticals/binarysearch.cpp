#include<iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    int a[n];

    for(int i = 0; i < n; i++)
        cin >> a[i];

    for(int i = 0; i < n; i++) {
        int count = 0;

        for(int j = 0; j < n; j++) {
            if(a[i] == a[j])
                count++;
        }

        bool printed = false;

        for(int j = 0; j < i; j++) {
            if(a[i] == a[j])
                printed = true;
        }

        if(count > 1 && !printed)
            cout << a[i] << " ";
    }

    return 0;
}



