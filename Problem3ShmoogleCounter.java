import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3ShmoogleCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();

        ArrayList<String> doubles = new ArrayList<>();
        ArrayList<String> ints = new ArrayList<>();

        Pattern pattern = Pattern.compile("(int|double)\\s([a-z][a-zA-Z]*)");

        while (!userInput.equals("//END_OF_CODE")) {
            Matcher matcher = pattern.matcher(userInput);
            while (matcher.find()) {
                String primitive = matcher.group(1);
                String variable = matcher.group(2);

                switch (primitive){
                    case "double":
                        doubles.add(variable);
                        break;
                    case "int":
                        ints.add(variable);
                        break;
                }
            }

            userInput = console.nextLine();
        }

        Collections.sort(doubles);
        Collections.sort(ints);
        if(doubles.size() > 0){
            System.out.printf("Doubles: %s\n", String.join(", ", doubles));
        } else{
            System.out.printf("Doubles: None\n");
        }
        if(ints.size() > 0){
            System.out.printf("Ints: %s", String.join(", ", ints));
        } else{
            System.out.printf("Ints: None");
        }
    }
}
