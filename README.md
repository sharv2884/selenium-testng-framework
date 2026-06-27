# Test Intelligence Dashboard

A Spring Boot web application that parses TestNG JUnit XML reports and displays them as an interactive dashboard — showing pass/fail rates, test suite breakdowns, failure frequency analysis, and slowest test identification.

**Built as a companion to [selenium-testng-framework](https://github.com/sharvani-ar/selenium-testng-framework)** — the automation framework that generates the XML reports this dashboard reads.

---

## Screenshots

> Dashboard reading real output from the Selenium TestNG framework

| Overview | Failure Analysis |
|---|---|
| _(add screenshot after running)_ | _(add screenshot after running)_ |

---

## How It Works

TestNG generates JUnit-format XML reports in `test-output/junitreports/` after every run. This Spring Boot app parses those XML files, aggregates the data, and renders it via Thymeleaf templates.

```
TestNG run → test-output/junitreports/TEST-*.xml → Spring Boot parser → Dashboard UI
```

No database needed — reports are read directly from the file system on each request.

## Features

- **Overview page** — total tests, pass rate, runtime, per-suite stat cards with mini progress bars
- **All Tests table** — filterable by PASS / FAIL / SKIP / ERROR status
- **Failure Analysis page** — most frequently failing tests ranked by count, top 5 slowest tests, full stack traces

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 17, Spring Boot 3.2 |
| Templating | Thymeleaf |
| Report Parsing | Java DOM XML parser |
| Build | Maven |
| Frontend | HTML/CSS (served as static resources) |

## Running Locally

**Prerequisites:** Java 17+, Maven.

```bash
git clone https://github.com/sharvani-ar/test-intelligence-dashboard.git
cd test-intelligence-dashboard
mvn spring-boot:run
```

Open `http://localhost:8080` — the dashboard loads immediately using the **bundled sample data** in `sample-data/junitreports/` (real output from the companion automation framework).

### Pointing to your own test reports

Update `src/main/resources/application.properties`:

```properties
# Change this to your automation project's report output folder
reports.directory=/absolute/path/to/your-automation-project/test-output/junitreports
```

Then re-run the app. It picks up the new path on startup.

## Project Structure

```
src/main/java/com/dashboard/
├── DashboardApplication.java      # Spring Boot entry point
├── controller/
│   └── DashboardController.java   # Route handlers (/, /tests, /failures)
├── model/
│   ├── TestCase.java              # Individual test case data
│   ├── TestSuite.java             # Suite-level aggregation
│   └── DashboardStats.java        # Top-level stats + computed metrics
├── parser/
│   └── TestReportParser.java      # DOM-based JUnit XML parser
└── service/
    └── DashboardService.java      # Business logic: aggregation, streak sort, slowest tests

sample-data/junitreports/          # Real TestNG output (11 suites, works out of the box)
```

## What I Would Add Next

- GitHub Actions CI integration — auto-refresh reports on push
- Historical trend charts — track pass rate across multiple runs
- Junit5 / Allure XML support
- REST API endpoints returning JSON (for CI/CD pipeline integration)
- Unit tests with MockMvc for controller layer
