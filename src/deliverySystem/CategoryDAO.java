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
 * カテゴリーDAO
 * @author 20jz0130
 */
public class CategoryDAO {
    private static Connection           con;
    private static PreparedStatement    ps;
    
   /**
     * コンストラクタ
     * データベース接続情報設定
     */
    public CategoryDAO() {
        DBManager dbManager = DBManager.getDBManager();
        con                 = dbManager.getConnection();
    }
    /**
     * Categoryテーブル検索処理実行
     * @return 検索結果のテスト
     */
    public List<Category> selectCategoryExecute(){
        List<Category> categoryList = new ArrayList<>();
        try{
            categoryList.clear();
            ResultSet rs = ps.executeQuery();
            //結果の表示
            while(rs.next()){
                Category category = new Category();
                setCategory(category, rs);
                categoryList.add(category);
            }
            //後片付け
            rs.close();
        }
        catch(SQLException e){
                e.printStackTrace();
        }
        return categoryList;
    }
    /**
     * 問い合わせ結果をCategoryに設定
     * @param category 問い合わせ結果を格納
     * @param rs    問い合わせ結果
     */
    public void setCategory(Category category, ResultSet rs){
        try{
            String category_no = rs.getString("CATEGORY_NO");
            String  name        = rs.getString("NAME");
            category.setCategory_no(category_no);
            category.setName(name);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * 全件検索
     * @return 検索結果リスト
     */
    public List<Category> dbSearchCategoryAll(){
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * " + 
                     "FROM CATEGORIES ORDER BY CATEGORY_NO";
        try{
            ps = con.prepareStatement(sql);
            categoryList = selectCategoryExecute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }
    /**
     * name指定による検索
     * @return 検索結果リスト
     */
    public List<Category> dbSearchCategoryname(String name){
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * " + 
                     "FROM CATEGORIES " +
                     " WHERE NAME = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            categoryList = selectCategoryExecute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }
}

