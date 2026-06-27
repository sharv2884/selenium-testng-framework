# Selenium TestNG Automation Framework

A robust UI test automation framework built with Java, Selenium 4, and TestNG during my internship at Empulse. Demonstrates professional test engineering patterns including Page Object Model, data-driven testing, parallel-ready architecture, and automated reporting.

## Framework Architecture

```
src/test/java/
├── Base/           # BaseClass (driver init, browser config, teardown)
├── Config/         # ConfigReader (externalised properties)
├── DriverManager/  # Thread-safe WebDriver management
├── Pages/          # Page Object Model (LoginPage, etc.)
├── Tests/          # Test classes (LoginTest, LoginTestClass)
├── Utilities/      # Reusable helpers:
│   ├── WaitUtil         – Explicit waits (visibility, clickability)
│   ├── ExcelUtil        – Apache POI-based data reader
│   ├── DataProviderClass – TestNG @DataProvider wired to Excel
│   ├── ScreenshotUtil   – Failure screenshot capture
│   ├── ExtentManager    – Singleton ExtentReports setup
│   ├── ExtentTestManager – ThreadLocal test node storage
│   └── RetryAnalyzer    – Auto-retry on flaky failures
└── listeners/      # TestListener (ITestListener for reporting hooks)
```

## Key Features

- **Page Object Model** — UI actions and locators separated from test logic
- **Data-Driven Testing** — Test data loaded from Excel via Apache POI; TestNG `@DataProvider` drives parameterised login tests
- **Explicit Waits** — `WaitUtil` wraps `WebDriverWait` for visibility and clickability; no `Thread.sleep()` in tests
- **Extent Reports** — HTML test report auto-generated after each run, with failure screenshots embedded
- **Retry Mechanism** — `RetryAnalyzer` retries flaky tests once before marking as failed
- **Headless Execution** — Configurable via `config.properties`; CI-ready (`--headless=new` Chrome)
- **Configurable Browser** — Switch between Chrome and Edge via properties file, no code changes

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Browser Automation | Selenium 4.18 |
| Test Framework | TestNG 7.12 |
| Build Tool | Maven |
| Reporting | ExtentReports 5 |
| Data | Apache POI 5 (Excel) |
| Logging | Log4j 2 |

## Running the Tests

**Prerequisites:** Java 17+, Maven, Chrome browser installed.

```bash
git clone https://github.com/sharvani-ar/selenium-testng-framework.git
cd selenium-testng-framework

# Run full login suite
mvn test -Dsurefire.suiteXmlFiles=testng.xml

# Run headless (CI mode)
mvn test -Dsurefire.suiteXmlFiles=testng.xml
# headless=true is already set in config.properties
```

Configuration is in `src/test/resources/config.properties`:
```properties
base.url=https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
browser=chrome
headless=true
```

Test reports are generated to `test-output/` after each run (excluded from git; regenerated on every run).

## Test Coverage

Tests run against the [OrangeHRM demo application](https://opensource-demo.orangehrmlive.com) — a publicly available HR management system used for automation practice.

| Suite | Tests | Coverage |
|---|---|---|
| Login (valid credentials) | 1 | Positive login flow, URL assertion |
| Login (data-driven) | 3 | Multiple credential sets via Excel |
| Assertions Practice | 1 | Hard + soft assert patterns |
| Data Provider | 3 | Parameterised login with invalid data |

## What I Would Add Next

- Page Object classes for Employee and Dashboard modules
- Cross-browser parallel execution via TestNG `parallel="tests"`
- GitHub Actions CI pipeline running the suite headlessly on every push
- Allure Reports integration for richer test history
