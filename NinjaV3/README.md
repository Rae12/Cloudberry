# 👩‍💻💻 Parallel Testing & ThreadLocal BaseClass Automation Framework

Welcome to the **BaseClass Automation Framework**!  
This base class simplifies the setup and execution of automated tests by providing configurable, cross-browser support, **parallel test execution**, and more.

---

## ✅ Summary: What This BaseClass Enables

### Feature Descriptions

| Feature             | Description                                                           |
|---------------------|-----------------------------------------------------------------------|
| 🧠 **Configurable**   | Reads browser and app URL from configuration files or parameters.    |
| 🌐 **Cross-browser**  | Supports running tests on Chrome, Firefox, and Edge.                 |
| ⚙️ **Thread-safe**    | Uses `ThreadLocal WebDriver` to enable parallel test execution.     |
| 📸 **Screenshot support** | Captures screenshots with timestamps when tests fail.             |
| 📦 **Reusable**       | Can be easily extended or called by any test class.                  |

### Key Benefits

- 🔧 **Flexible configuration** allows for easy updates to browser settings or app URLs.
- 🌍 **Cross-browser compatibility** ensures your tests run on multiple browsers.
- 🧵 **Parallel test execution** speeds up testing by running tests simultaneously using `ThreadLocal` WebDriver instances, ensuring thread safety and reducing overall test run time.
- 📸 **Built-in screenshot support** automatically captures screenshots on failure, with timestamped filenames to help with debugging.
- 🔁 **Reusable design** makes it easy for any test class to extend BaseClass, streamlining setup and ensuring consistent test execution.

---

## ⚙️ Parallel Test Execution with `ThreadLocal` WebDriver

The **BaseClass** uses **ThreadLocal** to create thread-safe WebDriver instances. This allows you to run tests in parallel without interfering with each other. 

### Benefits of `ThreadLocal` WebDriver for Parallel Testing:
- **Thread safety**: Each test thread gets its own WebDriver instance, ensuring that tests do not interfere with one another.
- **Efficiency**: Parallel execution reduces the total time to run your test suite, making the testing process faster and more scalable.
- **Seamless integration**: Easily integrate parallel execution into your existing test framework by simply leveraging `ThreadLocal`.
