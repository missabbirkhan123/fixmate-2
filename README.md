# Fixmate - Professional Multi-Vendor Service Marketplace

Fixmate is a comprehensive marketplace platform designed to connect professional service providers (Sellers) with homeowners (Buyers). This project includes both a fully functional **Android Application (Jetpack Compose)** and a **Web Interface**.

## 📂 Project Structure

-   **`app/`**: This folder contains the **Source Code** for the Android Application.
    -   `src/main/java/com/example/fixmate/ui/screens/`: All Jetpack Compose screens (Landing, Auth, Dashboards, Messaging).
    -   `src/main/java/com/example/fixmate/MainActivity.kt`: Cental navigation and entry point.
-   **`web/`**: Contains the **Web Front-end** (HTML/Tailwind CSS).
    -   `index.html`: Main marketplace landing page.
    -   `seller.html`: Seller management dashboard.
    -   `admin.html`: Platform administration panel.
    -   `signin.html` / `signup.html`: Authentication flow.
-   **`marketplace_project_plan.txt`**: The original Project Requirements Document (PRD).

## 🚀 Key Features

1.  **Dual Registration**: Separate onboarding flows for Buyers and Sellers.
2.  **Seller Gateway**: Manual verification system for sellers to unlock service listings.
3.  **Real-time Interaction**: Integrated messaging system for service inquiries.
4.  **Admin Controls**: Comprehensive dashboard for user approvals and platform monitoring.
5.  **Modern UI**: High-trust "Corporate Modern" aesthetic built with Inter typography and Deep Indigo branding.

## 🛠 Tech Stack

-   **Android**: Kotlin, Jetpack Compose, Material3, Navigation Component.
-   **Web**: HTML5, Tailwind CSS (CDN), Material Symbols.

## 📝 How to Run

### Android App
1.  Open the root folder in **Android Studio**.
2.  Wait for Gradle to sync.
3.  Select an emulator or physical device and click **Run**.

### Web Interface
1.  Open `web/index.html` in any modern web browser.
2.  Navigation between pages is configured using relative links for easy local testing.

---
© 2024 Fixmate Marketplace. Built for scalability and reliability.
