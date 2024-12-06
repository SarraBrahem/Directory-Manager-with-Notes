# Directory-Manager-with-Notes

## Description
This project is a Command Line Interface (CLI) application that allows users to explore directories, manage files, and attach notes to files. Built with a modular architecture, it supports file operations, annotations, and interactive command execution.

---

## Features
### **Directory Exploration**
- Navigate through directories, listing files and subdirectories.
- Real-time updates for directory content.

### **File Management**
- Create and delete directories.
- Copy, cut, and paste files.

### **Annotations**
- Add and manage notes attached to files.
- Remove or update existing annotations.

### **Built-in Commands**
- Interactive commands via a robust parser (`InputParser`).
- Available commands: `copy`, `cut`, `paste`, `mkdir`, `find`, `visu`, `help`, etc.

---

## Project Structure
### **Key Files**
- **`App.java`**: Main entry point to start the application.
- **`Application.java`**: Initializes key components.
- **`CommandManager.java`**: Manages command execution.
- **`Repertoire.java`**: Core manager for directories and notes.

### **Supporting Modules**
- **`FileManager.java`**: Handles file system interactions.
- **`NoteManager.java`**: Manages file annotations.
- **`InputParser.java`**: Parses user commands and maps them to actions.
- **`Affichage.java`**: Handles CLI display.

---

## Installation and Execution

### Prerequisites
- Java 8 or higher installed on your system.

### Steps
1. Clone the project:
   ```bash
   git clone https://github.com/SarraBrahem/Directory-Manager-with-Notes.git
   cd directory-manager
