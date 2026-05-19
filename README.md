# 🎓 The GPA Spy(Java + MySQL + Python)

A database-driven academic analytics system developed using Java, MySQL, and Python to manage and analyze student academic performance. The project integrates SQL-based student management with Python-powered analytics and reporting to generate meaningful educational insights.

---

## 🚀 Features

- Student Record Management
- Course Management System
- Student Enrollment Tracking
- Grade & Performance Management
- SQL-Based Report Generation
- Python Data Analytics Integration
- Performance Trend Analysis
- Data Visualization Support
- Power BI Dashboard Integration

---

## 🧠 Tech Stack

- Language: Java SE
- Database: MySQL
- Analytics: Python
- Database Connectivity: JDBC
- Data Processing: Pandas
- Visualization: Matplotlib
- Dashboard Tool: Power BI
- IDE: IntelliJ IDEA / VS Code

---

## ⚙️ How to Run

1. Install MySQL and create the database.

2. Execute SQL scripts:

mysql -u root -p < sql/create_tables.sql

3. Open the project in IntelliJ IDEA or VS Code.

4. Update database credentials in DatabaseManager.java:

private static final String URL = "jdbc:mysql://localhost:3306/student_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";

5. Install Python libraries:

pip install pandas matplotlib mysql-connector-python

6. Run Main.java to start the application.

7. Execute Python analytics scripts for report generation and visualization.

---

## 📁 Project Structure

The-GPA-Spy/
│
├── src/
│   ├── Main.java
│   ├── DatabaseManager.java
│   ├── Student.java
│   ├── Course.java
│   ├── Grade.java
│   └── AnalyticsManager.java
│
├── python/
│   ├── performance_analysis.py
│   ├── visualization.py
│   └── report_generator.py
│
├── sql/
│   └── create_tables.sql
│
├── powerbi/
│   └── dashboard.pbix
│
├── dataset/
│
├── README.md
└── LICENSE

---

## 📊 Python & Power BI Integration

### Python Analytics Features

- Student performance prediction
- Grade trend analysis
- Subject-wise analytics
- Attendance analysis
- Automated report generation

### Power BI Dashboard Features

- Student performance dashboard
- Course analytics
- Grade distribution visualization
- Department-wise statistics
- Academic performance trends

---

## 🧩 Sample Console Output

Database connected successfully!

--- The GPA Spy ---
1. Add Student
2. Add Course
3. Enroll Student
4. Assign Grades
5. Generate Reports
6. Run Python Analytics
7. Export Data for Power BI
0. Exit

---

## 📈 Future Enhancements

- AI-based performance prediction
- Student recommendation system
- Web-based dashboard
- Faculty analytics portal
- Real-time academic monitoring

---

## 🧑‍💻 Author

Prajakta Chhetri

GitHub Repository:
https://github.com/unforeseen18/The-GPA-Spy

---

## 📜 License

This project is developed for educational and academic purposes. It can be used for learning Java, SQL, Python analytics, database connectivity, and business intelligence concepts.
