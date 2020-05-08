# Selenium WebDriver TestNG Framework
Automating functional and end to end UI tests for www.oculus.com website. This project uses the page object model (POM) design. 

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
- Chrome version 80+

## Easy way to configure Maven (Mac)
1. Download Maven (tar.gz for mac) from [here](https://maven.apache.org/download.cgi)
2. Move the downloaded apache-maven-3.6.3 folder to User directory
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
7. Now Maven will be installed for all sessions. Type mvn --version to verify Maven is installed

## How to run Selenium tests
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
