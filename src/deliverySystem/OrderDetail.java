package deliverySystem;

/**
 *
 * @author 20jz0134
 */
public class OrderDetail {
    private String      orderNum;   
    private String      productNo;
    private int         count;
    
    public OrderDetail() {
        
    }
    
    public OrderDetail(String orderNum, String productNo, int count) {
        setOrderNum(orderNum);
        setProductNo(productNo);
        setCount(count);
    }

    public String getOrderNum() {
        return orderNum;
    }

    public String getProductNo() {
        return productNo;
    }

    public int getCount() {
        return count;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public String toString() {
        return getOrderNum() + ", " + getProductNo() + ", " + getCount();
    }
    
}
