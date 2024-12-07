public interface Interactiune {
    // Metoda pentru atacarea prăzii (implementată doar de carnivore)
    void ataca(Animal prada);

    // Metoda pentru reproducerea entităților (toate entitățile trebuie să poată reproduce)
    void reproduce(Ecosistem ecosystem);
}
