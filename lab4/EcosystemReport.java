

import java.util.HashMap;
import java.util.Map;

public class EcosystemReport {

    private Map<String, Long> populationCounts = new HashMap<>();
    private StringBuilder interactions = new StringBuilder();

    // Method to record the population count of an entity type
    public void recordPopulation(String entityType) {
        populationCounts.put(entityType, populationCounts.getOrDefault(entityType, 0L) + 1);
    }

    // Method to record interactions
    public void recordInteraction(String interaction) {
        interactions.append(interaction).append("\n");
    }

    // Method to generate the final report
    public void generateReport() {
        System.out.println("\n--- Raportul final al ecosistemului ---");
        for (Map.Entry<String, Long> entry : populationCounts.entrySet()) {
            System.out.println(entry.getKey() + " populatia: " + entry.getValue());
        }
        System.out.println("\n--- Interactiunile observate ---");
        System.out.println(interactions.toString());
    }
}