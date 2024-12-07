import java.util.Random;

public class Erbivor extends Animal implements Interactiune {
    private int generation;

    public Erbivor(String name, int energy, int x, int y, double survivalRate, int speed, int generation) {
        super(name, energy, x, y, survivalRate, speed, "Erbivor");
        this.generation = generation;
    }

    @Override
    public void act(Ecosistem ecosystem) {
        move();
        System.out.println(name + " la (" + x + ", " + y + ") acționează... Se deplasează la (" + x + ", " + y + ").");
        eat(ecosystem);
        reproduce(ecosystem);
    }

    @Override
    public void eat(Ecosistem ecosystem) {
        Planta plant = ecosystem.findNearestPlant(x, y);
        if (plant != null && isNear(plant)) {
            System.out.println(name + " la (" + x + ", " + y + ") mananca " + plant.name + "!");
            ecosystem.getReport().recordInteraction(name + " a mâncat  " + plant.name + " la (" + x + ", " + y + ").");
            energy += plant.energy;
            ecosystem.removeEntity(plant);
        }
    }

    private boolean isNear(EntitateEcosistem entity) {
        return Math.abs(entity.x - x) <= 1 && Math.abs(entity.y - y) <= 1;
    }

    @Override
    public void ataca(Animal prada) {
        // Erbivorul nu atacă, așadar nu implementăm această metodă
    }

    @Override
    public void reproduce(Ecosistem ecosystem) {
        if (energy > 100) {
            int newX = Math.max(0, Math.min(9, x + (new Random().nextInt(3) - 1)));
            int newY = Math.max(0, Math.min(9, y + (new Random().nextInt(3) - 1)));

            String newErbivorName = "Erbivor " + (generation + 1);

            ecosystem.addEntity(new Erbivor(newErbivorName, 50, newX, newY, survivalRate, speed, generation + 1));
            energy -= 50;
            System.out.println(newErbivorName + " a fost adăugat în ecosistem la coordonatele (" + newX + ", " + newY + ").");
        }
    }
}
