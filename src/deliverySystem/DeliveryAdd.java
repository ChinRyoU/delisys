package deliverySystem;

/**
 * デリバリーアドレスクラス
 * @author 20jz0130
 */
public class DeliveryAdd {
    String customer_no;
    int delivery_code;
    String delivery_address;
    
    public DeliveryAdd(){
        
    }
    public DeliveryAdd(String customer_no, int delivery_code, String address){
        setCustomer_no(customer_no);
        setDelivery_code(delivery_code);
        setDeliveryAddress(address);
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public void setDelivery_code(int delivery_code) {
        this.delivery_code = delivery_code;
    }

    public void setDeliveryAddress(String address) {
        this.delivery_address = address;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public int getDelivery_code() {
        return delivery_code;
    }

    public String getDeliveryAddress() {
        return delivery_address;
    }
    public String toString(){
        return getCustomer_no() + ", " + getDelivery_code() + ", " + getDeliveryAddress();
    }
}
