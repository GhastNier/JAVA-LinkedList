import java.util.Scanner;

public class Visual {

    public static int listChoice;
    static LinkedList listSelected;

    static {
        if (listChoice == 1) {
            listSelected = LinkedList.listOne;
        } else listSelected = LinkedList.listTwo;
    }

    public static void listSelect() {
        Scanner scanList;
        int listNum;
        scanList = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Please select the list you want to modify:");
        System.out.println("1 or 2");
        listNum = Integer.parseInt(scanList.nextLine());
        if (listNum < 1 || listNum > 2) {
            System.out.println("Please enter the number associated with the list: 1 or 2.");
            listNum = Integer.parseInt(scanList.nextLine());
            System.out.println("==========================================");
        }
        System.out.println("==========================================");
        listChoice = listNum;
        selectionMenu(choices());
    }


    public static int choices() {
        Scanner scanChoice = new Scanner(System.in);
        System.out.println("Please select one of the following options:");
        System.out.println("1. Add to the list");
        System.out.println("2. Remove from the list");
        System.out.println("3. Size of the List");
        System.out.println("4. Contains");
        System.out.println("5. toString");
        System.out.println("6. Compare");
        System.out.println("7. Magic Compare");
        System.out.println("8. Print list and Quit");
        System.out.println("9. Change list");
        int select = Integer.parseInt(scanChoice.nextLine());
        System.out.println(select);
        while (select > 9 || select < 1) {
            System.out.println("==========================================");
            System.out.println("Please enter a number from 1 to 9");
            select = Integer.parseInt(scanChoice.nextLine());
        }
        return select;

    }


    public static void selectionMenu(int i) {
        switch (i) {
            case 1:
                System.out.println("==========================================");
                Scanner scanCase1 = new Scanner(System.in);
                System.out.println("Please enter a number to add to list #" + listChoice);
                int intAdd = Integer.parseInt(scanCase1.nextLine());
                listSelected.add(intAdd);
                System.out.println("==========================================");
                System.out.println("Would you like to add another Number to list #" + listChoice + "?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int next = Integer.parseInt(scanCase1.nextLine());
                System.out.println("==========================================");
                switch (next) {
                    case 1 -> selectionMenu(1);
                    case 2 -> choices();
                    default -> {
                        System.out.println("Please enter the number associated with 1. Yes and 2. No.");
                        scanCase1.nextLine();
                    }
                }

            case 2:
                System.out.println("==========================================");
                Scanner scanCase2 = new Scanner(System.in);
                System.out.println("Please enter the number that you wish to remove from list #" + listChoice);
                System.out.println(listSelected);
                listSelected.remove(Integer.parseInt(scanCase2.nextLine()));
                System.out.println("==========================================");
                System.out.println("Would you like to remove another Number from list #" + listChoice + "? (1 or 2)");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int nextRm = Integer.parseInt(scanCase2.nextLine());
                System.out.println("==========================================");
                switch (nextRm) {
                    case 1 -> selectionMenu(2);
                    case 2 -> choices();
                    default -> {
                        System.out.println("Please enter the number associated with 1. Yes and 2. No.");
                        scanCase2.nextLine();
                    }
                }
            case 3:
                System.out.println("==========================================");
                System.out.println("The List # " + listChoice + " size is: " + listSelected.size() + " number(s).");
                System.out.println("==========================================");
                choices();

            case 4:
                System.out.println("==========================================");
                Scanner scanCase4 = new Scanner(System.in);
                System.out.println("Please enter the number that you wish to find in list #" + listChoice + ".");
                int number = Integer.parseInt(scanCase4.nextLine());
                System.out.println("==========================================");
                System.out.println("Does the list #" + listChoice + " contains the number :" + number + "?");
                if (listSelected.contain(number)) {
                    System.out.println("The number " + number + " is in the list #" + listChoice);
                } else {
                    System.out.println("The number " + number + " isn't in the list #" + listChoice);
                }
                System.out.println("Would you like to check for another Number? (1 or 2)");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int nextCont = Integer.parseInt(scanCase4.nextLine());
                System.out.println("==========================================");
                switch (nextCont) {
                    case 1 -> selectionMenu(4);
                    case 2 -> selectionMenu(choices());
                    default -> {
                        System.out.println("Please enter the number associated with 1. Yes and 2. No.");
                        scanCase4.nextLine();
                        System.out.println("==========================================");
                    }
                }

            case 5:
                System.out.println("==========================================");
                System.out.println("List # " + listChoice + " is as follow: \r\n" + listSelected);
                System.out.println("==========================================");
                choices();

            case 6:
                System.out.println("==========================================");
                if (!LinkedList.listOne.compare()) {
                    System.out.println("The two list aren't the same");
                } else {
                    System.out.println("The two list are the same");
                }
                System.out.println("==========================================");
                System.out.println("Here are the values of the first list: " + LinkedList.listOne);
                System.out.println("Here are the values of the second list: " + LinkedList.listTwo);
                System.out.println("==========================================");
                selectionMenu(choices());

            case 7:
                System.out.println("==========================================");
                if (!(LinkedList.listOne.magicCompare())) {
                    System.out.println("The two list aren't the same");
                } else {
                    System.out.println("The two list are the same");
                }
                System.out.println("==========================================");
                selectionMenu(choices());
            case 8:
                System.out.println("==========================================");
                System.out.println("These are the items from list #1: " + LinkedList.listOne);
                System.out.println("These are the items from list #2: " + LinkedList.listTwo);
                System.out.println("Thank you for using this program.");
                System.out.println("==========================================");
                System.exit(0);
            case 9:
                listSelect();
            default:
                System.out.println("Well Well Well That's not good");

        }

    }
}