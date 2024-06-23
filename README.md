Basic implementation of CSRF prevention

Here we are relying on the basic building blocks provided by Spring Security.

We are mainly storing the Tokens in memory which are attached to the Http Session.

You can of course customize the token by implementing the `CsrfToken.java` interface, 
persist them in a dedicated datastore using `CsrfTokenRepository.java`

