# 🚀 CodeAlpha App Development Tasks

<p align="center">

  <img src="https://img.shields.io/badge/CodeAlpha-App%20Development-blueviolet?style=for-the-badge" alt="CodeAlpha">

  <img src="https://img.shields.io/badge/Android-Java-brightgreen?style=for-the-badge&logo=android" alt="Android">

  <img src="https://img.shields.io/badge/UI-XML-blue?style=for-the-badge" alt="XML">

  <img src="https://img.shields.io/badge/Projects-2-orange?style=for-the-badge" alt="Projects">

</p>

<p align="center">
  <b>A collection of Android applications developed as part of the CodeAlpha App Development Tasks.</b>
</p>

---

## 📱 Projects

This repository contains Android application development projects built using **Java, XML, Android Studio, and Android SDK**.

| Task       | Project                                    | Description                                          | Technology          |
| ---------- | ------------------------------------------ | ---------------------------------------------------- | ------------------- |
| **Task 1** | 📚 **StudyDeck — Flashcard Quiz App**      | Create and study customizable flashcards             | Java + XML + SQLite |
| **Task 2** | ✨ **QuoteSphere — Random Quote Generator** | Discover a fresh random quote with every interaction | Java + XML          |

---

# 📚 Task 1 — StudyDeck

### Flashcard Quiz App

**StudyDeck** is a simple and user-friendly flashcard application designed for studying and learning.

Users can create their own flashcards and study questions and answers through a clean interface.

### ✨ Features

* ➕ Add flashcards
* ✏️ Edit flashcards
* 🗑️ Delete flashcards
* 👁️ Show / hide answers
* ⬅️ Previous card
* ➡️ Next card
* 🔢 Flashcard counter
* 💾 Local SQLite storage
* 📱 Offline support
* 🎨 Clean Android UI
* 🔐 No registration required

### 🛠️ Technology

```text
Java
XML
Android Studio
Android SDK
SQLite
AndroidX
CardView
```

### 📦 Package Name

```text
com.studydeck.flashcards
```

### 📂 Project Location

```text
Task-1-Flashcard-Quiz-App/
```

### 🔄 Application Flow

```text
             Launch App
                 │
                 ▼
          Load Flashcards
                 │
                 ▼
          Display Question
                 │
        ┌────────┴────────┐
        │                 │
        ▼                 ▼
   Show Answer       Next / Previous
        │
        ▼
    Study Card
        │
        ▼
   Add / Edit / Delete
        │
        ▼
    SQLite Database
```

### 📖 Documentation

➡️ [Open Task 1 Project](./Task-1-Flashcard-Quiz-App)

---

# ✨ Task 2 — QuoteSphere

### Random Quote Generator

**QuoteSphere** is a lightweight and minimal Android application that displays inspirational quotes and their authors.

A new random quote is automatically displayed when the application starts, and users can generate another quote using the **New Quote** button.

### ✨ Features

* 🎲 Random quote on app launch
* 🔄 New Quote button
* 👤 Author display
* 🚫 Prevents immediate quote repetition
* ✨ Smooth quote animation
* 🎨 Clean and minimal UI
* 📱 Responsive Android design
* 🌐 Fully offline
* 🔐 No registration required
* ⚡ Lightweight application

### 🛠️ Technology

```text
Java
XML
Android Studio
Android SDK
AndroidX
Material Components
CardView
```

### 📦 Package Name

```text
com.quotesphere.randomquote
```

### 📂 Project Location

```text
Task-2-Random-Quote-Generator/
```

### 🔄 Application Flow

```text
             Launch App
                 │
                 ▼
          Load Quote List
                 │
                 ▼
        Select Random Quote
                 │
                 ▼
       Display Quote + Author
                 │
                 ▼
          New Quote Button
                 │
                 ▼
       Select Another Quote
                 │
                 ▼
        Smooth Fade Animation
                 │
                 ▼
          Display New Quote
```

### 📖 Documentation

➡️ [Open Task 2 Project](./Task-2-Random-Quote-Generator)

---

# 🧩 Repository Structure

```text
CodeAlpha_App_Development_Tasks/
│
├── 📁 Task-1-Flashcard-Quiz-App/
│   │
│   └── 📁 StudyDeck/
│       ├── app/
│       ├── build.gradle.kts
│       ├── settings.gradle.kts
│       └── README.md
│
├── 📁 Task-2-Random-Quote-Generator/
│   │
│   └── 📁 QuoteSphere/
│       ├── app/
│       ├── build.gradle.kts
│       ├── settings.gradle.kts
│       └── README.md
│
└── 📄 README.md
```

---

# ⚙️ Development Environment

Both applications were developed using:

```text
IDE              : Android Studio
Language         : Java
UI               : XML
Platform         : Android
Build System     : Gradle
Version Control  : Git + GitHub
```

---

# 🚀 Getting Started

## 1. Clone the Repository

```bash
git clone https://github.com/LogicLearner9889/CodeAlpha_App_Development_Tasks.git
```

## 2. Open a Project

Choose either:

```text
Task-1-Flashcard-Quiz-App/StudyDeck
```

or:

```text
Task-2-Random-Quote-Generator/QuoteSphere
```

Open the selected folder in **Android Studio**.

## 3. Sync Gradle

Wait for Android Studio to complete:

```text
Gradle Sync
```

## 4. Run

Connect an Android device or start an Android Emulator.

Then click:

```text
Run ▶
```

---

# 📦 APK

Both projects can be built as standalone APK files.

### Task 1

```text
StudyDeck.apk
```

### Task 2

```text
QuoteSphere.apk
```

Build from Android Studio:

```text
Build
→ Build Bundle(s) / APK(s)
→ Build APK(s)
```

---

# 🔒 Privacy & Permissions

These applications are designed to work without requiring user registration.

### StudyDeck

Uses:

```text
Local SQLite Database
```

for storing flashcards.

### QuoteSphere

Uses:

```text
Built-in Local Quote Collection
```

and does not require an internet connection.

No unnecessary permissions are required.

---

# 📊 Project Comparison

| Feature         | StudyDeck |  QuoteSphere |
| --------------- | :-------: | :----------: |
| Android App     |     ✅     |       ✅      |
| Java            |     ✅     |       ✅      |
| XML             |     ✅     |       ✅      |
| Offline         |     ✅     |       ✅      |
| Database        |   SQLite  | Not Required |
| Add Data        |     ✅     |       —      |
| Edit Data       |     ✅     |       —      |
| Delete Data     |     ✅     |       —      |
| Random Content  |     —     |       ✅      |
| Animation       |     —     |       ✅      |
| Navigation      |     ✅     |       —      |
| No Registration |     ✅     |       ✅      |

---

# 🛣️ Future Improvements

Planned improvements across future versions:

```text
📚 More learning features
🌙 Dark Mode
🎨 Theme customization
✨ Advanced animations
📊 Progress tracking
❤️ Favorites
📤 Share content
🔍 Search
🔔 Notifications
📱 Improved responsive layouts
```

---

# 🏷️ Project Status

| Project       | Version | Status      |
| ------------- | ------- | ----------- |
| 📚 StudyDeck  | v1.0.0  | ✅ Completed |
| ✨ QuoteSphere | v1.0.0  | ✅ Completed |

---

# 👨‍💻 Developer

**LogicLearner9889**

GitHub:

https://github.com/LogicLearner9889

---

# ⭐ Support

If you find these projects useful:

⭐ Star this repository

🍴 Fork the repository

📢 Share the projects

---

<p align="center">

<b>🚀 CodeAlpha App Development Tasks</b>

<br>

Java • XML • Android Studio • SQLite

<br><br>

✨ Built for learning, practice, and Android development.

</p>
