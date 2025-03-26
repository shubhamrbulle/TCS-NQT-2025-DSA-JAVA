/* Write a program that takes user income and a series of expenses, then calculates: 
 * 1. Total income
 * 2. Total expenses
 * 3. Breakdown of expenses by category
 * Input : 
 * Enter Income: 1000$
 * Enter Expenses and type or done:food
 * Enter price of expense: 200$
 * Enter Expenses and type or done:transport
 * Enter price of expense: 150$
 * Enter Expenses and type or done: done
 * Output: 
 * Summary of expenses:
 * Total Income: 1000$
 * Total Expenses: 350$
 * Total Savings: 650$
 * Analysis:
 * Expenses and price:
 * Food: 200$
 * Transport: 150$
 */

 import java.util.HashMap;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> expenses = new HashMap<>();

        // Get user income
        System.out.print("Enter income: $");
        int income = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int totalExpenses = 0;

        // Input expenses
        while (true) {
            System.out.print("Enter expense and type or 'done': ");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter price of expense: $");
            int price = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Add to expenses
            expenses.put(type, expenses.getOrDefault(type, 0) + price);
            totalExpenses += price;
        }

        // Calculate savings
        int totalSavings = income - totalExpenses;

        // Output results
        System.out.println("\nSummary of expenses:");
        System.out.println("Total income: $" + income);
        System.out.println("Total expenses: $" + totalExpenses);
        System.out.println("Total savings: $" + totalSavings);

        System.out.println("\nAnalysis:");
        for (String category : expenses.keySet()) {
            System.out.println("- " + category + ": $" + expenses.get(category));
        }

        scanner.close();
    }
}
