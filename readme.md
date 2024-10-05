# Medicine Pro App

This is an Android project that uses Kotlin, Jetpack Compose, and Hilt for dependency injection. The app requires setting up a base URL for API requests, which is defined in the `local.properties` file.

## Prerequisites

Before building the project, ensure you have the following installed:

- Android Studio (latest stable version)
- Android SDK (API level 24 or higher)
- Gradle (version defined in the project)
- Kotlin

## Setup

To build the project, you need to define the `BASE_URL` used for API calls. This can be set up by adding the `BASE_URL` key in the `local.properties` file.

### Step 1: Add `base_url` in `local.properties`

1. In the root directory of the project, locate the `local.properties` file.
2. Add the following line to specify your base API URL:

   ```properties
   BASE_URL=https://your-api-url.com
   ```
-   Replace https://your-api-url.com with the actual URL of your API.
### Step 2: Sync Project
After adding the `BASE_URL` value, sync the project with Gradle by clicking Sync Now in Android Studio.

## Build and Run