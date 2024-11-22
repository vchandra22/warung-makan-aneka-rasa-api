# Warung Makan Bahari REST API

Warung Makan Bahari REST API is a backend application built using Spring Boot, designed to manage data and operations for a restaurant system.

## Features
- RESTful API endpoints for managing menu items, orders, and customers.
- PostgreSQL database integration.
- Hibernate for ORM and database interaction.
- Detailed SQL logging for debugging.

## Getting Started

### Prerequisites
Before you begin, ensure you have the following installed:
- Java 17+
- Maven 3.8+
- PostgreSQL 17.1+

### Installation

1. Clone the repository:
   ```bash
   git clone <https://github.com/vchandra22/warung-makan-aneka-rasa-api.git>
   cd <repository-folder>

2. Configure the database:
   Create a PostgreSQL database named ``aneka_rasa_db`` and update the username and password in application-properties.xml if necessary.

3. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   
4. The application will be available at:
   ```bash
   http://localhost:8086

### Configuration
The main configuration is in src/main/resources/application-properties.xml.
Key properties:
- spring.application.name: Application name.
- server.port: Server port (default: 8080).
- Database connection details (spring.datasource.*).
- Hibernate settings (spring.jpa.*).

### Technologies Used
- Java: Programming language.
- Spring Boot: Framework for building RESTful APIs.
- PostgreSQL: Relational database.
- Hibernate: ORM framework.

### Contributing
Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a feature branch:
    ```bash
   git checkout -b feature/your-feature-name
3. Commit your changes:
    ```bash
   git commit -m "feat: describe your feature"
4. Push to your branch:
    ```bash
   git push origin feature/your-feature-name
5. Open a pull request.

### License
This project is licensed under the MIT License.

### Contact
For any questions or issues, please open an issue in the repository.
```bash
Feel free to adjust the content as per your project’s actual needs or to add/remove sections!
