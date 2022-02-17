package deliverySystem;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Super
 */
public class ControlEmployee {
    ControldeliverySystem control;
    private EmployeeDAO         employeeDAO;
    private List<Employee>      employeeList;
    private BoundaryLogin       boundarylogin;
    private Employee emp;
    
    public ControlEmployee(){
        employeeDAO         = new EmployeeDAO();
        employeeList        = new ArrayList<>();
        boundarylogin       = new BoundaryLogin();
    }
    public void setControl(ControldeliverySystem control){
        this.control = control;
        control.setBoundaryLogin(boundarylogin);
    }
    public int employeelogin(String no, String pass){
        try{
            employeeList = employeeDAO.dbSearchEmployeeNoPass(no, pass);
            emp = employeeList.get(0);
            if(emp.getPost() == 1){
                return 1;
            }else{
                return 2;
            }
        }
        catch(Exception e){
            return -1;
        }
    }
    public Employee getEmployee(){
        return emp;
    }
}
