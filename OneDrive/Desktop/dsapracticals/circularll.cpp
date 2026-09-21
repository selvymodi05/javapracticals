#include <iostream>
using namespace std;

class node
{
public:
    int data;
    node* next;

    node(int val)
    {
        data = val;
        next = nullptr;
    }
};

void insertatbegin(node*& head, node*& tail, int val)
{
    node* n = new node(val);

    if (head == nullptr)
    {
        head = n;
        tail = n;
        n->next = head;
    }
    else
    {
        n->next = head;
        head = n;
        tail->next = head;
    }
}

void insertatend(node*& head, node*& tail, int val)
{
    node* n = new node(val);

    if (head == nullptr)
    {
        head = tail = n;
        tail->next = head;
    }
    else
    {
        n->next = head;
        tail->next = n;
        tail = n;
    }
}

void insertatkpos(node*& head, node*& tail, int val, int k)
{
    node* n = new node(val);

    if (k == 1)
    {
        n->next = head;
        head = n;
        tail->next = head;
        return;
    }

    node* temp = head;

    for (int i = 1; i < k - 1; i++)
    {
        temp = temp->next;
    }

    n->next = temp->next;
    temp->next = n;

    if (temp == tail)
    {
        tail = n;
    }
}

int main()
{
    node* head = new node(10);
    node* tail = head;

    head->next = new node(20);
    tail = head->next;

    head->next->next = new node(30);
    tail = head->next->next;

    tail->next = head;

    insertatbegin(head, tail, 50);
    insertatend(head, tail, 60);
    insertatkpos(head,tail,70,3);

    node* temp = head;

    do
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    while (temp != head);

    return 0;
}