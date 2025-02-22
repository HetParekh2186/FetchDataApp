# FetchDataApp

FetchDataApp is a native Android application built with Kotlin and Jetpack Compose. The app retrieves JSON data from a remote URL, filters out items with blank or null names, groups them by `listId`, and sorts them for an easy-to-read display.

## Features

- **Data Fetching:** Retrieves JSON data from [Fetch Hiring](https://fetch-hiring.s3.amazonaws.com/hiring.json) using Retrofit.
- **Data Processing:** Filters out items with blank or null names.
- **Grouping & Sorting:** Groups items by `listId` and sorts by `listId` and `name`.
- **Modern UI:** Displays the processed list using Jetpack Compose.
- **Asynchronous Processing:** Uses Kotlin Coroutines for background tasks.

## Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Retrofit** (with Gson Converter)
- **Kotlin Coroutines**
- **Android Architecture Components (ViewModel)**
- **Gradle (Kotlin DSL)**



