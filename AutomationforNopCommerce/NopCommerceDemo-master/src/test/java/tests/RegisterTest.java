package tests;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import readerData.JsonReader;
import java.io.IOException;
public class RegisterTest extends BaseTest {
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    String registerJsonPath = "src/test/resources/registerData.json";
    @Test()
    public void TestRegisterMale() throws IOException, ParseException {
        registerPage = homePage.NavigateToRegisterPage()
                .FillMaleFields(JsonReader.TestJson.getJson(registerJsonPath, "FirstName"),
                        JsonReader.TestJson.getJson(registerJsonPath, "LastName"),
                        "10", "7", "1990",
                        JsonReader.TestJson.getJson(registerJsonPath, "Email") + currentTime + "@gmail.com",
                        JsonReader.TestJson.getJson(registerJsonPath, "Company"),
                        JsonReader.TestJson.getJson(registerJsonPath, "Password"),
                        JsonReader.TestJson.getJson(registerJsonPath, "Password"));
        registerPage.ClickOnRegisterBtn();
        Assert.assertTrue(registerPage.CompleteMessage().contains("complete"), " Register faild");
        registerPage.ClickOnContinue();
    }
}
