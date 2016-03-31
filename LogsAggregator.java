import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        console.nextLine();

        TreeMap<String, TreeMap<String, Integer>> collection = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String userInput = console.nextLine();
            String[] command = userInput.split("\\s+");
            String name = command[1];
            String ipAddress = command[0];
            int duration = Integer.parseInt(command[2]);

            if (!collection.containsKey(name)) {
                collection.put(name, new TreeMap<>());
            }

            if (collection.get(name).containsKey(ipAddress)) {
                collection.get(name).put(ipAddress, collection.get(name).get(ipAddress) + duration);
            } else {
                collection.get(name).put(ipAddress, duration);
            }
        }

        for (String name : collection.keySet()) {
            System.out.print(name + ": ");
            int sum = 0;
            for (String ip : collection.get(name).keySet()) {
                sum += collection.get(name).get(ip);
            }

            System.out.print(sum + " ");
            System.out.print(collection.get(name).keySet());
            System.out.println();
        }
    }
}







