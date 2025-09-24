package utilities;

import com.github.javafaker.Faker;

//faker class
public class RandomDataUtility
{
	Faker faker = new Faker();
	public String randomUsername()
	{
		return faker.name().username(); //creates random username
	}
	public String randomPaswword()
	{
		return faker.internet().password(); //creates random passwords
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
