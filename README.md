# Advanced Network Port Scanner

## Overview

Advanced Network Port Scanner is a Java-based cybersecurity tool designed to identify open TCP ports and detect commonly used network services on a target host. The application provides a graphical user interface (GUI), multithreaded scanning, report generation, and scan statistics to deliver an efficient and user-friendly network scanning experience.

## Features

* TCP Port Scanning
* Service Detection (HTTP, HTTPS, SSH, MySQL, etc.)
* Multithreaded Scanning using Java Concurrency
* Interactive Java Swing GUI
* Input Validation and Error Handling
* Automated Scan Report Generation
* Scan Statistics Dashboard
* Git Version Control and GitHub Integration

## Technologies Used

* Java
* Java Swing
* Socket Programming
* Multithreading
* ExecutorService (Thread Pool)
* File Handling
* Git & GitHub

## Project Structure

```text
Network_Port_Scanner/
│
├── src/
│   ├── Main.java
│   ├── PortScannerGUI.java
│   ├── ServiceDetector.java
│   ├── ReportGenerator.java
│   └── ...
│
├── scan-report.txt
├── README.md
└── screenshots/
```

## How It Works

1. Enter a target Host/IP address.
2. Specify the Start Port and End Port.
3. Click the Scan button.
4. The scanner attempts TCP connections to each port.
5. Open ports are displayed along with detected services.
6. Scan results are saved to a report file.
7. Scan statistics are generated after completion.

## Sample Output

```text
[OPEN] Port 22 -> SSH
[OPEN] Port 80 -> HTTP
[OPEN] Port 443 -> HTTPS

====================
SCAN SUMMARY
====================
Target: localhost
Total Ports Scanned: 981
Open Ports Found: 4
Time Taken: 0.42 seconds
```

## Key Concepts Implemented

### Socket Programming

The scanner uses Java Sockets to establish TCP connections and determine whether a port is open.

### Multithreading

Concurrent scanning improves performance and reduces total scan time.

### Service Detection

Common ports are mapped to well-known services such as:

| Port | Service    |
| ---- | ---------- |
| 22   | SSH        |
| 80   | HTTP       |
| 443  | HTTPS      |
| 3306 | MySQL      |
| 5432 | PostgreSQL |

### Report Generation

Scan results are automatically stored in a text report for future analysis.

## Learning Outcomes

Through this project, I gained practical experience in:

* Computer Networking
* TCP/IP Fundamentals
* Socket Programming
* Java GUI Development
* Concurrent Programming
* Cybersecurity Fundamentals
* Software Design and Documentation
* Git and GitHub Workflow

## Future Enhancements

* PDF Report Export
* Dark Mode UI
* Banner Grabbing
* Host Discovery
* Vulnerability Detection
* Network Range Scanning
* Spring Boot Web Version

## Author

**Rahul Yadav**

B.Tech (Cybersecurity)

Passionate about Cybersecurity, Java Development, and Problem Solving.

GitHub: https://github.com/RahulYadav294
