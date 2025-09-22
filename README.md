# Cookie WebApp

A Java Servlet-based web application demonstrating cookie management functionality. This application allows users to create, store, and retrieve cookies through a simple web interface.

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Technologies Used](#-technologies-used)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Local Development Setup](#-local-development-setup)
- [Running the Application](#️-running-the-application)
- [Usage](#-usage)
- [API Endpoints](#-api-endpoints)
- [Troubleshooting](#-troubleshooting)
- [Contributing](#-contributing)
- [License](#-license)
- [Support](#-support)

## 🔍 Overview

This web application demonstrates cookie management in Java servlets. Users can input their name and a secret code, which are stored as cookies in the browser. The application provides functionality to create new cookies and read existing ones, with automatic expiration after 30 minutes.

## ✨ Features

- **Cookie Creation**: Store user information (name and secret code) as browser cookies
- **Cookie Retrieval**: Display stored cookie information in a formatted table
- **Automatic Expiration**: Cookies automatically expire after 30 minutes
- **User-Friendly Interface**: Simple HTML forms for easy interaction
- **Error Handling**: Graceful handling of missing or expired cookies

## 🛠 Technologies Used

- **Java 17**: Programming language
- **Maven 3.6+**: Build and dependency management
- **Java Servlets API 4.0.1**: Web application framework
- **Apache Tomcat**: Servlet container
- **HTML/CSS**: Frontend interface
- **Heroku**: Cloud deployment platform

## 📁 Project Structure

```
CookieWebApp/
├── src/
│   └── main/
│       ├── java/
│       │   ├── CreateCookieServlet.java    # Handles cookie creation
│       │   └── ReadCookieServlet.java      # Handles cookie reading
│       └── webapp/
│           ├── index.html                  # Main user interface
│           └── WEB-INF/
│               └── web.xml                 # Web application configuration
├── target/                                 # Compiled classes and WAR file
├── pom.xml                                # Maven configuration
├── Procfile                               # Heroku deployment configuration
└── README.md                              # This file
```

## 📋 Prerequisites

Before running this application, ensure you have the following installed:

### Required Software

1. **Java Development Kit (JDK) 17 or higher**
   ```powershell
   # Check Java version
   java -version
   javac -version
   ```

2. **Apache Maven 3.6 or higher**
   ```powershell
   # Check Maven version
   mvn -version
   ```

3. **Git** (for cloning the repository)
   ```powershell
   # Check Git version
   git --version
   ```

### Installation Guide

#### Installing Java 17 (Windows)
1. Download OpenJDK 17 from [Eclipse Temurin](https://adoptium.net/)
2. Run the installer and follow the setup wizard
3. Verify installation: `java -version`

#### Installing Maven (Windows)
1. Download Maven from [Apache Maven](https://maven.apache.org/download.cgi)
2. Extract to a directory (e.g., `C:\apache-maven-3.9.4`)
3. Add Maven bin directory to your PATH environment variable
4. Verify installation: `mvn -version`

## 🚀 Local Development Setup

### 1. Clone the Repository

```powershell
# Clone the repository
git clone https://github.com/ShogunTestOrg/cookie-webapp.git
cd cookie-webapp
```

### 2. Verify Project Structure

Ensure your project has the following structure:
- `src/main/java/` contains servlet classes
- `src/main/webapp/` contains web resources
- `pom.xml` exists in the root directory

### 3. Install Dependencies

```powershell
# Clean and compile the project
mvn clean compile

# Download all dependencies
mvn dependency:resolve
```

## 🏃‍♂️ Running the Application

### Method 1: Using Maven Tomcat Plugin (Recommended)

```powershell
# Build the project
mvn clean package

# Start the embedded Tomcat server
mvn tomcat7:run
```

The application will be available at: **http://localhost:8080/cookie-webapp**

### Method 2: Using External Tomcat Server

1. **Build the WAR file:**
   ```powershell
   mvn clean package
   ```

2. **Deploy to Tomcat:**
   - Copy `target/cookie-webapp.war` to your Tomcat `webapps/` directory
   - Start Tomcat server
   - Access: **http://localhost:8080/cookie-webapp**

### Method 3: Using Webapp Runner (Heroku-style)

```powershell
# Build the project (this downloads webapp-runner.jar)
mvn clean package

# Run using webapp-runner
java -jar target/dependency/webapp-runner.jar --port 8080 target/cookie-webapp.war
```

Access the application at: **http://localhost:8080**

## 📖 Usage

### Creating Cookies

1. Open your browser and navigate to the application URL
2. Fill in the form with:
   - **Name**: Your username
   - **Secret Code**: Any secret code you want to store
3. Click "Create Cookie" button
4. You'll see a confirmation page showing the stored information

### Reading Cookies

1. Click "View Stored Information" from the main page, or
2. Click "Read Cookie" from the confirmation page
3. The application will display your stored information in a table format
4. If no cookies exist or they've expired, you'll see an appropriate message

### Cookie Expiration

- Cookies automatically expire after **30 minutes**
- Expired cookies will not be displayed when reading
- You'll need to create new cookies after expiration

## 🔗 API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/` | GET | Main page with cookie creation form |
| `/CreateCookieServlet` | POST | Creates new cookies with user data |
| `/ReadCookieServlet` | GET | Retrieves and displays stored cookies |

## 🔧 Troubleshooting

### Common Issues

#### "Port already in use" Error
```powershell
# Find process using port 8080
netstat -ano | findstr :8080

# Kill the process (replace PID with actual process ID)
taskkill /PID <PID> /F

# Or use a different port
mvn tomcat7:run -Dmaven.tomcat.port=8081
```

#### Maven Build Errors
```powershell
# Clean Maven cache and rebuild
mvn clean
mvn dependency:purge-local-repository
mvn clean compile package
```

#### Java Version Issues
```powershell
# Check JAVA_HOME environment variable
echo $env:JAVA_HOME

# Set JAVA_HOME if needed (adjust path to your JDK installation)
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-17.0.8.101-hotspot"
```

#### Cookies Not Working
- Ensure your browser allows cookies
- Check that you're accessing the application through the correct URL
- Clear browser cache and cookies if needed
- Verify that cookies haven't expired (30-minute limit)

### Logs and Debugging

- **Maven logs**: Check console output when running `mvn tomcat7:run`
- **Application logs**: Available in the terminal where you started the server
- **Browser Developer Tools**: Use F12 to inspect network requests and cookies

### Development Tips

1. **Hot Reload**: Use `mvn tomcat7:run` for automatic reloading during development
2. **IDE Integration**: Import the project as a Maven project in your IDE
3. **Debug Mode**: Add `-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005` to Java options for debugging

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature-name`
3. Make your changes and commit: `git commit -am 'Add new feature'`
4. Push to the branch: `git push origin feature-name`
5. Submit a pull request

### Development Guidelines

- Follow Java naming conventions
- Add comments for complex logic
- Test your changes thoroughly
- Update documentation as needed

## 📝 License

This project is created for educational purposes as part of Web Programming Lab coursework.

---

## 📞 Support

If you encounter any issues or have questions:

1. Check the [Troubleshooting](#troubleshooting) section
2. Review the Maven and Java installation guides
3. Ensure all prerequisites are properly installed
4. Verify that ports are not blocked by firewall

**Quick Start Command:**
```powershell
mvn clean package && mvn tomcat7:run
```

Then open: **http://localhost:8080/cookie-webapp**
