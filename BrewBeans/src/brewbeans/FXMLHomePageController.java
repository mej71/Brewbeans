package brewbeans;
//define imports
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Wes
 */
public class FXMLHomePageController implements Initializable
{
//reference FXML document for variables
    @FXML
    private TextField searchBar;
    @FXML
    private AnchorPane HomePane;
    @FXML
    private TextField acctUseName;
    @FXML
    private TextField acctFrstName;
    @FXML
    private TextField acctLstName;
    @FXML
    private TextField acctPhone;
    @FXML
    private TextField acctFax;
    @FXML
    private TextField acctEmail;
    @FXML
    private TextField acctAddress;
    @FXML
    private TextField acctCity;
    @FXML
    private TextField acctState;
    @FXML
    private TextField acctZip;
    @FXML
    private TextField acctPrvnc;
    @FXML
    private TextField acctCntry;
    @FXML
    private Button addToCartButton;
    @FXML
    private Button checkOutCancelBtn;
    @FXML
    private Button checkOutBtn;
    @FXML
    private Button checkOutBtn2;
    @FXML
    private TableColumn<Table, String> productName;
    @FXML
    private TableColumn<Table, Float> price;
    @FXML
    private TableColumn<Table, String> prodDescription;
    @FXML
    private TableColumn<Table, Integer> stock;
    @FXML
    private TableColumn<Cart, String> cartProdName;
    @FXML
    private TableColumn<Cart, String> cartPriceEach;
    @FXML
    private TableColumn<Cart, Integer> numInCart;
    @FXML
    private TableColumn<Cart, String> cartProdTotal;
    @FXML
    private TableColumn<CheckOutCart, String> cartProdName2;
    @FXML
    private TableColumn<CheckOutCart, String> cartPriceEach2;
    @FXML
    private TableColumn<CheckOutCart, Integer> numInCart2;
    @FXML
    private TableColumn<CheckOutCart, String> cartProdTotal2;
    @FXML
    private TableColumn<Cart, String> grindOptionCol;
    @FXML
    private TableColumn<Cart, String> sizeCol;
    @FXML
    private TableColumn<OrderStatusFill, String> notesCol;
    @FXML
    private TableColumn<OrderStatusFill, String> carrierCol;
    @FXML
    private TableColumn<OrderStatusFill, String> trackNumCol;
    @FXML 
    private TableColumn<OrderStatusFill, String> orderStatCol;
    @FXML
    private TableColumn<OrderStatusFill, Date> dtOrderedCol;
    @FXML
    private Button logOutButton;
    @FXML
    private Button editAcctBtn;
    @FXML
    private Button editPassButton;
    @FXML
    private Button cancelEditBtn;
    @FXML
    private MenuButton filterMenu;
    @FXML
    private Label regSnc;
    @FXML
    private Label invalidNewPassLbl;
    @FXML
    private Tab cartTab;
    @FXML
    private Tab shopTab;
    @FXML
    private Tab orderTab;
    @FXML
    private Tab accountTab;   
    @FXML
    private Tab checkOutTab;
    @FXML
    private Label cartTotal;    
    @FXML
    private Label incorrectCurntPass;
    @FXML
    private Label invldEmail;
    @FXML
    private Label itemsInCartLbl;
    @FXML
    private ComboBox qtyList;
    @FXML
    private ComboBox grindOpBox;
    @FXML
    private ComboBox pkgSizeBox;
    @FXML
    private TabPane userTabs;
    @FXML
    private PasswordField curntPassBox;
    @FXML
    private PasswordField newPassBox;
    @FXML
    private PasswordField confirmPassBox;
    @FXML
    private Label newPassLbl;
    @FXML
    private Label confirmPassLbl;
    @FXML
    private Label curntPassLbl;
    @FXML
    private Label cardNumStar;
    @FXML
    private Label CCVStar;
    @FXML
    private Label billZipStar;
    @FXML
    private Label nameStar;
    @FXML
    private Label checkOutError;
    @FXML
    private Label cardExpStar;
    @FXML
    private TextField chkOutFName;
    @FXML
    private TextField chkOutLName;
    @FXML
    private TextField chkOutEmail;
    @FXML
    private TextField chkOutPhone;
    @FXML
    private TextField chkOutFax;
    @FXML
    private TextField chkOutAddress;
    @FXML
    private TextField chkOutCity;
    @FXML
    private TextField chkOutState;
    @FXML
    private TextField chkOutZip;
    @FXML
    private TextField chkOutCountry;
    @FXML
    private TextField chkOutPrvnc;
    @FXML
    private Label chkOutSub;
    @FXML
    private Label chkOutShip;
    @FXML
    private Label chkOutTax;
    @FXML
    private Label chkOutTotal;
    @FXML
    private TextField cardNum;
    @FXML
    private TextField cardMonth;
    @FXML
    private TextField cardYear;
    @FXML
    private TextField cardCCV;
    @FXML
    private TextField cardZip;
    @FXML
    private TextField cardName;
    @FXML
    private Button submitOrderBtn;
    @FXML
    private ComboBox changeQty;
    @FXML
    private Button removeItemBtn;
    @FXML
    private TableView<Table> productList;
    @FXML
    private TableView<Cart> cartTable;
    @FXML
    private TableView<CheckOutCart> checkOutCartTable;
    @FXML
    private TableView<OrderStatusFill> statusListTable;
    @FXML
    private Button updateCart;    
    @FXML
    private Label popUpLabel;
    
    private EmailValidator emailvalidator = new EmailValidator();//validates email address syntax
    //define  observable lists to be used in scene
    ObservableList<Table> products;
    ObservableList<String> pkgSzList;
    ObservableList<String> grindOpList;
    ObservableList<Cart> cartItems;
    ObservableList<CheckOutCart> chkOutCartItems;
    ObservableList<OrderStatusFill> statusList;
    //formats to currency
    DecimalFormat df = new DecimalFormat("##0.00");
    //scene only variables
    Statement stmt;
    ResultSet rs;
    Connection con;
    int userNum;
    int cartNum;
    int cartQty;
    int editAcctClicks = 0;
    int editPassClicks = 0;
    float calcdPrice;
    float cartSubNum, cartTotalNum, cartTaxNum, cartTax, cartShipping, cartActualTotal; 
    int cartShipNum;
    String urlStr;
    boolean canCheckOut = false;
        
    
    Stage checkOutStage; 
    Parent checkOutRoot;
    //define string arrays to add to combo boxes on shopping tab
    String pkgSzArray[] =
    {
        "1/2 lb", "1 lb"
    };
    String grindOpArray[] =
    {
        "Whole Bean", "Regular Grind"
    };
    private String search;

    boolean cartFlag = true, createCart = true;

    public void setUserNum(int un)
    {
        userNum = un;
        //called from the last scene to initialize the carriers for list factories
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        prodDescription.setCellValueFactory(new PropertyValueFactory<>("prodDescription"));

        cartProdName.setCellValueFactory(new PropertyValueFactory<>("cartProdName"));
        cartPriceEach.setCellValueFactory(new PropertyValueFactory<>("cartPriceEach"));
        numInCart.setCellValueFactory(new PropertyValueFactory<>("numInCart"));
        cartProdTotal.setCellValueFactory(new PropertyValueFactory<>("cartProdTotal"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("sizeCol"));
        grindOptionCol.setCellValueFactory(new PropertyValueFactory<>("grindOptionCol"));

        cartProdName2.setCellValueFactory(new PropertyValueFactory<>("cartProdName2"));
        cartPriceEach2.setCellValueFactory(new PropertyValueFactory<>("cartPriceEach2"));
        numInCart2.setCellValueFactory(new PropertyValueFactory<>("numInCart2"));
        cartProdTotal2.setCellValueFactory(new PropertyValueFactory<>("cartProdTotal2"));

        notesCol.setCellValueFactory(new PropertyValueFactory<>("notesCol"));
        carrierCol.setCellValueFactory(new PropertyValueFactory<>("carrierCol"));
        trackNumCol.setCellValueFactory(new PropertyValueFactory<>("trackNumCol"));
        orderStatCol.setCellValueFactory(new PropertyValueFactory<>("orderStatCol"));
        dtOrderedCol.setCellValueFactory(new PropertyValueFactory<>("dtOrderedCol"));

        ObservableList<String> options = FXCollections.observableArrayList("");
        qtyList.getItems().setAll(options);

        changeQty.getItems().setAll(options);

        pkgSzList = FXCollections.observableArrayList();
        pkgSzList.addAll(pkgSzArray);
        pkgSizeBox.setItems(pkgSzList);

        grindOpList = FXCollections.observableArrayList();
        grindOpList.addAll(grindOpArray);
        grindOpBox.setItems(grindOpList);

        pkgSizeBox.setValue("1/2 lb");
        grindOpBox.setValue("Whole Bean");
        addToCartButton.setDisable(true);

        Timeline refreshProdustStk = new Timeline(new KeyFrame(Duration.seconds(30), (ActionEvent event) ->
        {//creates a timer to refresh stock in case someone places an order and the level changes
            try
            {
                Integer ind = productList.getSelectionModel().getSelectedIndex();
                populateProdList();
                productList.getSelectionModel().select(ind);
                updateQty();
                checkCartStatus();
                populateOrderStatus();
            }
            catch (Exception ex)
            {
                Logger.getLogger(FXMLHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
        refreshProdustStk.setCycleCount(Timeline.INDEFINITE);
        refreshProdustStk.play();

        try
        {            
            populateProdList();
        }
        catch (Exception ex)
        {
            Logger.getLogger(FXMLHomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
		//initializes character limits for credit card info on check out
        cardMonth.addEventFilter(KeyEvent.KEY_TYPED, limitTextField(2));
        cardYear.addEventFilter(KeyEvent.KEY_TYPED, limitTextField(4));
        cardCCV.addEventFilter(KeyEvent.KEY_TYPED, limitTextField(3));
        cardZip.addEventFilter(KeyEvent.KEY_TYPED, limitTextField(5));
        cardNum.addEventFilter(KeyEvent.KEY_TYPED, limitTextField(16));
        
        try {
            checkCartStatus();
        }
        catch (Exception e){
            
        }
    }
	//initialize the scene
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
               
    }

    @FXML
    private void goSearch(ActionEvent event)
    {//gets typed search bar and sends to the populate class to find contoning entries
        search = searchBar.getText();
        try
        {
            populateProdList();
        }
        catch (Exception ex)
        {
            Logger.getLogger(FXMLHomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        searchBar.clear();
    }

    private void dbConnect() throws Exception
    {//connects to the db
        try
        {
            //step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object  
            con = DriverManager.getConnection("jdbc:oracle:thin:@oracle.gulfcoast.edu:1521/orcl.gulfcoast.edu", "teamCoffee", "oracleTC");
            con.setAutoCommit(true);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }

    private void dbDisconnect() throws Exception
    {//closes the statement and result set
        rs.close();
        stmt.close();
        con.close();
    }

    private void populateProdList() throws Exception
    {        //populates the shopping list from the db
        products = FXCollections.observableArrayList();

        String filter;

        switch (filterMenu.getText())
        {
            case "Equipment":
                filter = "'E'";
                break;
            case "Coffee":
                filter = "'C'";
                break;
            default:
                filter = "*";
                break;
        }

        try
        {
            dbConnect();

            stmt = con.createStatement();
            

            if (filter.equals("*"))//determines how the query should be structured
            {
                if (search != null)
                {
                    rs = stmt.executeQuery("SELECT * FROM BB_PRODUCT WHERE STOCK > 0 AND (LOWER(PRODUCTNAME) LIKE '%" + search.toLowerCase() + "%' OR LOWER(DESCRIPTION) LIKE '%" + search.toLowerCase() + "%')");
                }
                else
                {
                    rs = stmt.executeQuery("SELECT * FROM BB_PRODUCT WHERE STOCK > 0");
                }
            }
            else
            {
                if (search != null)
                {
                    rs = stmt.executeQuery("SELECT * FROM BB_PRODUCT WHERE TYPE = " + filter
                            + " AND STOCK > 0 AND (LOWER(PRODUCTNAME) LIKE '%" + search.toLowerCase() + "%' OR LOWER(DESCRIPTION) LIKE '%" + search.toLowerCase() + "%')");
                }
                else
                {
                    rs = stmt.executeQuery("SELECT * FROM BB_PRODUCT WHERE TYPE = " + filter
                            + " AND STOCK > 0");
                }
            }
			// cycles through the result set to populate the List of products
            while (rs.next())
            {
                String name = rs.getString("PRODUCTNAME");
                String price3 = df.format(rs.getFloat("PRICE"));
                int stk = rs.getInt("STOCK");
                String description = rs.getString("DESCRIPTION");

                products.add(new Table(name, price3, stk, description));
            }

            dbDisconnect();
        }
        catch (Exception ex)
        {
            Logger.getLogger(FXMLHomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
		//sets items to the table view
        productList.setItems(products);
    }
    
    private void populateOrderStatus() throws Exception
    {//checks users past orders and displays them on the order status tab
        statusList = FXCollections.observableArrayList();
        
        String stage;
        String notes;
        String shipNum;
        String shipCarrier;
        Date date;
        int stageNum;
        
        try
        {//connect and query the db
            dbConnect();
        
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT * FROM BB_SHIP_VU WHERE IDSHOPPER = " + userNum + " ORDER BY IDBASKET");
            
            while(rs.next())
            {                
                notes = rs.getString("NOTES");
                shipNum = rs.getString("SHIPPINGNUM");
                shipCarrier = rs.getString("SHIPPER");                                  
                stageNum = rs.getInt("IDSTAGE");
                date = rs.getDate("DATEORDERED");
                
                switch(stageNum)//determines by code what the status is
                {
                    case 1:
                        stage = "Order Placed";
                        break;
                    case 2:
                        stage = "Order Verified";
                        break;
                    case 3:
                        stage = "Sent To Shipping";
                        break;
                    case 5:
                        stage = "Shipped";
                        break;
                    case 4:
                        stage = "Cancelled";
                        break;
                    case 6:
                        stage = "Back-Ordered";
                        break;
                    default:
                        stage = "N/A";
                        break;
                }
            
                statusList.add(new OrderStatusFill(notes, shipCarrier, shipNum, stage, date));
            }
            
            
            statusListTable.setItems(statusList);
            
            dbDisconnect();
            
        }
        catch (Exception e)
        {
        }
        
    }

    private void populateAccount() throws Exception
    {//populates the account info
        try
        {
            dbConnect();

            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT * FROM BB_SHOPPER WHERE IDSHOPPER = " + userNum);

            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

            while (rs.next())//sets the data for the account tab and the check out tab and if null sets it to a blank space
            {
                acctUseName.setText(rs.getString("USERNAME"));
                if (acctUseName.getText().equals("null"))
                {
                    acctUseName.setText("");
                }
 
                acctFrstName.setText(rs.getString("FIRSTNAME"));
                if (acctFrstName.getText().equals("null"))
                {
                    acctFrstName.setText("");
                }
                chkOutFName.setText(acctFrstName.getText());
                
                acctLstName.setText(rs.getString("LASTNAME"));
                if (acctLstName.getText().equals("null"))
                {
                    acctLstName.setText("");
                }
                chkOutLName.setText(acctLstName.getText());
                
                acctPhone.setText(rs.getString("PHONE"));
                if (acctPhone.getText().equals("null"))
                {
                    acctPhone.setText("");
                }
                chkOutPhone.setText(acctPhone.getText());
                
                acctFax.setText(rs.getString("FAX"));
                if (acctFax.getText().equals("null"))
                {
                    acctFax.setText("");
                }
                chkOutFax.setText(acctFax.getText());
                
                acctEmail.setText(rs.getString("EMAIL"));
                if (acctEmail.getText().equals("null"))
                {
                    acctEmail.setText("");
                }
                chkOutEmail.setText(acctEmail.getText());
                
                acctAddress.setText(rs.getString("ADDRESS"));
                if (acctAddress.getText().equals("null"))
                {
                    acctAddress.setText("");
                }
                chkOutAddress.setText(acctAddress.getText());
                
                acctCity.setText(rs.getString("CITY"));
                if (acctCity.getText().equals("null"))
                {
                    acctCity.setText("");
                }
                chkOutCity.setText(acctCity.getText());
                
                acctState.setText(rs.getObject("STATE").toString());
                if (acctState.getText().equals("null"))
                {
                    acctState.setText("");
                }
                chkOutState.setText(acctState.getText());
                
                acctZip.setText(rs.getString("ZIPCODE"));
                if (acctZip.getText().equals("null"))
                {
                    acctZip.setText("");
                }
                chkOutZip.setText(acctZip.getText());
                
                acctPrvnc.setText(rs.getString("PROVINCE"));
                if (acctPrvnc.getText().equals("null"))
                {
                    acctPrvnc.setText("");
                }
                chkOutPrvnc.setText(acctPrvnc.getText());
                
                acctCntry.setText(rs.getString("COUNTRY"));
                if (acctCntry.getText().equals("null"))
                {
                    acctCntry.setText("");
                }
                chkOutCountry.setText(acctCntry.getText());
                
                Date newDate = date.parse(rs.getString("DTENTERED"));
                String DateToStr = date.format(newDate);
                regSnc.setText(DateToStr);
            }
              
            dbDisconnect();
        }
        catch (Exception e)
        {
            Logger.getLogger(FXMLHomePageController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void populateCart() throws Exception
    {
        try
        {//contacts database and populates the shopping cart with the items in cart in db
            checkCartStatus();           
            cartItems = FXCollections.observableArrayList();
            chkOutCartItems = FXCollections.observableArrayList();

            dbConnect();
            stmt = con.createStatement();

            if (!createCart)
            {
                try
                {//contact the db
                    rs = stmt.executeQuery("SELECT p.PRODUCTNAME, b.PRICE, b.QUANTITY, b.OPTION1, b.OPTION2  "
                            + "FROM BB_PRODUCT p JOIN BB_BASKETITEM b ON p.IDPRODUCT = b.IDPRODUCT WHERE IDBASKET = " + cartNum);

                    while (rs.next())
                    {
                        String name = rs.getString("PRODUCTNAME");
                        float price2 = rs.getFloat("PRICE");
                        int qty = rs.getInt("QUANTITY");
                        float total = price2 * qty;
                        int op1 = rs.getInt("OPTION1");
                        int op2 = rs.getInt("OPTION2");
                        
                        String priceDF = df.format(price2);
                        String totalDF = df.format(total);
                        cartItems.add(new Cart(name, priceDF, qty, totalDF, op1, op2));
                        chkOutCartItems.add(new CheckOutCart(name, priceDF, qty, totalDF));                            
                            
                    }
                }
                catch (Exception e)
                {
                    Logger.getLogger(FXMLHomePageController.class.getName()).log(Level.SEVERE, null, e);
                }
                cartTable.setItems(cartItems); 
                checkOutCartTable.setItems(chkOutCartItems);
                               
            }


            dbDisconnect();
        }
        catch (Exception e)
        {
            Logger.getLogger(FXMLHomePageController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void checkCartStatus() throws Exception
    {//checks to see if the user has an open cart and if not trips flag to create one
        dbConnect();

        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT IDBASKET, QUANTITY, SUBTOTAL, TAX, SHIPPING, TOTAL FROM BB_BASKET WHERE ORDERPLACED = 0 AND IDSHOPPER = " + userNum);

            if (!rs.isBeforeFirst())
            {
                createCart = true;
                cartQty = 0;
            }
            else
            {
                while (rs.next())
                {
                    cartNum = rs.getInt("IDBASKET");
                    cartQty = rs.getInt("QUANTITY");
                    cartFlag = false;
                    cartSubNum = rs.getFloat("SUBTOTAL");       
                    cartTax = rs.getFloat("TAX");
                    cartShipping = rs.getFloat("SHIPPING");
                    cartActualTotal = rs.getFloat("TOTAL");
                }
                
                String tempTotal = df.format(cartSubNum);                
                                
                cartTotal.setText(tempTotal);
                
                
                createCart = false;
            }
        }

        catch (Exception e)
        {
            Logger.getLogger(FXMLHomePageController.class.getName()).log(Level.SEVERE, null, e);
        }
        //if cart exists sets the labels to reflect what is in it
        itemsInCartLbl.setText(Integer.toString(cartQty));
        chkOutSub.setText(df.format(cartSubNum));
        chkOutTax.setText(df.format(cartTax));
        chkOutShip.setText(df.format(cartShipping));
        chkOutTotal.setText(df.format(cartActualTotal));
        

        dbDisconnect();
    }

    private void makeNewCart() throws Exception
    {//if the flag to make a new cart is raised, this makes a new entry in the basket table
        dbConnect();
        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO BB_BASKET (IDBASKET, IDSHOPPER, ORDERPLACED, QUANTITY, SUBTOTAL, TAX, SHIPPING, TOTAL)VALUES (BB_IDBASKET_SEQ.NEXTVAL, " + userNum + ", 0, 0, 0, 0, 0, 0)");

            createCart = false;

            rs = stmt.executeQuery("SELECT IDBASKET FROM BB_BASKET WHERE ORDERPLACED = 0 AND IDSHOPPER = " + userNum);

        }
        catch (Exception e)
        {
            Logger.getLogger(FXMLHomePageController.class.getName()).log(Level.SEVERE, null, e);
        }

        dbDisconnect();
    }

    private void addItemToCart() throws Exception
    {//adds selected item and the value of the qty combo box to the db
                
        float tempPrice = Float.parseFloat(productList.getSelectionModel().getSelectedItem().getPrice());        
        int tempQty = (Integer) qtyList.getValue();        
        String optStr1 = (String) pkgSizeBox.getValue();         
        String optStr2 = (String) grindOpBox.getValue();
        int option1 = 0;
        int option2 = 0;
        
        switch (optStr1)//determines what the options selected was 
        {
            case "1/2 lb":
                option1 = 1;
                break;
            case "1 lb":
                option1 = 2;
                break;
        }
        switch (optStr2)
        {
            case "Whole Bean":
                option2 = 1;
                break;
            case "Regular Grind":
                option2 = 2;
                break;
        }    
        if(option1 == 1)
        {
            tempPrice = tempPrice/2;
        }
        
        dbConnect();
        
        stmt = con.createStatement();

        rs = stmt.executeQuery("SELECT IDPRODUCT, IDDEPARTMENT FROM BB_PRODUCT WHERE PRODUCTNAME = '" + productList.getSelectionModel().getSelectedItem().getProductName()+ "'");
        
        int idProd = 0;
        int idDept = 0;
        
        while (rs.next())
        {
            idProd = rs.getInt("IDPRODUCT");
            idDept = rs.getInt("IDDEPARTMENT");
        }
        dbDisconnect();
        dbConnect();
        
        stmt = con.createStatement();
        //decides if the item is equipment or not to insert only correct fields
        if(idDept == 1)
        {
            stmt.executeUpdate("INSERT INTO BB_BASKETITEM (IDBASKETITEM, IDPRODUCT, PRICE, QUANTITY, IDBASKET, OPTION1, OPTION2) VALUES (BB_IDBASKETITEM_SEQ.NEXTVAL, " + idProd + ", " + tempPrice + ", " + tempQty + ", " + cartNum + ", " + option1 + ", " + option2 + ")");
        }
        else
        {
            stmt.executeUpdate("INSERT INTO BB_BASKETITEM (IDBASKETITEM, IDPRODUCT, PRICE, QUANTITY, IDBASKET) VALUES (BB_IDBASKETITEM_SEQ.NEXTVAL, " + idProd + ", " + tempPrice + ", " + tempQty + ", " + cartNum + ")");
        }    
        
        dbDisconnect();
        dbConnect();
        
        stmt = con.createStatement();
        
        stmt.executeUpdate("UPDATE BB_BASKET SET SUBTOTAL = sub_calc_sf("+cartNum+") WHERE IDBASKET ="+cartNum);
        rs = stmt.executeQuery("SELECT SUBTOTAL FROM BB_BASKET WHERE IDBASKET ="+cartNum);
        Float tempsub = 0.0f;
        while (rs.next())
        {
            tempsub = rs.getFloat("SUBTOTAL");
        }
        stmt.executeUpdate("UPDATE BB_BASKET SET SHIPPING = ship_calc3_sf("+cartNum+") WHERE IDBASKET ="+cartNum);
        rs = stmt.executeQuery("SELECT SHIPPING FROM BB_BASKET WHERE IDBASKET ="+cartNum);
        Float tempship = 0.0f;
        while (rs.next())
        {
            tempship = rs.getFloat("SHIPPING");
        }
        //stmt.executeUpdate("UPDATE BB_BASKET SET TAX = tax_calc2_sf("+cartNum+","+tempsub+") WHERE IDBASKET ="+cartNum);
        //rs = stmt.executeQuery("SELECT TAX FROM BB_BASKET WHERE IDBASKET ="+cartNum);
        Float temptax = 0.0f;
        //while (rs.next())
        //{
           // temptax = rs.getFloat("TAX");
        //}
        stmt.executeUpdate("UPDATE BB_BASKET SET TOTAL = "+tempsub+"+"+tempship+"+"+temptax);
    }

    private void submitAccountEdit() throws Exception
    {//submits the changes to the account tab
        dbConnect();

        stmt = con.createStatement();

        stmt.executeUpdate("UPDATE BB_SHOPPER SET FIRSTNAME = '" + acctFrstName.getText() + "', LASTNAME = '" + acctLstName.getText()
                + "', ADDRESS = '" + acctAddress.getText() + "', CITY = '" + acctCity.getText() + "', STATE = '" + acctState.getText()
                + "', ZIPCODE = '" + acctZip.getText() + "', PHONE = '" + acctPhone.getText() + "', FAX = '"
                + acctFax.getText() + "', EMAIL = '" + acctEmail.getText() + "', PROVINCE =  '" + acctPrvnc.getText() + "', COUNTRY = '"
                + acctCntry.getText() + "' WHERE IDSHOPPER = " + userNum);

        dbDisconnect();
    }

    private void updateQty() throws Exception
    {//updates the qty combo boxes after a new item is selected
        if (productList.getSelectionModel().getSelectedItem() != null)
        {
            dbConnect();

            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT IDDEPARTMENT FROM BB_PRODUCT WHERE PRODUCTNAME = '" + productList.getSelectionModel().getSelectedItem().getProductName() + "'");

            while (rs.next())
            {
                int tmp = rs.getInt("IDDEPARTMENT");

                if (tmp == 1)
                {
                    pkgSizeBox.setVisible(true);
                    grindOpBox.setVisible(true);
                }
                else
                {
                    pkgSizeBox.setVisible(false);
                    grindOpBox.setVisible(false);
                }
            }
            
            dbDisconnect();

            int qtyInStk = productList.getSelectionModel().getSelectedItem().getStock();

            ObservableList<Integer> options = FXCollections.observableArrayList();        
            

            for (int i = 0; i < qtyInStk; i++)
            {
                options.add(i + 1);
            }
                        
            qtyList.getItems().setAll(options);
        }
        else
        {
            ObservableList<String> options = FXCollections.observableArrayList("");
            qtyList.getItems().setAll(options);
        }
    }
    
    private void updateQty2() throws Exception
    {//does the same as the above function but for a different listener and tab and combobox
        if (cartTable.getSelectionModel().getSelectedItem()!=null)
        {
            dbConnect();
            stmt = con.createStatement();
            
            int qtyInStk2 = 0;
            
            rs = stmt.executeQuery("Select Stock From BB_Product Where Productname = '"+cartTable.getSelectionModel().getSelectedItem().getCartProdName()+"'");
            while (rs.next())
            {
                qtyInStk2 = rs.getInt("STOCK");
            }
            dbDisconnect();
            ObservableList<Integer> options2 = FXCollections.observableArrayList();
            
            for (int i = 0; i < qtyInStk2; i++)
            {
                options2.add(i + 1);
            }
            changeQty.getItems().setAll(options2);
        }
        else
        {
            ObservableList<String> options = FXCollections.observableArrayList("");
            changeQty.getItems().setAll(options);
        }
    }
        
    @FXML
    private void onClickCartTab() throws Exception
    {//listener to switch to the cart tab and populate it with the correct info
        populateCart();
        cartTable.getSelectionModel().select(null);
        changeQty.setVisible(false);
        removeItemBtn.setVisible(false);
        changeQty.setValue("Change Quantity");
    }

    @FXML
    private void onClickAddToCart(ActionEvent e) throws Exception
    {//listener to add item to cart, calls the function to do so
        checkCartStatus();
        
        if (createCart)
        {
            makeNewCart();
        }       
        
        checkCartStatus();
        addItemToCart();   
        checkCartStatus();
    }

    @FXML
    private void onClickViewCart() throws Exception
    {//listener to switch to view cart tab
        populateCart();
        SingleSelectionModel<Tab> selectionModel = userTabs.getSelectionModel();

        selectionModel.select(cartTab);
        cartTable.getSelectionModel().select(null);
        changeQty.setVisible(false);
        removeItemBtn.setVisible(false);
        changeQty.setValue("Change Quantity");
    }

    @FXML
    private void onClickAccount() throws Exception
    {//listener to switch to view account tab
        onCancelEdit();
        populateAccount();
        populateCart();
    }
    
    @FXML
    private void onClickOrderStat() throws Exception
    {//listener to switch to view order status tab
        populateOrderStatus();
    }

    @FXML
    private void onClickEditPass(ActionEvent event) throws Exception
    {//makes password fields available to edit, then checks to make sure they entered correct data and updates if it is correct, if not makes them re enter the data
        String tempPass = "";
        
        if(editPassClicks == 0)
        {
            curntPassBox.setVisible(true);
            newPassBox.setVisible(true);
            confirmPassBox.setVisible(true);
            curntPassLbl.setVisible(true);
            newPassLbl.setVisible(true);
            confirmPassLbl.setVisible(true);
            
            cancelEditBtn.setVisible(true);
            editAcctBtn.setVisible(false);
            
            editPassButton.setText("Submit Password");
            
            editPassClicks = 1;
        }
        else
        {                                    
            dbConnect();            
            
            stmt = con.createStatement();
            
            rs = stmt.executeQuery("SELECT PASSWORD FROM BB_SHOPPER WHERE IDSHOPPER = " + userNum);
            
            while (rs.next())
            {
                tempPass = rs.getString("PASSWORD");
            }
            
            dbDisconnect();
            dbConnect();
            
            stmt = con.createStatement();
            
            if (tempPass != null && tempPass.equals(curntPassBox.getText()))
            {
                if(newPassBox.getText().length() > 0 && newPassBox.getText().length() <= 8 && newPassBox.getText().equals(confirmPassBox.getText())  && !newPassBox.getText().contains(" "))
                {//correct inofrmation given and password updated
                    stmt.executeUpdate("UPDATE BB_SHOPPER SET PASSWORD = '" + newPassBox.getText() + "' WHERE IDSHOPPER = " + userNum);
                    editPassButton.setText("Edit Password");
                    newPassBox.setText("");
                    confirmPassBox.setText("");
                    curntPassBox.setText("");
                    curntPassBox.setVisible(false);
                    newPassBox.setVisible(false);
                    confirmPassBox.setVisible(false);
                    curntPassLbl.setVisible(false);
                    newPassLbl.setVisible(false);
                    confirmPassLbl.setVisible(false);
                    cancelEditBtn.setVisible(false);
                    editAcctBtn.setVisible(true);
                    editPassClicks = 0;
                }
                else//incorrect info given and tells user so
                {
                    if(newPassBox.getText().length() == 0 || confirmPassBox.getText().length() == 0)
                    {
                        invalidNewPassLbl.setText("You Did Not Enter a New/Confirm Password!");
                        newPassBox.setText("");
                        confirmPassBox.setText("");
                    }
                    
                    if(!newPassBox.getText().equals(confirmPassBox.getText()))
                    {
                        invalidNewPassLbl.setText("New/Confirm Passwords Do Not Match!");
                        newPassBox.setText("");
                        confirmPassBox.setText("");
                    }
                    
                    if(newPassBox.getText().length() > 8 || confirmPassBox.getText().length() > 8)
                    {
                        invalidNewPassLbl.setText("New/Confirm Passwords Too Long! Max of 8 Characters!");
                        newPassBox.setText("");
                        confirmPassBox.setText("");
                    }
                    
                    if (newPassBox.getText().contains(" "))
                    {
                        invalidNewPassLbl.setText("Passwords May Not Contain Any Spaces!");
                        newPassBox.setText("");
                        confirmPassBox.setText("");
                    }
                }
            }
            else
            {
                if(!curntPassBox.getText().equals(tempPass))
                {
                    incorrectCurntPass.setText("Incorrect Current Password!");
                    curntPassBox.setText("");
                }
                
                if (curntPassBox.getText() == null)
                {
                    incorrectCurntPass.setText("Please Enter You Current Password!");
                    curntPassBox.setText("");
                }
                
            }
            
            dbDisconnect();            
        }
    }

    @FXML
    private void enableAddToCart(Event event) throws Exception
    {//enables add to cart if qty is selected
        if (qtyList.getSelectionModel().isEmpty())
        {
            addToCartButton.setDisable(true);
        }
        else
        {
            addToCartButton.setDisable(false);
        }
    }

    @FXML
    private void updateQtyAction(MouseEvent event) throws Exception
    {//updates if an item is clicked
        addToCartButton.setDisable(true);
        qtyList.setValue("Qty to Add");
        updateQty();
    }
    
    @FXML
    private void updateQtyAction2(MouseEvent event) throws Exception
    {////updates if an item is clicked for a different
        updateQty2();
        changeQty.setVisible(true);
        removeItemBtn.setVisible(true);
        changeQty.setValue("Change Quantity");
    }

    @FXML
    private void onClickEditAccnt() throws Exception
    {//enables the diting of the account information on the account tab and then submits it to the db after submit preseed
        if (editAcctClicks == 0)
        {
            acctFrstName.setEditable(true);
            acctLstName.setEditable(true);
            acctPhone.setEditable(true);
            acctFax.setEditable(true);
            acctEmail.setEditable(true);
            acctAddress.setEditable(true);
            acctCity.setEditable(true);
            acctState.setEditable(true);
            acctZip.setEditable(true);
            acctPrvnc.setEditable(true);
            acctCntry.setEditable(true);
            
            cancelEditBtn.setVisible(true);
            editPassButton.setVisible(false);

            editAcctBtn.setText("Submit");
            editAcctClicks = 1;
        }
        else
        {
            if (emailvalidator.validate(acctEmail.getText()))
            {
                invldEmail.setVisible(false);
                acctFrstName.setEditable(false);
                acctLstName.setEditable(false);
                acctPhone.setEditable(false);
                acctFax.setEditable(false);
                acctEmail.setEditable(false);
                acctAddress.setEditable(false);
                acctCity.setEditable(false);
                acctState.setEditable(false);
                acctZip.setEditable(false);
                acctPrvnc.setEditable(false);
                acctCntry.setEditable(false);

                cancelEditBtn.setVisible(false);
                editPassButton.setVisible(true);

                editAcctBtn.setText("Edit Account");
                editAcctClicks = 0;

                submitAccountEdit();
            }
            else
            {
                invldEmail.setVisible(true);
                acctEmail.setText("");
            }
        }
    }

    @FXML
    private void onClickFilter(ActionEvent event) throws Exception
    {//filters the product list by category
        search = null;
        MenuItem menu = (MenuItem) event.getSource();
        filterMenu.setText(menu.getText());

        populateProdList();
        updateQty();
    }

    @FXML
    private void keyPressed(KeyEvent e) throws Exception
    {//listens to see if the up or down arrow is pressed to select an item in shopping tab
        if (e.getCode() == KeyCode.UP || e.getCode() == KeyCode.DOWN)
        {
            updateQty();
            addToCartButton.setDisable(true);
            qtyList.setValue("Qty to Add");
            updateQty2();
            changeQty.setValue("Change Quantity");
        }
    }
    
    @FXML
    private void removeInvalid(KeyEvent e) throws Exception
    {//if key pressed inside one of the password fields it takes away the error message 
        incorrectCurntPass.setText("");
        invalidNewPassLbl.setText("");
    }
    
    @FXML
    private void onCancelEdit() throws Exception
    {//resets the editing functionality on the account tab
        cancelEditBtn.setVisible(false);
        editAcctBtn.setVisible(true);
        editPassButton.setVisible(true);
        
        acctFrstName.setEditable(false);
        acctLstName.setEditable(false);
        acctPhone.setEditable(false);
        acctFax.setEditable(false);
        acctEmail.setEditable(false);
        acctAddress.setEditable(false);
        acctCity.setEditable(false);
        acctState.setEditable(false);
        acctZip.setEditable(false);
        acctPrvnc.setEditable(false);
        acctCntry.setEditable(false);
        curntPassBox.setVisible(false);
        newPassBox.setVisible(false);
        confirmPassBox.setVisible(false);
        curntPassLbl.setVisible(false);
        newPassLbl.setVisible(false);
        confirmPassLbl.setVisible(false);
        
        newPassBox.setText("");
        confirmPassBox.setText("");
        curntPassBox.setText("");        
        
        invalidNewPassLbl.setText("");
        incorrectCurntPass.setText("");

        editAcctBtn.setText("Edit Account");
        editPassButton.setText("Edit Password");
        editAcctClicks = 0;
        editPassClicks = 0;
        invldEmail.setVisible(false);
        populateAccount();
    }
    
    @FXML
    private void onClickCheckout(ActionEvent e) throws Exception
    {              
        //brings the check out tab into focus
        SingleSelectionModel<Tab> selectionModel = userTabs.getSelectionModel();
        selectionModel.select(checkOutTab);       
        
    }
    
    @FXML
    private void checkOutCardInfoKey(KeyEvent e) throws Exception
    {//determines if all fields are correct and returns as aboolean
        canCheckOut = checkOutCardInfo();
    }
    
    @FXML
    private void checkOutCardInfoMouse(MouseEvent e) throws Exception
    {//does same as above only for a mouse event though
        canCheckOut = checkOutCardInfo();
    }
    
    @FXML
    private boolean checkOutCardInfo() throws Exception
    {//checks to make sure criteria are met for credit card info before allowing submission
        canCheckOut = false;
        Integer count = 0;
        if (cardName.getText().equals("")){
            nameStar.setVisible(true);
            checkOutError.setVisible(true);
            submitOrderBtn.setVisible(false);
            count++;
        }
        else
        {
            nameStar.setVisible(false);
        }
        if (!cardMonth.getText().matches("[0-9]+") || cardMonth.getText().length()<2){
            cardExpStar.setVisible(true);
            checkOutError.setVisible(true);
            submitOrderBtn.setVisible(false);
            count++;
        }
        else
        {
            if (!cardYear.getText().matches("[0-9]+") || cardYear.getText().length()<4)
            {
            cardExpStar.setVisible(true);
            checkOutError.setVisible(true);
            submitOrderBtn.setVisible(false);
            count++;
            }
            else
            {
                cardExpStar.setVisible(false);
            }
        }
        if (!cardCCV.getText().matches("[0-9]+") || cardCCV.getText().length()<3){
            CCVStar.setVisible(true);
            checkOutError.setVisible(true);
            submitOrderBtn.setVisible(false);
            count++;
        }
        else
        {
            CCVStar.setVisible(false);
        }
        if (!cardZip.getText().matches("[0-9]+") || cardZip.getText().length()<5){
            billZipStar.setVisible(true);
            checkOutError.setVisible(true);
            submitOrderBtn.setVisible(false);
            count++;
        }
        else
        {
            billZipStar.setVisible(false);
        }
        if (!cardNum.getText().matches("[0-9]+") || cardNum.getText().length()<16){
            cardNumStar.setVisible(true);
            checkOutError.setVisible(true);
            submitOrderBtn.setVisible(false);
            count++;
        }
        else
        {
            cardNumStar.setVisible(false);
        }
        if (checkOutCartTable.getItems().isEmpty())
        {
            count++;
            submitOrderBtn.setVisible(false);
        }
        if (count==0){
            canCheckOut = true;
            checkOutError.setVisible(false);
            submitOrderBtn.setVisible(true);
        }
        return canCheckOut;
    }
    
    @FXML
    private void onClickSubmitOrder(ActionEvent e) throws Exception
    {//alerts the user that they are about to submit the order and gives them a chance to cancel incase of mistaken button mashing
        canCheckOut = checkOutCardInfo();
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Order Submission");
        alert.setHeaderText("Are you sure you are want to submit this order?");
        alert.setContentText("Click OK to continue or Cancel to go back to cart.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK && canCheckOut){
            dbConnect();
            stmt = con.createStatement();
            //submits order to the db and marks it as ordered
            stmt.executeUpdate("UPDATE BB_BASKET SET ORDERPLACED = 1, SHIPFIRSTNAME = '" + chkOutFName.getText() + "', SHIPLASTNAME = '" + chkOutLName.getText() 
                    + "', SHIPADDRESS = '" + chkOutAddress.getText() + "', SHIPCITY = '" + chkOutCity.getText() + "', SHIPSTATE = '" + chkOutState.getText() 
                    + "', SHIPZIPCODE = " + chkOutZip.getText() + ", DTORDERED = SYSDATE WHERE IDBASKET = " + cartNum);
            dbDisconnect();
            Alert alert2 = new Alert(AlertType.INFORMATION);
            alert2.setTitle("Confirmed Order Submission");
            alert2.setHeaderText("Thank you for ordering from BrewBeans!");
            alert2.setContentText("Click OK to continue.");
            alert2.showAndWait();
            checkCartStatus();
            populateCart();
            populateOrderStatus();
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
    @FXML
    private EventHandler<KeyEvent> limitTextField(Integer limit){//checks to make sure CC info meets length requirements
        return (KeyEvent arg0) ->
        {
            TextField tx = (TextField) arg0.getSource();
            if (tx.getText().length() >=limit){
                arg0.consume();
            }
        };
    }
    
    @FXML
    private void refreshCart(ActionEvent event) throws Exception
    {//refreshes the quantity of an item in the cart 
        if (!changeQty.getSelectionModel().getSelectedItem().equals("Change Quantity") && cartTable.getSelectionModel().getSelectedItem()!=null)
        {
            dbConnect();
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE BB_BASKETITEM SET QUANTITY ="+changeQty.getSelectionModel().getSelectedItem()+" WHERE IDBASKET = "+cartNum+" AND IDPRODUCT = (Select IDPRODUCT FROM BB_PRODUCT WHERE PRODUCTNAME = '"+cartTable.getSelectionModel().getSelectedItem().getCartProdName()+"')");
            dbDisconnect();
        }
        populateCart();
        cartTable.getSelectionModel().select(null);
        updateQty2();
        changeQty.setValue("Change Quantity");
    }
    
    @FXML
    private void removeFromCart(ActionEvent event) throws Exception
    {//removes selected item from the cart and db
        if (cartTable.getSelectionModel().getSelectedItem()!=null)
        {
            dbConnect();
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE BB_BASKETITEM WHERE IDBASKET = "+cartNum+" AND IDPRODUCT = (Select IDPRODUCT FROM BB_PRODUCT WHERE PRODUCTNAME = '"+cartTable.getSelectionModel().getSelectedItem().getCartProdName()+"')");
            dbDisconnect();
            populateCart();
            cartTable.getSelectionModel().select(null);
            updateQty2();
            changeQty.setValue("Change Quantity");
        }
    }
    
    @FXML
    private void clearCart(ActionEvent event) throws Exception
    {//clears the entire cart contents
        
        Alert alert = new Alert(AlertType.CONFIRMATION);//alerts user that they are about to empty the cart
        alert.setTitle("Confirm Clear Cart");
        alert.setHeaderText("Are you sure you want to clear your cart?");
        alert.setContentText("Click OK to continue or Cancel to go back to cart.");
        alert.initModality(Modality.APPLICATION_MODAL);
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            dbConnect();
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE BB_BASKETITEM WHERE IDBASKET = "+cartNum);
            dbDisconnect();
            populateCart();
            cartTable.getSelectionModel().select(null);
            updateQty2();
            changeQty.setValue("Change Quantity");
        } 
        else 
        {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
    @FXML
    private void onClickLogOut(ActionEvent event) throws Exception
    {//reloads the log in scene to allow another user or exit of system
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLLogInPage.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        FXMLLogInPageController controller = fxmlLoader.<FXMLLogInPageController>getController();
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.setResizable(false);
        app_stage.getIcons().add(new Image("file:src/brewbeans/images/55-512.png"));
        scene.getStylesheets().add("brewbeans/LogInStyleSheet.css");
        app_stage.setTitle("Shop Brew Beans Log In");
        app_stage.centerOnScreen();
        app_stage.show();
    }
}