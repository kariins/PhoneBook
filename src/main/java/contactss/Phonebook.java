package contactss;

import java.util.ArrayList;
import java.util.Scanner;

public class Phonebook {
    private ArrayList<Contacts> contactss = new ArrayList<Contacts>();

    public String addContacts(Contacts contacts) {
        this.contactss.add(contacts);
        return contacts.name + " Added successfully";
    }

    public String removeContact(int contactsIndex) {
        try {
            contactss.remove(contactsIndex);
        } catch (Exception ex) {
            return "Unable to remove specified contact";
        }
        return "Contact removed successfully";
    }
    public Contacts findByName(String name) {
        for (Contacts contacts : contactss) {
            if (contacts.name.equals((name))) {
                return contacts;
            }
        }
       return null;
    }
    public Contacts findByPartOfName(String name) {
        for (Contacts contacts : contactss) {
            if (contacts.name.contains((name))) {
                return contacts;
            }
        }
        return null;
    }
    public ArrayList<Contacts> searchByPartName(String contactsName) {
        for (Contacts contacts : contactss) {
            if (contacts.name.contains(contactsName)) ;
            return contactss;
        }
        return null;
    }

    public Contacts findByEmail(String contactsEmail) {
        for (Contacts contacts : contactss) {
            if (contacts.email.equals((contactsEmail))) {
                return contacts;
            }
        }
        return null;
    }
    public Contacts updateContact(int contactsIndex, Contacts contacts) {
        return contactss.set(contactsIndex, contacts);
    }
    public ArrayList<Contacts> getAllContacts() {
        return contactss;
    }

    }
