import java.util.Scanner;

public class MagicCard {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();
        String[] cards = userInput.trim().split("\\s+");
        String oddOrEven = console.nextLine();
        String magicCard = console.nextLine();

        String magicCardFace = magicCard.substring(0, magicCard.length()-1);
        String magicCardSuit = magicCard.substring(magicCard.length()-1, magicCard.length());

        int sum = 0;
        int position;

        if(oddOrEven.equals("odd")){
            position = 1;
        } else {
            position = 0;
        }

        for (int i = position; i < cards.length; i+=2) {
            String card = cards[i];
            String cardFace = card.substring(0, card.length()-1);
            String cardSuit = card.substring(card.length()-1, card.length());
            int value = 0;

            switch(cardFace){
                case "2":
                    value = 20;
                    break;
                case "3":
                    value = 30;
                    break;
                case "4":
                    value = 40;
                    break;
                case "5":
                    value = 50;
                    break;
                case "6":
                    value = 60;
                    break;
                case "7":
                    value = 70;
                    break;
                case "8":
                    value = 80;
                    break;
                case "9":
                    value = 90;
                    break;
                case "10":
                    value = 100;
                    break;
                case "J":
                    value = 120;
                    break;
                case "Q":
                    value = 130;
                    break;
                case "K":
                    value = 140;
                    break;
                case "A":
                    value = 150;
                    break;
            }

            if(magicCardSuit.equals(cardSuit)){
                value *= 2;
            }

            if(magicCardFace.equals(cardFace)){
                value *= 3;
            }

            sum += value;
        }

        System.out.println(sum);
    }
}
