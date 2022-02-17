package deliverySystem;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author 20jz0134
 */
public class Order {
    private String      orderNum;
    private Timestamp   orderDate;
    private Timestamp   deliveryDate;
    private int         customerNo;
    private Date        paymentTime;
    private String      deliveryAdd;
    private String      employeeNo;
    private int         requestPrice;

    public void setRequestPrice(int requestPrice) {
        this.requestPrice = requestPrice;
    }

    public int getRequestPrice() {
        return requestPrice;
    }
    
    public Order() {
        
    }
    
    public Order(String orderNum, Timestamp orderDate, Timestamp deliveryDate, int customerNo, Date paymentTime, String deliveryAdd, String employeeNo, int requestPrice) {
        setOrderNum(orderNum);
        setOrderDate(orderDate);
        setDeliveryDate(deliveryDate);
        setCustomerNo(customerNo);
        setPaymentTime(paymentTime);
        setDeliveryAdd(deliveryAdd);
        setEmployeeNo(employeeNo);
        setRequestPrice(requestPrice);
    }
    
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
    
    public void setDeliveryAdd(String deliveryAdd) {
        this.deliveryAdd = deliveryAdd;
    }
    
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }
    
    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }
    
    public Date getPaymentTime() {
        return paymentTime;
    }
    
    public int getCustomerNo() {
        return customerNo;
    }
    
    public String getDeliveryAdd() {
        return deliveryAdd;
    }
    
    public String getEmployeeNo() {
        return employeeNo;
    }
    
    @Override
    public String toString() {
        return getOrderNum() + ", " + getOrderDate() + ", " + getDeliveryDate() + ", " + getCustomerNo() + ", " + getPaymentTime() + ", "
                             + getCustomerNo() + ", " + getDeliveryAdd() + ", " + getEmployeeNo();
    }
}
