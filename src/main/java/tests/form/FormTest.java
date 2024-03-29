package tests.form;

import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import test_flows.form.FormFlow;
import tests.BaseTest;

public class FormTest extends BaseTest {

    @Test
    @Issue("JIRA-321")
    public void testFormInput() {
  //      System.out.println("--> Session ID: " + getDriver().getSessionId());
//        Assert.fail(".....");
 //       Assert.assertTrue(true);
        FormFlow formFlow = new FormFlow(getDriver());
        formFlow.gotoFormScreen();
        formFlow.fillTheForm();
        formFlow.verifyFormDisplay();
    }
}