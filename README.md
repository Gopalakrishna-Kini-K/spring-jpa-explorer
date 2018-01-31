# spring-jpa-explorer
A project to explore the different relationships between entities like @OneToMay @ManyToMany and @ManyToOne, check their performances.

This project is configured to print the hql queries being executed. Using these queries we can analyse, which relations produce more intermediate queries, thus enabling us to refactor our entity relations

In this project, we explore relationships between three entities
  * NationalTeam 
  * CricketPlayer 
  * FranchiseTeam 
  
  There is a ``` @OneToMany ``` relationship between ```NationalTeam``` and ```CricketPlayer``` i.e. one national team can have many cricket players playing for them, but one cricket player can have only one national team. There is a ```@ManyToMany``` relationship between ```CricketPlayer``` and ```FranchiseTeam``` i.e. one player can play for mutliple franchise teams ( CSK, Melbourne ) etc.
  

