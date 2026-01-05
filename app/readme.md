# Android Mahasiswa App

Aplikasi Android untuk menampilkan **data mahasiswa** yang diambil dari **Backend Mahasiswa API**.  
Aplikasi ini dibangun menggunakan **Java**, **RecyclerView**, dan **Volley** sebagai HTTP client.

---

## 📱 Features
- Menampilkan daftar mahasiswa
- Pencarian mahasiswa berdasarkan **nama**
- Data diambil dari REST API
- RecyclerView untuk list data
- ProgressBar saat loading data
- Error handling dengan Toast
- UI modern menggunakan Material Design

---

## 🚀 Tech Stack

### 🧠 Core
- **Android Studio**
- **Java**
- **Minimum SDK 25**

---

### 🌐 Networking
- **Volley** – HTTP request & JSON parsing

---

### 🎨 UI Components
- **RecyclerView**
- **MaterialCardView**
- **ProgressBar**
- **LinearLayout**
- **Material Design**

---


## 🌐 API Integration


## ⚠️ Catatan Penting

- localhost tidak bisa di Android

- Gunakan IP lokal laptop

- Android & laptop harus 1 jaringan WiFi

- HTTP diizinkan dengan: android:usesCleartextTraffic="true"

### Base URL
```java
String BASE_URL = "http://IP_LOCAL_LAPTOP:3000/api/mahasiswa";





