# ElementAdapter Description

## 1. General Information
*   **Class Name:** `ElementAdapter`
*   **Type:** Adapter (extends `RecyclerView.Adapter`)
*   **Purpose:** This class acts as a translator. It takes a list of `Element` objects and converts them into visual rows (items) that can be displayed on the screen.
*   **Interaction:** 
    *   Works with `MainActivity` which provides the data.
    *   Works with `Element` to extract information.
    *   Works with `element_item.xml` to define how each row looks.

## 2. Variables (Class Fields)

| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `elements` | `List<Element>` | The internal list of chemical elements to be displayed. | Used in almost all methods to know what to show. |

## 3. Class Methods

### Method name: `onCreateViewHolder`
*   **Type:** `public`
*   **Return value:** `ElementViewHolder`
*   **Parameters:** `ViewGroup parent`, `int viewType`
*   **What does it do:** It "inflates" (creates) the XML layout for a single row. It's like building the "frame" for a picture.
*   **When called:** Automatically when the `RecyclerView` needs a new row to show.

### Method name: `onBindViewHolder`
*   **Type:** `public`
*   **Return value:** `void`
*   **Parameters:** `ElementViewHolder holder`, `int position`
*   **What does it do:** This is where the actual "drawing" happens. It takes one `Element` from the list based on its `position` and puts its name, symbol, and mass into the text fields of the `holder`.
*   **When called:** Every time a row becomes visible on the screen.

### Method name: `updateElements`
*   **Type:** `public`
*   **Return value:** `void`
*   **Parameters:** `List<Element> newElements`
*   **What does it do:** It replaces the old list with a new one and calls `notifyDataSetChanged()` to tell the screen to refresh.
*   **When called:** When `MainActivity` finishes loading data.

## 4. Lifecycle
The Adapter doesn't have a standard Android lifecycle, but it is deeply tied to the `RecyclerView`.

## 5. Interface Interaction (UI)
*   **`ElementViewHolder`**: An internal class that "holds" references to the UI elements (TextViews) of a single row. This prevents the app from having to search for UI elements (using `findViewById`) every single time a list scrolls, which makes it very fast.

## 6. General Logic
1. Create the row design (`onCreateViewHolder`).
2. Fill the row with data (`onBindViewHolder`).
3. Count how many rows there are (`getItemCount`).

## 7. Simplified Explanation
Imagine you are a **waiter** in a restaurant.
*   The **List of Elements** is the order from the kitchen.
*   The **XML Layout** is the empty plate.
*   **onBindViewHolder** is you putting the food (data) onto the plate.
*   **RecyclerView** is the customer waiting for their food.
You (the Adapter) take the food from the kitchen and present it nicely to the customer.
