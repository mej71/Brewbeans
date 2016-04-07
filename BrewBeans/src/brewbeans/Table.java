package brewbeans;


public class Table
{
    private String productName;
    private String price;
    private int stock;
    private String prodDescription;

    public Table()
    {
        this.productName = "";
        this.price = "";
        this.stock = 0;
        this.prodDescription = "";
    }

    public Table(String name, String price, int inStk, String prodDesc)
    {
        this.productName = name;        
        this.price = price;
        this.stock = inStk;        
        this.prodDescription = prodDesc;        
    }

    public String getProductName() 
    {
        return productName;
    }

    public void setProductName(String name) 
    {
        this.productName = name;
    }

    public String getPrice() 
    {
        return price;
    }

    public void setPrice(String price) 
    {
        this.price = price;
    }

    public int getStock() 
    {
        return stock;
    }

    public void setStock(int inStk) 
    {
        this.stock = inStk;
    }
    
    public String getProdDescription() 
    {
        return prodDescription;
    }

    public void setProdDescription(String prodDesc) 
    {
        this.prodDescription = prodDesc;
    }
}
