package gui;
import emporium.*;
import product.*;
import person.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.lang.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class MainWin extends JFrame{
    private Emporium emporium;
    private JLabel display;
    private File filename;

    public MainWin(){
        /*********************
        Modified Code from: Goerge Rice
        Available: https://github.com/prof-rice/cse1325-prof/blob/main/12/code_from_slides/nim/MainWin.java
        *********************/
        super("MICE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        filename = new File("untitled.emp");
        
        JMenuBar menubar = new JMenuBar();
        
        JMenu     file                 = new JMenu("File");
        JMenuItem quit                 = new JMenuItem("Quit");

        JMenu     view                 = new JMenu("View");
        JMenuItem viewIceCreamFlavor   = new JMenuItem("Ice Cream Flavor");
        JMenuItem viewMixInFlavor      = new JMenuItem("Mix In Flavor");
        //JMenuItem viewScoop            = new JMenuItem("Scoop");
        JMenuItem viewOrder            = new JMenuItem("Order");
        JMenuItem viewContainer        = new JMenuItem("Container");
        JMenuItem viewCustomer         = new JMenuItem("Customer");

        JMenu     create               = new JMenu("Create");
        JMenuItem createIceCreamFlavor = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMixInFlavor    = new JMenuItem("Mix In Flavor");
        //JMenuItem createScoop          = new JMenuItem("Scoop");
        JMenuItem createOrder          = new JMenuItem("Order");
        JMenuItem createContainer      = new JMenuItem("Container");
        JMenuItem createCustomer       = new JMenuItem("Customer");

        JMenu     help                 = new JMenu("Help");
        JMenuItem about                = new JMenuItem("About");
        
        quit.addActionListener(event -> onQuitClick());
        viewIceCreamFlavor.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        viewMixInFlavor.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        //viewScoop.addActionListener(event -> view(Screen.SCOOPS));
        viewOrder.addActionListener(event -> view(Screen.ORDERS));
        viewContainer.addActionListener(event -> view(Screen.CONTAINERS));
        viewCustomer.addActionListener(event -> view(Screen.CUSTOMERS));
        createIceCreamFlavor.addActionListener(event -> onCreateIceCreamFlavorClick());
        createMixInFlavor.addActionListener(event -> onCreateMixInFlavorClick());
        //createScoop.addActionListener(event -> onCreateScoopClick());
        createOrder.addActionListener(event -> onCreateOrderClick());
        createContainer.addActionListener(event -> onCreateContainerClick());
        createCustomer.addActionListener(event -> onCreateCustomerClick());

        about.addActionListener(event -> onAboutClick());
        
        file.add(quit);
        view.add(viewIceCreamFlavor);
        view.add(viewMixInFlavor);
        //view.add(viewScoop);
        view.add(viewOrder);
        view.add(viewContainer);
        view.add(viewCustomer);
        create.add(createIceCreamFlavor);
        create.add(createMixInFlavor);
        //create.add(createScoop);
        create.add(createOrder);
        create.add(createContainer);
        create.add(createCustomer);
        help.add(about);
        
        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);
        setJMenuBar(menubar);
        ///////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("Tool Bar");
        
        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));
        
        // Create the first 3 buttons
        JButton saveButton = new JButton(new ImageIcon("Save.PNG"));
          saveButton.setToolTipText("Save");
          toolbar.add(saveButton);
          saveButton.addActionListener(event -> onSaveClick());

        JButton saveAsButton = new JButton(new ImageIcon("SaveAs.PNG"));
          saveAsButton.setToolTipText("Save As");
          toolbar.add(saveAsButton);
          saveAsButton.addActionListener(event -> onSaveAsClick());

        JButton openButton = new JButton(new ImageIcon("Open.PNG"));
          openButton.setToolTipText("Open");
          toolbar.add(openButton);
          openButton.addActionListener(event -> onOpenClick());
        
        JButton createICFButton = new JButton(new ImageIcon("CreateIceCreamFlavor.PNG"));
          createICFButton.setToolTipText("Create Ice Cream Flavor");
          toolbar.add(createICFButton);
          createICFButton.addActionListener(event -> onCreateIceCreamFlavorClick());

        JButton createMIFButton = new JButton(new ImageIcon("CreateMixInFlavor.PNG"));
          createMIFButton.setToolTipText("Create Mix In Flavor");
          toolbar.add(createMIFButton);
          createMIFButton.addActionListener(event -> onCreateMixInFlavorClick());

        JButton createOrderButton = new JButton(new ImageIcon("CreateOrder.PNG"));
          createOrderButton.setToolTipText("Create Order");
          toolbar.add(createOrderButton);
          createOrderButton.addActionListener(event -> onCreateOrderClick());

        JButton createContButton = new JButton(new ImageIcon("CreateContainer.PNG"));
          createContButton.setToolTipText("Create Container");
          toolbar.add(createContButton);
          createContButton.addActionListener(event -> onCreateContainerClick());

        JButton createCustomerButton = new JButton(new ImageIcon("CreateCustomer.PNG"));
          createCustomerButton.setToolTipText("Create Customer");
          toolbar.add(createCustomerButton);
          createCustomerButton.addActionListener(event -> onCreateCustomerClick());
        /*JButton createScoopButton = new JButton(new ImageIcon("CreateScoop.PNG"));
          createScoopButton.setToolTipText("Create Scoop");
          toolbar.add(createScoopButton);
          createScoopButton.addActionListener(event -> onCreateScoopClick());*/

        JButton viewICFButton = new JButton(new ImageIcon("ViewIceCreamFlavor.PNG"));
          viewICFButton.setToolTipText("View Ice Cream Flavor");
          toolbar.add(viewICFButton);
          viewICFButton.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));

        JButton viewMIFButton = new JButton(new ImageIcon("ViewMixInFlavor.PNG"));
          viewMIFButton.setToolTipText("View Mix In Flavor");
          toolbar.add(viewMIFButton);
          viewMIFButton.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));

        JButton viewOrderButton = new JButton(new ImageIcon("ViewOrder.PNG"));
          viewOrderButton.setToolTipText("View Order");
          toolbar.add(viewOrderButton);
          viewOrderButton.addActionListener(event -> view(Screen.ORDERS));

        JButton viewContButton = new JButton(new ImageIcon("ViewContainer.PNG"));
          viewContButton.setToolTipText("View Container");
          toolbar.add(viewContButton);
          viewContButton.addActionListener(event -> view(Screen.CONTAINERS));

        JButton viewCustomerButton = new JButton(new ImageIcon("ViewCustomer.PNG"));
          viewCustomerButton.setToolTipText("View Customer");
          toolbar.add(viewCustomerButton);
          viewCustomerButton.addActionListener(event -> view(Screen.CUSTOMERS));
        /*JButton viewScoopButton = new JButton(new ImageIcon("ViewScoop.PNG"));
          viewScoopButton.setToolTipText("View Scoop");
          toolbar.add(viewScoopButton);
          viewScoopButton.addActionListener(event -> view(Screen.SCOOPS)); */

        toolbar.add(Box.createHorizontalStrut(25));
        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        ///////////////////////////////////////////////
        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(display, BorderLayout.CENTER);

        emporium = new Emporium();

        setVisible(true);
    }
    public void onQuitClick(){System.exit(0);}
    public void onCreateCustomerClick(){
        String name = JOptionPane.showInputDialog("Name? ");
        String phone = JOptionPane.showInputDialog("Phone? ");
        Customer customer = new Customer(name,phone);
        emporium.addCustomer(customer);
        view(Screen.CUSTOMERS);
    }
    public void onCreateContainerClick(){
        String name = JOptionPane.showInputDialog("Name? ");
        String description = JOptionPane.showInputDialog("Description? ");
        String maxScoops = JOptionPane.showInputDialog("Max Scoops? ");
        //Container container;
        try{
            int maxScoopsInt = Integer.parseInt(maxScoops);
            product.Container container = new product.Container(name,description,maxScoopsInt);
            emporium.addContainer(container);
            view(Screen.CONTAINERS);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    public void onCreateIceCreamFlavorClick(){
        String name = JOptionPane.showInputDialog("Name? ");
        String description = JOptionPane.showInputDialog("Description? ");
        String cost = JOptionPane.showInputDialog("Cost? ");
        String price = JOptionPane.showInputDialog("Price? ");
        IceCreamFlavor iceCreamFlavor;
        try{
            int costInt = Integer.parseInt(cost);
            int priceInt = Integer.parseInt(price);
            iceCreamFlavor = new IceCreamFlavor(name,description,costInt,priceInt);

            emporium.addIceCreamFlavor(iceCreamFlavor);
            view(Screen.ICE_CREAM_FLAVORS);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }

    }
    public void onCreateMixInFlavorClick(){
        String name = JOptionPane.showInputDialog("Name? ");
        String description = JOptionPane.showInputDialog("Description? ");
        String cost = JOptionPane.showInputDialog("Cost? ");
        String price = JOptionPane.showInputDialog("Price? ");
        MixInFlavor mixInFlavor;
        try{
            int costInt = Integer.parseInt(cost);
            int priceInt = Integer.parseInt(price);
            mixInFlavor = new MixInFlavor(name,description,costInt,priceInt);

            emporium.addMixInFlavor(mixInFlavor);
            view(Screen.MIX_IN_FLAVORS);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
//******************************************************************
//******************************************************************
    public Scoop onCreateScoopClick(){
        Object pickedIceCream, pickedMixIn, pickedMixInAmmount;
        IceCreamFlavor iceCreamFlavor;
        MixInFlavor mixInFlavor;
        MixInAmount mixInAmount;
        MixIn mixin;
        Scoop scoop;

        pickedIceCream = JOptionPane.showInputDialog(
            this,
            "Ice cream flavor? ",
            null,
            JOptionPane.QUESTION_MESSAGE,
            null,
            emporium.iceCreamFlavors(),
            JOptionPane.DEFAULT_OPTION);
        if(pickedIceCream != null){
            iceCreamFlavor = (IceCreamFlavor)pickedIceCream;
            scoop = new Scoop(iceCreamFlavor);
            do{
                pickedMixIn = JOptionPane.showInputDialog(
                    this,
                    "Mixin flavor? ",
                    null,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    emporium.mixInFlavors(),
                    JOptionPane.DEFAULT_OPTION);
                if(pickedMixIn != null)
                {
                    mixInFlavor = (MixInFlavor)pickedMixIn;
                    pickedMixInAmmount = JOptionPane.showInputDialog(
                        this,
                        "Mixin amount? ",
                        null,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        MixInAmount.values(),
                        JOptionPane.DEFAULT_OPTION);
                    if(pickedMixInAmmount != null){
                        mixInAmount = (MixInAmount)pickedMixInAmmount;
                        mixin = new MixIn(mixInFlavor,mixInAmount);
                        scoop.addMixIn(mixin);
                    }
                }
            }
            while(pickedMixIn != null);
            //emporium.addScoop(scoop); //<------Modification 1
            
            //view(Screen.SCOOPS);//<-------Modification 3
        }
        else{
            scoop = null;
        }
        return scoop; //<--------Modification 2
    }
//******************************************************************
//******************************************************************
    public Serving onCreateServing(){
        Object pickedContainer, pickedMixIn, pickedMixInAmmount;
        int YorNScoop;
        product.Container container;
        MixInFlavor mixInFlavor;
        MixInAmount mixInAmount;
        MixIn mixin;
        Serving serving;

        pickedContainer = JOptionPane.showInputDialog(
            this,
            "Container? ",
            null,
            JOptionPane.QUESTION_MESSAGE,
            null,
            emporium.containers(),
            JOptionPane.DEFAULT_OPTION);
        if(pickedContainer != null){
            container = (product.Container)pickedContainer;
            serving = new Serving(container);
            do{
                YorNScoop = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to add a Scoop?",
                    "Scoop?",
                    JOptionPane.YES_NO_OPTION);
                if(YorNScoop == JOptionPane.YES_OPTION) serving.addScoop(onCreateScoopClick());
            }
            while((YorNScoop != JOptionPane.NO_OPTION) && (serving.numScoops() <= container.maxScoops()));
            do{
                pickedMixIn = JOptionPane.showInputDialog(
                    this,
                    "Toppings flavor? ",
                    null,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    emporium.mixInFlavors(),
                    JOptionPane.DEFAULT_OPTION);
                if(pickedMixIn != null)
                {
                    mixInFlavor = (MixInFlavor)pickedMixIn;
                    pickedMixInAmmount = JOptionPane.showInputDialog(
                        this,
                        "Toppings amount? ",
                        null,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        MixInAmount.values(),
                        JOptionPane.DEFAULT_OPTION);
                    if(pickedMixInAmmount != null){
                        mixInAmount = (MixInAmount)pickedMixInAmmount;
                        mixin = new MixIn(mixInFlavor,mixInAmount);
                        serving.addTopping(mixin);
                    }
                }
            }
            while(pickedMixIn != null);
            //emporium.addScoop(scoop);
            return serving;
            //view(Screen.SCOOPS);
        }
        else{
            serving = null;
            return serving;
        }
    }
    public void onCreateOrderClick(){
        Serving serving;
        Object customerName;
        Customer theCustomer;
        customerName = JOptionPane.showInputDialog(
                    this,
                    "Name? ",
                    null,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    emporium.customers(),
                    JOptionPane.DEFAULT_OPTION);
        theCustomer = (Customer)customerName;
        Order order = new Order(theCustomer);
        do{
            serving = onCreateServing();
            if(serving != null){
                order.addServing(serving);
                emporium.addOrder(order);
            }
        }
        while(serving != null);
        view(Screen.ORDERS);
    }
    public void onAboutClick(){
        /*********************
        Modified Code from: Goerge Rice
        Available: https://github.com/prof-rice/cse1325-prof/blob/main/12/code_from_slides/nim/MainWin.java
        *********************/
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mavs Ice Cream Emporium");
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("ice-cream-1429596_640.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>MICE</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(title);

        JLabel artists = new JLabel("<html>"
          + "<p>Version 0.1</p>"
          + "<p>Copyright 2022 by Isaac Medrano</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by Schmidsi, per the Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/ice-cream-ice-cream-cone-ice-ball-1429596/</font></p>"
          + "<p>Ice cream icons created by Isaac Medrano</p>"
          + "<p>File icons created by Isaac Medrano</p>"
          + "</html>",JLabel.CENTER);
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(600, 600);
        about.setVisible(true);
    }

    private void view(Screen screen){

        int indexCounter = 0;
        String displayList = null;

        if(screen.equals(screen.ICE_CREAM_FLAVORS)){
            for(Object i : emporium.iceCreamFlavors()){ 
                if(indexCounter==0){
                    displayList = (emporium.iceCreamFlavors())[indexCounter]+ ", ";
                }
                else{
                    displayList = displayList + (emporium.iceCreamFlavors())[indexCounter] + ", ";
                }
                indexCounter++;
            }
            display.setText("Ice Cream Flavors: " + displayList);
        }
        if(screen.equals(screen.MIX_IN_FLAVORS)){
            for(Object i : emporium.mixInFlavors()){ 
                if(indexCounter==0){
                    displayList = (emporium.mixInFlavors())[indexCounter]+ ", ";
                }
                else{
                    displayList = displayList + (emporium.mixInFlavors())[indexCounter] + ", ";
                }
                indexCounter++;
            }
            display.setText("Mixin Flavors: \n" + displayList);
        }
        if(screen.equals(screen.CONTAINERS)){
            for(Object i : emporium.containers()){
                if(indexCounter==0){
                    displayList = (emporium.containers())[indexCounter]+ ", ";
                }
                else{ 
                displayList = displayList + (emporium.containers())[indexCounter] + ", ";
                }
                indexCounter++;
            }
            display.setText("Containers: " + displayList);
        }
        if(screen.equals(screen.ORDERS)){
            for(Object i : emporium.orders()){
                if(indexCounter==0){
                    displayList = (emporium.orders())[indexCounter] + ", ";
                }
                else{ 
                displayList = displayList + (emporium.orders())[indexCounter] + ", ";
                }
                indexCounter++;
            }
            display.setText("Orders: " + displayList + "\n");
        }
        if(screen.equals(screen.CUSTOMERS)){
            for(Object i : emporium.customers()){
                if(indexCounter==0){
                    displayList = (emporium.customers())[indexCounter] + ", ";
                }
                else{ 
                displayList = displayList + (emporium.customers())[indexCounter] + ", ";
                }
                indexCounter++;
            }
            display.setText("Customers: " + displayList + "\n");
        }
    }
/////////////////////////////////////////////////////
    protected void onOpenClick() {         // Create a new game
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter empFiles = new FileNameExtensionFilter("Emp files", "emp");
        fc.addChoosableFileFilter(empFiles);         // Add "Nim file" filter
        fc.setFileFilter(empFiles);                  // Show Nim files only by default
        
        int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();        // Obtain the selected File object
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                emporium = new Emporium(br);                   // Open a new game                  
                view(Screen.ICE_CREAM_FLAVORS); // Update the user interface
                view(Screen.MIX_IN_FLAVORS);
                //view(Screen.SCOOPS);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
            }
        }
    }

    protected void onSaveClick() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            emporium.save(bw);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e,
                "Failed", JOptionPane.ERROR_MESSAGE); 
        }
    }

    protected void onSaveAsClick() {         // Create a new game
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter empFiles = new FileNameExtensionFilter("Emp files", "emp");
        fc.addChoosableFileFilter(empFiles);         // Add "Nim file" filter
        fc.setFileFilter(empFiles);                  // Show Nim files only by default
        
        int result = fc.showSaveDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();         // Obtain the selected File object
            if(!filename.getAbsolutePath().endsWith(".emp"))  // Ensure it ends with ".nim"
                filename = new File(filename.getAbsolutePath() + ".emp");
            onSaveClick();                       // Delegate to Save method
        }
    }
}