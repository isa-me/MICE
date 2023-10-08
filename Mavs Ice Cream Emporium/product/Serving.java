
package product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Serving{
    private Container container;
    private ArrayList<Scoop> scoops;
    private ArrayList<MixIn> toppings;

    public Serving(Container container){
        this.container = container;
        this.scoops = new ArrayList<>();
        this.toppings = new ArrayList<>();
    }
    public Serving(BufferedReader in) throws IOException {
        this.container = new Container(in);
        try{
            int numbOfScoops = Integer.parseInt(in.readLine());
            int numbOfToppings = Integer.parseInt(in.readLine());
            this.scoops = new ArrayList<>();
            this.toppings = new ArrayList<>();
            for(int i = 0; i<numbOfScoops; i++){
                addScoop(new Scoop(in));
            }
            for(int i = 0; i<numbOfToppings; i++){
                addTopping(new MixIn(in));
            }
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    public void save(BufferedWriter out) throws IOException{
        container.save(out);
        int numbOfScoops = scoops.size();
        int numbOfToppings = toppings.size();
        out.write("" + numbOfScoops + '\n');
        out.write("" + numbOfToppings + '\n');
        for(int i = 0; i < numbOfScoops; i++){
            scoops.get(i).save(out);
        }
        for(int i = 0; i < numbOfToppings; i++){
            toppings.get(i).save(out);
        }
    }
    public int numScoops(){
        return scoops.size();
    }
    public void addScoop(Scoop scoop){
        scoops.add(scoop);
    }
    public void addTopping(MixIn topping){
        toppings.add(topping);
    }
    @Override
    public String toString(){

        String servingsList = null;
        int getIndex = 0;
        if(scoops.isEmpty() && toppings.isEmpty()){
            return "" + container;
        }
        else{
            if(toppings.isEmpty()){
                for(Scoop i : scoops){
                    if(getIndex == 0){
                        servingsList = "" + container + " with " + scoops.get(0);
                    }
                    else
                        servingsList = servingsList + ",  " + scoops.get(getIndex);
                    getIndex++;
                }
            }
            else{
                for(Scoop i : scoops){
                    if(getIndex == 0){
                        servingsList = "" + container + " with " + scoops.get(0);
                    }
                    else
                        servingsList = servingsList + ",  " + scoops.get(getIndex);
                    getIndex++;
                }
                getIndex = 0;
                for(MixIn i: toppings){
                    if(getIndex == 0){
                        servingsList = servingsList + " Topped with " + toppings.get(0);
                    }
                    else
                        servingsList = servingsList + ",  " + toppings.get(getIndex);
                    getIndex++;
                } 
            }           
        }
        return servingsList;            
    }
    public int price(){
        int thePrice = 0;
        int arrayListIndex = 0;
        for(Scoop i : scoops){
            thePrice = thePrice + (scoops.get(arrayListIndex)).price();
            arrayListIndex++;
        }
        arrayListIndex = 0;
        for(MixIn i : toppings){
            thePrice = thePrice + (toppings.get(arrayListIndex)).price();
            arrayListIndex++;
        }
        return thePrice;
    }
}