# Freedie Uniform Finding Helper 

This project is a Java Application that process secret messages from freedie's friends by folding. The current primary funcationality involves parsing files, extracting the grid details, and performing specified folding oprations

## Table of Contents

- [Features](#features)

- [Getting Started](#getting-started)

- [Developoment](#development)
    - [Main Components](#main-components)

- [Contact](#contact)

## Features
* **File Parsing**: Reads and processes grid and fold instruction files.
* **Dynamic Folding: Currently supports both upward and leftward grid folding operations.
* **Visualization: Renders the final state of the grid after all folding operations.

## Getting Started

### Prerequisites
Ensure you have the following software/tools installed:

* Java JDK(Version 8 or higher)
* A Unicode-compatible terminal or console
* Ensure your environment uses UTF-8 encoding
### Installation
1. **Clone the Repository**:

    ```bash
   git clone https://github.com/jimmyli0408/freddie-missing-uniform-finder.git
   ```
### Usage

Run the `Main` class in your preferred IDE to process the grid files in the `./resources` directory

### Development

#### Main Components
* Main Class: Entry point for the program. It reads the files from the `.resources` directory and process each of them.
* MessageProcess: Decodes the messages and executes the fold instructions.
* FileParser: Responsible for reading the input file and parsing the grid's initial state.
* DecodeService: An interface that outlines the methods required to fold the grid.
* FoldServiceImpl: Implements the `DecodeService` interface. Contains logic to fold the grid either upwards or to the left.
* Grid: Represents the grid with marked points.
* Pair: Represents a marked point with x and y coordinates.

### Contact
* Name: Jimmy Li
* GitHub: [github](https://github.com/jimmyli0408)

   

