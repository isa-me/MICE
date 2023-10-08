package emporium;
import product.*;
import person.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Emporium{
    private ArrayList<MixInFlavor> mixInFlavors;
    private ArrayList<IceCreamFlavor> iceCreamFlavors;
    private ArrayList<Order> orders;
    private ArrayList<Container> containers;
    private ArrayList<Customer> customers;
    public Emporium(){
        this.mixInFlavors = new ArrayList<MixInFlavor>();
        this.iceCreamFlavors =  new ArrayList<IceCreamFlavor>();
        this.orders = new ArrayList<Order>();
        this.containers = new ArrayList<Container>();
        this.customers = new ArrayList<Customer>();
    }
    public Emporium(BufferedReader in) throws IOException{
        try{
            int numbOfMixInFlavors = Integer.parseInt(in.readLine());
            this.mixInFlavors = new ArrayList<>();
            for(int i = 0; i<numbOfMixInFlavors; i++){
                addMixInFlavor(new MixInFlavor(in));
            }
            int numberOfIceCreamFlavors = Integer.parseInt(in.readLine());
            this.iceCreamFlavors = new ArrayList<>();
            for(int i = 0; i<numberOfIceCreamFlavors; i++){
                addIceCreamFlavor(new IceCreamFlavor(in));
            }
            int numberOfOrders = Integer.parseInt(in.readLine());
            this.orders = new ArrayList<>();
            for(int i = 0; i<numberOfOrders; i++){
                addOrder(new Order(in));
            }
            int numberOfContainers = Integer.parseInt(in.readLine());
            this.containers = new ArrayList<Container>();
            for(int i = 0; i<numberOfContainers; i++){
                addContainer(new Container(in));
            }
            int numberOfCustomers = Integer.parseInt(in.readLine());
            this.customers = new ArrayList<Customer>();
            for(int i = 0; i<numberOfCustomers; i++){
                addContainer(new Container(in));
            }
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    public void save(BufferedWriter out) throws IOException{
        int numbOfMixInFlavors = mixInFlavors.size();
        out.write("" + numbOfMixInFlavors + '\n');
        for(int i = 0; i < numbOfMixInFlavors; i++){
            mixInFlavors.get(i).save(out);
        }
        int numberOfIceCreamFlavors = iceCreamFlavors.size();
        out.write("" + numberOfIceCreamFlavors + '\n');
        for(int i = 0; i < numberOfIceCreamFlavors; i++){
            iceCreamFlavors.get(i).save(out);
        }
        int numberOfOrders = orders.size();
        out.write("" + numberOfOrders + '\n');
        for(int i = 0; i < numberOfOrders; i++){
            orders.get(i).save(out);
        }
        int numberOfContainers = containers.size();
        out.write("" + numberOfContainers + '\n');
        for(int i = 0; i < numberOfContainers; i++){
            containers.get(i).save(out);
        }
        int numberOfCustomers = customers.size();
        out.write("" + numberOfCustomers + '\n');
        for(int i = 0; i < numberOfCustomers; i++){
            customers.get(i).save(out);
        }
    }
    public void addMixInFlavor(MixInFlavor flavor){
        mixInFlavors.add(flavor);
    }
    public void addIceCreamFlavor(IceCreamFlavor flavor){
        iceCreamFlavors.add(flavor);
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public void addContainer(Container contain){
        containers.add(contain);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    
    public Object[] mixInFlavors(){
        return mixInFlavors.toArray();
    }
    public Object[] iceCreamFlavors(){
        return iceCreamFlavors.toArray();
    }
    public Object[] orders(){
        return orders.toArray();
    }
    public Object[] containers(){
        return containers.toArray();
    }
    public Object[] customers(){
        return customers.toArray();
    }
}