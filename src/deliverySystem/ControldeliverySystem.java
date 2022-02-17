package deliverySystem;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
/**
 *
 * @author 20jz0130
 */
public class ControldeliverySystem {
    private BoundarySystemMenu  boundarysystemmenu;         //システムメニュー画面
    private BoundaryAddCustomer boundaryaddcustomer;        //顧客登録画面
    private BoundaryLogin       boundarylogin;              //従業員ログイン画面
    private BoundaryOrder       boundaryorder;              //注文画面
    private BoundaryPayments    boundarypayments;           //入金画面
    private BoundaryForm        boundaryform;               //注文明細
    private List<Category>      categoryList;               //種類
    private List<Product>       productList;                //商品
    private ControlCustomer     controlcustomer;            //顧客コントロール
    private ControlOrder        controlorder;               //注文、入金コントロール
    private ControlEmployee     controlemployee;            //従業員コントロール
    
    public ControldeliverySystem(){
        boundarysystemmenu  = new BoundarySystemMenu();
        boundaryform        = new BoundaryForm();
        categoryList        = new ArrayList<>();
        productList         = new ArrayList<>();
        controlorder        = new ControlOrder();
        controlcustomer     = new ControlCustomer();
        controlemployee     = new ControlEmployee();
    }
    //システム起動
    public void start(){
        controlorder.setControl(this);
        controlcustomer.setControl(this, boundaryorder);
        controlemployee.setControl(this);
        boundarysystemmenu.setControl(this);
        boundaryaddcustomer.setControl(this, controlcustomer);
        boundarypayments.setControl(this, controlorder);
        boundarylogin.setControl(this, controlemployee);
        boundaryorder.setControl(this, controlorder);        
        showCategory();
        showProduct(categoryList.get(0).getCategory_no());
        boundaryform.setControl(this, controlorder);
        boundarysystemmenu.setVisible(true);
    }
    
    public void setBoundaryOrder(BoundaryOrder boundaryorder){
        this.boundaryorder = boundaryorder;
    }
    public void setBoundaryLogin(BoundaryLogin boundarylogin){
        this.boundarylogin = boundarylogin;
    }
    public void setBoundaryAddCustomer(BoundaryAddCustomer boundaryaddcustomer){
        this.boundaryaddcustomer = boundaryaddcustomer;
    }
    public void setBoundaryPayments(BoundaryPayments boundarypayments){
        this.boundarypayments = boundarypayments;
    }
    //注文画面に種類を表示する
    public void showCategory(){
        categoryList = controlorder.searchCategoryAll();
        String[] categoryNames = new String[categoryList.size()];
        for(int i = 0; i < categoryList.size(); i++){
            categoryNames[i] = categoryList.get(i).getName();
        }
        boundaryorder.showcategory(categoryNames);
    }
    //注文画面に商品を表示する
    public void showProduct(String categoryno){
        productList = controlorder.searchProductCategory(categoryno);
        String[] productNames = new String[productList.size()];
        for(int i = 0; i < productList.size(); i++){
            productNames[i] = productList.get(i).getName();
        }
        boundaryorder.showproduct(productNames);
    }
    //システム画面から従業員ログイン画面に移動
    public void showBoundaryLogin(){
        boundarysystemmenu.setVisible(false);   
        boundarylogin.setVisible(true);
    }
    //従業員ログイン画面からシステム画面に戻る
    public void closeBoundaryLogin(){
        boundarylogin.setVisible(false);
        boundarysystemmenu.setVisible(true);
    }
    //システム画面から注文画面に移動
    public void showBoundaryOrder(){
        boundaryorder.removeOrder();
        boundarysystemmenu.setVisible(false);   
        boundaryorder.setVisible(true);
    }
    //注文画面からシステム画面に戻る
    public void closeBoundaryOrder(){
        boundaryorder.setVisible(false);
        boundarysystemmenu.setVisible(true);
    }
    //注文画面から顧客登録画面に移動
    public void showBoundaryAddCustomer(){
        boundaryorder.setVisible(false);  
        boundaryaddcustomer.setVisible(true);
    }
    //顧客登録画面から注文画面に戻る
    public void closeBoundaryAddCustomer(){
        boundaryaddcustomer.setVisible(false);
        boundaryorder.setVisible(true);
    }
    //従業員ログイン画面から入金画面に移動
    public void showBoundaryPayments(){
        boundarylogin.setVisible(false);
        boundarypayments.setVisible(true);
        boundarypayments.setManager(controlemployee.getEmployee());
    }
    //入金画面から従業員ログイン画面に戻る
    public void closeBoundaryPayments(){
        boundarypayments.setVisible(false);
        boundarypayments.removeMessage();
        boundarylogin.clearMessage();
        boundarylogin.setVisible(true);
    }
    //注文明細画面を開く
    public void showOrder(){
        boundaryform.showOrder(boundaryorder.getorderForm());
        boundaryform.setVisible(true);
    }
    //注文明細画面を閉じる
    public void closeBoundaryForm(){
        boundaryform.setVisible(false);
        boundaryorder.removeOrder();
    }
    public int getCustomerno(String tel){
        return controlcustomer.getCustomerno(tel);
    }
    public void showCustomer(String tel){
        controlcustomer.showCustomer(tel);
    }
    public static void main(String[] args){
        new ControldeliverySystem().start();
    }
}
