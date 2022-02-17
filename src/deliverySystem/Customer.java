package deliverySystem;

/**
 * 顧客クラス
 * @author 20jz0130
 */
public class Customer {
    int customer_no;
    String name;
    String tel;
    String address;
    
    public Customer(){
        
    }
    public Customer(int customer_no, String name, String tel, String address){
        setCustomer_no(customer_no);
        setName(name);
        setTel(tel);
        setAddress(address);
    }

    public void setCustomer_no(int customer_no) {
        this.customer_no = customer_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomer_no() {
        return customer_no;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }
    @Override
    public String toString(){
        return getCustomer_no() + ", " + getName() + ", " + getTel() + ", " + getAddress();
    }
}
