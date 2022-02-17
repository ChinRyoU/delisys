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
 * 顧客DAO
 * @author 20jz0130
 */
public class CustomerDAO {
    private static Connection           con;
    private static PreparedStatement    ps;
   /**
     * コンストラクタ
     * データベース接続情報設定
     */
    public CustomerDAO() {
        DBManager dbManager = DBManager.getDBManager();
        con                 = dbManager.getConnection();
    }
    public List<Customer> selectCustomerExecute(){
        List<Customer> customerList = new ArrayList<>();
        try{
            customerList.clear();
            ResultSet rs = ps.executeQuery();
            //結果の表示
            while(rs.next()){
                Customer customer = new Customer();
                setCustomer(customer, rs);
                customerList.add(customer);
            }
            //後片付け
            rs.close();
        }
        catch(SQLException e){
                e.printStackTrace();
        }
        return customerList;
    }
    /**
     * 問い合わせ結果をcustomerに設定
     * @param customer 問い合わせ結果を格納
     * @param rs    問い合わせ結果
     */
    public void setCustomer(Customer customer, ResultSet rs){
        try{
            int customer_no    = rs.getInt("CUSTOMER_NO");
            String name        = rs.getString("NAME");
            String tel         = rs.getString("TEL");
            String address     = rs.getString("ADDRESS");
            customer.setCustomer_no(customer_no);
            customer.setName(name);
            customer.setTel(tel);
            customer.setAddress(address);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * Customersテーブル、データ挿入メソッド
     * @param customer
     * @return 挿入件数
     */
    public int dbInsertCustomer (Customer customer){
        String sql = "INSERT INTO CUSTOMERS" +
                     " values(?, ?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, customer.getCustomer_no());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getTel());
            ps.setString(4, customer.getAddress());
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
    public List<Customer> dbSearchCustomerAll(){
        List<Customer> customerList = new ArrayList<>();
        String sql = "SELECT * " + 
                     "FROM CUSTOMERS ";
        try{
            ps = con.prepareStatement(sql);
            customerList = selectCustomerExecute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }
    /**
     * tel指定による検索
     * @param tel　検索キーtel
     * @return 検索結果リスト
     */
    public List<Customer> dbSearchCustomerTEL(String tel){
        List<Customer> customerList = new ArrayList<>();
        String sql = "SELECT * " + 
                     " FROM CUSTOMERS" +
                     " WHERE tel = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, tel);
            customerList = selectCustomerExecute();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }
    public static void main(String[] args) {
        CustomerDAO cdao = new CustomerDAO();
        String tel = "0333693333";
        List<Customer> customerList = new ArrayList<>();
        
        
        customerList = cdao.dbSearchCustomerTEL(tel);
        System.out.println(customerList);
    }
}
