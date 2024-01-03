
The problem for manage beverages information, needs a data structure, therefore i decided use Postgress database 

Postgress is a relational database wich bring us reference integrity. Therefore we can save information like beeverage, customers, discounts, etc, getting a informacion more ordered 
 
For repository layer, i use JpaRepository because this implementation has all necesary for interact details and fields in database tables 

since we use a jpaRepository we don´t need write querys for getting information, we just need write abstract methods that bring us required records. 

The problem doesn't need complex queries for extract information and meet the business requirements
