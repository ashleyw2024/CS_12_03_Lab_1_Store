import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StoreTester {

    @Test
    public void testAddBook(){
        Store instanceOfStore = new Store();
        Book book = new Book("The Three Little Pigs", "shelf 711", 500, "a fable about three pigs who build three houses of different materials", 1000, "10Jan2023", "Joseph Jacobs", "1465478485", "10th edition", "The Three Little Pigs");
        instanceOfStore.addBook(book);
        System.out.println(instanceOfStore.getItems());
        assertTrue(instanceOfStore.getItems().size() != 0);
    }

    @Test
    public void testAddBookAndAddPhone(){
        Store instanceOfStore = new Store();
        Book book = new Book("The Three Little Pigs", "shelf 711", 500, "a fable about three pigs who build three houses of different materials", 1000, "10Jan2023", "Joseph Jacobs", "1465478485", "10th edition", "The Three Little Pigs");
        Phone phone = new Phone("iPhone 14 Pro", "Apple Store Central", 8500, "The iPhone 14 Pro comes with a 6.1-inch ProMotion OLED display with 1-120Hz adaptive refresh rates, Dolby Vision, and a Face ID Dynamic Island", 128, "14 Pro", "Apple", "IOS 16.0.2", "CSL", 16);
        instanceOfStore.addBook(book);
        instanceOfStore.addPhone(phone);
        System.out.println(instanceOfStore.getItems());
        assertTrue(instanceOfStore.getItems().size() == 2);
    }

    @Test
    public void updatePhonesLocation(){
        Store instanceOfStore = new Store();
        Book book = new Book("The Three Little Pigs", "shelf 711", 500, "a fable about three pigs who build three houses of different materials", 1000, "10Jan2023", "Joseph Jacobs", "1465478485", "10th edition", "The Three Little Pigs");
        Phone phone = new Phone("iPhone 14 Pro", "Apple Store Central", 8500, "The iPhone 14 Pro comes with a 6.1-inch ProMotion OLED display with 1-120Hz adaptive refresh rates, Dolby Vision, and a Face ID Dynamic Island", 128, "14 Pro", "Apple", "IOS 16.0.2", "CSL", 16);
        instanceOfStore.addBook(book);
        instanceOfStore.addPhone(phone);
        instanceOfStore.updatePhonesLocation("Room 514");
        ArrayList<Phone> phones = instanceOfStore.getAllPhones();
        for (int i = 0; i < phones.size(); i++){
            assertEquals(phone.getLocation(), "Room 514");
        }
    }

    @Test
    public void getAllPhones(){
        Store instanceOfStore = new Store();
        Book book = new Book("The Three Little Pigs", "shelf 711", 500, "a fable about three pigs who build three houses of different materials", 1000, "10Jan2023", "Joseph Jacobs", "1465478485", "10th edition", "The Three Little Pigs");
        Phone phone = new Phone("iPhone 14 Pro", "Apple Store Central", 8500, "The iPhone 14 Pro comes with a 6.1-inch ProMotion OLED display with 1-120Hz adaptive refresh rates, Dolby Vision, and a Face ID Dynamic Island", 128, "14 Pro", "Apple", "IOS 16.0.2", "CSL", 16);
        instanceOfStore.addBook(book);
        instanceOfStore.addPhone(phone);
        System.out.println(instanceOfStore.getItems());
        ArrayList<Phone> phones = instanceOfStore.getAllPhones();
        System.out.println(phones);
        assertEquals( 1, phones.size());
    }

    @Test
    public void getItemsPhone(){
        Store instanceOfStore = new Store();
        Book book = new Book("The Three Little Pigs", "shelf 711", 500, "a fable about three pigs who build three houses of different materials", 1000, "10Jan2023", "Joseph Jacobs", "1465478485", "10th edition", "The Three Little Pigs");
        Phone phone = new Phone("iPhone 14 Pro", "Apple Store Central", 8500, "The iPhone 14 Pro comes with a 6.1-inch ProMotion OLED display with 1-120Hz adaptive refresh rates, Dolby Vision, and a Face ID Dynamic Island", 128, "14 Pro", "Apple", "IOS 16.0.2", "CSL", 16);
        instanceOfStore.addBook(book);
        instanceOfStore.addPhone(phone);
        String itemType = "Phone";
        ArrayList<CISItem> items = instanceOfStore.getItems(itemType);
        System.out.println(items);
        assertEquals( 1 , items.size());
    }

    @Test
    public void getItemsBook(){
        Store instanceOfStore = new Store();
        Book book = new Book("The Three Little Pigs", "shelf 711", 500, "a fable about three pigs who build three houses of different materials", 1000, "10Jan2023", "Joseph Jacobs", "1465478485", "10th edition", "The Three Little Pigs");
        Phone phone = new Phone("iPhone 14 Pro", "Apple Store Central", 8500, "The iPhone 14 Pro comes with a 6.1-inch ProMotion OLED display with 1-120Hz adaptive refresh rates, Dolby Vision, and a Face ID Dynamic Island", 128, "14 Pro", "Apple", "IOS 16.0.2", "CSL", 16);
        instanceOfStore.addBook(book);
        instanceOfStore.addPhone(phone);
        String itemType = "Book";
        ArrayList<CISItem> items = instanceOfStore.getItems(itemType);
        System.out.println(items);
        assertEquals( 1 , items.size());
    }

    @Test
    public void updateItems() {
        Store instanceOfStore = new Store();
        Book book = new Book("The Three Little Pigs", "shelf 711", 500, "a fable about three pigs who build three houses of different materials", 1000, "10Jan2023", "Joseph Jacobs", "1465478485", "10th edition", "The Three Little Pigs");
        Phone phone = new Phone("iPhone 14 Pro", "Apple Store Central", 8500, "The iPhone 14 Pro comes with a 6.1-inch ProMotion OLED display with 1-120Hz adaptive refresh rates, Dolby Vision, and a Face ID Dynamic Island", 128, "14 Pro", "Apple", "IOS 16.0.2", "CSL", 16);
        instanceOfStore.addBook(book);
        instanceOfStore.addPhone(phone);

        //update the location of the books
        instanceOfStore.updateItems("book", "location", "Room 514");
        ArrayList<CISItem> books = instanceOfStore.getItems("book");

        //update the location of the phones
        instanceOfStore.updateItems("phone", "location", "Room 515");
        ArrayList<CISItem> phones = instanceOfStore.getItems("phone");
        assertEquals(phones.get(0).getLocation(), "Room 515");
    }
}