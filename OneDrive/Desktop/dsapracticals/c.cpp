#include <iostream>
#include <string>
using namespace std;

int main() {
    string sentence;
    getline(cin, sentence);

    string word = "", longest = "";

    for (int i = 0; i <= sentence.length(); i++) {
        if (sentence[i] == ' ' || sentence[i] == '\0') {

            if (word.length() > longest.length())
                longest = word;

            word = "";
        }
        else {
            word += sentence[i];
        }
    }

    cout << "Longest word: " << longest << endl;
    cout << "Length: " << longest.length();

    return 0;
}