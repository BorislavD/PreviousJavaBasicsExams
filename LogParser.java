import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();

        TreeMap<String, Integer> totalMap = new TreeMap<>();
        HashMap<String, ArrayList<String>> criticalMap = new HashMap<>();
        HashMap<String, ArrayList<String>> warningMap = new HashMap<>();

        Pattern pattern = Pattern.compile("\\[\"(.+?)\"\\].*\\[\"(.+?)\"\\].*\\[\"(.+?)\"\\]");

        while (!userInput.equals("END")) {
            Matcher matcher = pattern.matcher(userInput);
            if (matcher.find()) {
                String projName = matcher.group(1);
                String type = matcher.group(2);
                String message = matcher.group(3);

                if (!totalMap.containsKey(projName)) {
                    totalMap.put(projName, 0);
                    criticalMap.put(projName, new ArrayList<>());
                    warningMap.put(projName, new ArrayList<>());
                }

                int incrementor = totalMap.get(projName) + 1;
                totalMap.put(projName, incrementor);

                if (type.equals("Warning")) {
                    warningMap.get(projName).add(message);
                } else { // Critical
                    criticalMap.get(projName).add(message);
                }
            }

            userInput = console.nextLine();
        }

        totalMap.entrySet()
                .stream()
                .sorted((el1, el2) -> el2.getValue().compareTo(el1.getValue()))
                .forEach(e -> {
                    System.out.printf("%s:\n", e.getKey());
                    System.out.printf("Total Errors: %d\n", e.getValue());

                    System.out.printf("Critical: %d\n", criticalMap.get(e.getKey()).size());
                    System.out.printf("Warnings: %d\n", warningMap.get(e.getKey()).size());

                    System.out.println("Critical Messages:");
                    ArrayList<String> criticals = criticalMap.get(e.getKey());
                    criticals.sort(Comparator.<String>naturalOrder());
                    criticals.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
                    for (String msg : criticals) {
                        System.out.printf("--->%s\n", msg);
                    }
                    if (criticals.size() == 0) {
                        System.out.println("--->None");
                    }

                    System.out.println("Warning Messages:");
                    ArrayList<String> warnings = warningMap.get(e.getKey());
                    warnings.sort(Comparator.<String>naturalOrder());
                    warnings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
                    for (String msg : warnings) {
                        System.out.printf("--->%s\n", msg);
                    }
                    if (warnings.size() == 0) {
                        System.out.println("--->None");
                    }

                    System.out.println();
                });
    }
}

