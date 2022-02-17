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
 * 従業員DAO
 * @author 20jz0130
 */
public class EmployeeDAO {
    private static Connection           con;
    private static PreparedStatement    ps;
    
    /**
     * コンストラクタ
     * データベース接続情報設定
     */
    public EmployeeDAO() {
        DBManager dbManager = DBManager.getDBManager();
        con                 = dbManager.getConnection();
    }
    public List<Employee> selectEmployeeExecute(){
        List<Employee> employeeList = new ArrayList<>();
        try{
            employeeList.clear();
            ResultSet rs = ps.executeQuery();
            //結果の表示
            while(rs.next()){
                Employee employee = new Employee();
                setEmployee(employee, rs);
                employeeList.add(employee);
            }
            //後片付け
            rs.close();
        }
        catch(SQLException e){
                e.printStackTrace();
        }
        return employeeList;
    }
        /**
     * 問い合わせ結果をEmployeeに設定
     * @param employee 問い合わせ結果を格納
     * @param rs    問い合わせ結果
     */
    public void setEmployee(Employee employee, ResultSet rs){
        try{
            String  employee_no      = rs.getString("EMPLOYEE_NO");
            String  password         = rs.getString("PASSWORD");
            String  name             = rs.getString("NAME");
            Integer post             = rs.getInt("POST");
            employee.setEmployee_no(employee_no);
            employee.setPassword(password);
            employee.setName(name);
            employee.setPost(post);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * employeeno,password確認
     * @return 検索結果リスト
     */
    public List<Employee> dbSearchEmployeeNoPass(String no, String pass){
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * " + 
                     "FROM EMPLOYEES " +
                     "WHERE employee_no = ?" +
                     " AND  password = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, no);
            ps.setString(2, pass);
            employeeList = selectEmployeeExecute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return employeeList;
    }
        /**
     * employeeno,password確認
     * @return 検索結果リスト
     */
    public List<Employee> dbSearchEmployeeNo(String no){
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * " + 
                     "FROM EMPLOYEES " +
                     "WHERE employee_no = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, no);
            employeeList = selectEmployeeExecute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return employeeList;
    }
}
