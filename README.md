# SwagLabs Application
As per the requirement provided the Application Under Test is downloaded from the following Github link, https://github.com/saucelabs/sample-app-mobile/releases/ . For the given assignment, the Application is tested on Windows with Android envionment in a simulator. End to End flows with Negative cases are covered.

# **Prerequisites:**
The following prerequisites are required to clone and use the project. Please make sure it is available and installed to make sure the execution is successfull. Windows PC, Java v8.0, Eclipse/Intellij(Any IDE),Testng, Node, GitBash, Appium Server (Desktop/Command line), Android Simulator/Device.

# **Tools used:**
For Cloning and Re-Executing the project, below are the minimum requirement
- Windows 10
- Java Version 8
- Eclipse/Intellij (Any Latest Version)
- Node v14.5.3
- Appium Server Version 1.20.0
- Android Device/Simulator with version 10
- Since the project is developed in Maven, the dependencies are available in POM.xml. 

# **Scenarios Covered:**
- Login using invalid Credentials to verify proper Error message.
- Login using valid Credentials to verify Successfull login.
- Verify the product name and price in Homepage with the Item Description.
- Validate whether user is able to add products and remove products and perform successfull checkout.
- Verify if the user is not allowed to checkout when the shopping cart is empty.
- Verify if alternate user login is having the proper item in home page and item description page.
- Validate if the alternat user login is able to add item and remove item from cart and confirm.

# **Defects Identified:**
The following issues are identified in the application,
- User is able to checkout without any item in the shopping cart. Ideally user should be prevented from checking out without any item in the shopping cart.
- User with credentials (problem_user/secret_sauce) is having issue with item name and image displayed in the home page when compared with item description page. On click of any product from home page the name, image of product is not matching with the name and image in the item description page.
- User with credentials (problem_user/secret_sauce) is unable to remove items that is added from the home page.
- User with credentials (problem_user/secret_sauce) is unable to add the product "Sauce Labs Bike Light".
