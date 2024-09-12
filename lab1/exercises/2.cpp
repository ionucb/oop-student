//Implementați un exemplu simplu care folosește încapsularea, unde variabilele de instanță sunt private, iar accesul la ele este realizat prin metode publice.

#include <iostream>
#include <string>

using namespace std;

class Person {
private:
    string name;
    int age;

public:
    Person(const string& name, int age) : name(name), age(age) {}

    void setName(const string& name) {
        this->name = name;
    }

    string getName() const {
        return name;
    }

    void setAge(int age) {
        if (age >= 0) {
            this->age = age;
        } else {
            cout << "Age cannot be negative." << endl;
        }
    }

    int getAge() const {
        return age;
    }

    void display() const {
        cout << "Name: " << name << ", Age: " << age << endl;
    }
};

int main() {
    Person person("Artur Scufinschi", 30);

    person.display();

    person.setName("Larisa Pacpac");
    person.setAge(25);

    person.display();

    person.setAge(-5);

    return 0;
}
