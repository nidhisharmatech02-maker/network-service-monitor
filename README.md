# Network Service Monitor

A simple distributed network monitoring service built with Java Spring Boot.

## What this repo contains
- Multithreaded health checks (concurrent HTTP checks)
- REST API to run checks, manage targets, and read recent metrics
- Stores metrics in a relational DB (H2 for demo; Oracle for production)
- Integration test and GitHub Actions CI workflow
- Dockerfile and docker-compose for local demo

## Quick demo (no external DB required)
1. Build:
```bash
mvn clean package
```
2. Run:
```bash
java -jar target/network-service-monitor-0.0.1-SNAPSHOT.jar
```
The app runs with an in-memory H2 DB (demo profile). Endpoints:
- `GET /api/v1/health/run`
- `GET /api/v1/health/targets`
- `POST /api/v1/health/targets` with JSON `{ "name": "...", "endpoint": "https://..." }`
- `GET /api/v1/metrics/recent?limit=20`

## Running with Docker
Build and run with docker-compose:
```bash
docker-compose up --build
```
App will be available at `http://localhost:8080`.

## Switching to Oracle (production)
Replace DB properties in `application.properties` with your Oracle connection or create a `application-prod.properties` and activate the `prod` profile.
Note: Oracle JDBC driver is **not** included due to licensing.

## Tests & CI
- A basic Spring Boot test is included (`src/test/...`).
- GitHub Actions workflow (`.github/workflows/java-ci.yml`) runs `mvn package` on push/PR.

## How to upload this project to GitHub (step by step)

1. Create a GitHub repository:
   - Go to https://github.com and sign in.
   - Click **New** and create a repository (e.g., `network-service-monitor`).
   - Do **not** initialize with a README (we already have one).

2. Initialize git locally and push:
```bash
cd /path/to/network-service-monitor
git init
git add .
git commit -m "Initial commit - Network Service Monitor"
git branch -M main
git remote add origin https://github.com/<your-username>/network-service-monitor.git
git push -u origin main
```
Replace `<your-username>` with your GitHub username. If using SSH, use the SSH URL.

3. Enable GitHub Actions:
- After push, go to the repository's **Actions** tab to see CI runs.

4. Add repository secrets (if later switching to Oracle or other credentials):
- Go to **Settings → Secrets & variables → Actions → New repository secret** and add `DB_USERNAME`, `DB_PASSWORD`, etc.

## What I changed for "ready to upload"
- Added H2 runtime dependency and `schema.sql` so the app runs locally without Oracle.
- Added an integration test and GitHub Actions workflow.
- Added `docker-compose.yml` and expanded README with upload instructions.
- Kept Oracle placeholders for production use.

## Next help I can do (pick any)
- Add GitHub `README` badges (build, license, etc.).
- Add a small architecture diagram (SVG) and example screenshots.
- Create a polished resume-ready README blurb summarizing your contributions.

