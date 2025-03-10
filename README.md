# Test Assignment: Organization Management

This Java Spring application manages organizational data, including full and short names, INN, OGRN, postal and legal
addresses, director information, and branch details, utilizing Hibernate for database interaction. For detailed
requirements and instructions, please refer to the task description provided in the `task.txt` file at the root of the
project.

## Local Development Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/sidorovmsk/aontt_test.git
    cd aontt_test
    ```

2. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```


3. **Swagger UI:**

   After starting, Swagger UI will be accessible
   at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

   You can use Swagger UI to interact with your API and view documentation.

## Additional Configurations

- **PostgreSQL:**

  The project uses a PostgreSQL database. Adjust database settings in `application.yaml` if needed.

- **Additional Environment Variables:**

  You can configure other environment variables, such as the application port and other parameters, in the `.env` file.

## Notes

- Ensure that ports 8080 and 5432 (default) are not being used by other processes on your computer.
