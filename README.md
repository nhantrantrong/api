## api Repository
- This is sample repository framework for api testing with Java Serenity

## Get the Application Under Test
- Download and install docker on your machine
https://www.docker.com/products/docker-desktop

- To pull the student app image, run following command 
`docker pull tejasn1/student-app`

- You can launch the student-app using the command below
`docker run -p 8081:8080 -d tejasn1/student-app`

- Then You can access the student app on the url http://localhost:8081/student/list

## Noted:
- Test files Name should be Ended with `Test` or `Tests` to be able to recognize and execute by Junit

## Test execution locally 
- Run a single test:
`mvn clean verify -Dit.test=testClassPathName#testMethodName serenity:aggregate`

- Run all tests:
`mvn clean verify serenity:aggregate`

- Only generate serenity report
`mvn serenity:aggregate`

## Java Doc reference by below html file
./javaDoc/index.html

## Generate Json Schema to validate
- Navigate to any of below online tool:
https://www.liquid-technologies.com/online-json-to-schema-converter
https://www.jsonschema.net/login
- Copy and paste your JSon string to the text file
- Select any corresponding options
- Click "Generate" button
- Save the generated json schema to your resource folder
