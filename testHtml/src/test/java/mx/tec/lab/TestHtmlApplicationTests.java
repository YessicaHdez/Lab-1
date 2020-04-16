package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestHtmlApplicationTests {

	private WebClient webClient;
	
	@BeforeEach
	public void init() {
		webClient=new WebClient();
	}
	@AfterEach
	public void close() {
		webClient.close();
	}
	
	
	@Test
	public void givenAClient_whenEnteringAutomationPractice_thenPageTitleIsCorrect()
	throws Exception {
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage("http://automationpractice.com/index.php");
		
		assertEquals("My Store", page.getTitleText());
	}
	@Test
    public void givenAClient_whenEnteringLoginCredentials_thenAccountPageIsDisplayed()
        throws Exception {
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
        emailField.setValueAttribute("A01561794@itesm.mx");
        HtmlPasswordInput passwordField = (HtmlPasswordInput) page.getElementById("passwd");
        passwordField.setValueAttribute("CANONPERRITo");
        HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
        HtmlPage resultPage = submitButton.click();

        assertEquals("My account - My Store", resultPage.getTitleText());
    }
	
	 @Test
	    public void givenAClient_whenEnteringWrongLoginCredentials_thenAuthenticationPageIsDisplayed()
	            throws Exception {
		    webClient.getOptions().setThrowExceptionOnScriptError(false);
	        HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	        HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
	        emailField.setValueAttribute("A01561794@itesm.mx");
	        HtmlPasswordInput passwordField = (HtmlPasswordInput) page.getElementById("passwd");
	        passwordField.setValueAttribute("CANON");
	        HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
	        HtmlPage resultPage = submitButton.click();

	        assertEquals("Login - My Store", resultPage.getTitleText());

	    }

	    @Test
	    public void givenAClient_whenEnteringWrongLoginCredentials_thenErrorMessageIsDisplayed()
	            throws Exception {
	    	    webClient.getOptions().setThrowExceptionOnScriptError(false);
		        HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		        HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
		        emailField.setValueAttribute("A01561794@itesm.mx");
		        HtmlPasswordInput passwordField = (HtmlPasswordInput) page.getElementById("passwd");
		        passwordField.setValueAttribute("CANON");
		        HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
		        HtmlPage resultPage = submitButton.click();
		        HtmlDivision error = (HtmlDivision) resultPage.getByXPath("//div[@class='alert alert-danger']").get(0);
				
				assertNotNull(error, "error");
		        
		        
		        
	    }

	    @Test
	    public void givenAClient_whenSearchingNotExistingProduct_thenNoResultsDisplayed()
	            throws Exception {
	    	 webClient.getOptions().setThrowExceptionOnScriptError(false);
	         HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	         HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
	         emailField.setValueAttribute("A01561794@itesm.mx");
	         HtmlPasswordInput passwordField = (HtmlPasswordInput) page.getElementById("passwd");
	         passwordField.setValueAttribute("CANONPERRITo");
	         HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
	         HtmlPage resultPage = submitButton.click();
	    	
	         
	         HtmlTextInput searchField = (HtmlTextInput) resultPage.getElementById("search_query_top");
	         searchField.setValueAttribute("blusa");
	         HtmlButton submitB = (HtmlButton) resultPage.getElementByName("submit_search");
	         resultPage = submitB.click();

	         HtmlParagraph noExist = (HtmlParagraph) resultPage.getFirstByXPath("//p[@class='alert alert-warning']");

	         assertNotNull(noExist, "no item");
	     }
	         
	    	
	    

	    @Test
	    public void givenAClient_whenSearchingEmptyString_thenPleaseEnterDisplayed()
	            throws Exception {
	    	 webClient.getOptions().setThrowExceptionOnScriptError(false);
	         HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	         HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
	         emailField.setValueAttribute("A01561794@itesm.mx");
	         HtmlPasswordInput passwordField = (HtmlPasswordInput) page.getElementById("passwd");
	         passwordField.setValueAttribute("CANONPERRITo");
	         HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
	         HtmlPage resultPage = submitButton.click();
	         
	         
	         HtmlButton submitB = (HtmlButton) resultPage.getElementByName("submit_search");
	         resultPage = submitB.click();

	         HtmlParagraph p = (HtmlParagraph) resultPage.getFirstByXPath("//p[@class='alert alert-warning']");


	         assertEquals("Please enter a search keyword", p.getTextContent().trim());
	         
	    }

	    @Test
	    public void givenAClient_whenSigningOut_thenAuthenticationPageIsDisplayed()
	            throws Exception {
	     
	    	 webClient.getOptions().setThrowExceptionOnScriptError(false);
	         HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	         HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
	         emailField.setValueAttribute("A01561794@itesm.mx");
	         HtmlPasswordInput passwordField = (HtmlPasswordInput) page.getElementById("passwd");
	         passwordField.setValueAttribute("CANONPERRITo");
	         HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
	         HtmlPage resultPage = submitButton.click();
	       
	         HtmlAnchor logOut = (HtmlAnchor) resultPage.getFirstByXPath("//a[@class='logout']");
	         resultPage = logOut.click();

	         assertEquals("Login - My Store", resultPage.getTitleText());
	    }
}
