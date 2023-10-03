# EberryAssignmentByParisa
## Search TVShow App
This is an Android app that allows a user to search for TV shows using modern Android development technologies.

## Features
- Allows a user to search for TV shows displays the search which is clickable and open up a detailed
  view about the selected TV show.
- Uses MVI architecture for clean separation of concerns.
- Utilizes Jetpack Compose for building UI components.
- Dagger Hilt which provides a smooth dependency injection way in android.
- Fetches search data using Retrofit and displays it using Gson Converter.
- Each class has their own short comment to understad easily.
- Includes unit tests for critical app components.

## Prerequisites
Android Studio (latest version)
Kotlin programming language

## Getting Started
1. Clone the repository to your local machine:

```
git clone https://github.com/parisa-mohamadi/EberryAssignmentByParisa.git
```

1. Open the project in Android Studio.

1. Build and run the app on an emulator or a physical device.

## Architecture
The app follows the MVI architecture which is basically MVVM but with added features, which promotes the separation of concerns and maintainability.

**Di:** dependency injection - can see all layers.

**Data:** for the internal and external storage — can see domain layer.

**Domain:** for the repository and use-case — no access to any layer.

**Presentation:** for the UI logic — can see domain.

## Dependencies
- Retrofit: For making API requests and handling responses.
- Jetpack Compose: For building modern and responsive UI.
- Dagger Hilt: which provides a smooth dependency injection way in android.
- ViewModel: For managing UI-related data in a lifecycle-conscious way.
- Coroutines: for asynchronous programming.
- Coil: simplifies image loading from the internet.
- Mockito: used in unit testing to create and handle mock objects.

## Usage
1. Launch the app on your emulator or device.
2. You will see a search bar.
3. write your desire Text and search.
4. after loading display the results in grid with 2 column.
5. Explore the detailed about each Tvshow via clicking.

## Unit Tests
The app includes unit tests to ensure the correctness of critical app components. To run unit tests:

1. Open the project in Android Studio.
1. Navigate to the test directory under src.
1. Right-click on the test class you want to run.
1. Select "Run" to execute the tests.
  
## Contributing
Contributions are welcome! If you find any issues or want to add new features, feel free to reach out to me at 
mohamadiparisa312@gmail.com.

