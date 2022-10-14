# appium-k9-mobile

## Command to build
```
mvn clean package -DskipTests=true
```

## Command to run
* Remove all allure-re* folders
```
rm -rf allure-re*
```  

* Execute command
```
java -Dplatform=android/ios -Dremote=true/fasle -jar target/appium-k9-mobile-1.0-SNAPSHOT-fat-tests.jar
```

* View report
```
allure generate
```
```
allure open
```




