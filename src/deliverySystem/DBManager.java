package deliverySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * シングルトンパターンを適用した
 * データベース接続管理クラス
 * @author 20jz0134
 */
public class DBManager {
    private static DBManager        dbManager       = null;
    private static Connection       con             = null;
    private static final String     driveUrl        = "jdbc:oracle:thin:@//10.40.112.11:1521/dbsys";
    private static final String     dbUserName      = "g2006";
//     private static final String     dbUserName      = "jz200134";
    private static final String     dbUserPassword  = "g2006";
//    private static final String     dbUserPassword  = "pass";
    
    /**
     * コンストラクタ
     * ドライブマネージャにJDBCドライバを登録し、URLで指定された場所に存在するデータベースに接続する
     *  アクセス修飾子がprivateなので、内部メソッドからしか生成することができない
     */
    private DBManager() {
        try {
            con = DriverManager.getConnection(driveUrl, dbUserName, dbUserPassword);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * DB接続インスタンスの生成を兼ねたゲッター
     * @return DB接続管理インスタンス
     */
    public static DBManager getDBManager() {
        if (DBManager.dbManager == null) {
            DBManager.dbManager = new DBManager();
        }
        
        return DBManager.dbManager;
    }
    /**
     * コネクションのゲッター
     * @return コネクション
     */
    public Connection getConnection() {
        return con;
    }
    /**
     * テスト用main
     * @param args 
     */
    public static void main(String[] args) {
        DBManager dBManager = DBManager.getDBManager();
        con = dbManager.getConnection();
        System.out.println("Finish!!");
    }
    
}