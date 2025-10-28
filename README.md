# **Network Service Monitor**

A distributed network monitoring service built using **Java** and **Spring Boot**.

---

## 🚀 Key Features
- Monitors network **health**, **latency**, and **uptime** across multiple services.  
- Implements **multithreaded health checks** for concurrent monitoring.  
- Provides **RESTful APIs** for triggering and viewing health reports.  
- Stores and analyzes metrics in **Oracle Database** (H2 used for demo).  
- **Dockerized setup** for easy deployment and scalability.  
- Integrated **GitHub Actions CI workflow** for automated testing and builds.  

---

## 🧰 Tech Stack
- **Backend:** Java, Spring Boot  
- **Database:** Oracle / H2 (for demo)  
- **Build Tool:** Maven  
- **Containerization:** Docker & Docker Compose  
- **Version Control & CI/CD:** GitHub + GitHub Actions  

---

## 💡 Highlights
- Designed and implemented **distributed, production-grade monitoring modules**.  
- Ensures **real-time system health tracking** and API-driven accessibility.  
- Clean architecture for scalability and maintainability.  
- Ready-to-run demo setup (H2 DB) for recruiters and reviewers.  

---

## 🖥️ How to Run (Demo Mode)
```bash
mvn clean package
java -jar target/network-service-monitor-0.0.1-SNAPSHOT.jar
