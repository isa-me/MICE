package product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.*;
public class Container{
    private String name;
    private String description;
    private int maxScoops;
    public Container(String name, String description, int maxScoops){
        this.name = name;
        this.description = description;
        this.maxScoops = maxScoops;
    }
    public Container(BufferedReader in) throws IOException{
        this.name = name;
        this.description = description;
        try{
            this.maxScoops = Integer.parseInt(in.readLine());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    public int maxScoops(){
        return maxScoops;
    }
    public void save(BufferedWriter out) throws IOException{
        out.write("" + name + '\n');
        out.write("" + description + '\n');
        out.write("" + maxScoops + '\n');
    }
    @Override
    public String toString(){
        return "" + name;
    }
}
