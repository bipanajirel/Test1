import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        double totalLoanAmount = 0;
        double interestRate = 0;

        System.out.println("RPG LOAN PROVIDERS");
        System.out.println("Loan Type\tInterest Rate");
        System.out.println("1. Home Loan\t4.2%");
        System.out.println("2. Car Loan\t3.9%");
        System.out.println("3. Gold Loan\t5.2%");
        System.out.println("4. Study Loan\t2.8%");
        System.out.println("5. Business Loan\t5.8%");
        System.out.println("6. Exit");

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your family annual income:");
        double annualIncome = input.nextDouble();

        if (annualIncome < 80000) {
            System.out.println("You are not eligible to get the loan from RPG Loan Providers.");
            
        }

        System.out.print("Enter the loan type numbers you want (separated by commas): ");
        String loanTypesInput = input.next();
        String[] loanTypeNumbers = loanTypesInput.split(",");
        int selectedLoans = loanTypeNumbers.length;

        if (selectedLoans < 2) {
            throw new IllegalArgumentException("You must select at least two loans.");
        }

        System.out.print("Enter the number of monthly installments (6-60 months): ");
        int installments = input.nextInt();

        if (installments < 6 || installments > 60) {
            System.out.println(" Please enter a value between (6 - 60).");

        }

        for (String loanTypeNumber : loanTypeNumbers) {
            int loanType = Integer.parseInt(loanTypeNumber);

            double loanInterestRate;
            switch (loanType) {
                case 1:
                    System.out.println("Home Loan:");
                    loanInterestRate = 4.2;
                    break;
                case 2:
                    System.out.println("Car Loan:");
                    loanInterestRate = 3.9;
                    break;
                case 3:
                    System.out.println("Gold Loan:");
                    loanInterestRate = 5.2;
                    break;
                case 4:
                    System.out.println("Study Loan:");
                    loanInterestRate = 2.8;
                    break;
                case 5:
                    System.out.println("Business Loan:");
                    loanInterestRate = 5.8;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid loan type selected: ");
            }
            //  Getting loan type from user.
            System.out.println("Enter the loan amount for Loan Type " + loanType + " (" + loanInterestRate
                    + "% interest rate):");
            int loanAmount = input.nextInt();

            if (loanAmount > 500000) {
                interestRate -= 0.10;
            }
            totalLoanAmount += loanAmount;
        }
        // Calculating and printing the results.
        double monthlyInstallment = totalLoanAmount / installments;

        System.out.println("Total Loan amount: $" + totalLoanAmount);
        System.out.println("Monthly Installment Amount: $" + monthlyInstallment);
    }
}
