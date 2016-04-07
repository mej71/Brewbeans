package brewbeans;


public class Cart 
{
    private String cartProdName;
    private String price;
    private int cartQty;
    private String cartProdTotal;
    private String grindOptionCol;
    private String sizeCol;

    public Cart()
    {
        this.cartProdName = "";
        this.price = "";
        this.cartQty = 0;
        this.cartProdTotal = "";
        this.grindOptionCol = "";
        this.sizeCol = "";
    }    

    public Cart(String name, String price, int qty, String total, int op1, int op2)
    {
        this.cartProdName = name;        
        this.price = price;
        this.cartQty = qty;        
        this.cartProdTotal = total;  
        
        if(op2 == 3)
        {
            this.grindOptionCol = "Whole Bean";
        }
        else 
        {
            this.grindOptionCol = "Regular Grind";
        } 
        
        if(op1 == 1)
        {
            this.sizeCol = "1/2 lb";
        }
        else 
        {
            this.sizeCol = "1 lb";
        }
    }

    public String getCartProdName() 
    {
        return cartProdName;
    }

    public void setCartProdName(String name) 
    {
        this.cartProdName = name;
    }

    public String getCartPriceEach() 
    {
        return price;
    }

    public void setcartCartProdName(String price) 
    {
        this.price = price;
    }

    public int getNumInCart() 
    {
        return cartQty;
    }

    public void setNumInCart(int qty) 
    {
        this.cartQty = qty;
    }
    
    public String getCartProdTotal() 
    {
        return cartProdTotal;
    }

    public void setCartProdTotal(String crtPrdTtl) 
    {
        this.cartProdTotal = crtPrdTtl;
    }
    
    public String getGrindOptionCol()
    {
        return grindOptionCol;
    }
    
    public void setGrindOptionCol(int op2)
    {
        if(op2 == 3)
        {
            this.grindOptionCol = "Whole Bean";
        }
        else 
        {
            this.grindOptionCol = "Regular Grind";
        }        
    }
    
    public String getSizeCol()
    {
        return sizeCol;
    }
    
    public void setSizeCol(int op1)
    {
        if(op1 == 1)
        {
            this.sizeCol = "1/2 lb";
        }
        else 
        {
            this.sizeCol = "1 lb";
        }        
    }
}
