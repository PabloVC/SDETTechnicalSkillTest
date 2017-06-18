package com.testsdetwilliam.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class WilliamTestStep {
	
	//Declaration of the main variables used in the code.
	String website = "http://games.williamhill.com";
    WebDriver driver = new FirefoxDriver();
    
  //Method to wait between Selenium commands in Firefox.
    public void waitSecond(WebDriver driver, int seconds){
        synchronized(driver){
           try {
              driver.wait(seconds * 1000);
           } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }
        }
     }
	
	@Given("^William Hill website$")
	//Open the web site and print the cookies data
	public void william_Hill_website() throws Throwable {
		driver.get(website);
		waitSecond(driver,5);
		
		System.out.println("/////////////////////////////////");
		System.out.println("The data cokies is shown below:");
		System.out.println(driver.manage().getCookies());
	}

	@When("^Authentication with user \"(.*?)\" and password \"(.*?)\"$")
	public void authentication_with_user_and_password(String arg1, String arg2) throws Throwable {
		//Manage an authentication with user and password parameterized.
		driver.findElement(By.cssSelector("a.wf-user-button__login.ng-scope > span.ng-binding")).click();
		driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys(arg1);
	    System.out.println("/////////////////////////////////");
	    System.out.println("User "+arg1+" have been entered");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(arg2);
	    System.out.println("Password "+arg2+" have been entered");
	    driver.findElement(By.cssSelector("button.login.ng-binding")).click();
	    System.out.println("Loggin process have been done");
	}

	@Then("^Count and list all the games in A-Z$")
	// Go to A-Z games, print name of each game and count the total
	public void count_and_list_all_the_games_in_A_Z() throws Throwable {
		driver.manage().window().maximize();
		waitSecond(driver,3);
		driver.findElement(By.xpath("//div[3]/div/a[3]/span")).click();
		waitSecond(driver,3);
		int start = 1;
		System.out.println("/////////////////////////////////");
		System.out.println("The list of game is shown below:");
		try{
			while(true){
				System.out.println((driver.findElement(By.cssSelector("div.game-tile:nth-child("+start+")")).
				findElement(By.className("tile-overlay")).getAttribute("ng-href")).substring(17));
				start++;
			}
		}catch (Exception e) {
			}
		System.out.println("/////////////////////////////////");
		System.out.println("Total Games Listed :"+(start-1));
	}
}