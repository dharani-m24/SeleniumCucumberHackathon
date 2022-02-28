package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.baseClass.BaseClass;



public class AdactinHotelSearchPage extends BaseClass{
	
	@FindBy(id="location")
	WebElement location;
	
	@FindBy(id="hotels")
	WebElement hotels;
	
	@FindBy(id="room_type")
	WebElement roomType;
	
	@FindBy(id="room_nos")
	WebElement NoOfRoom;
	
	@FindBy(id="datepick_in")
	WebElement checkInDate;
	
	@FindBy(id="datepick_out")
	WebElement checkOutDate;
	
	@FindBy(id="adult_room")
	WebElement adultPerson;
	
	@FindBy(id="Submit")
	WebElement searchBtn;
	
	@FindBy(id="radiobutton_0")
	WebElement radiobtn;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	
	public AdactinHotelSearchPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void searchHotel(String locationName, String hotelName, String roomTypeName, String number, String checkDate, String OutDate, String personCount) {
		
		Select selectLocation=new Select(location);
		selectLocation.selectByValue(locationName);
		
		Select selectHotel=new Select(hotels);
		selectHotel.selectByValue(hotelName);
		
		Select selectRoomType=new Select(roomType);
		selectRoomType.selectByValue(roomTypeName);
		
		Select selectRoomNo=new Select(NoOfRoom);
		selectRoomNo.selectByIndex(1);
		
		checkInDate.clear();
		checkInDate.sendKeys(checkDate);
		
		checkOutDate.clear();
		checkOutDate.sendKeys(OutDate);
		
		Select selectAdultPersonNo=new Select(adultPerson);
		selectAdultPersonNo.selectByIndex(1);
		
		searchBtn.click();
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Adactin.com - Select Hotel";
		Assert.assertEquals(expectedTitle, actualTitle);
		
		
	}
	
	public void selectHotel() {
		radiobtn.click();
		continueBtn.click();
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Adactin.com - Book A Hotel";
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	

}
