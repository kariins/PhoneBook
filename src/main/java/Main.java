import contactss.Phonebook;
import contactss.Contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Phonebook phonebook = new Phonebook();

    public static void main(String[] args) {
        Main main = new Main();

        main.showMenu();
    }

    void showMenu() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        do {
            System.out.println("\nWelcome to the phonebook, please choose an activity: ");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Find Contact by Name");
            System.out.println("4. Find Contact by part of Name");
            System.out.println("5. Find Contact by E-mail");
            System.out.println("6. Update Contact");
            System.out.println("7. See all Contacts");
            System.out.println("\nEnter Quit to end program...");

            System.out.println("Choose a number: ");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "quit":
                    System.out.println("Exiting Application");
                    break;
                case "1":
                    addContacts();
                    break;
                case "2":
                    removeContact();
                    break;
                case "3":
                    findByName();
                    break;
                case "4":
                    findByPartOfName();
                    break;
                case "5":
                    findByEmail();
                    break;
                case "6":
                    updateContact();
                    break;
                case "7":
                    viewAllContacts();
                    break;
                default:
                    break;
            }
        } while (!userInput.equals("Quit"));
        return;
    }

    void addContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Contact");

        Contacts contacts = new Contacts();
        System.out.println("Enter Name: ");
        contacts.name = scanner.nextLine();

        System.out.println("Enter Email: ");
        contacts.email = scanner.nextLine();

        System.out.println("Enter Phone Number: ");
        contacts.phoneNumber = scanner.nextLine();

        String message = phonebook.addContacts(contacts);
        System.out.println(message);
    }

    void removeContact() {
        System.out.println("Remove Contact");
        System.out.println("Please provide Contact ID");
        Scanner scanner = new Scanner(System.in);
        int contactsIndex = scanner.nextInt();
        System.out.println((phonebook.removeContact(contactsIndex)));

    }

    void findByName() {
        System.out.println("Find contact by name...");
        System.out.println("Enter contact name: ");

        Scanner scanner = new Scanner(System.in);
        String contactsName = scanner.nextLine();

        Contacts contacts = phonebook.findByName(contactsName);
        System.out.println("Contact name: " + contactsName);
        System.out.println("Contact e-mail: " + contacts.email);
        System.out.println("Contact phone number: " + contacts.phoneNumber);
    }
    void findByPartOfName() {
        System.out.println("Find contact by part of name...");
        System.out.println("Enter contact name: ");

        Scanner scanner = new Scanner(System.in);
        String contactsName = scanner.nextLine();

        ArrayList<Contacts> searchByPart = phonebook.searchByPartName(contactsName);
        for (Contacts contacts : searchByPart) {
            System.out.println("Contact name: " + contacts.name);
            System.out.println("Contact e-mail: " + contacts.email);
            System.out.println("Contact phone number: " + contacts.phoneNumber);
        }
    }

    void findByEmail() {
        System.out.println("Find contact by e-mail...");
        System.out.println("Enter contact e-mail: ");

        Scanner scanner = new Scanner(System.in);
        String contactsEmail = scanner.nextLine();

        Contacts contacts = phonebook.findByEmail(contactsEmail);
        System.out.println("Contact name: " + contacts.name);
        System.out.println("Contact e-mail: " + contactsEmail);
        System.out.println("Contact phone number: " + contacts.phoneNumber);
    }

    void updateContact() {
        System.out.println("Update Contact.. ");
        System.out.println("Enter Contact name: ");
        Scanner scanner = new Scanner(System.in);
        String contactsName = scanner.nextLine();

        Contacts contacts = phonebook.findByName(contactsName);
        int contactsIndex = phonebook.getAllContacts().indexOf(contacts);
        System.out.println("Enter the property you would like to change: ");
        String property = scanner.nextLine();

        System.out.println("Enter the new value of: " + property);
        String value = scanner.nextLine();

        switch (property) {
            case "name", "Name":
                contacts.name = value;
                break;
            case "email", "Email":
                contacts.email = value;
                break;
            case "phone number", "Phone number", "Phone Number":
                contacts.phoneNumber = value;
                break;
            default:
                System.out.println("Please provide a valid property");
                break;
        }
        phonebook.updateContact(contactsIndex, contacts);
        System.out.println(contacts.name + " updated successfully");

    }
    void viewAllContacts() {
        ArrayList<Contacts> allContacts = phonebook.getAllContacts();

        System.out.println("\nAll Available Contacts\n");
        System.out.println("Contact Name\t E-mail\t \tPhone Number");
        for (Contacts contacts : allContacts) {
            System.out.println(contacts.name + "\t" + contacts.email + "\t" + "\t" + contacts.phoneNumber);
        }
    }

}