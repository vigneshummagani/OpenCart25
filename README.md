# Selenium Hybrid Framework - OpenCart 🛒

This repository contains a **Selenium Hybrid Framework** designed to automate test cases for the [OpenCart](https://demo.opencart.com/) e-commerce application.  
The framework combines **Data-Driven, Keyword-Driven, and Page Object Model (POM)** approaches, making it scalable and easy to maintain.

---

## 🚀 Features
- Hybrid Framework (Data-Driven + Keyword-Driven + POM)
- Test execution using **TestNG**
- Logging with **Log4j**
- Reporting with **Extent Reports**
- Maven-based project (easy dependency management)
- Supports both **local** and **remote (Selenium Grid / Docker)** execution
- Screenshot capture on test failures
- Reusable utility classes

---

## 🛠️ Tech Stack
- **Language**: Java  
- **Build Tool**: Maven  
- **Test Runner**: TestNG  
- **Automation Tool**: Selenium WebDriver  
- **Logging**: Log4j  
- **Reporting**: Extent Reports  
- **CI/CD**: Jenkins (optional integration)  

---


## ⚡ How to Run Tests

### 1️⃣ Clone the repository
```bash
git clone https://github.com/your-username/selenium-hybrid-framework.git

2️⃣ Navigate to the project folder
cd opencart25

3️⃣ Run tests using Maven
mvn clean test
-----

4️⃣ View Reports
After execution, reports will be available at:
Extent Reports → reports/extent-report.html
Logs → reports/logs/

✅ Sample Test Cases Automated
OpenCart Login / Logout
Add Product to Cart
Search Functionality
Checkout Process
User Registration

🤝 Contribution
Feel free to fork this repo, raise issues, and submit PRs to improve the framework.

📧 Author
Vignesh Ummagani
🔗 https://www.linkedin.com/in/vignesh-ummagani-766484245/
📧 vigneshummagani19@gmail.com
