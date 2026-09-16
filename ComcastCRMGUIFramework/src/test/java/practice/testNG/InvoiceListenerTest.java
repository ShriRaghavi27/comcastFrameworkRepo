package practice.testNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
//@Listeners(com.comcast.crm.listenerUtility.ListImpClass.class)
public class InvoiceListenerTest extends BaseClass {
	@Test
	public void creaInvoiceTest() {
		System.out.println("execute creaInvoiceTest");
		String actTitle=driver.getTitle();
		
		Assert.assertEquals(actTitle, "login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
	}
	@Test
	public void creaInvoiceWithContactTest() {
		System.out.println("execute creaInvoiceWithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
	}

}
