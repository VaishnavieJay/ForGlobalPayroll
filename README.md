# ForGlobalPayroll

Description:
This project is for IIPay. A sample implementation for sorting dates based on - Dates with an 'r' in the month, sorted ascending
(first to last), then dates without a 'r'in the month, sorted descending (last to first).
Example: (01/07/19, 02/01/19, 01/01/19, 03/05/19) would sort to (01/01/19, 02/01/19, 01/07/19, 03/05/19)

Pre-requisites:
The following are the pre-requisites to run -
Java 11
Maven

Build:

mvn clean build


Test:

mvn clean test 

This will run all the testcases present in the file - /IIPaySample/src/test/java/com/iipay/sample/DateSorterImplTest.java
