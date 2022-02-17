package deliverySystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
/**
 * デリバリーアドレスDAO
 * @author 20jz0130
 */
public class DeliveryAddDAO {
    private static Connection           con;
    private static PreparedStatement    ps;
    
    /**
     * コンストラクタ
     * データベース接続情報設定
     */
    public DeliveryAddDAO() {
        DBManager dbManager = DBManager.getDBManager();
        con                 = dbManager.getConnection();
    }
    public List<DeliveryAdd> selectDeliveryAddExecute(){
        List<DeliveryAdd> deliveryaddList = new ArrayList<>();
        try{
            deliveryaddList.clear();
            ResultSet rs = ps.executeQuery();
            //結果の表示
            while(rs.next()){
                DeliveryAdd deliveryadd = new DeliveryAdd();
                setDeliveryAdd(deliveryadd, rs);
                deliveryaddList.add(deliveryadd);
            }
            //後片付け
            rs.close();
        }
        catch(SQLException e){
                e.printStackTrace();
        }
        return deliveryaddList;
    }
        /**
     * 問い合わせ結果をDeliveryAddに設定
     * @param deliveryadd 問い合わせ結果を格納
     * @param rs    問い合わせ結果
     */
    public void setDeliveryAdd(DeliveryAdd deliveryadd, ResultSet rs){
        try{
            String  customer_no     = rs.getString("CUSTOMER_NO");
            Integer delivery_code   = rs.getInt("DELIVERY_CODE");
            String  address         = rs.getString("ADDRESS");
            deliveryadd.setCustomer_no(customer_no);
            deliveryadd.setDelivery_code(delivery_code);
            deliveryadd.setDeliveryAddress(address);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * DELI_ADDSテーブル、データ挿入メソッド
     * @param deliveryadd
     * @return 挿入件数
     */
    public int dbInsertDeliveryAdd (DeliveryAdd deliveryadd){
        String sql = "INSERT INTO DELI_ADDS" +
                     " values(?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, deliveryadd.getCustomer_no());
            ps.setInt(2, deliveryadd.getDelivery_code());
            ps.setString(3, deliveryadd.getDeliveryAddress());
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
    /**
     * 全件検索
     * @return 検索結果リスト
     */
    public List<DeliveryAdd> dbSearchDeliveryAddAll(){
        List<DeliveryAdd> deliveryaddList = new ArrayList<>();
        String sql = "SELECT * " + 
                     "FROM DELI_ADDS ";
        try{
            ps = con.prepareStatement(sql);
            deliveryaddList = selectDeliveryAddExecute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return deliveryaddList;
    }
    
}
