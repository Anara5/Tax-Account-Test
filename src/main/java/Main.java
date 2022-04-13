import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int incomes = 0;
        int expenses = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println(); //empty line for more space
            System.out.println("Choose operation and enter its number:"); //main menu
            System.out.println("1. Add new income");
            System.out.println("2. Add new expenses");
            System.out.println("3. Choose the tax system");
            System.out.println("END for exit");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Enter the amount of income:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    incomes += money; //incomes counter is adding amounts every time the user enters during the operation
                    break;
                case 2:
                    System.out.println("Enter the amount of expenses");
                    moneyStr = scanner.nextLine();
                    money = Integer.parseInt(moneyStr);
                    expenses += money; //expenses counter is subtracting amounts every time the user enters during the operation
                    break;
                case 3:
                    toSave(taxIncomes(incomes), taxIncomesMinusExpenses(incomes, expenses)); //calling the method that counts savings
                    break;
                default:
                    System.out.println("Wrong operation");
            }
        }
        System.out.println("Program is closed!");
    }

    static int taxIncomes(int incomes) { //method to count tax1 option
        int tax1 =  incomes * 6 / 100;
        return tax1;
    }

    static int taxIncomesMinusExpenses(int incomes, int expenses) { //method to count tax2 option
        int tax2 = (incomes - expenses) * 15 / 100;
        if (tax2 >= 0) {
            return tax2;
        } else {
            return 0;
        }
    }

    public static int toSave(int tax1, int tax2) { //method for counting how much we will safe with certain tax option

        if (tax2 > tax1) { //comparison between tax options
            int savings = tax2 - tax1; //difference
            System.out.println("We advise you STS income");
            System.out.println("Your tax will be: " + tax1 + " rubles");
            System.out.println("Tax on another system: " + tax2 + " rubles");
            System.out.println("Savings: " + savings + " rubles");
        } else {
            int savings = tax1 - tax2; //difference
            System.out.println("We advise you STS income minus expenses");
            System.out.println("Your tax will be: " + tax2 + " rubles");
            System.out.println("Tax on another system: " + tax1 + " rubles");
            System.out.println("Savings: " + savings + " rubles");
        }
        System.out.println(); //empty line for space
        return Math.abs(tax1-tax2);
    }
}