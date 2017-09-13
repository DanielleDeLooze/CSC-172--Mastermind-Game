Author: Danielle DeLooze
Student ID: 29493487
Project: Project 1 MasterMind

Description: This project has us implement a version of the game MasterMind where the user would think of a code made up of x colors and y positions. The computer will try
and guess what the code is based of the x colors and y positons. The user will provide feedback based on the computer's guesses until it comes up with the correct code! The way
went about this was by creating an array of all the possible code combinations, then using the user feedback to remove codes that would be impossible. To make the array,
I first calculated the total number of possible combinations (by doing the number of colors raised to the number of positions). This is the total number of codes possible. Then I fixed
the first position in all the codes to one of the colors. I then used a recursive algorithm that calls itself until there is no more positons left to fill the rest of the array.
Once this array is built, the computer will guess the first entry in the array that is not null. Then using the feedback from the user, it will eliminate impossible codes. It does this
by comparing it's guess to every entry in the array to see if the feedback would be the same as the feedback provided by the user. So it will first go through and check if the guess
and the test array have any identical postions. If this is the case, it will increment the variable for correct positions and then set the test array's position here to null. It will do this 
for all positions. Then it will check to see if the guess array has any similiar strings to the test array left (position does not matter). If it does, the correct color, wrong position
variable will be incremented. It will then compare the two variables to the feedback provided by the user and if they are not identical, it will set the test array to null. It does this
for every entry, then guesses the next non null entry. My program will do this until the correct code is found. It will know it's correct when the user says the correct colors is
equal to the total number of positions.