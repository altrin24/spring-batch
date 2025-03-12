# **Optimized Excel to MySQL Data Processing**

## **Overview**

This project efficiently processes **1 million records** from an Excel file and inserts them into a **MySQL database** within **10 seconds** (or **7 seconds** if the column count is lower).

## **Optimization Techniques Used**

### ✅ **1. Used Plain JDBC Instead of JPA**

- Avoids the overhead of **Hibernate/JPA**.
- Provides **direct control** over batch inserts.

### ✅ **2. Implemented Multithreading**

- Divides the workload into multiple **parallel threads**.
- Achieves **faster data insertion** by leveraging **all CPU cores**.

### ✅ **3. Enabled Bulk Insert with **``

- Appended `?rewriteBatchedStatements=true` to the **JDBC URL**.
- Allows MySQL to **optimize batch inserts** by converting multiple single-row inserts into a **single bulk insert statement**.

## **JDBC URL Example**

```plaintext
jdbc:mysql://localhost:3306/your_db?rewriteBatchedStatements=true
```

## **How to Run the Project**

1. Clone the repository:
   ```sh
   git clone [https://github.com/altrin24/spring-batch.git]
   ```
2. Navigate to the project directory:
   ```sh
   cd spring-batch
   ```
3. Build and run the application:
   ```sh
   mvn clean install
   java -jar target/your-application.jar
   ```

## **Performance Metrics**

- **1 million records** processed in **7-10 seconds**.
- **Significant improvement** over traditional JPA-based inserts.

## **Contributing**

Feel free to submit issues and pull requests to improve performance further!

---

🔥 **Optimized for high-speed bulk inserts!** 🚀

