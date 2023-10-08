package product;
import person.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Order{
    private ArrayList<Serving> servings;
    private Customer customer;
    public Order(Customer customer){
        this.servings = new ArrayList<>();
        this.customer = customer;
    }
    public Order(BufferedReader in) throws IOException {
        try{
            this.customer = new Customer(in);
            int numbOfServings = Integer.parseInt(in.readLine());
            this.servings = new ArrayList<>();
            for(int i = 0; i<numbOfServings; i++){
                addServing(new Serving(in));
            }            
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    public void save(BufferedWriter out)throws IOException{
        customer.save(out);
        int numbOfServings = servings.size();
        out.write("" + numbOfServings + '\n');
        for(int i = 0; i < numbOfServings; i++){
            servings.get(i).save(out);
        }
    }
    public Customer getCustomer(){
        return customer;
    }
    public void addServing(Serving serving){
        servings.add(serving);
    }
    @Override
    public String toString(){

        String servingsList = null;
        int getIndex = 0;
        for(Serving i : servings){
            if(getIndex == 0){
                servingsList = customer + ": " + servings.get(0);
            }
            else
                servingsList = servingsList + ",  " + servings.get(getIndex);
            getIndex++;
        }
        return servingsList;            
    }
    public int price(){
        int thePrice = 0;
        int servingsIndex = 0;
        for(Serving i : servings){
            thePrice = thePrice + (servings.get(servingsIndex)).price();
            servingsIndex++;
        }
        return thePrice;
    }
}