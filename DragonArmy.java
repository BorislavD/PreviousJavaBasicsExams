import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        console.nextLine();
        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();
        int DEFAULT_DAMAGE = 45;
        int DEFAULT_HEALTH = 250;
        int DEFAULT_ARMOR = 10;

        for (int i = 0; i < n; i++) {
            String userInput = console.nextLine();
            String[] commands = userInput.split("\\s+");
            String type = commands[0];
            String name = commands[1];
            int damage;
            int health;
            int armor;
            if(commands[2].equals("null")){
                damage = DEFAULT_DAMAGE;
            } else{
                damage = Integer.parseInt(commands[2]);
            }

            if(commands[3].equals("null")){
                health = DEFAULT_HEALTH;
            } else{
                health = Integer.parseInt(commands[3]);
            }

            if(commands[4].equals("null")){
                armor = DEFAULT_ARMOR;
            } else{
                armor = Integer.parseInt(commands[4]);
            }

            if(!dragons.containsKey(type)){
                dragons.put(type, new TreeMap<>());
            }

            if(!dragons.get(type).containsKey(name)){
                dragons.get(type).put(name, new int[3]);
            }

            dragons.get(type).get(name)[0] = damage;
            dragons.get(type).get(name)[1] = health;
            dragons.get(type).get(name)[2] = armor;
        }

        for (Map.Entry<String, TreeMap<String, int[]>> pair : dragons.entrySet()) {
            System.out.println(pair.getKey() +"::" + getAverage(pair.getValue()));
            pair.getValue()
                    .entrySet()
                    .stream()
                    .forEach(innerPair -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                            innerPair.getKey(),
                            innerPair.getValue()[0],
                            innerPair.getValue()[1],
                            innerPair.getValue()[2]
                    ));
        }
    }

    private static String getAverage(TreeMap<String, int[]> dragonStats){
        double damage = 0;
        double health = 0;
        double armor = 0;
        int count = dragonStats.size();

        for (Map.Entry<String, int[]> pair : dragonStats.entrySet()) {
            damage += pair.getValue()[0];
            health += pair.getValue()[1];
            armor += pair.getValue()[2];
        }

        double averageDamage = damage / count;
        double averageHealth = health / count;
        double averageArmor = armor / count;

        return String.format("(%.2f/%.2f/%.2f)", averageDamage, averageHealth, averageArmor);
    }
}
