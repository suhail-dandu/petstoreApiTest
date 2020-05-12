# petstoreApiTest
Excute test by clicking batch file- Execute.bat

or 

Execute by maven command - mvn clean test (execute all tests),

To Execute specific test use executionTag. for example
	- mvn clean test -DexecutionTag=testPetstoreFindByID
	
These are the available tests:

testPetstoreAddPet
testPetstoreUpdatePet
testPetstoreFindByStatus
testPetstoreFindByID
testPetstorePostUpdate
testPetstoreDeleteRecord


Check execute result in /reportLogs/ folder

*Note: There are few pending issues which I was not able to fix due to lack of time.