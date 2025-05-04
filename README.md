
# 🌍 Smart Trip Recommendation System

A smart and personalized trip recommendation system that helps users discover ideal travel destinations based on their preferences. Built using **Spring Boot**, **MongoDB**, **React.js**, and **Java ML libraries**, it offers custom itinerary planning and recommendations, with plans to integrate bookings and chatbot assistance.

---

## 🚀 Features

- ✈️ **Personalized Trip Recommendations** using machine learning
- 🧭 **Itinerary Planning** with destination highlights
- 🧠 **AI-Driven Suggestions** based on user interests and travel history
- 📦 **RESTful API Backend** with Spring Boot
- 🧾 **MongoDB Integration** for storing user and trip data
- 🔐 **Secure Password Hashing**
- 📄 **Proper Request Validations & Status Handling**
- 🔄 **PUT Endpoints for Updates**
- 📈 **Scalable Architecture** for future integrations (bookings, chatbot)

---

## 🛠 Tech Stack

- **Frontend**: React.js
- **Backend**: Spring Boot (Java)
- **Database**: MongoDB
- **Machine Learning**: Java ML Libraries
- **Security**: Password hashing, Input validations
- **Other**: Maven, Postman (for API testing), Git

---

## 📦 Project Structure

```bash
smart-trip-recommendation/
├── backend/
│   ├── controller/
│   ├── service/
│   ├── model/
│   ├── repository/
│   ├── exception/
│   ├── config/
├── frontend/
│   ├── components/
│   ├── pages/
│   ├── services/
│   └── App.js
```

---

## ⚙️ Setup Instructions

### Prerequisites

- Java 17+
- Node.js and npm
- MongoDB installed or hosted (e.g., MongoDB Atlas)

### Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run
```

### Frontend (React.js)

```bash
cd frontend
npm install
npm start
```

> Make sure to configure your environment variables and MongoDB URI in the backend application properties or `.env`.

---

## 📱 Usage

1. Visit the web app in your browser at `http://localhost:8080`.
2. Sign up and log in.
3. Fill out your travel preferences.
4. Receive AI-based destination recommendations.
5. Save or edit your itinerary.

---

## 🔮 Future Scope

- 🏨 Hotel & Flight Booking Integration
- 🤖 Travel Chatbot Assistant
- 📍 Real-time Location-based Suggestions
- 🌐 Multi-language Support

---

## 👥 Contributors

- Chirag Singh – Developer, Backend Architect
- Deepak Kumar - Developer, Frontend Architect

---

## 📝 License

This project is licensed under the [MIT License](LICENSE).

