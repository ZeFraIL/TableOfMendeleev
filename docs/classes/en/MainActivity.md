# MainActivity Description

## 1. General Information
*   **Class Name:** `MainActivity`
*   **Type:** Activity
*   **Purpose:** This is the main screen of the application. It is responsible for the user interface, managing the application's lifecycle, and the logic of loading chemical element data. It decides whether to download data from the internet or read it from the phone's memory.
*   **Interaction:** 
    *   Uses `ElementAdapter` to display data in a list.
    *   Uses `Element` to store parsed data.
    *   Interacts with the Android system to perform network requests and file operations.

## 2. Variables (Class Fields)

| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `recyclerView` | `RecyclerView` | A specialized UI component for displaying long lists efficiently. | Used in `onCreate` to display the table. |
| `adapter` | `ElementAdapter` | A "bridge" that takes data from a list and puts it into the `RecyclerView`. | Used throughout the class to update the UI. |
| `executorService` | `ExecutorService` | A tool for running tasks in the "background" (not on the main screen thread). | Used in `loadPeriodicTableData` for networking/files. |
| `mainHandler` | `Handler` | A tool to send messages back to the "Main Thread" (UI thread). | Used to update the list once data is loaded. |

## 3. Class Methods

### Method name: `onCreate`
*   **Type:** `protected`
*   **Return value:** `void` (returns nothing)
*   **Parameters:**
    | Name | Type | Description |
    | :--- | :--- | :--- |
    | `savedInstanceState` | `Bundle` | Stored data from a previous session (if the app was restarted). |
*   **What does the method do:**
    1. Calls the parent's `onCreate` to set up basic Activity features.
    2. Sets the layout from `activity_main.xml`.
    3. Finds the `RecyclerView` in the layout.
    4. Creates the `adapter` and connects it to the `RecyclerView`.
    5. Initializes the `executorService` and `mainHandler`.
    6. Starts the data loading process by calling `loadPeriodicTableData()`.
*   **When called:** Automatically by the Android system when the app starts.
*   **What is important to understand:** This is the entry point. If you do too much work here, the app will freeze.

### Method name: `loadPeriodicTableData`
*   **Type:** `private`
*   **Return value:** `void`
*   **Parameters:** None
*   **What does the method do:**
    1. Switches to a background thread using `executorService`.
    2. Checks if the file `periodic_table.json` exists in the app's folder.
    3. If it doesn't exist, it calls `downloadPeriodicTable()`.
    4. Reads the file content using `readFile()`.
    5. Converts the text into a list of `Element` objects using `parseElements()`.
    6. Uses `mainHandler` to tell the `adapter` to show the new list.
*   **When called:** Manually from `onCreate`.
*   **What is important to understand:** This method handles the "Main Logic" of data flow.

### Method name: `downloadPeriodicTable`
*   **Type:** `private`
*   **Return value:** `void`
*   **Parameters:**
    | Name | Type | Description |
    | :--- | :--- | :--- |
    | `file` | `File` | The destination where the downloaded data will be saved. |
*   **What does the method do:**
    1. Opens a connection to a specific URL on GitHub.
    2. Reads data from the internet in small chunks (buffers).
    3. Writes these chunks into the local `file`.
*   **When called:** From `loadPeriodicTableData` if the file is missing.

## 4. Lifecycle
*   **`onCreate()`**: Called when the Activity is first created. Here, the UI is built and services are started.
*   **`onDestroy()`**: Called just before the Activity is destroyed. Here, we shut down the `executorService` to prevent memory leaks (keeping a thread running when the app is closed).

## 5. Interface Interaction (UI)
*   **`RecyclerView`**: Used to show the list of elements. Linked via `findViewById(R.id.recyclerView)`.
*   **`Toast`**: Small pop-up messages used to show errors or notifications.

## 6. Interaction with other components
*   **API/Network**: Connects to GitHub to fetch raw JSON data.
*   **File System**: Saves the JSON to `getFilesDir()` for offline use.

## 7. General Logic
1. Start -> 2. Check local file -> 3. (Optional) Download if missing -> 4. Read text -> 5. Parse JSON -> 6. Show in list.

## 8. Simplified Explanation
Imagine you are at a library.
*   **MainActivity** is the librarian.
*   The **RecyclerView** is the bookshelf.
*   The **Internet** is the warehouse.
The librarian checks if the book (data) is on the shelf. If not, they order it from the warehouse. Once the book arrives, they organize the information and put it on the bookshelf for you to see.

---
**Note for Improvement:** The `recyclerView.setOnClickListener` in `onCreate` won't work as expected because individual items in a `RecyclerView` handle clicks inside the Adapter or via an Interface, not on the `RecyclerView` itself. Suggest moving click logic to `ElementAdapter`.
