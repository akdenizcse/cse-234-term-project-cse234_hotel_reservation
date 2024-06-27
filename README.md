# Stay Safe Hotell App

This project is an Android application built using Kotlin and Jetpack Compose for a seamless and modern UI. The app allows users to search for hotels, view details, make reservations, manage booking. Authentication is handled via Google Firebase.

## Work Distribution

### Barış Ayhan
- **Database Integration**: Implementing user authentication using **Firebase** Authentication. Setting up Firebase Firestore to store user data.
- **Main Layout and Tabs**: Designing and developing the main layout with tabs for easy navigation between different sections of the app, such as Home, Favorites, Bookings, and Profile.
  
### Önder Polatdemir
- **Navigation**: Implementing navigation logic to switch between the main screen and other necessary screens, such as hotel details, booking confirmation, and user profile. Ensuring a smooth user experience with intuitive navigation.
- **UI/UX Design**: Creating and refining the UI/UX design using Figma. This includes designing all the screens, ensuring a consistent look and feel, and making the app user-friendly. Additionally, utilizing **Relay Figma** for transferring some UI components efficiently.

---

## Pages and Navigation

### Authentication Pages
- **MainPage**: The entry point of the app, containing two buttons: "Login" and "Sign Up".
- **Login Page**: Allows users to log in with their email and password using Firebase Authentication.
- **Signup Page**: Enables users to create a new account with their email and password via Firebase Authentication.

### Home Navigation and  Bottom Bar Navigation
- **HomePage**: After authentication, users can search for hotels using this page.
- **HomePage**: Part of the bottom bar navigation, allowing users to search for hotels.
- **Favorites Page**: Displays a list of hotels that the user has marked as favorites.
- **My Bookings Page**: Shows the user's previous bookings, with options to view details or cancel bookings.
- **Profile Page**: Allows users to view and update their profile information.

### Details Navigation
- **FindScreen Page**: Accessible after searching for hotels on the HomePage.
- **HotelsDetail Page**: Navigated from the FindScreen Page for more detailed information about a selected hotel.
- **Booking Summary Page**: Accessible after clicking "Book Now" on the HotelsDetail Page.
- **Payment Page**: The final step in the booking process, navigated from the Booking Summary Page.

## Project Structure

The app utilizes three main navigation structures:

1. **Home Navigation**: Includes the MainPage, Login Page, Sign Up Page, and HomePage.
2. **Bottom Bar Navigation**: Integrates HomePage, Favorites Page, My Bookings Page, and Profile Page for easy access via a bottom navigation bar.
3. **Details Navigation**: Handles the flow from searching for hotels to making a payment, including the FindScreen Page, HotelsDetail Page, Booking Summary Page, and Payment Page.

## Firebase Authentication

Authentication is a key component of this app, ensuring secure access to user accounts and data. Firebase Authentication is used for logging in, signing up, and managing user sessions.

---

This README provides a brief overview of the Hotel Reservation App, detailing the primary pages, their functions, and the navigation structure. The app is designed to offer a smooth and secure user experience for hotel reservations.
