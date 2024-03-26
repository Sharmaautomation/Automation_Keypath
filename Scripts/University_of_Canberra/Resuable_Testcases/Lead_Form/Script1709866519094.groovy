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
int optionListLength = 3
Random rand = new Random()
int index = rand.nextInt(optionListLength-1)+1
TestObject program = findTestObject('Object Repository/University_of_Canberra/Dropdown_Enquiry_Program')
WebUI.selectOptionByIndex(program, index)

// Generates a random first name and Lastname
Faker faker = new Faker()
String randomFirstName = faker.name().firstName()
TestObject firstNameField = findTestObject('Object Repository/University_of_Canberra/Field_FirstName')
WebUI.setText(firstNameField, randomFirstName)

String randomSecondName = faker.name().firstName()
TestObject secondNameField = findTestObject('Object Repository/University_of_Canberra/Field_SecondName')
WebUI.setText(secondNameField, randomSecondName)

//Clicks the next step
WebUI.waitForElementClickable(findTestObject('Object Repository/University_of_Canberra/Button_Nextstep2'), 10)
WebUI.click(findTestObject('Object Repository/University_of_Canberra/Button_Nextstep2'))

//Selects random Startdate
TestObject startdate = findTestObject('Object Repository/University_of_Canberra/Dropdown_Enquiry_StartDate')
WebUI.selectOptionByIndex(startdate, index)

//Selects random EnquiryReason
TestObject Enquiryreason = findTestObject('Object Repository/University_of_Canberra/Dropdown_EnquiryReason')
WebUI.selectOptionByIndex(Enquiryreason, index)

WebUI.selectOptionByValue(findTestObject('Object Repository/University_of_Canberra/Dropdown_Enquiry_Leveleducation'),GlobalVariable.Education_Level, false)

//Selects random work experience
TestObject Workexperience = findTestObject('Object Repository/University_of_Canberra/Field_Enquiry_Workexperience')
WebUI.selectOptionByIndex(Workexperience, index)

//Clicks the nextstep Now button
WebUI.waitForElementClickable(findTestObject('Object Repository/University_of_Canberra/Button_Nextstep3'), 10)
WebUI.click(findTestObject('Object Repository/University_of_Canberra/Button_Nextstep3'))

//generates phone nubmber
String randomphoneNumber = faker.numerify("04########")
TestObject phonenumber = findTestObject('Object Repository/University_of_Canberra/Field_Phonenumber')
WebUI.setText(phonenumber, randomphoneNumber)

// Common email domain
String domain = "@example.com"
// Generate a random email address using the first name and common domain
String randomEmail = randomFirstName + domain
TestObject EmailAddress = findTestObject('Object Repository/University_of_Canberra/Field_Email')
WebUI.setText(EmailAddress, randomEmail)



//Genrates random post code

String randompostCode = faker.address().zipCode()
TestObject postCode = findTestObject('Object Repository/University_of_Canberra/Field_Postcode')
WebUI.delay(3)
WebUI.setText(postCode, randompostCode)

//Clicks the Submit buttono
WebUI.waitForElementClickable(findTestObject('Object Repository/University_of_Canberra/Button_Submit'), 10)
WebUI.click(findTestObject('Object Repository/University_of_Canberra/Button_Submit'))

//Verify if the Thank you for enquiry content is displayed
WebUI.delay(5)
WebUI.verifyElementText(findTestObject('Object Repository/University_of_Canberra/Verify_Content'), 'Thank you for your enquiry!')