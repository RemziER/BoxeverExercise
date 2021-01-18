# BoxeverExercise

                                            BOXEVER EXERCISE

Summary

This project has 3 parts.

1.	Designing test cases for a valid maze. 
2.	Designing API test automation to create and delete a gist.
3.	Designing test automation framework to search an item in an e-commerce website, sort the results by price and add an item to the shopping cart. 


Strategy

For the first part, a test case has been written to validate a maze with the acceptance criteria.

For the second part, Page Object Model and Singleton design pattern have been used for Cucumber – JUnit test automation framework and the test cases have been written in Gherkin language. You can run the test cases from CukesRunner class by doing dryRun as False. The @smoke tag has also been added to the test scenarios in feature files.

For the third part, the automation tests have been designed in TestNG framework. In the framework, this part has been built in a single class which is “ApiStepDefinitions”. You can execute the test cases directly from the ApiStepDefinitions class.

The tools and structures which have been used to build these test automation frameworks are:

-	Java			: Programming language
-	Selenium WebDriver	: Browser automation
-	Maven			: Build management tool
-	Cucumber – JUnit		: framework
-	Gherkin			: test case language
-	TestNG			: framework (only for API part)
-	Page Object Model	: Design Pattern
-	Singleton			: Design Patter (Driver class)


Websites:

1.	http://en.wikipedia.org/wiki/Maze_generation_algorithm
2.	https://github.com
http://rest-assured.io
https://developer.github.com/v3/gists/
3.	https://www.etsy.com

Dependencies

https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59

https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/4.1.0

https://mvnrepository.com/artifact/io.cucumber/cucumber-java/5.7.0

https://mvnrepository.com/artifact/io.cucumber/cucumber-junit/5.7.0

https://mvnrepository.com/artifact/net.masterthought/maven-cucumber-reporting/5.0.0

https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin/2.22.2

https://mvnrepository.com/artifact/org.testng/testng/7.1.0
