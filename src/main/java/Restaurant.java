import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        //DELETE ABOVE STATEMENT AND WRITfE CODE HERE
//        boolean x= ((getCurrentTime().isAfter(openingTime) || getCurrentTime().equals(openingTime)) &&
//                (getCurrentTime().isBefore(closingTime))|| getCurrentTime().equals(closingTime));
//
//        return x;

        displayDetails();
        return ((getCurrentTime().isAfter(openingTime) || getCurrentTime().equals(openingTime)) &&
                (getCurrentTime().isBefore(closingTime))|| getCurrentTime().equals(closingTime));
    }

    public LocalTime getCurrentTime(){
        return  LocalTime.now();
    }

    public List<Item> getMenu() {
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
         return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {

        return name;
    }

    public int calculating_total_price(List<Item> orderlist) {
        int ordervalue = 0;
        if(orderlist.isEmpty()){
            throw new NoItemSelectedException("no items selected");
        }
        for(Item item: orderlist){
            ordervalue += item.getPrice();
        }
        return ordervalue;
    }
}
