package IuserDaoImpl;

import java.util.List;

import org.springframework.ui.Model;

import com.user.pojo.UserPojo;

public interface IuserDao {
	
	public void saveUser(UserPojo user);
	
	public List loginUser(String emailId, String password);
	
	public List<UserPojo> showUserDetails();
	
	public List<UserPojo> editUser(int userId);
	
	public List<UserPojo> updateUser(UserPojo user);
	
	public int deleteUserDetails(int userId);
	
	public List<UserPojo> fetchmemory();

}
