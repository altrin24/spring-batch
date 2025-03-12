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

## **Database Table Schema**

To store Excel data in MySQL, use the following table structure:

```sql
CREATE TABLE batch.excel_data (
    col1 VARCHAR(255),
    col2 VARCHAR(255),
    col3 VARCHAR(255),
    col4 VARCHAR(255),
    col5 VARCHAR(255),
    col6 VARCHAR(255),
    col7 VARCHAR(255),
    col8 VARCHAR(255),
    col9 VARCHAR(255),
    col10 VARCHAR(255),
    col11 VARCHAR(255),
    col12 VARCHAR(255)
);
```

## **How to Run the Project**

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/your-repo.git
   ```
2. Navigate to the project directory:
   ```sh
   cd your-repo
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

