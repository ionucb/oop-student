import java.util.Random;

public class Omnivor extends Animal implements Interactiune {
    private int generation;

    public Omnivor(String name, int energy, int x, int y, double survivalRate, int speed, int generation) {
        super(name, energy, x, y, survivalRate, speed, "Omnivor");
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
            System.out.println(name + " la (" + x + ", " + y + ") mănâncă " + plant.name + "!");
            ecosystem.getReport().recordInteraction(name + " a mâncat " + plant.name + " la (" + x + ", " + y + ").");
            energy += plant.energy;
            ecosystem.removeEntity(plant);
        }
    }

    private boolean isNear(EntitateEcosistem entity) {
        return Math.abs(entity.x - x) <= 1 && Math.abs(entity.y - y) <= 1;
    }

    @Override
    public void ataca(Animal prada) {
        // Omnivorul nu atacă, așadar nu implementăm această metodă
    }

    @Override
    public void reproduce(Ecosistem ecosystem) {
        if (energy > 120) {
            int newX = Math.max(0, Math.min(9, x + (new Random().nextInt(3) - 1)));
            int newY = Math.max(0, Math.min(9, y + (new Random().nextInt(3) - 1)));

            // Crearea unui nou Omnivor cu numele care include generația
            String newOmnivoreName = "Omnivor " + (generation + 1);  // Numele cu generația
            ecosystem.addEntity(new Omnivor(newOmnivoreName, 60, newX, newY, survivalRate, speed, generation + 1));
            energy -= 60;

            System.out.println(newOmnivoreName + " a fost adăugat în ecosistem la coordonatele (" + newX + ", " + newY + ").");
        }
    }
}
