package dept;

import java.util.ArrayList;

public interface DeptDAO {
	int insert(DeptDTO dept);
	ArrayList<DeptDTO> getDeptList();
	int delete(String deptno);
}
