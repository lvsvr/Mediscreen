# Mediscreen

Spring Boot application - Gradle - Microservices - Feign - Docker

---
**Instructions**
---

1-**create data base 'dbpatient' with Docker-compose:**<br>

/Mediscreen/dbpatient]<br>
$ docker pull postgres:alpine<br>
$ docker pull dpage/pgadmin4<br>
$ docker-compose up<br>
<br>
bonus:<br>
- get the IpAddress<br>
$ docker ps // to get CONTAINER ID<br>
$ docker inspect {ij} // i & j are the 2 first numbers of the CONTAINER ID<br>
- connect you IDE to the new db<br>
- connect to pgAdmin4<br>
http://localhost:5050 <br>
login: root@root.com - psw: root<br>
<br>

2-**Testing tools:**<br>

- cd /Mediscreen/patient/src/main/java/com/mediscreen/patient/tools <br>
  uncomment  : <br>
  internalPatient.java <br>
  internalTestingController.java <br>
  internalTestingParameter <br>

- GET a list of internal patients: <br>
  http://localhost:9001/testing/initializeInternalPatients
  <br>
- GET all the patients from the db: <br>
  http://localhost:9001/testing/resetDb
  <br>
  <br>

3-**Endpoints:**<br>

- GET a list of all patients:<br>
  http://localhost:9001/patient/list <br>
  <br>
- GET a patient by id: <br>
  http://localhost:9001/patient/{id} <br>
  <br>
- GET a list of patients by family name: <br>
  http://localhost:9001/patient/search/family} <br>
  <br>
- GET a patient deleted by id: <br>
  http://localhost:9001/patient/delete?id={id} <br>
  <br>
- POST a new patient to add:<br>
  http://localhost:9001/patient/add <br>
  <br>
- POST a patient to update:<br>
  http://localhost:9001/updatePatient <br>
  <br>

bonus:<br>
- connect to Swagger3: <br>
  http://localhost:9001/swagger-ui/ <br>
  <br>