package deliverySystem;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Super
 */
public class ControlOrder {
    ControldeliverySystem control;
    private List<Order>         orderList;
    private List<OrderDetail>   orderdetailList;
    private List<Category>      categoryList;
    private List<Product>       productList;
    private OrderDAO            orderDAO;
    private OrderDetailDAO      orderdetailDAO;
    private CategoryDAO         categoryDAO;
    private ProductDAO          productDAO;
    private BoundaryOrder       boundaryorder;
    private BoundaryPayments     boundarypayments;
    public List<Order> getOrderdata(){
        return orderList = orderDAO.dbSearchOrderAll();
    }
    public void setControl(ControldeliverySystem control){
        this.control = control;
        control.setBoundaryOrder(boundaryorder);
        control.setBoundaryPayments(boundarypayments);
    }

    public ControlOrder(){
        orderList            = new ArrayList<>();
        orderdetailList      = new ArrayList<>();
        categoryList         = new ArrayList<>();
        productList          = new ArrayList<>();
        categoryDAO          = new CategoryDAO();
        productDAO           = new ProductDAO();
        orderDAO             = new OrderDAO();
        orderdetailDAO       = new OrderDetailDAO();
        boundaryorder        = new BoundaryOrder();
        boundarypayments     = new BoundaryPayments();
    }
    public void setboundaryorder(BoundaryOrder boundaryorder){
        
    }
    public List<OrderDetail> getOrderdetaildata(String order_no){        
        return orderdetailList = orderdetailDAO.dbSearchOrderDetailOrdernum(order_no);
    }
    public List<Order> getOrdernum(String ordernum){
        return orderList = orderDAO.dbSearchOrderNum(ordernum);
    }
    public List<Order> getOrderAll(){
        return orderList = orderDAO.dbSearchOrderAll();
    }
    public int updateorders(Date paymentTime, String employeeNo, String orderNum){
        return orderDAO.dbUpdateOrders(paymentTime, employeeNo, orderNum);
    }
    /**
     * order追加する
     * @param order_num
     * @param order_date
     * @param deli_date
     * @param customer_no
     * @param delivery_add 
     */
    public String insertOrder(Timestamp order_date,Timestamp deli_date, int customer_no,String delivery_add, int request_price){
        Order order = new Order();
        orderList = orderDAO.dbSearchOrderAll();
        String ordernum;
        int orderno = orderList.size() + 1;
        ordernum = "GK" + String.format("%04d", orderno);
        order.setOrderNum(ordernum);
        order.setOrderDate(order_date);
        order.setDeliveryDate(deli_date);
        order.setCustomerNo(customer_no);
        order.setDeliveryAdd(delivery_add);
        order.setRequestPrice(request_price);
        orderDAO.dbInsertOrder(order);
        return ordernum;
    }

    public void showCategory(){
        categoryList = categoryDAO.dbSearchCategoryAll();
        String[] categoryNames = new String[categoryList.size()];
        for(int i = 0; i < categoryList.size(); i++){
            categoryNames[i] = categoryList.get(i).getName();
        }
        boundaryorder.showcategory(categoryNames);
    }
    
    public void insertOrderDetail(OrderDetail orderdetail){
        orderdetailDAO.dbInsertOrderDetails(orderdetail);
    }
    public Product getProductdata(String name){
        Product product = productDAO.dbSearchProductName(name).get(0);
        return product;
    }
    
    public String getCategoryno(String category_name){
        List<Category> category = categoryDAO.dbSearchCategoryname(category_name);
        return category.get(0).getCategory_no();
    }
    public int getProductPrice(String num){
        Product product = productDAO.dbSearchProductName(num).get(0);
        return product.getPrice();
    }
    public void showProduct(String categoryno){
        productList = productDAO.dbSearchProductCategory(categoryno);
        String[] productNames = new String[productList.size()];
        for(int i = 0; i < productList.size(); i++){
            productNames[i] = productList.get(i).getName();
        }
        boundaryorder.showproduct(productNames);
    }
    
    public List<Category> searchCategoryAll(){
        categoryList = categoryDAO.dbSearchCategoryAll();
        return categoryList;
    }
    
    public List<Product> searchProductCategory(String categoryno){
        productList = productDAO.dbSearchProductCategory(categoryno);
        return productList;
    }
}
