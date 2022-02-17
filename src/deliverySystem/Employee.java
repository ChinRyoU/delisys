package deliverySystem;

/**
 * 従業員クラス
 * @author 20jz0130
 */
public class Employee {
    String employee_no;
    String password;
    String name;
    int post;
    
    public Employee(){
        
    }

    public Employee(String employee_no, String password, String name, int post) {
        setEmployee_no(employee_no);
        setPassword(password);
        setName(name);
        setPost(post);
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getPost() {
        return post;
    }
    public String toString(){
        return getEmployee_no() + ", " + getPassword() + ", " + getName() + ", " + getPost();
    }
}
