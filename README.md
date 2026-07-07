# Employee Payroll Management System

A simple Java (Jakarta Servlet + JSP) web application for managing employee payroll records. It supports:
- Add a payroll record
- View payroll record by **Employee Name + Payment Date**
- View all payroll records

## Tech Stack
- Java 21
- Jakarta Servlet (Tomcat 10.1)
- JSP (JavaServer Pages)
- Oracle Database (JDBC)

## Project Structure
- `src/main/java/com/wipro/payroll/bean/PayrollBean.java`
- `src/main/java/com/wipro/payroll/dao/PayrollDAO.java` (DB operations)
- `src/main/java/com/wipro/payroll/service/Administrator.java` (business logic)
- `src/main/java/com/wipro/payroll/servlets/MainServlet.java` (request routing)
- `src/main/webapp/*.jsp` (UI)
- `src/main/webapp/menu.html` (entry page)

## Application Pages / Flow
1. **Home Menu:** `src/main/webapp/menu.html`
2. **Add Record:** `src/main/webapp/addPayroll.jsp`
3. **View Record:** `src/main/webapp/viewPayroll.jsp` → `MainServlet` → `displayPayroll.jsp`
4. **View All Records:** `src/main/webapp/viewAllPayrolls.jsp` → `MainServlet` → `displayAllPayrolls.jsp`
5. **Status Pages:** `src/main/webapp/success.html`, `src/main/webapp/error.html`

## Database Setup (Oracle)
This project expects an Oracle table `payroll_tbl` and a sequence used to generate record ids.

### Connection (see `DBUtil.java`)
Update credentials and URL if needed:
- URL: `jdbc:oracle:thin:@localhost:1521:xe`
- User: `YOUR USERNAME`
- Password: `YOUR PASSWORD`

> Note: The repository references a JDBC driver JAR via Eclipse `.classpath`.

## How to Run
### Prerequisites
- Oracle XE running
- JDBC driver for Oracle configured in your IDE
- Tomcat 10.1

### Steps
1. Import the project into Eclipse/STS (Java EE / Web Project).
2. Ensure Tomcat is configured for the project.
3. Create/verify the required Oracle schema objects (`payroll_tbl`, required columns, and sequence).
4. Update DB credentials in `src/main/java/com/wipro/payroll/util/DBUtil.java`.
5. Deploy to Tomcat.
6. Open the application starting from `menu.html`.

## Usage
- To add: fill `addPayroll.jsp` and submit.
- To view single record: use `viewPayroll.jsp` and enter **Employee Name** and **Payment Date**.
- To view all: use `viewAllPayrolls.jsp`.

## Notes
- The app uses a single servlet (`MainServlet`) with an `operation` parameter to decide the action.
- Validation is handled in `Administrator` and errors redirect to `error.html`.

## License
preferred license

