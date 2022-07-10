## Cookies

A cookie is a key-value pair of information sent by the server to the client, which the client will store.  The client (usually a web browser) can send this cookie in the HTTP request header for all subsequent requests until the cookie becomes invalid.

The Servlet container checks the request header for cookies, most commonly to get the session information from the cookie, which it uses it to retrieve the associated session data stored in the server.

We can classify the cookies into two types based on their expiry time:

![cookies](./images/cookies-1.png)

* **Non-persistent cookie** - Cookie becomes expired when the user closes the browser.

* **Persistent Cookies** - Cookie expires only if the user logs out of the website.  The cookie is stored on the browser even the user closes the browser each time. 

### Creating Cookies with Servlets

To send cookies to the client, we need to create a Cookie object, set the maximum age for the cookie, and place the cookie in the HTTP response header.
The `Cookie(String name, String value)` constructor defined in the **javax.servlet.http.Cookie** class can be used to create a cookie with a specified name and value. We can use the `setMaxAge()` method to set the maximum age for the particular cookie in seconds. We can use the `response.addCookie()` method to place the cookie in the HTTP response header.

**Example:**
```java
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    
    //Creating a Cookie object
    Cookie cookie = new Cookie("name","Adam");
    
    // Set expiry date after 24 Hrs (86,400seconds)
    cookie.setMaxAge(86400);
    
    // Add the cookie in the response header
    response.addCookie(cookie);
}
```

### Reading Cookies with Servlets

To read cookies, We need to create an array of javax.servlet.http.Cookie objects by calling the `getCookies()` method of HttpServletRequest. Then the `getName()` and `getValue()` methods used to access each cookie and associated value.


**Example:**
```java
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

    //getting all the cookies
    Cookie cookies[]=request.getCookies();
 
    PrintWriter out = response.getWriter();
    for(Cookie c : cookies){  
        out.println("Name: "+c.getName()+" & Value: "+c.getValue());
    }
}
```

### References
* [Further Reading on Cookies](https://www.geeksforgeeks.org/javax-servlet-http-cookie-class-java/)


