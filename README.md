Business requirements
1. Develop web service for Gift Certificates system with the following entities (many-to-many):

2. The system should expose REST APIs to perform the following operations:
3. 
CRUD operations for GiftCertificate. 
If new tags are passed during creation/modification – they should be created in the DB.
For update operation - update only fields, that pass in request, others should not be updated.
Batch insert is out of scope.

CRD operations for Tag.

Get certificates with tags (all params are optional and can be used in conjunction):
by tag name (ONE tag)
search by part of name/description (can be implemented, using DB function call)
sort by date or by name ASC/DESC (extra task: implement ability to apply both sort type at the same time).

Application requirements
1. JDK version: 8 – use Streams, java.time.*, etc. where it is possible. 
(the JDK version can be increased in agreement with 
the mentor/group coordinator/run coordinator)

2. Application packages root: com.epam.esm

3. widely-used connection pool could be used.

4. JDBC / Spring JDBC Template should be used for data access.

5. Use transactions where it’s necessary.

6. Java Code Convention is mandatory (exception: margin size – 120 chars).

7. Build tool: Maven/Gradle, latest version. Multi-module project.

8. Web server: Apache Tomcat/Jetty.

9. Application container: Spring IoC. Spring Framework, the latest version.

10. Database: PostgreSQL/MySQL, latest version.

11. Testing: JUnit 5.+, Mockito.

12. Service layer should be covered with unit tests not less than 80%.

13. Repository layer should be tested using integration tests with an 
in-memory embedded database (all operations with certificates).