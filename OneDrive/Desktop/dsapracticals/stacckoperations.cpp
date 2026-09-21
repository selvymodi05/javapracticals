#include<iostream>
#include<stack>
using namespace std;
class node
{
    public:
    int data;
    node* next;
    node*top;

    node(int val)
    {
        data = val;
        next = nullptr;
        top = nullptr;
    }
};
node* top = nullptr;
void insertattop(int val)
{
    node* n = new node(val);
    n->next = top;
    top = n;
}
void removeattop()
{

    node*temp = top;
    top = temp->next;
    delete temp;
}
void peek()
{
    if(top!=nullptr)
    {
        cout<<"top element " <<top->data<<endl;
    }
}
void change(int oldValue, int newValue)
{
    node* temp = top;

    while(temp != nullptr)
    {
        if(temp->data == oldValue)
        {
            temp->data = newValue;
            return;
        }

        temp = temp->next;
    }

    cout << "Element not found" << endl;
}
int main()
{
    top = new node(10);
    top->next = new node(20);
    top->next->next = new node(30);
   
    insertattop(50);
    removeattop();
    peek();
    change(20,60);
    node* temp = top;
    while(temp!=nullptr)
    {
        cout<<temp->data<<endl;
        temp = temp->next;
    }
    return 0;
}