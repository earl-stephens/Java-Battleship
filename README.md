# Java Battleship

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
![Sonarlint](https://img.shields.io/badge/SonarLint-CB2029?style=for-the-badge&logo=sonarlint&logoColor=white)

## Table of Contents

- [Introduction](#introduction)
- [Installation](#installation)  
- [Getting Started](#getting-started)  
- [Further Improvements](#further-improvements)  
- [Built With](#built-with)  
- [Coverage](#coverage)  
- [Authors](#authors)  

## Introduction

This project takes the classic Battleship game and turns into a digital version.  This is originally a Turing School of Software and Design project, that is coded in Ruby.  I have done it in Java to practice Java fundamentals as well unit testing.  The Turing project requirements that I followed are located at [Battleship](https://backend.turing.edu/module1/projects/battleship/index).

The first iteration of the project sets up the Ship class.  This is a simple class that has attributes of name, length and health (where health is equal to the length of the ship).  Methods include hit and sunk, where hit affects the health of the ship, and sunk returns a boolean if the ship is sunk.

The Cell class is used to hold a Ship object.  The playing board is a 4x4 matrix of individual cells.  Each cell corresponds to a ship of length one.  Since the ships are longer than one, a Ship object is spread across several cells.  The Cell constructor takes a string to indicate it's place in the board matrix.  Cell has attributes of coordinate, ship.  Methods for Cell include place_ship, empty? and fired_upon.  Cell also has a render method, which displays the status of the cell and the ship.  An empty cell will render a '.'  After ships are placed, firing on an empty cell will render 'M' (for miss).  Firing on an occupied cell will render a 'H' (for hit).  If the fired shot sinks the ship, the cell will render 'S' (for sunk).  Lastly, the cell will render an 'S' to indicate that a ship is placed in that cell.  This is used to show the player where their ships are located.  It is turned off for the computer user, so that the player does not see where the computer ships are located.

In the second iteration, the Board class is introduced.  Board sets up the 4x4 matrix of cells.  The Board class also performs a lot of validation checks.  The checks include things such as whether or not a coordinate is present in the 4x4 matrix, whether or not the ship is placed linearly, whether or not the ship is placed diagonally and whether or not the ship placement overlaps another ship.  The validation logic for this iteration took some time to work through.  Since the coordinates are of the form "A1", the coordinate had to be split into a char and an integer for the checks.  If all the validation checks were successful, the ship was allowed to be placed on the board.  Once the ships were placed, the board would render the board to the user.

Iteration 3 is where most of the game play logic was established.  A Battleship class containing the main method was created.  This simply calls the Game class, which runs the game.  Game instantiates the ships and the player and the computer objects.  It also creates a Turn object.  Game directs setting up the boards and placing the ships.  After that, a turn is called.  Turn uses the `turn.takeTurn()` method to get the firing coordinates from the computer and the user, fires on those coordinates, updates the ships' status and re-renders the board for the next turn.  Turn also checks to see if the ships have been sunk or not.  Game will keep the turns going until a winner is produced.  Game will then display who won and return the user to main menu to play again or to quit.

## Installation

Clone the repo to your local machine.  Navigate to the files in Battleship/src/application.  For each file, perform the following:  
`javac -d . filename.java`

## Getting Started   

To run the program, at the command line type:  
`java -cp . application.Battleship`

## Further Improvements

There is a lot of user interaction in this program that needs better testing.  I used JUnit to attempt some of this testing, but I need to work more on integration testing.

## Built With

OpenJDK 16.0.1

JUnit 5  

Eclipse 2020-06  

## Coverage

## Authors

[Earl Stephens](https://github.com/earl-stephens)