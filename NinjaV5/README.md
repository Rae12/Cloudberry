# 🌐 BaseClass for Local WebDriver Initialization

Welcome to the **BaseClass for Local WebDriver Initialization**!  
This simplified version of the BaseClass is designed to work with **local WebDriver** instances only, focusing on initializing browsers for local execution. Unlike previous versions, it does not support remote execution and is more streamlined.

---

##  Project Structure

```plaintext
📦 src
├── 🧑‍💻 BaseClass/           # Base class for local WebDriver initialization
├── 🧪 TestCases/             # Test scripts utilizing the local WebDriver
└── 📝 Logs/                  # Logs of WebDriver actions and test executions
```
## 🧹Code Cleanup Example:
```
            WebDriver localDriver;

            switch (br.toLowerCase()) {
                case "chrome":
                    log.info("Launching Chrome Browser");
                    localDriver = new ChromeDriver();
                    break;
                case "edge":
                    log.info("Launching Edge Browser");
                    localDriver = new EdgeDriver();
                    break;
                case "firefox":
                    log.info("Launching Firefox Browser");
                    localDriver = new FirefoxDriver();
                    break;
                default:
                    log.error("Invalid browser name provided: {}", br);
                    throw new IllegalArgumentException("No matching browser found: " + br);
            }
```
---
### 🧠 Key Features of the Local WebDriver BaseClass
1. **Project Structure**: Clear explanation of the local WebDriver setup and its structure.
2. **Local WebDriver**: Emphasized that this version of the `BaseClass` focuses only on local WebDriver initialization, simplifying the setup process.
3. **Difference from Previous Versions**: Comparison with previous versions to highlight the key changes (support for local only vs. both local and remote).

