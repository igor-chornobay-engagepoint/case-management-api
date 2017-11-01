# CWDS CASE MANAGEMENT API

The CWDS API provides Forms Generation RESTful services for the CWDS CALS Digital Service.

## Wiki

The development team is actively using the [Github Wiki](https://github.com/ca-cwds/case-management-api/wiki).

## Documentation

The development team uses [Swagger](http://swagger.io/) for documenting the API.
NOTE : At this time there is not a publicy available link to the documentation, a link will be provided as soon as one is available.


## Configuration

### Application Configuration Parameters
- APP_VERSION -- Version of application

### Data Stores Configuration Parameters

The CWDS API currently utilizes four persistent stores:

In order for the CASE MANAGEMENT API successfully connect to the databases the following environment variables are required to be set:

#### DB2 - CMS database
- DB_CMS_USER -- the CMS database username
- DB_CMS_PASSWORD -- the CMS database password
- DB_CMS_DB2_HOST -- the CMS DB2 host (IP - address)
- DB_CMS_DB2_PORT -- the CMS DB2 port number
- DB_CMS_DB_NAME -- the CMS database name 
- DB_CMS_JDBC_URL -- the CMS database URL in Java Database Connectivity format

- DB_CMS_SCHEMA -- the CMS database schema the tables belong to.
- DB_CMS_CP_INITIAL_SIZE -- the CMS connections pool iniitial size (default: 2)  
- DB_CMS_CP_MIN_SIZE -- the CMS connections pool minimum size (default: 2)
- DB_CMS_CP_MAX_SIZE -- the CMS connections pool maximum size (default: 8)


#### Swagger Configuration Parameters**
- LOGIN_URL -- Login URL
- LOGOUT_URL -- Logout URL 
- SHOW_SWAGGER -- Show swagger (true | false) default - true
- SWAGGER_JSON_URL -- default - http://localhost:8080/swagger.json
- SWAGGER_CALLBACK_URL -- default - http://localhost:8080/swagger

#### Shiro Configuration Parameters
- SHIRO_CONFIG_PATH -- path to Shiro configuration file
 
The Docker env-file option provides a convenient method to supply these variables. These instructions assume an env file called .env located in the current directory. The repository contains a sample env file called env.sample.

Further configuration options are available in the file config/case-management-api.yml.

## Testing

### Integration testing
To run Integration tests set property api.url to point to environment host. Use gradle integrationTest task. In this case token will be generated for default test user, so it's possible to test environment with Perry running in dev mode.

### Smoke Testing
Smoke test suite is part of integration tests. Set api.url, use gradle smokeTestSuite task. Smoke test endpoint is not protected by Perry.