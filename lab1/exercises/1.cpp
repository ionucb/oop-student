//TASK: Scrieți un program în C++ care să demonstreze utilizarea moștenirii (inheritance) între două clase (de exemplu, o clasă de Bază și o clasă Derivată).

class Vehicle {
  public:
    string brand = "Opel";
    void honk() {
      cout << "Chhhhh, chhhhh! \n" ;
    }
};

class Car: public Vehicle {
  public:
    string model = "Astra";
};

int main() {
  Car myCar;
  myCar.honk();
  cout << myCar.brand + " " + myCar.model;
  return 0;
} 