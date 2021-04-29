Steps to run the steps:
1. Right on click on the project and go to "Run As" and click on "Maven Clean".
2. You will see "Build Success" in the console window
3. Then again right click on the project and go to "Run As" and click on "Maven test".
4. The Execution Starts.

Steps to access the report:
1. After the execution finishes successfully, then right on click on the project and click "Refresh".
2. Go to the folder "target"-->"surefire-reports".
3. you will see "emailable-report.html"
4. Right click on "emailable-report.html" and click "properties"
5. Copy the location and paste it in the browser and click enter.


Note: If email address is already registered, then change the email address in the excel file 
      which is present under the folder src/main/java--->properties--->testData.xlsx