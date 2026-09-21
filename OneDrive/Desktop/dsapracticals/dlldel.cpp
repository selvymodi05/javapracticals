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
void deletefrombegin(node* &head)
{
    node* temp = head;
    head = head->next;
    head->prev = nullptr;
    delete temp;
}
void deletefromend(node* &head)
{
    node* temp = head;
    while(temp->next != nullptr)
    {
        temp = temp->next;
    }
    node* newlast = temp->prev;
    newlast->next = nullptr;
    delete temp;
}
 void deletefromkpos(node* &head,int pos)
{
   
    node* temp = head;

    for(int i = 1; i < pos; i++)
    {
        if(temp == nullptr)
            return;

        temp = temp->next;
    }

    if(temp == nullptr)
        return;

    temp->prev->next = temp->next;

    if(temp->next != nullptr)
    {
        temp->next->prev = temp->prev;
    }

    delete temp;
}

int main()
{
    node* head = new node(20);
    head->next = new node(30);
    head->next->prev = head;
    head->next->next = new node(50);
    head->next->next->prev= head->next;
    head->next->next->next = new node(90);
     head->next->next->next->prev = head->next->next;
    deletefrombegin(head);
    deletefromend(head);
    deletefromkpos(head,3);
    node* temp = head;
    while(temp!=nullptr)
    {
        cout<<temp->data<<endl;
        temp = temp->next;
    }
    return 0;
}