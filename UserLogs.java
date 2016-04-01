import com.sun.javafx.binding.StringFormatter;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> collection = new TreeMap<>();
        while (!userInput.equals("end")) {
            String[] command = userInput.split("\\s+");
            String[] arrIP = command[0].split("=");
            String ip = arrIP[1];
            String[] arrUser = command[2].split("=");
            String user = arrUser[1];

            if (!collection.containsKey(user)) {
                collection.put(user, new LinkedHashMap<>());
            }

            if (!collection.get(user).containsKey(ip)) {
                collection.get(user).put(ip, 0);
            }

            int count = 0;
            count = collection.get(user).get(ip);
            collection.get(user).put(ip, count + 1);


            userInput = console.nextLine();
        }

        for (String s : collection.keySet()) {
            System.out.println(s + ":");
            String str = "";
            for (String s1 : collection.get(s).keySet()) {
                str += String.format("%s => %d,\n", s1, collection.get(s).get(s1));
            }
            str = str.substring(0, str.length()-2)+'.';
            System.out.println(str);
        }
    }

}
