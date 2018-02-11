# Boni CSV Reader

Given the following content of a csv file:

  name;bank_identifier <br />
  Postbank;10010010 <br />
  Eurocity;10030700 <br />
  Commerzbank;10040000 <br />
  Raiffeisenbank;22163114 <br />
  
1. Write a program which imports the entries of the csv file into a database of
your choice (preferably PostgreSQL)
2. Fetch the record with the bank identifier 10040000 from DB and print the
name of the related bank to system out.


## Solution

Problem to above solution can be acheived using **Batch processing**. In this code i have tried to acheive spring boot batch processing.

Spring Batch is a powerful module to implement a batch process for tons of data conveniently.

Here we are trying to import CSV Data to PostgreSQL Database using Spring Batch Job.

There are four Jobs in typical Spring batch processing:

1. **Reader** : reads content of CSV file, then convert the content to **BankDetails** object.
2. **Processor** : process the **BankDetails** object. 
3. **Writer** : writes batch of records to PostgreSQL Database using **BankRepo**.
4. **Listner** :  handles after Step, read data from Database Table to verify and show LOGs.


Reason to chose Spring batch:

1. Spring Batch provides reusable functions that are essential in processing large volumes of records, including logging/tracing, transaction, and job processing statistics, job restart, skip, and resource management.<br />
2. It also provides more advanced technical services and features that will enable extremely high-volume and high performance batch jobs though optimization and partitioning <br />
3. Simple as well as complex, high-volume batch jobs can leverage the framework in a highly scalable manner to process significant volumes of information. <br />
4. Lack of a standard architecture results in the proliferation of expensive one-off, in-house custom architectures <br />
5. Although batch jobs are part of most IT projects, there is no widely-adopted commercial or open source java framework to provide a robust, enterprise-scale solution. <br />

Here once you successfuly cloned the project and started the application, You can see things in action

1. Reading and storing of data from CSV file(bank-data.csv) at [http://localhost:8080/startProcess](http://localhost:8080/startProcess)
2. Fetching data for Particular Bank Identifier at [http://localhost:8080/bank_identifier/10040000](http://localhost:8080/bank_identifier/10040000)

### Prerequisites

For this application to run below are the pre requisite

1. Java (Used for development)
2. Maven (Used for building and running application, You can use IDE like STS or Eclipse).

### How to start app??

Below are the steps to do run the application....

##### Running the project

To start app from IDE 

**STS**
```
 Right click on project -> Run as -> Spring boot app
```

**CLI**
From project folder execute below command. Since this is a mavenised project we will use below command.
```
 mvn clean install
```
```
 mvn spring-boot:run
```


## Authors

**Shaik Fareed** : Full stack Java developer at GE <br />
**Email id** : shaikfareed46@gmail.com


## Help

###### Please conatct me, if you have problems executing the app. 
