package product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class MixIn{
    private MixInFlavor flavor;
    private MixInAmount amount;

    public MixIn(MixInFlavor flavor, MixInAmount amount){
        this.flavor = flavor;
        this.amount = amount;
    }
    public MixIn(BufferedReader in) throws IOException{

        this.flavor = new MixInFlavor(in);
        this.amount = MixInAmount.valueOf(in.readLine());
    }
    public void save(BufferedWriter out) throws IOException{
        flavor.save(out);
        out.write("" + amount.toString() + '\n');
    }
    @Override
    public String toString(){
        if(!amount.equals(MixInAmount.Normal)){
            return flavor + " (" + amount + ")";
        }
        else
            return "" + flavor;
    }
    public int price(){
        int thePrice = flavor.cost();
        if(amount == MixInAmount.Light)
            thePrice = (int)(flavor.cost() * 0.8);
        else if(amount == MixInAmount.Extra)
            thePrice = (int)(flavor.cost() * 1.2);
        else if(amount == MixInAmount.Drenched)
            thePrice = (int)(flavor.cost() * 2);
        return thePrice;
    }
}