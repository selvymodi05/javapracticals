#include <iostream>
using namespace std;

class node
{
public:
    int data;
    node* next;

    node(int value)
    {
        data = value;
        next = nullptr;
    }
};

node* head = nullptr;

void removefrombegin()
{
    if(head == nullptr)
    {
        cout << "List is empty";
        return;
    }

    node* temp = head;
    head = head->next;
    delete temp;
}

void removefromend()
{
    if(head == nullptr)
    {
        cout << "List is empty";
        return;
    }

    if(head->next == nullptr)
    {
        delete head;
        head = nullptr;
        return;
    }

    node* temp = head;

    while(temp->next->next != nullptr)
    {
        temp = temp->next;
    }

    delete temp->next;
    temp->next = nullptr;
}

void removefromkpos(int pos)
{
    if(head == nullptr)
    {
        cout << "List is empty";
        return;
    }

    if(pos == 1)
    {
        removefrombegin();
        return;
    }

    node* temp = head;

    for(int i = 1; i < pos - 1; i++)
    {
        if(temp->next == nullptr)
        {
            cout << "Invalid position";
            return;
        }

        temp = temp->next;
    }

    if(temp->next == nullptr)
    {
        cout << "Invalid position";
        return;
    }

    node* d = temp->next;

    temp->next = d->next;

    delete d;
}

int main()
{
    head = new node(10);
    head->next = new node(20);
    head->next->next = new node(30);
    head->next->next->next = new node(40);

    removefrombegin();

    removefromend();

    removefromkpos(1);

    node* temp = head;

    while(temp != nullptr)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }

    return 0;
}