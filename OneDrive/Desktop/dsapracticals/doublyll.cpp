#include<iostream>
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

    void insertathead(node* &head,int val)
    {
        node* n = new node(val);
        n->data = val;
        n->prev = nullptr;
        n->next = head;
        if(head != nullptr)
        {
            head->prev = n;
        }
        head = n;
    }
    void insertatend(node* &head,int val)
    {
        node* n = new node(val);
        n->data = val;
        n->next = nullptr;
        if(head == nullptr)
        {
            n->prev = nullptr;
            head = n;
            return ;
        }
        node* temp =head;
        while(temp->next != nullptr)
        {
            temp = temp->next;
        }
        temp->next = n;
        n->prev =temp;
    }
    void insertatkpos(node* &head, int pos, int val)
{
    if(pos == 1)
    {
        insertathead(head, val);
        return;
    }

    node* n = new node(val);
    node* temp = head;

    for(int i = 1; i < pos - 1; i++)
    {
        temp = temp->next;
    }

    n->next = temp->next;
    n->prev = temp;

    if(temp->next != nullptr)
    {
        temp->next->prev = n;
    }

    temp->next = n;
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
    obj.insertathead(head,70);
    obj.insertatend(head, 40);
    obj.insertatkpos(head,3,50);

    node* temp = head;


  
    while(head != nullptr)
    {
        cout << head->data << " ";
        head = head->next;
    }
    return 0;
}