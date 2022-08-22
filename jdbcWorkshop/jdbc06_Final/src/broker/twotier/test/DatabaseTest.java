package broker.twotier.test;

import java.util.Vector;

import broker.twotier.dao.DatabaseMyself;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;

public class DatabaseTest {

	public static void main(String[] args)throws Exception{
		
		DatabaseMyself db = new DatabaseMyself("127.0.0.1");
//		db.addCustomer(new CustomerRec("111-111", "하바리", "다산동"));
		db.deleteCustomer("777-777");
		//db.updateCustomer(new CustomerRec("777-777", "하바리", "약수동"));
		
		/*Vector<SharesRec> v = db.getPortfolio("777-777");
		for(SharesRec sr : v)System.out.println(v);*/
	}

}
