import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hcl.controller.EmployeeController;
import com.hcl.dao.EmpRepository;
import com.hcl.model.Employee;
@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
public class EmployeeControllerTest  extends SpringBootTestApplicationTests{
    @InjectMocks // to createEmpController class and also inect the mocked employeerepo  instalnce
    EmployeeController empController;
    
    @Mock //to create mock object for EmpRepo
    EmpRepository empRepo;
    
    @Test
    public void testAddEmployee() {
        MockHttpServletRequest req=new     MockHttpServletRequest ();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(req));
        when(empController.addNewEmp(any(Employee.class))).thenReturn(true);
        Employee e1=new Employee(111,"Altaf");
        ResponseEntity<Object> response = empController.addNewEmp(e1);
        assertThat(response.getStatusCodeValue()).isEqualTo("201"); //httpstatus is 201 => create
        
        
        
        
    }

 

}
 