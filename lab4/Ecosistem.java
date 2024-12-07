import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ecosistem {
    private List<EntitateEcosistem> entities = new ArrayList<>();
    private final int gridSize = 10;
    private final Random random = new Random();
    private final double randomEventProbability = 0.2;
    private EcosystemReport report = new EcosystemReport();

    // Constructorul care populază ecosistemul cu entități aleatorii
    public Ecosistem(int numPlante, int numErbivore, int numOmnivore, int numCarnivore) {
        for (int i = 0; i < numPlante; i++) {
            int x = random.nextInt(gridSize);
            int y = random.nextInt(gridSize);
            Planta newPlant = new Planta("Planta", 50, x, y, 1);  // Parametrul generării este 1 pentru planta nouă
            addEntity(newPlant);
        }
        for (int i = 0; i < numErbivore; i++) {
            int x = random.nextInt(gridSize);
            int y = random.nextInt(gridSize);
            Erbivor newHerbivore = new Erbivor("Ierbivor", 80, x, y, 0.6, 2, 1);
            addEntity(newHerbivore);
        }
        for (int i = 0; i < numOmnivore; i++) {
            int x = random.nextInt(gridSize);
            int y = random.nextInt(gridSize);
            Omnivor newOmnivore = new Omnivor("Omnivor", 100, x, y, 0.7, 2, 1);
            addEntity(newOmnivore);
        }
        for (int i = 0; i < numCarnivore; i++) {
            int x = random.nextInt(gridSize);
            int y = random.nextInt(gridSize);
            Carnivor newCarnivore = new Carnivor("Carnivor", 120, x, y, 0.8, 3, 1);
            addEntity(newCarnivore);
        }
    }

    // Metoda pentru accesarea raportului
    public EcosystemReport getReport() {
        return report;
    }

    // Metoda pentru a adăuga entități în ecosistem
    public void addEntity(EntitateEcosistem entity) {
        entities.add(entity);
        report.recordPopulation(entity.getClass().getSimpleName()); // Înregistrează populația
        report.recordInteraction(entity.getName() + " adăugat în ecosistem.");
    }

    // Metoda pentru a îndepărta entități din ecosistem
    public void removeEntity(EntitateEcosistem entity) {
        entities.remove(entity);
        report.recordInteraction(entity.getName() + " eliminat din ecosistem.");
    }

    // Metoda pentru a găsi cel mai apropiat erbivor
    public Erbivor findNearestHerbivore(int x, int y) {
        return entities.stream()
                .filter(e -> e instanceof Erbivor)
                .map(e -> (Erbivor) e)
                .min((h1, h2) -> distance(x, y, h1.x, h1.y) - distance(x, y, h2.x, h2.y))
                .orElse(null);
    }

    // Metoda pentru a găsi cel mai apropiat omnivor
    public Omnivor findNearestOmnivore(int x, int y) {
        return entities.stream()
                .filter(e -> e instanceof Omnivor)
                .map(e -> (Omnivor) e)
                .min((o1, o2) -> distance(x, y, o1.x, o1.y) - distance(x, y, o2.x, o2.y))
                .orElse(null);
    }

    // Metoda pentru a găsi cel mai apropiat carnivor
    public Carnivor findNearestCarnivore(int x, int y) {
        return entities.stream()
                .filter(e -> e instanceof Carnivor)
                .map(e -> (Carnivor) e)
                .min((c1, c2) -> distance(x, y, c1.x, c1.y) - distance(x, y, c2.x, c2.y))
                .orElse(null);
    }

    // Metoda pentru calcularea distanței între două puncte
    private int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // Simularea unui pas în ecosistem
    public void simulateStep() {
        List<EntitateEcosistem> currentEntities = new ArrayList<>(entities);

        for (EntitateEcosistem entity : currentEntities) {
            if (entity.isAlive()) {
                entity.act(this);  // Fiecare entitate acționează în ecosistem
            }
        }

        // Îndepărtăm entitățile moarte
        entities.removeIf(e -> !e.isAlive());

        // Trigger evenimente aleatorii
        if (random.nextDouble() < randomEventProbability) {
            triggerRandomEvent();
        }
    }

    // Trigger un eveniment aleatoriu
    public void triggerRandomEvent() {
        int eventType = random.nextInt(3);
        switch (eventType) {
            case 0 -> storm();
            case 1 -> drought();
            case 2 -> introduceNewSpecies();
        }
    }

    // Metode pentru evenimentele aleatorii
    private void drought() {
        System.out.println("\n--- Eveniment Aleatoriu: Secetă! ---");
        for (EntitateEcosistem entity : entities) {
            if (entity instanceof Planta) {
                entity.energy -= 30; // Plantele pierd energie
                if (!entity.isAlive()) {
                    System.out.println(entity.name + " a murit din cauza secetei.");
                }
            }
        }
    }

    private void storm() {
        System.out.println("\n--- Eveniment Aleatoriu: Furtună! ---");
        for (EntitateEcosistem entity : new ArrayList<>(entities)) {
            if (random.nextDouble() > entity.survivalRate) {
                System.out.println(entity.name + " a fost pierdut(ă) în furtună.");
                entities.remove(entity);
                report.recordInteraction(entity.name + " a fost pierdut(ă) în furtună.");
            }
        }
    }

    // Introducerea unei noi specii
    public void introduceNewSpecies() {
        System.out.println("\n--- Eveniment Aleatoriu: Apariția unei Noi Specii! ---");
        int x = random.nextInt(gridSize);
        int y = random.nextInt(gridSize);

        // Se alege aleatoriu tipul de specie de introdus
        int speciesType = random.nextInt(4); // 0: Plant, 1: Herbivore, 2: Omnivore, 3: Carnivore
        switch (speciesType) {
            case 0: // Plantă nouă
                Planta newPlant = new Planta("Planta", 50, x, y, 1);  // Parametrul generării este 1 pentru planta nouă
                addEntity(newPlant);
                System.out.println("O nouă specie de plantă a apărut la (" + x + ", " + y + ").");
                break;
            case 1: // Erbivor nou
                Erbivor newHerbivore = new Erbivor("Ierbivor", 80, x, y, 0.6, 2, 1);
                addEntity(newHerbivore);
                System.out.println("O nouă specie de ierbivor a apărut la (" + x + ", " + y + ").");
                break;
            case 2: // Omnivor nou
                Omnivor newOmnivore = new Omnivor("Omnivor", 100, x, y, 0.7, 2, 1);
                addEntity(newOmnivore);
                System.out.println("O nouă specie de omnivor a apărut la (" + x + ", " + y + ").");
                break;
            case 3: // Carnivor nou
                Carnivor newCarnivore = new Carnivor("Carnivor", 120, x, y, 0.8, 3, 1);
                addEntity(newCarnivore);
                System.out.println("O nouă specie de carnivor a apărut la (" + x + ", " + y + ").");
                break;
            default:
                break; // This should never happen
        }
    }

    // Generarea unui raport final
    public void generateFinalReport() {
        for (EntitateEcosistem entity : entities) {
            String type = entity.getClass().getSimpleName();
            report.recordPopulation(type);
        }
        report.generateReport();
    }

    // Metoda pentru a găsi cea mai apropiată pradă (erbivor sau omnivor)
    public Animal findNearestPrey(int x, int y) {
        return entities.stream()
                .filter(e -> (e instanceof Erbivor || e instanceof Omnivor))  // Căutăm doar erbivore și omnivore
                .map(e -> (Animal) e)
                .min((a1, a2) -> distance(x, y, a1.x, a1.y) - distance(x, y, a2.x, a2.y))
                .orElse(null);  // Dacă nu există pradă, returnăm null
    }

    public Planta findNearestPlant(int x, int y) {
        return entities.stream()
                .filter(e -> e instanceof Planta)  // Filtrăm doar entitățile de tip Planta
                .map(e -> (Planta) e)  // Le mapăm la tipul Planta
                .min((p1, p2) -> distance(x, y, p1.x, p1.y) - distance(x, y, p2.x, p2.y))  // Căutăm planta cea mai apropiată
                .orElse(null);  // Dacă nu există plante, returnăm null
    }

    // Afișarea stării ecosistemului
    public void displayState() {
        System.out.println("\n--- Starea Ecosistemului ---");
        for (EntitateEcosistem entity : entities) {
            System.out.println(entity.name + " la (" + entity.x + ", " + entity.y + ") cu energie: " + entity.energy);
        }
    }

    // Afișarea matricei ecosistemului
    public void displayMatrix() {
        char[][] grid = new char[gridSize][gridSize];
        System.out.println("\n--- Matricea Ecosistemului ---");

        // Inițializăm matricea
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '.';
            }
        }

        // Plasăm entitățile în matrice
        for (EntitateEcosistem entity : entities) {
            if (entity.x >= 0 && entity.x < gridSize && entity.y >= 0 && entity.y < gridSize) {
                char symbol = entity instanceof Planta ? 'P' :
                        entity instanceof Erbivor ? 'H' :
                                entity instanceof Carnivor ? 'C' : 'O'; // Omnivore
                grid[entity.x][entity.y] = symbol;
            }
        }

        // Afișăm matricea
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
