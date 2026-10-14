
#include<iostream>
using namespace std;

class LinkedList
{
    struct Node
    {
        int data;
        Node *next;

        Node(int val)
        {
            data = val;
            next = nullptr;
        }
    };

    Node *head;
    int length;

public:

    LinkedList()
    {
        head = nullptr;
        length = 0;
    }

    void insertFront(int val)
    {
        Node *newNode = new Node(val);

        newNode->next = head;
        head = newNode;
        length++;

        cout << "Inserted at front: " << val << endl;
        display();
    }

    void insertEnd(int val)
    {
        Node *newNode = new Node(val);

        if(head == nullptr)
        {
            head = newNode;
        }
        else
        {
            Node *temp = head;

            while(temp->next != nullptr)
            {
                temp = temp->next;
            }

            temp->next = newNode;
        }

        length++;

        cout << "Inserted at end: " << val << endl;
        display();
    }

    void insertPosition(int pos, int val)
    {
        if(pos < 0 || pos > length)
        {
            cout << "Invalid position" << endl;
            return;
        }

        if(pos == 0)
        {
            insertFront(val);
            return;
        }

        Node *newNode = new Node(val);
        Node *temp = head;

        for(int i = 0; i < pos - 1; i++)
        {
            temp = temp->next;
        }

        newNode->next = temp->next;
        temp->next = newNode;

        length++;

        cout << "Inserted at position " << pos << ": " << val << endl;
        display();
    }

    void deleteValue(int val)
    {
        if(head == nullptr)
        {
            cout << "Queue is empty" << endl;
            return;
        }

        if(head->data == val)
        {
            Node *temp = head;
            head = head->next;

            delete temp;
            length--;

            cout << "Deleted value: " << val << endl;
            display();
            return;
        }

        Node *temp = head;

        while(temp->next != nullptr &&
              temp->next->data != val)
        {
            temp = temp->next;
        }

        if(temp->next == nullptr)
        {
            cout << "Value not found" << endl;
            return;
        }

        Node *del = temp->next;
        temp->next = del->next;

        delete del;
        length--;

        cout << "Deleted value: " << val << endl;
        display();
    }

    void display()
    {
        Node *temp = head;

        cout << "Queue: ";

        while(temp != nullptr)
        {
            cout << temp->data << " ";
            temp = temp->next;
        }

        cout << "NULL" << endl;
    }

    void reversePrint()
    {
        cout << "Reverse queue: ";
        reverseHelper(head);
        cout << "NULL" << endl;
    }

    void reverseHelper(Node *temp)
    {
        if(temp == nullptr)
        {
            return;
        }

        reverseHelper(temp->next);
        cout << temp->data << " ";
    }

    ~LinkedList()
    {
        Node *temp;

        while(head != nullptr)
        {
            temp = head;
            head = head->next;
            delete temp;
        }
    }
};

int main()
{
    LinkedList q;

    q.insertFront(10);
    q.insertFront(5);

    q.insertEnd(20);
    q.insertEnd(30);

    q.insertPosition(2, 15);

    q.insertPosition(10, 99);

    q.deleteValue(15);

    q.display();

    q.reversePrint();

    return 0;
}