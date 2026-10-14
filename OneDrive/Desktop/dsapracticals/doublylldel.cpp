#include <iostream>
using namespace std;

class node
{
public:
    int data;
    node* next;
    node* prev;

    node(int val)
    {
        data = val;
        next = nullptr;
        prev = nullptr;
    }

    void deletefromhead(node* &head)
    {
        if(head == nullptr)
        {
            return;
        }

        node* temp = head;

        head = head->next;

        if(head != nullptr)
        {
            head->prev = nullptr;
        }

        delete temp;
    }
    void deleteatend(node* &head)
    {
        node* temp = head;
        while(temp->next != nullptr)
        {
            temp = temp->next;
        }
         if(temp->prev != nullptr)
    {
        temp->prev->next = nullptr;
    }
    else
    {
        
        head = nullptr;
    }

    delete temp;
}
void deleteatkpos(node* &head, int pos)
{
    if(head == nullptr)
    {
        return;
    }

    if(pos == 1)
    {
        deletefromhead(head);
        return;
    }

    node* temp = head;

    for(int i = 1; i < pos; i++)
    {
        temp = temp->next;

        if(temp == nullptr)
        {
            return;
        }
    }

    temp->prev->next = temp->next;

    if(temp->next != nullptr)
    {
        temp->next->prev = temp->prev;
    }

    delete temp;
}
        
        
    
};


int main()
{
    node* head = new node(19);

    head->next = new node(20);
    head->next->prev = head;

    head->next->next = new node(30);
    head->next->next->prev = head->next;

    node obj(0);

    obj.deleteatkpos(head,2);
    node* temp = head;

    while(temp != nullptr)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }

    return 0;
}