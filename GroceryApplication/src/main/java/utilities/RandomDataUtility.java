package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility
{
	Faker faker = new Faker();
	public String randomUsername()
	{
		return faker.name().username(); 
	}
	
	public String randomPaswword()
	{
		return faker.internet().password(); 
	}
	
	public String randomEmail()
	{
		return faker.internet().emailAddress();
	}
	
	public String randomFullname()
	{
		return faker.name().fullName();
	}
   
}
