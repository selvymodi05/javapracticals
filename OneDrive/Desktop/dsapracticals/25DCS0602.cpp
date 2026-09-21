#include <iostream>
using namespace std;

struct Node
{
    int id;
    Node *next;
    Node *prev;

    Node(int x)
    {
        id = x;
        next = NULL;
        prev = NULL;
    }
};

class CircularList
{
    Node *head;
    Node *tail;
    int count;

public:

    CircularList()
    {
        head = NULL;
        tail = NULL;
        count = 0;
    }

    void insert(int x)
    {
        Node *newNode = new Node(x);

        if(head == NULL)
        {
            head = tail = newNode;

            head->next = head;
            head->prev = head;
        }
        else
        {
            newNode->next = head;
            newNode->prev = tail;

            tail->next = newNode;
            head->prev = newNode;

            tail = newNode;
        }

        count++;
    }

    void next()
    {
        if(head == NULL)
        {
            cout << "Empty\n";
            return;
        }

        head = head->next;
        cout << "Current: " << head->id << endl;
    }

    void prev()
    {
        if(head == NULL)
        {
            cout << "Empty\n";
            return;
        }

        head = head->prev;
        cout << "Current: " << head->id << endl;
    }

    void deleteNode()
    {
        if(head == NULL)
        {
            cout << "Empty\n";
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

        Node *temp = head;

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
            cout << "Empty\n";
            return;
        }

        Node *temp = head;

        cout << "Forward: ";

        for(int i = 0; i < count; i++)
        {
            cout << temp->id << " ";
            temp = temp->next;
        }

        cout << endl;

        temp = tail;

        cout << "Reverse: ";

        for(int i = 0; i < count; i++)
        {
            cout << temp->id << " ";
            temp = temp->prev;
        }

        cout << endl;
    }

    void info()
    {
        cout << "Head: " << head->id << endl;
        cout << "Tail: " << tail->id << endl;
        cout << "Count: " << count << endl;
    }
};

int main()
{
    CircularList list;

    list.insert(10);
    list.insert(20);
    list.insert(30);

    list.show();

    list.next();
    list.prev();

    list.deleteNode();

    list.show();

    list.info();

    return 0;
}