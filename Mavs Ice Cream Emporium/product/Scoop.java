package product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Scoop{
    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixins;

    public Scoop(IceCreamFlavor flavor){
        this.flavor = flavor;
        this.mixins = new ArrayList<>(); 
    }
    public Scoop (BufferedReader in) throws IOException{
        this.flavor = new IceCreamFlavor(in);
        try{
            int numbOfFlavors = Integer.parseInt(in.readLine());
            this.mixins = new ArrayList<>();
            for(int i = 0; i<numbOfFlavors; i++){
                addMixIn(new MixIn(in));
            }
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    public void save(BufferedWriter out)throws IOException{
        flavor.save(out);
        int numbOfMixins = mixins.size();
        out.write("" + numbOfMixins + '\n');
        for(int i = 0; i < numbOfMixins; i++){
            mixins.get(i).save(out);
        }
    }
    public void addMixIn(MixIn mixin){
        mixins.add(mixin);
    }

    @Override
    public String toString(){

        String mixinsList = null;
        int getIndex = 0;

        if(mixins.isEmpty()){
            return "" + flavor;
        }
        else{
            for(MixIn i : mixins){
                if(getIndex == 0){
                    mixinsList = "" + mixins.get(0);
                }
                else
                    mixinsList = mixinsList + ",  " + mixins.get(getIndex);
                getIndex++;
            }
            return flavor + " with " + mixinsList;            
        }

    }
    public int price(){
        int thePrice = flavor.cost();
        int mixinsIndex = 0;
        for(MixIn i : mixins){
            thePrice = thePrice + (mixins.get(mixinsIndex)).price();
            mixinsIndex++;
        }
        return thePrice;
    }
}