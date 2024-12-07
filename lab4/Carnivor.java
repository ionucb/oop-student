import java.util.Random;

public class Carnivor extends Animal implements Interactiune {
    private int generation;

    public Carnivor(String name, int energy, int x, int y, double survivalRate, int speed, int generation) {
        super(name, energy, x, y, survivalRate, speed, "Carnivor");
        this.generation = generation;
    }

    @Override
    public void act(Ecosistem ecosystem) {
        move();
        System.out.println(name + " la (" + x + ", " + y + ") acționează... Se deplasează la (" + x + ", " + y + ").");
        eat(ecosystem);  // Carnivorul caută și mănâncă prada
        reproduce(ecosystem);  // Carnivorul se reproduce dacă are suficientă energie
    }

    @Override
    public void eat(Ecosistem ecosystem) {
        Animal prey = ecosystem.findNearestPrey(x, y);  // Căutăm prada (erbivore sau omnivore)
        if (prey != null && isNear(prey)) {
            System.out.println(name + " la (" + x + ", " + y + ") mănâncă " + prey.getName() + "!");
            ecosystem.getReport().recordInteraction(name + " a mâncat " + prey.getName() + " la (" + x + ", " + y + ").");
            energy += prey.getEnergy();  // Adăugăm energia prăzii la carnivor
            ecosystem.removeEntity(prey);  // Eliminăm prada din ecosistem
        }
    }

    private boolean isNear(EntitateEcosistem entity) {
        return Math.abs(entity.x - x) <= 1 && Math.abs(entity.y - y) <= 1;
    }

    @Override
    public void ataca(Animal prada) {
        System.out.println(name + " atacă prada " + prada.getName() + "!");
        // Implementați logica pentru atac
        energy += prada.getEnergy(); // De exemplu, carnivorul câștigă energia prăzii
    }

    @Override
    public void reproduce(Ecosistem ecosystem) {
        if (energy >= 75) {  // Verificăm dacă carnivorul are suficientă energie pentru reproducere
            int newX = Math.max(0, Math.min(9, x + (new Random().nextInt(3) - 1)));
            int newY = Math.max(0, Math.min(9, y + (new Random().nextInt(3) - 1)));

            String newCarnivorName = "Carnivor " + (generation + 1);

            ecosystem.addEntity(new Carnivor(newCarnivorName , 75, newX, newY, survivalRate, speed, generation + 1));
            energy -= 75;  // După reproducere, carnivorul pierde energie
            System.out.println(name + " a creat un nou carnivor: " + newCarnivorName);
        }
    }
}
