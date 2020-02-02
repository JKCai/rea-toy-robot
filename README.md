
# Toy Robot Simulator

### Table of Contents

#### Description
<hr>

- The application is a simulation of a toy robot moving on a square tabletop,
  of dimensions 5 units x 5 units.
- There are no other obstructions on the table surface.
- The robot is free to roam around the surface of the table, but must be
  prevented from falling to destruction. Any movement that would result in the
  robot falling from the table must be preven

Create an application that can read in commands of the following (textual) form:

    PLACE X,Y,F
    MOVE
    LEFT
    RIGHT
    REPORT

- <i><b>PLACE</b></i> will put the toy robot on the table in position X,Y and facing NORTH,
  SOUTH, EAST or WEST.
  
- The origin (0,0) can be considered to be the SOUTH WEST most corner.

- The first valid command to the robot is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The application should discard all commands in the sequence until a valid PLACE command has been executed.
  
- <i><b>MOVE</b></i> will move the toy robot one unit forward in the direction it is currently facing.

- <i><b>LEFT</b></i> and <i><b>RIGHT</b></i> will rotate the robot 90 degrees in the specified direction without changing the position of the robot.

- <i><b>REPORT</b></i> will announce the X,Y and F of the robot. This can be in any form, but standard output is sufficient.

- A robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT and REPORT commands.

- Input can be from a file, or from standard input, as the developer chooses.

- Provide test data to exercise the application.
- The application must be a command line application.

#### Constrains
<hr>

- The toy robot must not fall off the table during movement. This also
  includes the initial placement of the toy robot.
- Any move that would cause the robot to fall must be ignored.

#### Setup
<hr>

1. Make sure you have install jkd 1.8 in your machine. 

2. Clone the repo to your local machine<br/>
<i>git clone https://github.com/JKCai/rea-toy-robot.git</i> <br/><br/>
Then change to the project directory: <br/>
<i>cd rea-toy-robot/out/artifacts/rea_toy_robot_jar 
</i>

3. run command: <br/><i>java -jar rea-toy-robot.jar</i>

#### Project Assumption <hr>

1. Robot can be re-place at different position. e.g. <br/>
PLACE 0 0 NORTH <br/> PLACE 1 1 WEST <br/><br/>The robot will be at the position 1 1 WEST

2. Extra spaces between command and command content are acceptable as long as the command is valid. e.g. <br/>
PLACE    0 , 0   ,  NORTH<br/>
LEFT<br/>
REPORT<br/>

#### Design Pattern<hr/>

##### Factory Pattern

- In this project, I abstract the "Command" Class such that in the future, more command type can be added.

- The benefit of this pattern is easy to create an object and the logic is hide from the client.

##### Null Object Pattern

- The application of Null Object Pattern is to handle to null checking. Instead of putting if check for a null value, a null object is created to reflect a do nothing relationship.

#### Input File<hr>

<b>Input File 1:</b>

PLACE 0,0,NORTH
MOVE
REPORT

<b>Expected Outcome:</b>

0,1,NORTH

<b>Input File 2:</b>

PLACE 0,0,NORTH<br/>
    LEFT<br/>
    REPORT

<b>Expected Outcome:</b>

0,0,WEST

<b>Input File 3:</b>

PLACE 1,2,EAST<br/>
    MOVE<br/>
    MOVE<br/>
    LEFT<br/>
    MOVE<br/>
    REPORT

<b>Expected Outcome:</b>

3,3,NORTH

#### Test Coverage Overview <hr>

The design of Test cases follow the "Boundary Test" Principle. That is, mainly testing if the robot's x and y value is within the table size; and if the direction is within the finite set.

<img src="https://sproutx.com.au/wp-content/uploads/2018/toy-robot-coverage.jpg" width="1000" />
