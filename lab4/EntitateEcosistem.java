abstract class EntitateEcosistem {
    protected String name;
    protected int energy;
    protected int x, y; // Position
    protected double survivalRate;
    protected int generation;

    public EntitateEcosistem(String name, int energy, int x, int y, double survivalRate) {
        this.name = name;
        this.energy = energy;
        this.x = x;
        this.y = y;
        this.survivalRate = survivalRate;
        this.generation = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return energy > 0;
    }

    public abstract void act(Ecosistem ecosystem);


}