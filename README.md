Overview
This project is an Android application built using Jetpack Compose and Kotlin, designed to provide a user-friendly interface for educational resources. The application follows the Figma design specifications closely, ensuring a visually appealing and consistent user experience across different devices.

Requirements
1. User Interface Creation
Layout Reproduction: The UI elements have been reproduced according to the Figma design. All components are created using Jetpack Compose, which allows for a declarative UI approach.

Visual Consistency: The application maintains visual consistency with the design by effectively utilizing Compose components, such as Text, Image, Card, and BottomNavigation.

Responsiveness: The layout is designed to be responsive, adapting well to various screen sizes and orientations. This is achieved through the use of LazyColumn, LazyRow, and LazyVerticalGrid, which allow for flexible item arrangements.

Hardcoded Data Model: As no APIs are provided, the UI is populated with hardcoded data models defined within the CourseViewModel.

2. Code Structure and Architecture
Jetpack Compose: The application utilizes Jetpack Compose for building the UI, adhering to modern Android development practices.

Kotlin Design Patterns: The code structure follows Kotlin-specific design patterns, enhancing readability and maintainability.

3. Compose-Specific Design Patterns
View Composition Pattern: Complex UI components are broken down into smaller, reusable composable functions (e.g., CardComponent, QuizComponent, ResourceComponent). This promotes modularity and readability, allowing for independent testing and reuse of components.

Observable Object and Published Properties: LiveData is used within the ViewModel (CourseViewModel) for state management. This ensures that updates in data models are automatically reflected in the UI.

Dependency Injection: If necessary, dependency injection can be incorporated using Hilt or other frameworks to manage dependencies throughout the application.

4. Design Principles
Reusable and Customizable Components: UI components are designed to be easily reusable and customizable across different parts of the app. For example, SectionComponent can be reused for various sections in the app with different headers and bodies.

5. Reusability and Flexibility
Design for Extensibility: The UI elements are designed with extensibility in mind, allowing for future changes with minimal code modifications. New features can be added by creating new composable functions or extending existing ones.

Compose Features: Commonality between UI components is achieved through shared composable functions that encapsulate similar behaviors or styles.

## Key Components

## Architecture

The application follows a simple MVVM (Model-View-ViewModel) architecture:

-   *View:* Composable functions represent the UI, observing data from the ViewModel.
-   *ViewModel:* `CourseViewModel` manages the data and provides it to the UI.
-   *Model:* Data classes represent the application's data.

## Customization

-   *UI:* Modify the composable functions to change the look and feel of the application.
-   *Data:* Update the data in the `CourseViewModel` to change the content displayed in the UI.
-   *Navigation:* Add or modify screens and navigation logic in `AppNavigation` and `BottomNavComponent`.
-   *Colors and Theme:* Edit `ApexApplicationTheme` to change the color palette.

### Navigation

-   **`AppNavigation`**: Manages navigation between different screens using Jetpack Compose's `NavHost`.
-   **`BottomNavComponent`**: Implements the bottom navigation bar with icons and labels, handling navigation events.
-   **`Screens`**: An enum defining the available screens in the application.

### UI Components

-   **`CardComponent`**: A reusable card component for displaying enrollment information with gradient backgrounds and optional images.
-   **`QuizComponent`**: A component for displaying quiz information, including completion status and background images.
-   **`ResourceComponent`**: A component for displaying resource icons and titles in a grid layout.
-   **`SectionComponent`**: A container component for organizing sections with header and body content.
-   **`HomeScreen`**: The main screen displaying enrollment cards, resource icons, and quiz information.

### Data and ViewModel

-   **`CourseViewModel`**: Manages the application's data using `LiveData` and provides data to the UI components.
    -   `resourceData`: Holds a list of `Resource` items.
    -   `bottomNavItems`: Holds a list of `BottomNavItem` items.
    -   `enrollmentItem`: Holds a list of `EnrollmentItem` items.
    -   `quizItem`: Holds a list of `QuizItem` items.
-   *`Resource`*, *`EnrollmentItem`*, *`QuizItem`*, **`BottomNavItem`**: Data classes representing the application's data models.

### Data Classes

-   **`Resource`**: Stores resource icon and title.
-   **`EnrollmentItem`**: Stores enrollment card data.
-   **`QuizItem`**: Stores quiz data.
-   **`BottomNavItem`**: Stores data for Bottom Navigation Items.

### Activities

-   **`MainActivity`**: The main activity hosting the application's UI.

## Dependencies

-   Jetpack Compose
-   Navigation Compose
-   ViewModel
-   LiveData
-   Material Design Components
