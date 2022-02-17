package deliverySystem;

/**
 * カテゴリークラス
 * @author 20jz0130
 */
public class Category {
    String category_no;
    String name;
    
    public Category(){
        
    }
    public Category(String category_no, String name){
        this.category_no = category_no;
        this.name        = name;
    }

    public String getCategory_no() {
        return category_no;
    }

    public String getName() {
        return name;
    }

    public void setCategory_no(String category_no) {
        this.category_no = category_no;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return getCategory_no() + ", " + getName();
    }
}
