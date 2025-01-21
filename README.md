# Currency Converter

A simple and user-friendly currency converter application built using Java and Thymeleaf. This application allows users to convert amounts between different currencies using real-time exchange rates.

## Features

- Convert any amount from one currency to another.
- Get real-time exchange rates from rapid api's  Fast Price Exchange rates  Api (https://rapidapi.com/apiwizard/api/fast-price-exchange-rates)
- Display results with the base and target currencies.

## Technologies Used

- **Java** (for backend logic)
- **Spring Boot** (for creating the backend application)
- **Thymeleaf** (for rendering dynamic HTML pages)
- **HTML/CSS** (for frontend design)
- **RESTful API** (for fetching live exchange rates)

## Installation

To run this project locally:

### Prerequisites
- JDK 17 or higher
- Maven
- IDE ( Eclipse)

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/currency-converter.git
2. Subscribe to Rapid Api's fast price exchange Api  (https://rapidapi.com/apiwizard/api/fast-price-exchange-rates)
3. Get your own api key and add it in Line 16 of src/main/java/com/mrinal/MainApp/ApiService.java class
4. Run the Spring Boot app  from   src/main/java/com/mrinal/MainApp/CurrencyConverterApplication.java class
5. Open http://localhost:8080/convert on yout browser , and enter the base currency and target currency and amount
6. Press Convert , wait while it processes
7. It gives you the current exchange rate between currencies and the amount in target currency 
