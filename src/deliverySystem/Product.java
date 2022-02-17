package deliverySystem;

/**
 *
 * @author 20jz0134
 */
public class Product {
    private String      productNo;
    private String      name;
    private int         price;
    private String      categoryNo;
    
    public Product() {
        
    }
    
    public Product(String productNo, String name, int price, String categoryNo) {
        setProductNo(productNo);
        setName(name);
        setPrice(price);
        setCategoryNo(categoryNo);
    }

    public String getProductNo() {
        return productNo;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategoryNo() {
        return categoryNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo;
    }
    
    @Override
    /**
     * 注文画面に表示するにはカテゴリーがいりません。
     */
    public String toString() {
        return getProductNo() + ", " + getName() + ", " + getPrice();
    }
}
