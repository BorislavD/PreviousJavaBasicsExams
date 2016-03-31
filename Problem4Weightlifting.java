import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Problem4Weightlifting {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        console.nextLine();
        TreeMap<String, TreeMap<String, Long>> collection = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String userInput = console.nextLine();
            String[] command = userInput.split("\\s+");
            String name = command[0];
            String exercise = command[1];
            long weight = Long.parseLong(command[2]);

            if (!collection.containsKey(name)) {
                collection.put(name, new TreeMap<>());
            }

            if (collection.get(name).containsKey(exercise)) {
                collection.get(name).put(exercise, collection.get(name).get(exercise) + weight);
            } else {
                collection.get(name).put(exercise, weight);
            }
        }

        for (Map.Entry<String, TreeMap<String, Long>> pair : collection.entrySet()) {
            System.out.print(pair.getKey() + " : ");
            ArrayList<String> exercises = new ArrayList<>();
            pair.getValue()
                    .entrySet()
                    .stream()
                    .forEach(innerPair -> exercises.add(String.format("%s - %d kg", innerPair.getKey(), innerPair.getValue())));

            System.out.println(exercises.toString().substring(1, exercises.toString().length() - 1));
        }
    }
}






