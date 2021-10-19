
import org.openqa.selenium.Alert;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends Common
{


    public void Main() throws Exception {
        String[][] testData = Util.getDataFromExcel(Util.FILE_PATH,
                Util.SHEET_NAME, Util.TABLE_NAME);
        String username, password;
        String actualTitle;
        String actualBoxtitle;

        @BeforeTest
        Common common = new Common();
                common.setUP();
        common.startBrowser();

        for (int i = 0; i < testData.length; i++) {
            username = testData[i][0]; // get username
            password = testData[i][1]; // get password



@Test
        common.login(username, password);
        try{

            Alert alt = driver.switchTo().alert();
            actualBoxtitle = alt.getText(); // get content of the Alter Message
            alt.accept();
            if (actualBoxtitle.contains(Util.EXPECT_ERROR)) { // Compare Error Text with Expected Error Value
                System.out.println("Test case with error message SS[" + i + "]: Passed");
            } else {
                System.out.println("Test case SS[" + i + "]: Failed");
            }
        }
        catch (NoAlertPresentException Ex){
            actualTitle = driver.getTitle();
            // On Successful login compare Actual Page Title with Expected Title
            if (actualTitle.contains(Util.EXPECT_TITLE)) {
                System.out.println("Test case without error SS[" + i + "]: Passed");
            } else {
                System.out.println("Test case SS[" + i + "]: Failed");
            }


        }
@AfterTest
        common.closeBrowser();
    }

   /*     String actualTitle = driver.getTitle();
        if (actualTitle.contains(Util.EXPECT_TITLE)) {
            System.out.println("Login test case: Passed");
        }
        else {
            System.out.println("Login test case : Failed");
        }

       common.scroll();
        common.logout();
        common.login(Util.INVALID_USER_NAME, Util.INVALID_PASS); */


    }
}

