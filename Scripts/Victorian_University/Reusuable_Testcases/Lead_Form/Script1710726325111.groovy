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
import com.github.javafaker.Faker


//Randomly selects the program from the drop-down
int optionListLength = 4
Random rand = new Random()
int index = rand.nextInt(optionListLength-1)+1
TestObject program = findTestObject('Object Repository/Victoria_University/Dropdown_Program')
WebUI.selectOptionByIndex(program, index)

// Generates a random first name and Lastname
Faker faker = new Faker()
String randomFirstName = faker.name().firstName()
TestObject firstNameField = findTestObject('Object Repository/Victoria_University/Field_Firstname')
WebUI.setText(firstNameField, randomFirstName)

String randomSecondName = faker.name().firstName()
TestObject secondNameField = findTestObject('Object Repository/Victoria_University/Field_Lastname')
WebUI.setText(secondNameField, randomSecondName)

//Clicks the next step
WebUI.waitForElementClickable(findTestObject('Object Repository/Victoria_University/Button_NextStep2'), 10)
WebUI.click(findTestObject('Object Repository/Victoria_University/Button_NextStep2'))

//Selects random Startdate
TestObject startdate = findTestObject('Object Repository/Victoria_University/Dropdown_Startdate')
WebUI.selectOptionByIndex(startdate, index)

//Selects random EnquiryReason
TestObject Enquiryreason = findTestObject('Object Repository/Victoria_University/Dropdown_Enquiry')
WebUI.selectOptionByIndex(Enquiryreason, index)

WebUI.selectOptionByValue(findTestObject('Object Repository/Victoria_University/Dropdown_Highereducation'),GlobalVariable.Education_Level, false)

//Selects random work experience
TestObject Workexperience = findTestObject('Object Repository/Victoria_University/Dropdown_Workexperience')
WebUI.selectOptionByIndex(Workexperience, index)


//Clicks the nextstep Now button
WebUI.waitForElementClickable(findTestObject('Object Repository/Victoria_University/Button_Nextstep3'), 10)
WebUI.click(findTestObject('Object Repository/Victoria_University/Button_Nextstep3'))

// Common email domain
String domain = "@example.com"
// Generate a random email address using the first name and common domain
String randomEmail = randomFirstName + domain
TestObject EmailAddress = findTestObject('Object Repository/Victoria_University/Field_Email')
WebUI.setText(EmailAddress, randomEmail)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Victoria_University/Dropdown_Country'),'Australia', false)

//Genrates random post code
String randompostCode = faker.address().zipCode()
TestObject postCode = findTestObject('Object Repository/Victoria_University/Field_Postcode')
WebUI.click(findTestObject('Object Repository/Victoria_University/Field_Postcode'))
WebUI.setText(postCode, randompostCode)

//generates phone nubmber
String randomphoneNumber = faker.numerify("04########")
TestObject phonenumber = findTestObject('Object Repository/Victoria_University/Field_Phonenumber')
WebUI.setText(phonenumber, randomphoneNumber)

//Clicks the Submit buttono
WebUI.waitForElementClickable(findTestObject('Object Repository/Victoria_University/Button_Submit'), 10)
WebUI.click(findTestObject('Object Repository/Victoria_University/Button_Submit'))

//Verify if the Thank you for enquiry content is displayed
WebUI.delay(5)
WebUI.verifyElementText(findTestObject('Object Repository/Victoria_University/Verify_Content'), 'THANKS FOR YOUR ENQUIRY')

