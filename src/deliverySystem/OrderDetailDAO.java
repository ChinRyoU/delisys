package deliverySystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author 20jz0134
 */
public class OrderDetailDAO {
    private static Connection           con;
    private static PreparedStatement    ps;
    
    public OrderDetailDAO() {
        DBManager dBManager = DBManager.getDBManager();
        con                 = dBManager.getConnection();
    }
    
    public List<OrderDetail> selectOrderDetailExecute() {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList.clear();
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                setOrderDetail(orderDetail, rs);
                orderDetailList.add(orderDetail);
            }
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetailList;
    }
    /**
     * 問い合わせ結果を　OrderDetailに設定
     * @param orderDetail   問い合わせ結果を格納
     * @param rs            問い合わせ結果
     */
    public void setOrderDetail(OrderDetail orderDetail, ResultSet rs) {
        try {
            String orderNum     = rs.getString("ORDER_NUM");
            String productNo    = rs.getString("PRODUCT_NO");
            int count           = rs.getInt("COUNT");
            orderDetail.setOrderNum(orderNum);
            orderDetail.setProductNo(productNo);
            orderDetail.setCount(count);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 全件検索　
     * @return 検索結果リスト
     */
    public List<OrderDetail> dbSearchOrderDetailAll() {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        String sql = "SELECT * " + 
                     "FROM ORDER_DETAILS ";
        try {
            ps = con.prepareStatement(sql);
            orderDetailList = selectOrderDetailExecute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetailList;
    }
    /**
     * order_no指定による検索
     * @param order_num　検索キーorder_no
     * @return 検索結果リスト
     */
    public List<OrderDetail> dbSearchOrderDetailOrdernum(String order_num){
        List<OrderDetail> orderdetailList = new ArrayList<>();
        String sql = "SELECT * " + 
                     " FROM ORDER_DETAILS" +
                     " WHERE order_num = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, order_num);
            orderdetailList = selectOrderDetailExecute();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return orderdetailList;
    }
    /**
     * OrderDetailsテーブル、データ挿入メソッド
     * @param orderdetail
     * @return 挿入件数
     */
    public int dbInsertOrderDetails (OrderDetail orderdetail){
        String sql = "INSERT INTO ORDER_DETAILS" +
                     " values(?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, orderdetail.getOrderNum());
            ps.setString(2, orderdetail.getProductNo());
            ps.setInt(3, orderdetail.getCount());
            return ps.executeUpdate();
            
        }
        catch(SQLIntegrityConstraintViolationException e){
            return 0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
}
