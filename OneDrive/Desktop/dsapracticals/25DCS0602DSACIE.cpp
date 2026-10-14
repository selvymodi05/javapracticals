#include <iostream>
using namespace std;

class node
{
public:
    int data;
    node *next;
    node *prev;

    node(int val)
    {
        data = val;
        next = NULL;
        prev = NULL;
    }
};
class CircularList
{
    node *head;
    node *tail;
    int count;

public:

    CircularList()
    {
        head = NULL;
        tail = NULL;
        count = 0;
    }

    void insert(int val)
    {
        node *n = new node(val);

        if(head == NULL)
        {
            head = tail = n;
            head->next = head;
            head->prev = head;
        }
        else
        {
            n->next = head;
            n->prev = tail;
            tail->next = n;
            head->prev = n;
            tail = n;
        }
        count++;
    }

   
    void next()
    {
        if(head == NULL)
        {
            cout << "Empty" << endl;
            return;
        }
        head = head->next;
        cout << "Current: "<< head->data << endl;
    }    
    void prev()
    {
        if(head == NULL)
        {
            cout << "Empty" << endl;
            return;
        }

        head = head->prev;
        cout << "Current: " << head->data << endl;
    }   
    void deleteNode()
    {
        if(head == NULL)
        {
            cout << "Empty" << endl;
            return;
        }

        if(head == tail)
        {
            delete head;

            head = NULL;
            tail = NULL;
            count = 0;
             return;
        }
        node *temp = head;
        head = head->next;
        head->prev = tail;
        tail->next = head;
        delete temp;
        count--;
    }
    void show()
    {
        if(head == NULL)
        {
            cout << "Empty" << endl;
            return;
        }
        node *temp = head;
        cout << "Forward: ";
        for(int i = 0; i < count; i++)
        {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
        temp = tail;
        cout << "Reverse: ";

        for(int i = 0; i < count; i++)
        {
            cout << temp->data << " ";
            temp = temp->prev;
        }
        cout << endl;
    }


    void info()
    {
        if(head == NULL)
        {
            cout << "Empty" << endl;
            return;
        }

        cout << "Head: " << head->data << endl;
        cout << "Tail: " << tail->data << endl;
        cout << "Count: " << count << endl;
    }
};

int main()
{
    CircularList list;

    list.insert(50);
    list.insert(70);
    list.insert(90);
    list.show();
    list.next();
    list.prev();
    list.insert(100);
    list.deleteNode();
    list.show();
    list.info();
    return 0;
}