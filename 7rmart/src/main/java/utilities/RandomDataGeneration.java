package utilities;

import com.github.javafaker.Faker;

public class RandomDataGeneration {
	
	public static String fakerNameStrings()
	{
	Faker faker = new Faker();
	String name =faker.address().firstName();
	return name;
	}
	
	public static String fakerCity()
	{
	Faker faker = new Faker();
	String name =faker.address().city();
	return name;
	}
	
	public static String fakerNumber()
	{
	Faker faker = new Faker();
	String name =faker.address().buildingNumber();
	return name;
	}
	

}
