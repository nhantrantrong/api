#### api Repository
This is sample repository framework for api testing

#### Get the Application Under Test
# Download and install docker on your machine

https://www.docker.com/products/docker-desktop

# To pull the student app image, run following command 

docker pull tejasn1/student-app

# You can launch the student-app using the command below

docker run -p 8085:8080 -d tejasn1/student-app

Then You can access the student app on the url http://localhost:8085/student/list

#### Noted:
Test files Name should be Endswith Test to be able to recognize and execute by Junit

#### Test execution locally 
# Run a single test:

mvn clean verify -Dit.test=testClassPathName#testMethodName serenity:aggregate

# Run all tests:

mvn clean verify serenity:aggregate

# Only generate serenity report

mvn serenity:aggregate
