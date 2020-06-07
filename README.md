# Selenium WebDriver TestNG Framework
Automating functional UI and end to end tests for www.oculus.com website. This project uses the page object model (POM) design. 

## Stack & Libraries
- Java
- Selenium WebDriver
- TestNG 
- Maven
- Extent Reports and logging

## Prerequisites
- IDE (Eclipse)
- JDK (version 7 or 8)
- Maven configuration

### Easy way to configure Maven (Mac)
<details>
  <summary>Click to view instructions</summary> 
  
1. Download Maven (tar.gz for mac) from [here](https://maven.apache.org/download.cgi)
2. Move the downloaded apache-maven-3.6.3 folder to your Home directory (This is the folder with your username)

In terminal:

1. Set system variables:
```
export M2_HOME=/Users/<YOUR USER NAME>/apache-maven-3.6.3/
```
2. Append the Maven bin folder to the path:
```
export PATH=$PATH:/Users/<YOUR USER NAME>/apache-maven-3.6.3/bin/
```
3. If you don't have a bash profile, create one:
```
touch .bash_profile
```
4. If you do have one, or after creating one, open the bash profile to edit:
```
open .bash_profile
```
5. Paste the two paths from step 1 and 2
6. Save and close
7. Now Maven will be installed for all sessions. To verify Maven is installed, type:
```
mvn --version
```
</details>

## How to run tests
In terminal:
```
git clone https://github.com/ajkim0418/Java-Selenium-TestNG-Framework.git
```
Change directory to the location of cloned project folder and run Maven clean
```
mvn clean
```
To run the test
```
mvn test
```
###### Note: For the verifyLogin test case to pass, you must edit the SmokeTestSuite.xml and change the values for parameter "username" and "password" to a registered username/password

## Project components
- Page objects are in the directory *src/main/java/pages*
- Test classes are in the the directory *src/test/java/tests*
- Listener class is in the directory *src/main/java/util*

## Highlights
- This framework supports Chrome browser
- This uses **WebDriverManager**, an open source browser binary manager. Selenium WebDriver requires you to download the binaries for each driver and hardcode the path of the driver. The disadvantage of this is each user must change the code to match their path, and they must manually check when new versions of the binaries are released. WebDriverManager automatically checks the latest version of the browser downloaded on your machine and downloads the required driver binary into the cache, eliminating the need to manually download and store binary files.
- Screenshot on test failure: A screenshot of the active browser is captured and stored in the screenshots folder
- Extent reporting and logging: After the test finishes, a visual report is generated for all the executed test cases from the suite. This report can be found in the 'report' folder
![TestResult](https://user-images.githubusercontent.com/64181697/81464435-aba35d00-9176-11ea-9859-d97d9aa1aed3.png)
<img width="1168" alt="Screen Shot 2020-05-08 at 9 56 41 PM" src="https://user-images.githubusercontent.com/64181697/81464457-d5f51a80-9176-11ea-8460-694660fc7904.png">
