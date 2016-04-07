package brewbeans;

import java.util.Date;

/**
 *
 * @author Wes
 */
public class OrderStatusFill
{
    private String notesCol;
    private String carrierCol;
    private String trackNumCol;
    private String orderStatCol;
    private Date dtOrderedCol;

    public OrderStatusFill()
    {
        this.notesCol = "";
        this.carrierCol = "";
        this.trackNumCol = "";
        this.orderStatCol = "";
        this.dtOrderedCol = null;
    }

    public OrderStatusFill(String notesCol, String carrierCol, String trackNumCol, String orderStatCol, Date dtOrderedCol)
    {
        this.notesCol = notesCol;        
        this.carrierCol = carrierCol;
        this.trackNumCol = trackNumCol;        
        this.orderStatCol = orderStatCol; 
        this.dtOrderedCol = dtOrderedCol;
    }

    public String getNotesCol() 
    {
        return notesCol;
    }

    public void setNotesCol(String notesCol) 
    {
        this.notesCol = notesCol;
    }

    public String getCarrierCol() 
    {
        return carrierCol;
    }

    public void setCarrierCol(String carrierCol) 
    {
        this.carrierCol = carrierCol;
    }

    public String getTrackNumCol() 
    {
        return trackNumCol;
    }

    public void setTrackNumCol(String trackNumCol) 
    {
        this.trackNumCol = trackNumCol;
    }
    
    public String getOrderStatCol() 
    {
        return orderStatCol;
    }

    public void setOrderStatCol(String orderStatCol) 
    {
        this.orderStatCol = orderStatCol;
    }
    
    public Date getDtOrderedCol() 
    {
        return dtOrderedCol;
    }

    public void setDtOrderedCol(Date dtOrderedCol) 
    {
        this.dtOrderedCol = dtOrderedCol;
    }
}
