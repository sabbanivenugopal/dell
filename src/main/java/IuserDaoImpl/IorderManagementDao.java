package IuserDaoImpl;

import java.util.List;

import com.user.pojo.ItemManagementPojo;

public interface IorderManagementDao {

	public void addItemsToDb(ItemManagementPojo item);
	
	public List showMenu();
	
	public int deleteitem(int itemid);
	
	public List fetchmemory();
	
	public ItemManagementPojo edititem(int itemid);
	
	public List updateitem(ItemManagementPojo useritem);
	
}
