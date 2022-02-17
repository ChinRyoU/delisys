package deliverySystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;

/**
 *
 * @author 20jz0134
 */
public class OrderDAO {
    private static Connection           con;
    private static PreparedStatement    ps;
    
    public OrderDAO() {
        DBManager dBManager = DBManager.getDBManager();
        con                 = dBManager.getConnection();
    }
    /**
     * Orderテーブル検索処理実行
     * @return 検索結果のテスト
     */
    public List<Order> selectOrderExecute() {
        List<Order> orderList = new ArrayList<>();
        try {
            orderList.clear();
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Order order = new Order();
                setOrder(order, rs);
                orderList.add(order);
            }
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
    
    public void setOrder(Order order, ResultSet rs){
        try{
            String orderNum      = rs.getString("ORDER_NUM");
            Timestamp   orderDate     = rs.getTimestamp("ORDER_DATE");
            Timestamp deliveryDate  = rs.getTimestamp("DELIVERY_DATE");
            int    customerNo    = rs.getInt("CUSTOMER_NO");
            Date   paymentTime   = rs.getDate("PAYMENT_TIME");
            String deliveryAdd   = rs.getString("DELIVERY_ADD");
            String employeeNo    = rs.getString("EMPLOYEE_NO");
            int    requestPrice  = rs.getInt("REQUEST_PRICE");
            order.setOrderNum(orderNum);
            order.setOrderDate(orderDate);
            order.setDeliveryDate(deliveryDate);
            order.setCustomerNo(customerNo);
            order.setPaymentTime(paymentTime);
            order.setDeliveryAdd(deliveryAdd);
            order.setEmployeeNo(employeeNo);
            order.setRequestPrice(requestPrice);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * 全件検索
     * @return 検索結果リスト
     */
    public List<Order> dbSearchOrderAll(){
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * " + 
                     "FROM ORDERS " + 
                     "ORDER BY ORDER_NUM";
        try{
            ps = con.prepareStatement(sql);
            orderList = selectOrderExecute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return orderList;
    }
    /**
     * ORDERSテーブル、データ挿入メソッド
     * @param orders
     * @return 挿入件数
     */
    public int dbInsertOrder(Order order) {
        String sql = "INSERT INTO ORDERS(order_num, order_date, delivery_date, customer_no, delivery_add, request_price) " +
                     "values(?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, order.getOrderNum());
            ps.setTimestamp(2, order.getOrderDate());
            ps.setTimestamp(3, order.getDeliveryDate());
            //ps.setDate(3, order.getDeliveryDate());
            ps.setInt(4, order.getCustomerNo());
            ps.setString(5, order.getDeliveryAdd());
            ps.setInt(6, order.getRequestPrice());
 
            return ps.executeUpdate();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    /**
     * ORDER_NUM指定による検索
     * @param orderNum  検索キー注文番号
     * @return          検索結果リスト
     */
    public List<Order> dbSearchOrderNum(String orderNum) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * " +
                     "FROM ORDERS " +
                     "WHERE ORDER_NUM LIKE ?" +
                     "ORDER BY ORDER_NUM";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + orderNum + "%");
            
            orderList = selectOrderExecute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return orderList;
    }
    /**
     * PAYMENT_TIMEによる検索
     * @param paymentTime 検索キー入金時間
     * @return            検索結果リスト
     */
    public List<Order> dbSearchNotPayment(Date paymentTime) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * " +
                     "FROM ORDERS " +
                     "WHERE PAYMENT_TIME = ?" + 
                     "ORDER BY ORDER_NUM";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "null");
            
            orderList = selectOrderExecute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return orderList;
    }
    /**
     * ORDERSテーブル、ORDER_NUM指定でPAYMENT_TIME, EMPLOYEE_NOを更新
     * @param paymentTime
     * @param employeeNo
     * @param orderNum
     * @return 
     */
    public int dbUpdateOrders(Date paymentTime, String employeeNo, String orderNum) {
        String sql = "UPDATE ORDERS " + 
                     "SET PAYMENT_TIME = ?, EMPLOYEE_NO = ? " +
                     "WHERE ORDER_NUM = ?";
        try {
            ps = con.prepareStatement(sql);         //SQLを実行するためのステートメント作成
            ps.setDate(1, paymentTime);               //1つ目のパラメータへの値設定
            ps.setString(2, employeeNo);                       //2つ目のパラメータへの値設定
            ps.setString(3, orderNum);
            return ps.executeUpdate();              //更新用SQLの実行
        }
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
