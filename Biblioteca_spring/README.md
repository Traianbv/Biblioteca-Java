# Biblioteca Management System

## Descriere
Biblioteca Management System este o aplicație web dezvoltată cu Spring Boot care permite gestionarea eficientă a unei biblioteci. Sistemul oferă funcționalități pentru administrarea cărților, cititorilor și împrumuturilor.

## Funcționalități

### Managementul Cărților
- Adăugare cărți noi în sistem
- Vizualizarea tuturor cărților
- Vizualizarea cărților disponibile pentru împrumut
- Actualizarea statusului cărților (disponibil/împrumutat)

### Managementul Cititorilor
- Înregistrarea cititorilor noi
- Vizualizarea listei de cititori
- Gestionarea statusului abonamentelor

### Sistem de Împrumut
- Împrumutarea cărților către cititori
- Returnarea cărților
- Urmărirea datelor de împrumut și returnare
- Verificarea disponibilității cărților

## Tehnologii Utilizate
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (in-memory)
- Thymeleaf
- Bootstrap 5
- Maven

## Structura Proiectului

### Entități
- `Carte`: Gestionează informațiile despre cărți
- `Cititor`: Stochează datele cititorilor
- `Imprumut`: Managementul împrumuturilor

### Repository
- `CarteRepository`: Operații CRUD pentru cărți
- `CititorRepository`: Operații CRUD pentru cititori
- `ImprumutRepository`: Operații CRUD pentru împrumuturi

### Service
- `BibliotecaService`: Logica de business pentru toate operațiunile

### Controller
- `BibliotecaController`: Gestionează cererile HTTP și rutarea

## Configurare și Instalare

### Cerințe Preliminare
- Java JDK 17 sau mai nou
- Maven
- IDE (recomandat: IntelliJ IDEA sau Eclipse)

