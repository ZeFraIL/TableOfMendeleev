# Element Description

## 1. General Information
*   **Class Name:** `Element`
*   **Type:** Normal Class (POJO - Plain Old Java Object) / Model
*   **Purpose:** This class acts as a template or a "container" for a single chemical element (like Hydrogen or Oxygen). It stores all the characteristics of an element.
*   **Interaction:** 
    *   `MainActivity` creates a list of these objects after parsing JSON.
    *   `ElementAdapter` uses these objects to fill the text fields in the UI.

## 2. Variables (Class Fields)
*This class has many fields. Here are the most important ones:*

| Name | Type | Purpose |
| :--- | :--- | :--- |
| `name` | `String` | The full name of the element (e.g., "Helium"). |
| `symbol` | `String` | The short symbol (e.g., "He"). |
| `number` | `int` | The atomic number. |
| `atomic_mass` | `double` | The mass of the atom. |
| `summary` | `String` | A short description or facts about the element. |
| `shells` | `ArrayList<Integer>` | Electron shells configuration. |

*How it is used:* These variables are private (encapsulated). They are accessed using "Getters" and "Setters" to ensure data safety.

## 3. Class Methods
The class consists mostly of **Getters** and **Setters**.

### Method name: `getName` / `setName`
*   **Type:** `public`
*   **Return value:** `String` (for get) / `void` (for set)
*   **Parameters:** `String name` (for set)
*   **What does it do:** `getName` returns the name, `setName` updates it.
*   **When called:** During JSON parsing (`setName`) and during UI binding (`getName`).

## 4. Lifecycle
This class is a normal Java class, so it does not have an Android lifecycle. It exists as long as it is stored in a list or variable in memory.

## 5. Interface Interaction (UI)
None directly. The fields are read by the `Adapter` which then puts them into the UI.

## 6. General Logic
This is a "Data Carrier". You can think of it as a form or a card in a filing cabinet. Each card represents one element and has fields for its name, weight, and symbol.

## 7. Simplified Explanation
Think of this class as a **business card** for a chemical element.
The card has specific fields: "Name", "Symbol", "Phone Number" (Atomic Number).
The class itself is just the *design* of the card. When the app runs, it creates 118 "physical" cards (objects) and fills them with info.
