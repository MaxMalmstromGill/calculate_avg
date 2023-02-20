import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ett program som läser in ett antal heltal från användaren och sedan räknar ut
 * hur många av talen som endast angavs en gång, samt medelvärdet av talen.
 */
public class Laboration3 {

    /**
     * Programmet startar här. Läser in antalet heltal som användaren vill ange
     * och sedan läser in dessa tal och sparar dem i en lista. Programmet räknar
     * sedan ut hur många tal som endast angavs en gång och medelvärdet av alla tal.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Hur många heltal vill du ange? ");
        int numIntegers = readIntFromUser(scan);
        List<Integer> numbers = readNumbersFromUser(numIntegers, scan);
        int count_times = countNumbersEnteredOnce(numbers);
        System.out.println("Varav " + count_times + " av talen bara engavs en gång.");
        int average = calculateAverage(numbers);
        System.out.println("Medelvärdet för talen är: " + average);
    }

    /**
     * Läser in ett heltal från användaren genom att använda en scanner. Om
     * användaren inte anger ett heltal skrivs ett felmeddelande ut och användaren
     * måste försöka igen.
     */
    private static int readIntFromUser(Scanner scan) {
        while(!scan.hasNextInt()) {
            System.out.println("Ogiltigt värde");
            scan.next();
        }
        return scan.nextInt();
    }

    /**
     *Läser in en lista med heltal från användaren genom att använda en scanner.
     * Om användaren inte anger ett heltal skrivs ett felmeddelande ut och användaren
     * måste försöka igen. Talen sparas i en lista som sedan returneras.
     * 
     * numIntegers antalet heltal som ska läsas in
     * en lista med heltalen som angavs av användaren
     */
    private static List<Integer> readNumbersFromUser(int numIntegers, Scanner scan) {
        int count = 1;
        List<Integer> numbers = new ArrayList<>();
        while (count <= numIntegers) {
            System.out.print("Ange heltal " + count + ": ");
            while(!scan.hasNextInt()) {
                System.out.println("Ogiltigt värde");
                System.out.print("Ange heltal " + count + ": ");
                scan.next();
            }
            int number = scan.nextInt();
            numbers.add(number);
            count += 1;
        }
        return numbers;
    }

    /**
     * Räknar ut och returnerar antalet heltal i en lista som bara angivits en gång.
     */
    
    private static int countNumbersEnteredOnce(List<Integer> numbers) {
        int count_times = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int count_n = 0;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(i) == numbers.get(j)) {
                    count_n++;
                    if (count_n > 1) {
                        break;
                    }
                }
            }
            if (count_n == 1) {
                count_times++;
            }
        }
        return count_times;
    }
   /**
    *Beräknar medelvärdet av listan med alla angiva heltat.
    *retunerar medelvärdet
    */
    
    private static int calculateAverage(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total / numbers.size();
    }
}

