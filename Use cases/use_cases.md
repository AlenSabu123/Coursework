Use Case 1: Generate Report of All Countries Organized by Population (Largest to Smallest)
Goal in Context
Generate a report showing all countries organized by population, from the largest to the smallest, for analysis and comparison.

Scope
The system will retrieve and sort the population data for all countries, presenting them from the highest to the lowest population.

Level
Primary task.

Preconditions
The system has access to global population data for all countries.
The system is capable of sorting the data by population.
Success End Condition
A valid report is generated, showing countries ordered from the largest to the smallest population.

Failed End Condition
The system is unable to retrieve or sort the population data for the countries.

Primary Actor
Software engineer (user).

Trigger
The software engineer requests a report showing all countries, ordered by population from largest to smallest.

Main Success Scenario
The software engineer selects the option to generate a report showing all countries ordered by population.
The system retrieves population data for all countries.
The system sorts the countries by population in descending order (largest to smallest).
The system generates and displays the report, showing each country’s population.
Extensions
Extension 1: If the population data for certain countries is unavailable, the system will flag those countries as missing from the report.
Use Case 2: Generate Report of Top N Countries by Population
Goal in Context
Generate a report showing the top N countries by population, where N is specified by the user.

Scope
The system will provide a report that includes only the top N most populous countries, sorted from largest to smallest population.

Level
Primary task.

Preconditions
The system has access to global population data.
The software engineer has specified the number N of countries to include in the report.
Success End Condition
A valid report is generated showing the top N countries by population, ordered from largest to smallest.

Failed End Condition
The system fails to retrieve or sort the required population data.

Primary Actor
Software engineer (user).

Trigger
The software engineer requests a report showing the top N countries by population.

Main Success Scenario
The software engineer specifies the number of countries (N) to include in the report.
The system retrieves population data for all countries.
The system sorts the countries by population in descending order (largest to smallest).
The system generates and displays the report, including only the top N countries.
Extensions
Extension 1: If there are fewer than N countries in the database, the system will display all available countries in the report.
Use Case 3: Generate Report of All Cities Organized by Population (Largest to Smallest)
Goal in Context
Generate a report showing all cities, ordered by population, from the largest to the smallest.

Scope
The system will retrieve and sort the population data for all cities, displaying them in descending order of population.

Level
Primary task.

Preconditions
The system has access to population data for all cities.
The system is capable of sorting data by population.
Success End Condition
A valid report is generated, showing cities ordered by population from largest to smallest.

Failed End Condition
The system is unable to retrieve or sort the population data for cities.

Primary Actor
Software engineer (user).

Trigger
The software engineer requests a report showing all cities ordered by population from largest to smallest.

Main Success Scenario
The software engineer selects the option to generate a report showing all cities ordered by population.
The system retrieves population data for all cities.
The system sorts the cities by population in descending order.
The system generates and displays the report, showing each city’s population.
Extensions
Extension 1: If any cities have missing population data, the system will flag these cities and exclude them from the report.

Use Case 4: Generate Report of Top N Cities by Population
Goal in Context
Generate a report showing the top N cities by population, where N is specified by the user.

Scope
The system will provide a report with the top N most populous cities, sorted from largest to smallest.

Level
Primary task.

Preconditions
The system has access to population data for all cities.
The software engineer has specified the number N of cities to include in the report.
Success End Condition
A valid report is generated showing the top N cities by population, ordered from largest to smallest.

Failed End Condition
The system fails to retrieve or sort the required population data.

Primary Actor
Software engineer (user).

Trigger
The software engineer requests a report showing the top N cities by population.

Main Success Scenario
The software engineer specifies the number of cities (N) to include in the report.
The system retrieves population data for all cities.
The system sorts the cities by population in descending order (largest to smallest).
The system generates and displays the report, including only the top N cities.
Extensions
Extension 1: If there are fewer than N cities in the database, the system will display all available cities in the report.

Use Case 5: Generate Report of All Capital Cities Organized by Population (Largest to Smallest)
Goal in Context
Generate a report showing all capital cities, organized by population from largest to smallest.

Scope
The system will retrieve and sort the population data for all capital cities, displaying them in descending order.

Level
Primary task.

Preconditions
The system has access to population data for all capital cities.
The system is capable of sorting capital cities by population.
Success End Condition
A valid report is generated, showing capital cities ordered by population from largest to smallest.

Failed End Condition
The system is unable to retrieve or sort the population data for capital cities.

Primary Actor
Software engineer (user).

Trigger
The software engineer requests a report showing all capital cities ordered by population from largest to smallest.

Main Success Scenario
The software engineer selects the option to generate a report showing all capital cities ordered by population.
The system retrieves population data for all capital cities.
The system sorts the capital cities by population in descending order.
The system generates and displays the report, showing each capital city’s population.
Extensions
Extension 1: If some capital cities have missing population data, the system will exclude them from the report and flag them as missing.
Use Case 6: Generate Report of Top N Populated Capital Cities
Goal in Context
Generate a report showing the top N most populous capital cities, where N is specified by the user.

Scope
The system will provide a report showing the top N populated capital cities, sorted from largest to smallest.

Level
Primary task.

Preconditions
The system has access to population data for all capital cities.
The software engineer has specified the number N of capital cities to include in the report.
Success End Condition
A valid report is generated showing the top N populated capital cities, ordered from largest to smallest.

Failed End Condition
The system fails to retrieve or sort the required capital city population data.

Primary Actor
Software engineer (user).

Trigger
The software engineer requests a report showing the top N populated capital cities.

Main Success Scenario
The software engineer specifies the number of capital cities (N) to include in the report.
The system retrieves population data for all capital cities.
The system sorts the capital cities by population in descending order (largest to smallest).
The system generates and displays the report, including only the top N capital cities.
Extensions
Extension 1: If there are fewer than N capital cities in the database, the system will display all available capital cities in the report.


#Use Case 7: Generate Report of People, People Living in Cities, and People Not Living in Cities
Goal in Context
Generate a report showing the total population of people, the population living in cities, and the population not living in cities, along with the percentage of each group.

# Scope
The system will generate a report that includes total population, urban population (living in cities), and rural population (not living in cities), as well as the percentage of each group within the total population.

Level
Primary task.

Preconditions
The system has access to population data for both urban and rural areas.
The system is capable of calculating percentages based on the total population.
Success End Condition
A report is generated showing the total population, the urban population, the rural population, and the percentage breakdowns.

Failed End Condition
The system fails to retrieve or process the required population data.

Primary Actor
Software engineer (user).

Trigger
The software engineer requests a report that includes total population, urban population, rural population, and percentage breakdowns.

Main Success Scenario
The software engineer selects the option to generate a report on total population, urban population, and rural population.
The system retrieves population data for both urban and rural areas.
The system calculates the percentage of people living in cities and those not living in cities.
The system generates and displays the report with the total population, urban population, rural population, and corresponding percentages.
Extensions
Extension 1: If some data is missing for urban or rural populations, the system will flag it as missing and exclude it from the report.