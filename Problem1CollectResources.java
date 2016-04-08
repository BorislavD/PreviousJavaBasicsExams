import java.util.Scanner;

public class Problem1CollectResources {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();
        String[] items = userInput.split("\\s+");

        int n = console.nextInt();
        console.nextLine();

        long maxQuantity = 0;
        long currentQuantity;
        int currentPosition;

        for (int i = 0; i < n; i++) {
            currentQuantity = 0;
            boolean[] itemsFlags = new boolean[items.length];
            String starAndStep = console.nextLine();
            String[] starAndStepAsArray = starAndStep.trim().split("\\s+");
            int start = Integer.parseInt(starAndStepAsArray[0]);
            int step = Integer.parseInt(starAndStepAsArray[1]);
            currentPosition = start;
            step %= items.length;
            while (!itemsFlags[currentPosition]) {
                String[] resourceData = items[currentPosition].split("_");
                String resourceType = resourceData[0];
                int quantity;
                if (resourceData.length == 1) {
                    quantity = 1;
                } else {
                    quantity = Integer.parseInt(resourceData[1]);
                }
                switch (resourceType) {
                    case "stone":
                    case "gold":
                    case "wood":
                    case "food":
                        currentQuantity += quantity;
                        itemsFlags[currentPosition] = true;
                }
                currentPosition += step;
                currentPosition %= items.length;
            }
            if (currentQuantity > maxQuantity) {
                maxQuantity = currentQuantity;
            }
        }
        System.out.println(maxQuantity);
    }
}
