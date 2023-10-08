package person;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.*;
public class Person{
    protected String name;
    protected String phone;

    public Person(String name, String phone){
        this.name = name;
        this.phone = phone;
    }
    public Person(BufferedReader in) throws IOException{
        this.name = in.readLine();
        this.phone = in.readLine();
    }
    public void save(BufferedWriter out) throws IOException{
        out.write("" + name + '\n');
        out.write("" + phone + '\n');
    }
    public String name(){
        return name;
    }
    public String phone(){
        return phone;
    }
    @Override
    public String toString(){
        return name + " " + phone;
    }

    //@Override
    public boolean equals(Person rhs){
        if(this == rhs) return true;
        if(rhs == null) return false;
        if(this.getClass() != rhs.getClass()) return false;
        return (rhs.name).equals(this.name) && 
               (rhs.phone).equals(this.phone);
    }
    /*public boolean equals(Object rhs){        
        if(this == rhs) return true;
        if(rhs == null) return false;
        if(this.getClass() != rhs.getClass()) return false;
        Person pr = (Person) rhs;
        return (pr.name()).equals(this.name) && 
               (pr.phone()).equals(this.phone);
    }*/
    public int hashCode(){
        int hash = phone.hashCode();
        return hash;
    }
}