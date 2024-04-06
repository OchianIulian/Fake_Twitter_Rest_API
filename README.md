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
- sa creeze postari
- sa vada postarile prietenilor
- sa isi vada propriile postari


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
  - /post/create (utilizatorul conectat creaza o postare)
  - /like/(post_id)(utilizatorul da like la o postare)
  - /reply/post/(post_id)(utilizatorul raspunde la o postare)
- PUT
  - /follow/(user_email) (urmareste un utilizator in functie de email si se updateaza si entitatea user in care apare cine o urmareste si pe cine urmareste sub forma a 2 liste)  
- GET
  - /user/user-info/(user_email) (returneaza redalii despre userul cu emailul dat)
  - /user/user-info (returneaza detalii despre contul utilizatorului conectat)
  - /post/get-own-posts (returneaza toate postarile personale)
  - /post/get-feed (returneaza toate postarile prietenilor)
  - /like/(post-id)(returneaza numarul de like uri ale unei postari)
- DELETE
  - /user/del-personal-acc (sterge contul utilizatorului conectat)
  - /post/delete-post/(post_id) (sterge o postare dupa id_ul ei)
  - /user/unfollow/(user-email) (anuleaza urmarirea unui utilizator in functie de adresa de email)
  - /like/(post-id)(sterge un like de la o postare)


Acesta este un ghid de bază pentru utilizarea API-ului Fake Twitter. Asigurați-vă că sunteți autentificat pentru a accesa anumite resurse și respectați cerințele de intrare specifice pentru fiecare endpoint.

