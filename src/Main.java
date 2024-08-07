import java.util.Scanner;
import java.time.LocalDate;

import userDAO.*;
import accountDAO.*;
import personalDetailsDAO.*;
import BeneficiaryDAO.*;
import transactionDAO.*;
import adminDAO.*;


public class Main {
    private static UserDAO userDAO = new UserDAOImpl();
    private static AccountDAO accountDAO = new AccountDAOImpl();
    private static PersonalDetailsDAO personalDetailsDAO = new PersonalDetailsDAOImpl();
    private static BeneficiaryDAO beneficiaryDAO = new BeneficiaryDAOImpl();
    private static TransactionDAO transactionDAO = new TransactionDAOImpl();
    private static AdminDAO adminDAO = new AdminDAOImpl();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Bank System");
            System.out.println("1. Register User");
            System.out.println("2. Create Savings Account");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Make Transaction");
            System.out.println("5. View Account Statement");
            System.out.println("6. Admin Dashboard");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    createSavingsAccount(scanner);
                    break;
                case 3:
                    addBeneficiary(scanner);
                    break;
                case 4:
                    makeTransaction(scanner);
                    break;
                case 5:
                    viewAccountStatement(scanner);
                    break;
                case 6:
                    adminDashboard(scanner);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void registerUser(Scanner scanner) {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter transaction password: ");
        String transactionPassword = scanner.nextLine();
        userDAO.createUser(new User(userId, password, transactionPassword));
        System.out.println("User registered successfully.");
    }
    private static void createSavingsAccount(Scanner scanner) {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        accountDAO.createAccount(new Account(userId, accountNumber));
        System.out.println("Savings account created successfully.");
    }
    private static void addBeneficiary(Scanner scanner) {
        System.out.print("Enter beneficiary ID: ");
        String beneficiaryId = scanner.nextLine();
        System.out.print("Enter source user ID: ");
        String source = scanner.nextLine();
        System.out.print("Enter beneficiary account number: ");
        String accountNumber = scanner.nextLine();
        beneficiaryDAO.createBeneficiary(new Beneficiary(beneficiaryId, source, accountNumber));
        System.out.println("Beneficiary added successfully.");
    }
    private static void makeTransaction(Scanner scanner) {
        System.out.print("Enter transfer ID: ");
        String transferId = scanner.nextLine();
        System.out.print("Enter source user ID: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination account number: ");
        String toAccount = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter date of transfer (yyyy-mm-dd): ");
        LocalDate dateOfTransfer = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter transaction type: ");
        String type = scanner.nextLine();
        System.out.print("Enter remarks: ");
        String remarks = scanner.nextLine();
        transactionDAO.createTransaction(new Transaction(transferId, source, toAccount, amount, dateOfTransfer, type, remarks));
        System.out.println("Transaction successful.");
    }
    private static void viewAccountStatement(Scanner scanner) {
        System.out.print("Enter source user ID: ");
        String source = scanner.nextLine();
        System.out.println("Account Statement for user: " + source);
        for (Transaction transaction : transactionDAO.getAllTransactions()) {
            if (transaction.getSource().equals(source)) {
                System.out.println(transaction);
            }
        }
    }
    private static void adminDashboard(Scanner scanner) {
        System.out.print("Enter admin ID: ");
        String adminId = scanner.nextLine();
        Admin admin = adminDAO.getAdmin(adminId);
        if (admin == null) {
            System.out.println("Admin not found.");
            return;
        }
        System.out.println("Welcome, " + adminId);
        System.out.println("1. View All Users");
        System.out.println("2. View All Accounts");
        System.out.println("3. View All Beneficiaries");
        System.out.println("4. View All Transactions");
        System.out.println("5. Approve Requests");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1:
                for (User user : userDAO.getAllUsers()) {
                    System.out.println(user);
                }
                break;
            case 2:
                for (Account account : accountDAO.getAllAccounts()) {
                    System.out.println(account);
                }
                break;
            case 3:
                for (Beneficiary beneficiary : beneficiaryDAO.getAllBeneficiaries()) {
                    System.out.println(beneficiary);
                }
                break;
            case 4:
                for (Transaction transaction : transactionDAO.getAllTransactions()) {
                    System.out.println(transaction);
                }
                break;
            case 5:
                System.out.println("Approval requests feature not implemented yet.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}