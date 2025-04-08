# 📝 Working with run.dat Files & Maven Plugins

Welcome to the **run.dat Files & Maven Plugin Setup**!  
This project handles both text-based and binary `run.dat` files and configures Maven plugins to manage Java compilation and test execution.

---

## 📁 Project Structure

```plaintext
📦 src
├── 🧑‍💻 Main/                     # Java source code and logic
├── 🧪 TestCases/                  # Test cases defined using TestNG
├── 🗂 Resources/                  # Resources including run.dat files
└── 📝 Configs/                    # Maven configurations (pom.xml, etc.)
```
## How to Work with run.dat Files:
- Text-based run.dat Files: You can usually open these files in any text editor (e.g., Notepad, VS Code) if they are in plain text format.
- Binary run.dat Files: If the file is binary, you may need specific software or scripts to interpret or extract the data.
If you're working with a specific framework or tool that uses a run.dat file, the tool's documentation would be the best place to look for detailed information about the format and usage.
---
## ⚙️ Maven Plugins Configuration
This project is configured with Maven to handle compilation and test execution. Here are two key Maven plugins configured in the pom.xml file:

## 1. 📦maven-compiler-plugin
The maven-compiler-plugin compiles the Java source code based on the specified version and configurations in the pom.xml. It ensures that the Java files are compiled with the correct JDK version.
```
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.8.1</version>
      <configuration>
        <source>1.8</source>
        <target>1.8</target>
      </configuration>
    </plugin>
  </plugins>
</build>
```
## 2.📦maven-surefire-plugin
The maven-surefire-plugin runs your tests (e.g., TestNG tests) as defined in a test suite XML file, like testng.xml. It allows you to automate test execution as part of the Maven build lifecycle.
```
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>2.22.2</version>
      <configuration>
        <suiteXmlFiles>
          <suiteXmlFile>testng.xml</suiteXmlFile>
        </suiteXmlFiles>
      </configuration>
    </plugin>
  </plugins>
</build>
```
### Key Features:
1. **Project Structure**: Provides an overview of the project, with a focus on the organization of Java code, test cases, and resources like `run.dat` files.
2. **Working with `run.dat` Files**: Explains how to handle both text-based and binary `run.dat` files.
3. **Maven Plugins**: Describes the `maven-compiler-plugin` and `maven-surefire-plugin` used for compiling and running tests.
