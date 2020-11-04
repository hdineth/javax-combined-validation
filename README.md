# javax-combined-validation
Combined Request Object Validation with Custom Messages

## Overview
- This is a sample project which has been implemented combined custom validation with custom messages
- "User.class" has 3 fields as "name", "email" and "country"
- If "name" is not empty in the system, then "email" and "country" can be empty
- If "name" is empty, both "email" and "country" are mandatory
- Custom validation is build as generic hence any object can be validated
- inmemory h2 databse has been used. Postman request is available under "_/resources_" folder.
