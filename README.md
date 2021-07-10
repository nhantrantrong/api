# api
This is sample repository framework for api testing

# Noted:
Test files Name should be Endswith Test to be able to recognize and execute by Junit

# Run a single test:
mvn clean verify -Dit.test=testClassPathName#testMethodName serenity:aggregate

# Run all tests:
mvn clean verify serenity:aggregate
