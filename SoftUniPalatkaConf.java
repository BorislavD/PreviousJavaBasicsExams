import java.util.Scanner;

public class SoftUniPalatkaConf {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int people = console.nextInt();
        int n = console.nextInt();
        console.nextLine();
        int personsFed = 0;
        int personsAccomodated = 0;

        for (int i = 0; i < n; i++) {
            String userInput = console.nextLine();
            String[] arr = userInput.trim().split("\\s+");
            String tentFoodRooms = arr[0];
            int quantity = Integer.parseInt(arr[1]);
            String type = arr[2];

            switch (tentFoodRooms) {
                case "tents":
                    if (type.equals("normal")) {
                        personsAccomodated += 2 * quantity;
                    } else {
                        personsAccomodated += 3 * quantity;
                    }

                    break;
                case "food":
                    if (type.equals("musaka")) {
                        personsFed += 2 * quantity;
                    } else {
                        personsFed += 0 * quantity;
                    }

                    break;
                case "rooms":
                    if (type.equals("single")) {
                        personsAccomodated += 1 * quantity;
                    } else if (type.equals("double")) {
                        personsAccomodated += 2 * quantity;
                    } else if (type.equals("triple")) {
                        personsAccomodated += 3 * quantity;
                    }
            }
        }

        if (people > personsAccomodated) {
            System.out.printf("Some people are freezing cold. Beds needed: %d\n", people - personsAccomodated);
        } else {
            System.out.printf("Everyone is happy and sleeping well. Beds left: %d\n", personsAccomodated - people);
        }

        if (people > personsFed) {
            System.out.printf("People are starving. Meals needed: %d\n", people - personsFed);
        } else {
            System.out.printf("Nobody left hungry. Meals left: %d\n", personsFed - people);
        }
    }
}


