import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory


// Calls the URL test cases
//WebUI.callTestCase(findTestCase('Test Cases/University_of_Canberra/Resuable_Testcases/Navigate_Url'), [:], FailureHandling.STOP_ON_FAILURE)

//Scrolls the page down
//WebUI.scrollToPosition(9999999, 9999999)

def driver = DriverFactory.getWebDriver()

// Execute JavaScript to scroll to the middle of the page
((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2)")

//Clicks the ContactUS button
WebUI.waitForElementClickable(findTestObject('Object Repository/University_of_Canberra/Button_Contactus'), 10)
WebUI.click(findTestObject('Object Repository/University_of_Canberra/Button_Contactus'))

//Navigates  to other tab
WebUI.switchToWindowIndex(1)

//Calls the Lead Form Test Cases
WebUI.callTestCase(findTestCase('Test Cases/University_of_Canberra/Resuable_Testcases/Lead_Form'), [:], FailureHandling.STOP_ON_FAILURE)

//Closes the browser
WebUI.closeBrowser()