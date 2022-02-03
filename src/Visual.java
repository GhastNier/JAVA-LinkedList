import java.util.Scanner;

public class Visual {
    public static int listChoice;

/*
        public void listSelect() {
        Scanner scanner;
        int appendList;
        scanner = new Scanner(System.in);
        System.out.println("Please select the list you want to modify:");
        System.out.println("1 or 2");
        appendList = scanner.nextInt();
        if (appendList < 1 || appendList > 2) {
            System.out.println("Please enter the number associated with the list: 1 or 2.");
            appendList = scanner.nextInt();
        }
        listChoice = appendList;
        choices();
    }
*/

    public static int choices() {
        Scanner scan = new Scanner(System.in);
        int select;
        System.out.println(" ");
        System.out.println("Please select one of the following options number:");
        System.out.println("1. Add to the list");
        System.out.println("2. Remove from the list");
        System.out.println("3. Size of the List");
        System.out.println("4. Contains");
        System.out.println("5. toString");
        System.out.println("6. Compare");
        System.out.println("7. Magic Compare");
        System.out.println("8. Print list and Quit");
        select = scan.nextInt();
        return select;
    }


    public static void selectionMenu(int i) {
        Scanner scan = new Scanner(System.in);
        if (i > 8 || i < 1) {
            System.out.println("Please enter a number from 1 to 8");
            selectionMenu(scan.nextInt());
        }
        switch (i) {
            case 1:
                System.out.println("Please enter a number to add.");
                int intAdd = scan.nextInt();
                LinkedList.listOne.add(intAdd);
                System.out.println("Would you like to add another Number? (1 or 2)");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int next = scan.nextInt();
                switch (next) {
                    case 1:
                        selectionMenu(1);
                        break;
                    case 2:
                        choices();
                        break;
                    default:
                        System.out.println("Please enter the number associated with 1. Yes and 2. No.");
                }
            case 2:
                System.out.println("Please enter the number that you wish to remove the first occurrence from the list");
                LinkedList.listOne.remove(scan.nextInt());
                System.out.println("Would you like to remove another Number? (1 or 2)");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int nextRm = scan.nextInt();
                switch (nextRm) {
                    case 1:
                        selectionMenu(2);
                        break;
                    case 2:
                        choices();
                        break;
                    default:
                        System.out.println("Please enter the number associated with 1. Yes and 2. No.");
                        scan.nextInt();
                }
            case 3:
                if (LinkedList.listOne.size() < 1) {
                    System.out.println("The list size is: 0");
                    choices();
                } else {
                    System.out.println("The list size is: " + LinkedList.listOne.size());
                    choices();
                }
            case 4:
                System.out.println("Please enter the number that you wish to find in your list");
                if (LinkedList.listOne.contain(scan.nextInt())) {
                    System.out.println("The List contains the number.");
                } else {
                    System.out.println("The list doesn't contain the number.");
                }
                System.out.println("Would you like to check for another Number? (1 or 2)");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int nextCont = scan.nextInt();
                switch (nextCont) {
                    case 1:
                        selectionMenu(4);
                        break;
                    case 2:
                        choices();
                        break;
                    default:
                        System.out.println("Please enter the number associated with 1. Yes and 2. No.");
                        scan.nextInt();
                }
            case 5:
                System.out.println("Your list is as follow: \r\n" + LinkedList.listOne);
                choices();
            case 6:
                if (!LinkedList.listOne.compare()) {
                    System.out.println("The two list aren't the same");
                    choices();
                } else {
                    System.out.println("The two list are the same");
                    choices();
                }
            case 7:
                if (!(LinkedList.listOne.magicCompare())) {
                    System.out.println("The two list aren't the same");
                    choices();
                } else {
                    System.out.println("The two list are the same");
                    choices();
                }
            case 8:
                System.out.println("These are the items from your list: " + LinkedList.listOne);
                System.out.println("Thank you for using this program.");
                System.exit(0);
            default:
                System.out.println("Well Well Well That's not good");
                break;
        }

    }
}