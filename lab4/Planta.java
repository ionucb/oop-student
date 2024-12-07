import java.util.Random;

public class Planta extends EntitateEcosistem implements Interactiune {
    private int generation;

    public Planta(String name, int energy, int x, int y, int generation) {
        super(name, energy, x, y, 1.0); // energia de supraviețuire
        this.generation = generation;
    }

    @Override
    public void act(Ecosistem ecosystem) {
        grow();
        System.out.println(name + " la (" + x + ", " + y + ") crește și energia crește cu 10.");
        reproduce(ecosystem);
    }

    private void grow() {
        energy += 10;
    }

    @Override
    public void ataca(Animal prada) {
        // Planta nu atacă, așadar nu implementăm această metodă
    }

    @Override
    public void reproduce(Ecosistem ecosystem) {
        if (energy > 50) {
            int newX = Math.max(0, Math.min(9, x + (new Random().nextInt(3) - 1)));
            int newY = Math.max(0, Math.min(9, y + (new Random().nextInt(3) - 1)));

            String newPlantName = "Planta " + (generation + 1);
            ecosystem.addEntity(new Planta(newPlantName, 20, newX, newY, generation + 1));
            energy -= 20;
            System.out.println(newPlantName + " a fost adăugat în ecosistem la coordonatele (" + newX + ", " + newY + ").");
        }
    }
}
