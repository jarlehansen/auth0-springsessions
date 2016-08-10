# Auth0 Spring Session

See details in stack overflow: http://stackoverflow.com/questions/38844652/spring-session-with-auth0-session-is-empty

An example project showing the issue with using Spring Session (with local embedded Redis) and Auth0.
The problem is that when using Spring Session we do not receive the tokens and the auth0User in the session.
If the `@EnableRedisHttpSession` is removed, this information (tokens & auth0User) works as intended.

## Usage

To run the example configure the auth0.properties auth0.domain, auth0.issuer, auth0.clientId and auth0.clientSecret.
In the auth0 application configuration set up "Allowed Callback URLs=http://localhost:8080/callback"