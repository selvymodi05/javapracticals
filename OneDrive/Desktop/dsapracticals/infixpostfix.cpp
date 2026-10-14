#include <iostream>
#include <stack>
#include <algorithm>
#include <string>
using namespace std;

int precedence(char op)
{
    if(op == '^')
        return 3;

    if(op == '*' || op == '/' || op == '%')
        return 2;

    if(op == '+' || op == '-')
        return 1;

    return 0;
}

string infixToPostfix(string infix)
{
    reverse(infix.begin(), infix.end());

    // Step 2: Swap brackets
    for(char &ch : infix)
    {
        if(ch == '(')
            ch = ')';
        else if(ch == ')')
            ch = '(';
    }
    stack<char> st;
    string postfix = "";

    for(char ch : infix)
    {
        // Operand
        if(isalnum(ch))
        {
            postfix += ch;
        }

        // Opening bracket
        else if(ch == '(')
        {
            st.push(ch);
        }

        // Closing bracket
        else if(ch == ')')
        {
            while(!st.empty() && st.top() != '(')
            {
                postfix += st.top();
                st.pop();
            }

            if(!st.empty())
                st.pop();
        }

        // Operator
        else
        {
            while(!st.empty() &&
                  st.top() != '(' &&
                  precedence(st.top()) >= precedence(ch))
            {
                postfix += st.top();
                st.pop();
            }

            st.push(ch);
        }
    }

    // Pop remaining operators
    while(!st.empty())
    {
        postfix += st.top();
        st.pop();
    }

    return postfix;
}

int main()
{
    string infix;

    cout << "Enter infix expression: ";
    cin >> infix;

    cout << "Postfix: " << infixToPostfix(infix);

    return 0;
}