import java.util.Random;
import java.util.Scanner;

public class ExtendedSimulation {
    private Ecosistem ecosystem;
    private Random random;
    private int randomEventProbability; // Probability for random events
    private int newSpeciesProbability;  // Probability for new species introduction
    private Scanner scanner;

    public ExtendedSimulation(Ecosistem ecosystem) {
        this.ecosystem = ecosystem;
        this.random = new Random();
        this.randomEventProbability = 10;  // Example: 10% chance for a random event
        this.newSpeciesProbability = 20;  // Example: 20% chance for introducing a new species
        this.scanner = new Scanner(System.in);  // Initialize scanner for user input
    }

    public void run(int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("\n--- Pasul de simulare " + (i + 1) + " ---");
            ecosystem.simulateStep();

            // Introducing random events with a certain probability
            if (random.nextInt(100) < randomEventProbability) {
                ecosystem.triggerRandomEvent();
            }

            // Introducing new species with a certain probability
            if (random.nextInt(100) < newSpeciesProbability) {
                ecosystem.introduceNewSpecies();
            }

            // Display the current state of the ecosystem
            ecosystem.displayMatrix();

            // Wait for user input (press Enter) to proceed to the next step
            System.out.println("\nApasă Enter pentru a trece la următoarea zi...");
            scanner.nextLine();  // This will pause the simulation until Enter is pressed
        }
        ecosystem.generateFinalReport();
    }
}
