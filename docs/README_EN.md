# 📱 Android Application Documentation: TableOfMendeleev

________________________________________
## 🧾 General Information
**Project Name:**  
TableOfMendeleev

**Author(s):**  
Zeev Fraiman

**Date:**  
July 2026

**Language:**  
Java

**Development Environment:**  
Android Studio

**Android Version (minSdk / targetSdk):**  
28 / 34
________________________________________
## 🎯 Project Goal
•	**Problem Solved:**  
The application provides interactive access to data about chemical elements of the periodic table.

•	**Why it matters:**  
Chemical elements are the building blocks of the material world. A handy reference is essential for students, scientists, and anyone interested in science.

•	**Target Audience:**  
Students, schoolchildren, chemistry teachers, researchers.
________________________________________
## 📌 Requirements
**Functional Requirements**
•	Download up-to-date data on chemical elements from an external JSON resource.
•	Display a list of elements with basic information (symbol, name, atomic number, mass).
•	Cache data in the device's internal storage.

**Non-functional Requirements**
•	**Performance:** Smooth scrolling of the element list.
•	**Usability:** Simple and intuitive interface.
•	**Reliability:** Network error handling and correct data parsing.
________________________________________
## 🧠 General Architecture
•	**Approach:**  
Close to MVC (Model-View-Controller), where MainActivity acts as the controller.

•	**Why this was chosen:**  
The project has a simple structure, making complex patterns (like MVVM) redundant at this stage.

•	**Core Components:**  
- **Model:** `Element` class.
- **View:** `RecyclerView` in `MainActivity`.
- **Controller/Logic:** `MainActivity` and `ElementAdapter`.
________________________________________
## 🧩 UML Diagram
`[MainActivity]` –> `[ElementAdapter]`  
`[ElementAdapter]` –> `[Element]`  
`[MainActivity]` –> `[ExecutorService]` (for data loading)  
`[MainActivity]` –> `[Internal Storage / API]`
________________________________________
## 🧩 Detailed Class Description
**📌 Class: MainActivity**
- **Role:** Main application screen.
- **Responsibility:** UI initialization, lifecycle management, starting background data loading tasks, interacting with the adapter.
- **Key Methods:**
  - `onCreate()` — sets up RecyclerView, initializes threads.
  - `loadPeriodicTableData()` — data loading logic (from file or network).
  - `downloadPeriodicTable()` — downloads the JSON file from the internet.
  - `parseElements()` — parses the JSON string into a list of Element objects.

**📌 Class: Element**
- **Role:** Data model.
- **Responsibility:** Stores properties of a chemical element (name, symbol, mass, etc.).

**📌 Class: ElementAdapter**
- **Role:** Bridge between data and UI.
- **Responsibility:** Creates list items and populates them with data from the `Element` list.
________________________________________
## 🔄 Application Workflow
1. Application launch.
2. `MainActivity` checks for `periodic_table.json` in internal storage.
3. If the file is missing, `downloadPeriodicTable()` runs in a background thread.
4. Once the file is obtained (or if it already existed), data is read and parsed by `parseElements()`.
5. Results are passed to `mainHandler`, which updates the UI via `ElementAdapter`.
________________________________________
## 🎨 UI/UX Analysis
•	**Why the UI is designed this way:** A classic list (RecyclerView) was chosen to ensure fast navigation through a large number of elements.
•	**Principles used:**
–	Simplicity: No unnecessary elements.
–	Logicity: Grouping of element data (symbol, name, number).
–	Accessibility: Clear fonts and contrasting colors.
________________________________________
## ⚙️ Threading
•	**Used:**
- `ExecutorService` (SingleThreadExecutor) for network and disk operations.
- `Handler` (MainLooper) for UI updates.
•	**Why this way:** It's a reliable and classic way to manage multi-threading in Java-Android apps without external libraries.
•	**Prevention of:**
–	Hangs (ANR): Heavy operations are moved to a background thread.
–	Memory leaks: Shutting down `ExecutorService` in `onDestroy()`.
________________________________________
## 💾 Data Management
•	**Storage Location:** Internal storage (`getFilesDir()`), file `periodic_table.json`.
•	**Why this way:** Ensures data availability without internet after the first download.
•	**Ensuring:**
–	Preservation: File is written to the app's private area.
–	Correctness: Using `JSONObject/JSONArray` for structure validation.
________________________________________
## 🌐 Networking
•	**How requests are made:** Standard `HttpURLConnection`.
•	**Error Handling:** try-catch blocks to intercept `IOException` and `JSONException`.
•	**Offline behavior:** If the file is already downloaded, the app works offline. If not, a Toast error message is shown.
________________________________________
## 🔐 Security
•	The app does not collect sensitive user data. Element data is public knowledge.
________________________________________
## 🧪 Testing
•	Basic manual testing of data loading and display is currently performed.
________________________________________
## 🐞 Error Handling
•	Network error handling (connection loss).
•	JSON parsing error handling (invalid format).
•	The app notifies the user of errors via Toast.
________________________________________
## ⚡ Performance
•	**Optimizations:** Use of RecyclerView for efficient memory management when displaying long lists. Background data loading.
________________________________________
## 🚀 Scalability
•	Adding a detail screen for each element.
•	Search and filtering by category.
•	Grid visualization of the table.
________________________________________
## 📊 Self-Assessment
| Criterion | Rating (1–10) |
| :--- | :--- |
| Architecture | 8 |
| Code | 9 |
| UI/UX | 7 |
| Reliability | 9 |
| Overall Level | 8 |
________________________________________
## 🏁 Conclusion
•	**What went best:** Reliable data loading and caching system.
•	**What was challenging:** Parsing a complex JSON structure with many fields.
•	**Skills acquired:** Working with multi-threading in Java, handling network requests, and the Android file system.
