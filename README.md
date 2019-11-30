// Patru Diana-Georgiana 322CA
# Project - Stage 1 - League of OOP

 As this is the first part of the project, I have tried as much as possible to structure and 
organize the logic of the code itself in as many packages and having suggestive names with 
specific functionalities. So, in the following, I will try to explain each package and the files
 that belong to it.
 
> 1  Abilities package 
>> * Each hero ability represents one file in which the visit() method is overwritten for each
>> hero type. These are part of the Double Dispatch concept, in which we deal with several categories 
>> of objects (each category containing objects of different types), between which there is an interaction. 
>>* Thus, each hero interacts with the type of ability corresponding to the opponent in the current battle. 
>> Each ability represents "a visitor" that determines the damage it inflicts on the opponent.
>> 
>
> 2 Common package 
>> * Contains a file called Constants.java in which all int or float constants are declared to determine 
> the damage, hp, or xp for each hero.
>
> 3 Heroes package
>> * Contains an abstract Hero class that is expanded by each type of hero: Pyromancer, Knight, Rogue,
>> Wizard and which contains all the hero methods for moving, fighting, level updating, hp, xp, etc.
>> * The Visitable class is an interface, whose accept method (Visitor) allows each ability to visit
>> each hero, being part of the Double Dispatch Concept. 
>> * The Factory Pattern design is used to create the types of heroes that correspond to the input data.
>
> 4 Main package 
>> * Contains the Main class that calls the GameInputLoader instance, which uses reading from the
>> first homework :). 
>> * The Game class, instantiated with Singleton Pattern, contains methods of creating heroes, conducting 
>> the game itself on rounds but also displaying the board game at the end of the game.
>
> 5 Map package
>> * Contains the instant Map class with Singleton Pattern, and represents the game map and the type of 
>> land for each corresponding box.
>
I left attached in the archive and the .git folder for granting the bonus :) :)