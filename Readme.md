# Assignment Done

Hi,
I have completed the given 2 exercises using Selenium for Web automation and RestAssured for API automation with Cucumber-Java.

## Run the code
Clone the repo and you will need to install lombok plugin as well to annotation processor.

In order to run the Ui and API automation we need to make below configuration changes:

|      Parameter          |UI Tags|API|
|----------------|-------------------------------|-----------------------------|
|TestRunner|@uiTest            |@apiTest          |
|baseConfig.Json|"testType": "ui"        |"testType": "api"  