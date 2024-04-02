# Fake_Twitter_Rest_API

Această aplicație este un REST API care simulează funcționalitățile de bază ale platformei Twitter. Este dezvoltată în Java folosind Spring Boot.

## Cuprins

- [Descriere](#descriere)
- [Tehnologii utilizate](#tehnologii-utilizate)
- [Configurare](#configurare)
- [Endpoints](#endpoints)

## Descriere

Fake Twitter REST API este o aplicație backend care permite utilizatorilor:

- să se înregistreze, să se autentifice
- să urmărească alți utilizatori
- să șteargă permanent propriul cont 
- să obțină informații despre contul lor sau despre alte conturi identificate după adresă de email.


## Tehnologii utilizate

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL (sau orice altă bază de date relațională)
- JWT authentication

## Configurare

1. Clonați sau descărcați proiectul de pe GitHub.
2. Importați proiectul într-un mediu de dezvoltare Java (de exemplu, IntelliJ IDEA, Eclipse).
3. Asigurați-vă că aveți o bază de date MySQL instalată și rulați scriptul `create database fake_twitter_database` pentru a crea schema bazei de date.
4. Modificați fișierul `application.properties` pentru a specifica detaliile de conectare la baza de date MySQL.

```properties
spring.application.name=Fake_Twitter_Rest_API
spring.jpa.hibernate.ddl-auto=create-drop
spring.datasource.url=jdbc:mysql://localhost:3306/fake_twitter_database
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8081


server.error.include-message=always 
```

## Endpoints

- POST
  - /registration/register (inregistrare utilizator nou)
  - /registration/login (login)
- PUT
  - /follow/(user_email) (urmareste un utilizator in functie de email)
- GET
  - /user/user-info/(user_email) (returneaza redalii despre userul cu emailul dat)
  - /user/user-info (returneaza detalii despre contul utilizatorului conectat)
- DELETE
  - /user/del-personal-acc (sterge contul utilizatorului conectat)


Acesta este un ghid de bază pentru utilizarea API-ului Fake Twitter. Asigurați-vă că sunteți autentificat pentru a accesa anumite resurse și respectați cerințele de intrare specifice pentru fiecare endpoint.

