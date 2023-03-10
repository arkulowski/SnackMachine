import java.util.Scanner;

public class SnackMachine {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        //The snacks available
        String[] snacks = {"Chips", "Chocolate Bar","Soda", "Gum"};
        
        //The prices associated with each snack'
        double[] prices = {1.5, 2.0, 1.25, .75};

        //Welcome and Usage Instructions
        System.out.println("Thank you for choosing the snack machine");
        System.out.println("To use this machine, follow these instructions");
        System.out.println("1. Decide which snack you would like to purchase");
        System.out.println("2. Insert $1 bills into the cash slot");
        System.out.println("3. Confirm the transaction");
        System.out.println("4. Then enjoy your snack");

        //User can pick which snack they want
        System.out.println("Which snack would you like?");
        for(int i = 0; i < snacks.length; i++){
            System.out.println((i+1) + ". " + snacks[i] + "($" + prices[i] + ")");
        }
        int selection = scanner.nextInt();
        System.out.println("You have selected " + snacks[selection] + ".");
        
     // User inserts money
         double total = 0.0;
           while (true) {
             System.out.println("Please insert $1 bills. Type 'done' when finished.");
             String input = scanner.next();
             if (input.equalsIgnoreCase("done")) {
                 break;
                                 }
             try {
                 double amount = Double.parseDouble(input);
                    if (amount == 1.0) {
                      total += amount;
                 } else {
                     System.out.println("Only $1 bills are accepted.");
                    }
             } catch (NumberFormatException e) {
                 System.out.println("Invalid input. Please enter a number or 'done'.");
                 }
             }
            System.out.println("You have inserted $" + total + ".");
        
             //User confirms transaction
             System.out.println("Are you sure that you want to purchase " + snacks[selection] + "for $" + prices[selection]+"? (yes/no)");
             String confirm = scanner.next();
             if(confirm.equalsIgnoreCase("no") ||  confirm.equalsIgnoreCase("n")){
                System.out.println("Transaction was cancelled. Here is your refund of $" + total + ".");
                System.exit(0);
             }

             //Dispense Exact change
             double change = total - prices[selection];
             System.out.println("Please take your "+ snacks[selection]+".");
             if(change > 0.0){
                System.out.println("Here is your change of $" + change + ".");
             } else {
                System.out.println("No chance needed");
             }

             //Departure Message
             System.out.println("Enjoy your $" + snacks[selection]+ "! Thank you for using the snack machine!");

    }
}