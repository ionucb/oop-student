//În cadrul unei clase C++, implementați un constructor care primește parametri și un destructor care afișează un mesaj când un obiect este distrus.

#include <iostream>
#include <string>

using namespace std;

class Sample {
private:
    string data;

public:
    Sample(const string& initData) : data(initData) {
        cout << "Constructor called: Object initialized with data = " << data << endl;
    }

    ~Sample() {
        cout << "Destructor called: Object with data = " << data << " is being destroyed" << endl;
    }

    void setData(const string& newData) {
        data = newData;
    }

    string getData() const {
        return data;
    }
};

int main() {
    Sample obj("Initial Data");

    obj.setData("Updated Data");
    cout << "Current data: " << obj.getData() << endl;

    return 0;
}
