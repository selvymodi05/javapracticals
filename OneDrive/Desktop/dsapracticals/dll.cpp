#include<iostream>
using namespace std;

class node
{
public:
    node* prev;
    int data;
    node* next;

    node(int val)
    {
        prev = nullptr;
        data = val;
        next = nullptr;
    }
};

void insertatbegin(node*& head, int val)
{
    node* n = new node(val);

    n->next = head;
    n->prev = nullptr;

    if(head != nullptr)
    {
        head->prev = n;
    }

    head = n;
}

void insertatend(node*& head, int val)
{
    node* n = new node(val);

    if(head == nullptr)
    {
        head = n;
        return;
    }

    node* temp = head;

    while(temp->next != nullptr)
    {
        temp = temp->next;
    }

    temp->next = n;
    n->prev = temp;
    n->next = nullptr;
}

void insertatkpos(node*& head, int val, int pos)
{
    if(pos == 1)
    {
        insertatbegin(head, val);
        return;
    }

    node* n = new node(val);
    node* temp = head;

    for(int i = 1; i < pos - 1 && temp != nullptr; i++)
    {
        temp = temp->next;
    }

    if(temp == nullptr)
    {
        cout << "Invalid position" << endl;
        delete n;
        return;
    }

    n->next = temp->next;
    n->prev = temp;

    if(temp->next != nullptr)
    {
        temp->next->prev = n;
    }

    temp->next = n;
}

int main()
{
    node* head = new node(10);

    head->next = new node(20);
    head->next->prev = head;

    head->next->next = new node(30);
    head->next->next->prev = head->next;

    insertatbegin(head, 60);

    insertatend(head, 80);

    insertatkpos(head, 90, 3);

    node* temp = head;

    while(temp != nullptr)
    {
        cout << temp->data << endl;
        temp = temp->next;
    }

    return 0;
}