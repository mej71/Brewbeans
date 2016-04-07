/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brewbeans;

/**
 *
 * @author Wes
 */
public class CheckOutCart
{
    private String cartProdName2;
    private String price2;
    private int cartQty2;
    private String cartProdTotal2;    

    public CheckOutCart()
    {
        this.cartProdName2 = "";
        this.price2 = "";
        this.cartQty2 = 0;
        this.cartProdTotal2 = "";
       
    }
    
    public CheckOutCart(String name, String priceLV, int qty, String total)
    {
        this.cartProdName2 = name;        
        this.price2 = priceLV;
        this.cartQty2 = qty;        
        this.cartProdTotal2 = total;
    }
    
    public String getCartProdName2() 
    {
        return cartProdName2;
    }

    public void setCartProdName2(String name) 
    {
        this.cartProdName2 = name;
    }

    public String getCartPriceEach2() 
    {
        return price2;
    }

    public void setCartPriceEach2(String priceLV) 
    {
        this.price2 = priceLV;
    }

    public int getNumInCart2() 
    {
        return cartQty2;
    }

    public void setNumInCart2(int qty) 
    {
        this.cartQty2 = qty;        
    }
    
    public String getCartProdTotal2() 
    {
        return cartProdTotal2;
    }

    public void setCartProdTotal2(String crtPrdTtl) 
    {
        this.cartProdTotal2 = crtPrdTtl;        
    }
}
