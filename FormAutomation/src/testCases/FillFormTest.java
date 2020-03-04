package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.FormPage;
import utilities.XLUtil;

public class FillFormTest extends BaseClass {
	
	@DataProvider(name="FormData")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+ "/src/testData/TestData.xlsx";
		int rownum = XLUtil.getRowCount(path,"Sheet1");
		int colcount = XLUtil.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtil.getCellData(path,"Sheet1", i,j);
			}
		}
	return logindata;
	}
	
	
	@Test(dataProvider = "FormData")
	public void fillform(String name, String email, String address, String phoneNumber, String comments) throws InterruptedException
	{
		FormPage f = new FormPage();
		
		Assert.assertTrue(f.isCurrent());
		System.out.println("Form is opened");
		f.inputName(name);
		f.inputemail(email);
		f.inputaddress(address);
		f.inputPhoneNumber(phoneNumber);
		f.inputComment(comments);
		f.clickSubmitButton();
		Assert.assertTrue(f.confirmSubmission());
		System.out.println("Form Submitted Sucessfully");
		
	}

}
