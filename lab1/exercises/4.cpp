/*
    Implementați în C++ o funcție friend care poate accesa atributele private ale unei clase.
    Creați două clase friend care pot accesa reciproc datele private ale fiecăreia și implementați un scenariu simplu care demonstrează acest lucru.
*/

#include <iostream>
#include <string>

using namespace std;

class ClassB;  // Declarație anticipată pentru a permite accesul din `ClassA`

class ClassA {
private:
    int aValue;
    string aData;

public:
    ClassA(int value, const string& data) : aValue(value), aData(data) {}

    // Declarați `ClassB` ca prieten pentru a-i permite accesul la membrii privați ai lui `ClassA`
    friend class ClassB;

    // Metodă pentru a afișa datele din `ClassA`
    void displayA() const {
        cout << "ClassA: aValue = " << aValue << ", aData = " << aData << endl;
    }
};

class ClassB {
private:
    int bValue;
    string bData;

public:
    ClassB(int value, const string& data) : bValue(value), bData(data) {}

    // Declarați `ClassA` ca prieten pentru a-i permite accesul la membrii privați ai lui `ClassB`
    friend class ClassA;

    // Metodă pentru a afișa datele din `ClassB`
    void displayB() const {
        cout << "ClassB: bValue = " << bValue << ", bData = " << bData << endl;
    }

    // Metodă pentru a modifica datele din `ClassA`
    void modifyA(ClassA& objA, int newValue, const string& newData) {
        objA.aValue = newValue;
        objA.aData = newData;
    }
};

int main() {
    // Crearea obiectelor `ClassA` și `ClassB`
    ClassA objA(10, "Initial Data A");
    ClassB objB(20, "Initial Data B");

    // Afișarea inițială a datelor
    objA.displayA();
    objB.displayB();

    // `ClassB` poate modifica datele private ale lui `ClassA`
    objB.modifyA(objA, 100, "Updated Data A");

    // Afișarea datelor actualizate
    objA.displayA();
    objB.displayB();

    return 0;
}
