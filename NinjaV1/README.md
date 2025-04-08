# NinjaV1 Automation Framework

🧪Welcome to the **BassClass Automation Framework**!  
This project is designed for efficient and scalable web application testing using WebDriver, built with a clean Page Object Model (POM) structure.


## ✅ Purpose of the Class

BaseClass acts as a test setup and teardown utility for Selenium tests using TestNG. It provides:

- Test environment initialization (like browser setup).
- Application startup.
- Screenshot capturing.
- Teardown logic after tests are done.
---

## 📁 Project Structure

```
📦 src
├── 🧱 BassClass/         # Base class to initialize and connect WebDriver
├── 📄 TestCases/         # Test scripts defining the expected conditions/behaviors
└── 🧭 PageObject/        # Page Object Models representing UI elements
```
---
## 📦Selenium Java

- Purpose: Selenium is a popular web automation tool. The selenium-java dependency provides the core Selenium WebDriver API to automate browser actions for testing web applications.
- Usage: It is used for automating browser interactions, running tests, and simulating user actions (like clicking, typing, navigating).
```
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.28.1</version>
</dependency>
```
## 🎯 Goals
```
✅ Create a reusable WebDriver setup.

✅ Implement modular and readable Page Object classes.

✅ Write robust test cases to validate web application functionality.
```
## 💡 Summary

This class:

- Starts and stops a Chrome browser for tests.

- Loads test configuration from a file.

- Provides a method to capture screenshots for debugging or reports.

