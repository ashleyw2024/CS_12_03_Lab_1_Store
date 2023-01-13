import java.util.ArrayList;

public class Store {
    private ArrayList<CISItem> items;

    public Store(ArrayList<CISItem> items) {
        this.items = items;
    }

    public Store() {
        this.items = new ArrayList<>();
    }

    public ArrayList<CISItem> getItems() {
        return items;
    }

    public void addBook(Book book){
        items.add(book);
    }

    public void addPhone(Phone phone){
        items.add(phone);
    }

    public void updatePhonesLocation(String location){
        //loop through items list
        //if item is a phone, then set location to the location that the user inputs
        for (int i = 0; i < items.size(); i++){
            if(items.get(i).getClass().getSimpleName().equals("phone")){
                items.get(i).setLocation(location);
            }
        }
    }

    public ArrayList<Phone> getAllPhones() {
        ArrayList<Phone> phones = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getClass().getSimpleName().equals("Phone")) {
                phones.add((Phone)items.get(i));
            }
        }
        return phones;
    }

    public ArrayList<CISItem> getItems(String itemType){
        ArrayList<CISItem> cisItems = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getClass().getSimpleName().equals(itemType)) {
                cisItems.add(items.get(i));
            }
        }
        return cisItems;
    }

    public void updateItems(String itemType, String property, String value){

        for (int i = 0; i < items.size(); i++){
            if(items.get(i).getClass().getSimpleName().equals(itemType)){
                if(property.equals("name")){
                    items.get(i).setName(value);
                }
                if(property.equals("location")){
                    items.get(i).setLocation(value);
                }
                if(property.equals("price")){
                    items.get(i).setPrice(Integer.parseInt(value));
                }
                if(property.equals("description")){
                    items.get(i).setDescription(value);
                }
            }
        }
    }

    public void showAllInfo(){
        for (CISItem item : items){
            System.out.println(item.toString());
        }
    }
}