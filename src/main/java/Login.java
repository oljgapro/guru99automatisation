import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

public class Login extends Common
{
    private static String actualTitle;
    private static String actualBoxtitle;
    public static void main(String[] args) {
        Common common = new Common();
        common.setUP();
        common.startBrowser();
        common.login(Util.INVALID_USER_NAME, Util.INVALID_PASS);
        try{

            Alert alt = driver.switchTo().alert();
            actualBoxtitle = alt.getText(); // get content of the Alter Message
            alt.accept();
            if (actualBoxtitle.contains(Util.EXPECT_ERROR)) { // Compare Error Text with Expected Error Value
                System.out.println("Test case : Passed");
            } else {
                System.out.println("Test case: Failed");
            }
        }
        catch (NoAlertPresentException Ex){
            actualTitle = driver.getTitle();
            // On Successful login compare Actual Page Title with Expected Title
            if (actualTitle.contains(Util.EXPECT_TITLE)) {
                System.out.println("Test case SS: Passed");
            } else {
                System.out.println("Test case SS: Failed");
            }

        }
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

