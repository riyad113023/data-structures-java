package tree;

public class ContactManagerApp {


    BasicBinaryTree<Contact> contacts = new BasicBinaryTree<>();

    public void addContacts(){
        contacts.add(new Contact("Abe","Lincoln","1234234"));
        contacts.add(new Contact("Sheree","Whisman","1234235"));
        contacts.add(new Contact("Doreatha","Crumbley","1234236"));
        contacts.add(new Contact("Mitchel","Wear","1234237"));
    }

    public boolean searchContact(){
        return contacts.contains(new Contact("Abe","Lincoln","1234234"));
    }

    public void removeContact(){
        contacts.delete(new Contact("Abe","Lincoln","1234234"));
    }

    public int contactSize(){
        return contacts.size();
    }

    public static void main(String[] args) {
        ContactManagerApp app = new ContactManagerApp();
        app.addContacts();
        System.out.println("contact size :" + app.contactSize());
        System.out.println("Is this contact available : " + app.searchContact());

        app.removeContact();

        System.out.println("contact size :" + app.contactSize());
        System.out.println("Is this contact available : " + app.searchContact());
    }



    class Contact implements Comparable<Contact>{

        private String firstName;
        private String lastName;
        private String contactNo;

        public Contact(String firstName, String lastName, String contactNo) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.contactNo = contactNo;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getContactNo() {
            return contactNo;
        }

        public void setContactNo(String contactNo) {
            this.contactNo = contactNo;
        }

        @Override
        public int compareTo(Contact other) {
            return this.lastName.compareTo(other.lastName);
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", contactNo='" + contactNo + '\'' +
                    '}';
        }
    }
}
