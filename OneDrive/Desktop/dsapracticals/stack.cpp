
#include<iostream>
using namespace std;

class Stack
{
    int n;
    int *arr;
    int top;

public:

    Stack(int size)
    {
        n = size;
        arr = new int[n];
        top = -1;
    }

    void insert(int val)
    {
        if(top == n - 1)
        {
            cout << "Overflow occurred, can't insert" << endl;
            return;
        }

        top++;
        arr[top] = val;

        cout << "Inserted value: " << arr[top] << endl;
    }

    void pop()
    {
        if(top == -1)
        {
            cout << "Stack is underflow or empty" << endl;
            return;
        }

        cout << "Deleted array: " << arr[top] << endl;
        top--;
    }

    void gettop()
    {
        if(top == -1)
        {
            cout << "Stack is empty" << endl;
            return;
        }

        cout << "Top value: " << arr[top] << endl;
    }
   void change(int index, int val)
{
    if(index < 0 || index > top)
    {
        cout << "Invalid index" << endl;
        return;
    }

    arr[index] = val;

    cout << "changed value:" << val << endl;
}
};

int main()
{
    int n = 6;

    Stack s(n);

    s.insert(10);
    s.insert(20);
    s.insert(30);
    s.insert(40);
    s.insert(50);
    s.insert(60);
    s.insert(70);
    s.gettop();
    s.pop();
    s.gettop();
    s.change(3,100);

    s.gettop();

 
    return 0;
}