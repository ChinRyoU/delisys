package deliverySystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20jz0134
 */
public class ProductDAO {
    private static Connection           con;
    private static PreparedStatement    ps;
    
    public ProductDAO() {
        DBManager dBManager = DBManager.getDBManager();
        con                 = dBManager.getConnection();
    }
    
    public List<Product> selectProductExecute() {
        List<Product> productList = new ArrayList<>();
        try {
            productList.clear();
            ResultSet rs = ps.executeQuery();
            //結果の表示
            while (rs.next()) {
                Product product = new Product();
                setProduct(product, rs);
                productList.add(product);
            }
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
        /**
     * 問い合わせ結果を Productに設定
     * @param product　問い合わせ結果を格納
     * @param rs 　　　　問い合わせ結果
     */
    public void setProduct(Product product, ResultSet rs) {
        try {
            String productNo    = rs.getString("PRODUCT_NO");
            String name         = rs.getString("NAME");
            int price           = rs.getInt("PRICE");
            String categoryno   = rs.getString("CATEGORY_NO");
            product.setProductNo(productNo);
            product.setName(name);
            product.setPrice(price);
            product.setCategoryNo(categoryno);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * category指定による検索
     * @param categoryno　検索キーcate
     * @return 検索結果リスト
     */
    public List<Product> dbSearchProductCategory(String categoryno){
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * " + 
                     " FROM PRODUCTS" +
                     " WHERE CATEGORY_NO = ?" + 
                     " ORDER BY PRODUCT_NO";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, categoryno);
            productList = selectProductExecute();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return productList;
    }
    /**
     * name指定による検索
     * @param name　検索キーcate
     * @return 検索結果リスト
     */
    public List<Product> dbSearchProductName(String name){
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * " + 
                     " FROM PRODUCTS" +
                     " WHERE NAME = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            productList = selectProductExecute();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return productList;
    }
    /**
     * no指定による検索
     * @param no　検索キーPRODUCT_NO
     * @return 検索結果リスト
     */
    public List<Product> dbSearchProductNo(String no){
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * " + 
                     " FROM PRODUCTS" +
                     " WHERE PRODUCT_NO = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, no);
            productList = selectProductExecute();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return productList;
    }
}
