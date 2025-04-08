# 🔄 Test Retry Mechanism

Welcome to the **Test Retry Mechanism**!  
This project implements a retry mechanism for failed tests, ensuring flaky tests are retried up to a set limit. It uses **Log4j** for logging each retry attempt and **TestNG** for managing retries.

---

## 📁 Project Structure

```plaintext
📦 src
├── 🔧 TestRetryAnalyzer/        # Contains the RetryAnalyzer for handling retries
├── 🧪 TestCases/                # The actual test cases using the retry logic
└── 📓 Logs/                     # Logs the retry attempts and results
```
---
## 📝Log4j Core
- Purpose: Log4j is a logging framework. The log4j-core dependency provides the core functionality for logging in Java applications.
- Usage: It's used to generate log messages for debugging and tracking application flow. It allows you to log messages at various levels (INFO, DEBUG, ERROR).

```
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.24.3</version>
</dependency>
```

## 📝Log4j API:
- Purpose: This is the API part of Log4j, which allows your application to log messages to different output sources (console, files, etc.).
- Usage: It provides the logging interface used to log messages, which are then handled by the log4j-core implementation.

```
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.24.3</version>
</dependency>
```
## 📝 Log4j SLF4J Binding:
- Purpose: This dependency provides an implementation of the SLF4J API using Log4j.
- Usage: SLF4J is a simple logging facade that can be used with various logging frameworks. This dependency binds the SLF4J API with Log4j as the underlying logging implementation. The <scope>test</scope> indicates it's used for testing purposes.

```
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j-impl</artifactId>
    <version>2.24.3</version>
    <scope>test</scope>
</dependency>
```
📚 Imports:
- LogManager and Logger: From the log4j library, used for logging messages.
- IRetryAnalyzer: An interface from TestNG that allows us to implement a retry logic for failed tests.
- ITestResult: Represents the result of a test execution, including its status (success, failure, etc.).
