#include <iostream>
using namespace std;

class node {
public:
    int data;
    node* next;

    node(int val) {
        data = val;
        next = nullptr;
    }
};\
void removefromhead(node* &head)
{
    if(head == nullptr)
    {
        return;
    }
    else
    {
        node* temp = head;
        head = head->next;
        delete temp;
    }
}

void removefromend(node*& head)
{
    if(head == nullptr)
    {
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
removefromkpos(node* &head,int pos)
{
    if(pos == 1)
    {
        removefromhead(head);
    }
    else
    {
        for(int i=1;i<pos-1;i++)
        {
            head = head->next;
        }
        node* temp = head->next;
        head->next = temp->next;
        delete temp;
    }
}

int main()
{
    node* head = new node(10);
    head->next = new node(20);
    head->next->next = new node(30);
    head->next->next->next = new node(40);
    head->next->next->next->next = new node(50);

    removefromend(head);
    removefromhead(head);
    removefromkpos(head,2);

    node* temp = head;

    while(temp != nullptr)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }

    return 0;
}