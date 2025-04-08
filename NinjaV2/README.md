# 🔧 NinjaV2 Incorporating Utilities

Welcome to the **Automation Testing usign Utilities**!  
This project is built for data-driven testing with features like Excel data input, dynamic reporting, and failure tracking using screenshots.

---

## 📁 Project Structure

```plaintext
📦 src
├── 📊 ExcelUtility/       # Reads test data from Excel files
├── 🔁 DataProvider/       # Feeds test data into test cases
├── 🧪 TestCases/          # Core test scripts and validations
├── 📸 ScreenshotUtil/     # Captures screenshots on test failure
├── 📈 ExtentReports/      # Generates interactive test reports
```

## 📦 Apache POI Dependency

This project uses Apache POI for reading and writing Excel files.
Make sure to include the following dependency in your pom.xml (Maven) file:
```
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.4.0</version>
</dependency>
```
## 📦 Apache POI OOXML (for .xlsx format Excel files):
- Purpose: This dependency adds support for handling .xlsx (Office Open XML) format files, which is the modern Excel file format.
- Usage: It allows reading, writing, and modifying .xlsx files specifically, complementing the poi dependency which is for the older .xls format.
```
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.4.0</version>
</dependency>
```
