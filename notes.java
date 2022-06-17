*File Connections*
Selenium 4.1.2 is not working
Driver related all the code is written in src/main/java --> driver package
In DriverManager class created Threadlocal methode to overcome the isuues when running the methods/test in parallel
DriverManager.getDriver() Use this to access the driver
Config file is connected with ReadPropertyFile of com.gudexams.utils the value is readed ReadPropertyFile.getValue("url"). Here url is key and the value is after the = of config file
In GPK_GudExams/src/main/java/ --> com.gudexams.pages write the Page Object code here
In excel sheet provide method name not class name 
To avoid NullPointerException while reading data from excel instade of empty cell insert '(single quot).


*Comments*
# is used to comment the line in properties file
<!-- Test --> format to comment the line or somthing in xml file
// or /* abcd */ to comment the java code

*Other*
final keyword is used for resticting the inheritance, value changes, methode over riding
private access modifiers is used for resticting the object creation
protected access modifer is used for access the data only in package
No need of default writing for default access modifiers



*IMP*
Templete to write xpath //tagname[@attribute='text'] to verify the xpath got to console of the browser and enter ctrl+f and paste the xpath
String dynamic_xpath="//a[text()='%value%'" driver.findElement(By.xpath(dynamic_xpath.replace("%value%" , value)));
cap=veriable.substring(0, 4); this line is used to limit the length of input value.


		