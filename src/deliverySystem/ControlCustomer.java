package deliverySystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Super
 */
public class ControlCustomer {
    ControldeliverySystem control;
    private CustomerDAO customerDAO;
    private List<Customer>      customerList;
    private BoundaryOrder       boundaryorder;
    private BoundaryAddCustomer boundaryaddcustomer;
    
    public ControlCustomer(){
        customerDAO          = new CustomerDAO();
        customerList         = new ArrayList<>();
        boundaryaddcustomer  = new BoundaryAddCustomer();
        
    }
    public void setControl(ControldeliverySystem control, BoundaryOrder boundaryorder){
        this.control = control;
        this.boundaryorder   = boundaryorder; 
        control.setBoundaryAddCustomer(boundaryaddcustomer);
    }
    public void insertCustomer(String customer_tel, String customer_name, String address){
        if(customerDAO.dbSearchCustomerTEL(customer_tel).size() == 0) {
            try{
                
                int customer_no;
                customerList = customerDAO.dbSearchCustomerAll();
                customer_no = customerList.size() + 1;
                Customer customer = new Customer(customer_no, customer_name, customer_tel, address);
                if(customerDAO.dbInsertCustomer(customer) == 1){
                    boundaryaddcustomer.showMessage("登録しました");
                }else{
                    boundaryaddcustomer.showMessage("書式が正しくありません。");
                }       
            }
            catch(Exception e){
                boundaryaddcustomer.showMessage(e.toString());
            }
        }else{
            boundaryaddcustomer.showMessage("電話番号が登録されています。");
        }
    }
    public int getCustomerno(String tel){
        Customer customer = customerDAO.dbSearchCustomerTEL(tel).get(0);
        return customer.getCustomer_no();
    }
    
    public void showCustomer(String tel){

        try{
            customerList = customerDAO.dbSearchCustomerTEL(tel);
            boundaryorder.showCustomerName(customerList.get(0).getName());
            boundaryorder.showCustomerAdd(customerList.get(0).getAddress());
            boundaryorder.setNameUnable();
        }
        catch(Exception e){
            boundaryorder.showConfirmMessage("電話番号が登録されていません。");
            setTel(tel);
        }
    }
    public void setTel(String tel){
        boundaryaddcustomer.setTel(tel);
    }
    
}
