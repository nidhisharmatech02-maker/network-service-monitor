# **Network Service Monitor**

A distributed network monitoring service built using **Java** and **Spring Boot**.  
This project demonstrates a scalable system for monitoring network health, latency, and uptime across distributed services, with REST APIs and database-backed metric storage.

---

## 🚀 **Key Features**
- Monitors **system health**, **latency**, and **uptime** in real-time.  
- Implements **multithreaded health checks** for concurrent network status tracking.  
- Provides **RESTful APIs** to trigger checks, manage targets, and fetch metrics.  
- Stores data in **Oracle Database** (with **H2** for demo mode).  
- **Dockerized setup** for quick deployment and testing.  
- Includes **GitHub Actions CI workflow** for automated build and test execution.  

---

## 🧰 **Tech Stack**
- **Language:** Java  
- **Framework:** Spring Boot  
- **Database:** Oracle / H2 (for demo)  
- **Build Tool:** Maven  
- **Containerization:** Docker, Docker Compose  
- **Version Control & CI/CD:** Git, GitHub, GitHub Actions  

---

## 💡 **Highlights**
- Developed a **distributed monitoring system** capable of handling multiple endpoints simultaneously.  
- Designed **modular Java components** with clean architecture and easy scalability.  
- Ensures **REST-based data access** and easy integration with cloud services.  
- Provides a **fully functional local demo setup** for recruiters and reviewers.  

---

## 🖥️ **How to Run (Demo Mode)**

### 1️ **Build the project**
```text
mvn clean package
```

### 2️⃣ **Run the JAR file**
```text
java -jar target/network-service-monitor-0.0.1-SNAPSHOT.jar
```

### 3️⃣ **Access the API endpoints**

- GET /api/v1/health/run — Run health check
- GET /api/v1/health/targets — View all monitored targets
- POST /api/v1/health/targets — Add new target
- GET /api/v1/metrics/recent?limit=20 — Fetch recent metrics

## 🐳 **Run with Docker**

To build and run the application using Docker:

```text
docker-compose up --build 
```
App will be available at: http://localhost:8080


## 🧪 ** Testing & CI**

Includes Spring Boot test cases for key modules.

Integrated GitHub Actions workflow to automatically build and test on every push or pull request.

## 🗂️ ** Project Structure**
```text
network-service-monitor/
├── src/
│   ├── main/java/...          # Source code (controllers, services, models)
│   ├── test/java/...          # Unit & integration tests
│   └── resources/
│       ├── application.properties
│       └── schema.sql
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

## 🔮 **Future Enhancements**

- Add a React-based dashboard to visualize network metrics.

- Implement alert notifications (Slack/Email) for downtime.

- Extend support for TCP and DB connection monitoring.

- Introduce user authentication and role-based access control.

## 🧑‍💻 Author

Nidhi Sharma

Full Stack Developer | Java & MERN Enthusiast

📧 nidhisharmatech02@gmail.com


### ⭐ If you like this project, consider giving it a star on GitHub!

