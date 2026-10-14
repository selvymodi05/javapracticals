#include<iostream>
using namespace std;
class node
{
public:
    int data;
    node* next;
    node*prev;

    node(int val)
    {
        data = val;
        next = nullptr;
    }
};

void deletefromhead(node* &head,node* &tail)
{
    node* temp = head;
    head = head->next;
    temp->next = nullptr;
    temp->prev = nullptr;
    tail->next = head;
    head->prev = tail;
}
void deletefromend(node* &head,node* &tail)
{
    node* prev = tail->prev;
    tail->prev = nullptr;
    tail->next = nullptr;
    tail = prev;
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
    deletefromhead(head,tail);
    deletefromend(head,tail);
      node* temp = head;

    do
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    while (temp != head);
return 0;

}