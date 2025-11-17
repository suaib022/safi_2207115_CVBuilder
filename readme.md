## 📄 CV Builder Desktop Application

### 🌟 Project Overview

This is a modern, cross-platform desktop application built using **JavaFX** that allows users to quickly input their professional and personal data and instantly generate a clean, two-column Curriculum Vitae (CV) preview. The application is designed for simplicity, providing a clear form interface and a stylish, professional CV template.

-----

### 🛠️ Tools & Technologies

* **Platform:** Java 17+ (or equivalent LTS version)
* **UI Framework:** **JavaFX**
* **Layout:** FXML and custom CSS for styling (including dynamic layouts like `GridPane`, `HBox`, and `VBox`).
* **Build System:** Maven or Gradle (standard Java project setup).
* **Design:** Scene Builder (used for visual FXML layout editing).

-----

### ✨ Key Features

* **Data Entry Form (`form.fxml`):** A clean, responsive input form with logically grouped fields for Personal Information and Professional Details.
* **Real-Time Preview (`preview.fxml`):** Instantly transforms the user-entered data into a professional, two-column CV template.
    * **Sidebar:** Displays Skills (Teal/Dark background).
    * **Main Content:** Displays Contact information, Experience, Education, and Projects (White/Light background).
* **Form Validation:** Prevents submission and shows a warning if any required fields are left empty.
* **Submission Feedback:** A standard **success message** (JavaFX Alert) appears upon successful data submission, confirming the action and requiring the user to click **"OK"** before the preview is fully interactive.
* **Intuitive Navigation:** A "Back to Form" button allows users to return and edit their data.
* **Modern UI Styling:** Includes styled labels, rounded buttons with hover effects, and distinct color separation for enhanced readability.

-----

### 📁 Project Structure

The core functionality is split across standard MVC-like JavaFX components:

| File/Component | Purpose |
| :--- | :--- |
| `HelloApplication.java` | Main application entry point; handles stage setup and scene transitions (Form $\leftrightarrow$ Preview). |
| `FormController.java` | Manages user input, performs validation, collects data into `CVData` object, and initiates the preview screen. |
| `PreviewController.java` | Receives the `CVData` object and populates all relevant labels in the `preview.fxml` layout. |
| `CVData.java` | Simple POJO (Plain Old Java Object) to hold the collected data for easy transfer between controllers. |
| `form.fxml` | The JavaFX Markup for the data input screen. |
| `preview.fxml` | The JavaFX Markup for the generated CV display (The final CV template). |
| `styles.css` | (Implied) Contains the custom CSS classes used to style the two-column CV layout. |

-----

### 🚀 Installation & Setup

These instructions assume you have a Java Development Kit (JDK 17+) and a JavaFX-compatible IDE (like IntelliJ IDEA or Eclipse).

### Prerequisites

* **Java JDK (17+):** Ensure Java is installed and configured.
* **JavaFX SDK:** Your project must depend on the appropriate JavaFX modules (`javafx-controls`, `javafx-fxml`).

### Steps

1.  **Clone the Repository:**

    ```bash
    git clone https://github.com/suaib022/safi_2207115_CVBuilder.git
    cd safi_2207115_CVBuilder/cv_builder
    ```

2.  **Add JavaFX Dependencies**


3.  **Configure the Main Class:**

    
4.  **Run the Application:**


The application should open to the welcome screen, and clicking "Create New CV" will take you to the data entry form.
