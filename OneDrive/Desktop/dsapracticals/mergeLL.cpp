#include<iostream>
using namespace std;
class node
{
    public:
    int data;
    node* next = nullptr;
    node(int val)
    {
        data = val;
        next = nullptr;
    }

};
void mergelist(node* &head1,node* head2)
{
    if(head1 == nullptr)
    {
        head1 = head2;
        return;
    }
    else
    {
        node* temp = head1;
        while(temp->next != nullptr)
        {
            temp = temp->next;
        }
        temp->next = head2;
    }
}
bool searchnode(node* head,int val)
{
    node* temp = head;
    while(temp != nullptr)
    {
        if(temp->data == val)
        {
            return val;
        }
        temp = temp->next;
        
    }
    return false;
}
int main()
{
    node* head1 = new node(10);
    head1->next = new node(20);
    head1->next->next = new node(30);
    node* head2 = new node(40);
    head2->next = new node(50);
    head2->next->next = new node(60);
    mergelist(head1,head2);
    searchnode(head1,30);
    int val = 60;
    
    if(searchnode(head1, val))
    cout << "Node found"<<endl;
else
cout << "Node not found"<<endl;
node* temp = head1;
    while(temp != nullptr)
    {
        cout<<temp->data<<endl;
        temp = temp->next;

    }
    return 0;
    
}
