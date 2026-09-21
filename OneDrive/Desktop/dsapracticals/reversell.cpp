#include<iostream>
using namespace std;
class node
{
   public:
    int data;
    node* next;

    node(int val) {
        data = val;
        next = nullptr;
    }
};
void reversell(node* &head)
{
    node* prev = nullptr;
    node* curr = head;
    while(curr!=nullptr)
    {
        node* next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    head = prev;
}
int main()
{
    node* head = new node(10);
    head->next = new node(20);
    head->next->next = new node(30);
    head->next->next->next = new node(40);
    head->next->next->next->next = new node(50);
    reversell(head);
    node* curr = head;
    while(curr != nullptr)
    {
        cout<<curr->data<<" ";
        curr = curr->next;
    }
    return 0;
}