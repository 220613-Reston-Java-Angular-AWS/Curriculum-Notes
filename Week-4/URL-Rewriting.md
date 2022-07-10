## URL Rewriting

URL Rewriting is a process by which a **unique session ID gets appended to each request URL**, so the server can identify the user session.

URL Rewriting maintains the session and works even the user's browser doesn't support cookies.  This makes it one of the ways in which we can provide a unique id in request and response, alongside [implementing the Session Interface](https://gitlab.com/revature_training/servlet-team/-/blob/master/modules/session-management/HttpSession.md) and [Cookies Management](https://gitlab.com/revature_training/servlet-team/-/blob/master/modules/session-management/cookies.md).

## Example

We will create an **HTML page** to capture a username value from the client, a **FirstServlet** which will print the username, and then provide the url pass control to **SecondServlet** using url rewriting. 

#### Program Flow

![programflow](./images/url-rewriting-1.png)


### Create <code>index.html</code> Form

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML Form</title>
</head>
<body>
	<form action="FirstServlet" method="get">
			Name:<input type="text" name="userName" /><br><br/> 
			     <input type="submit" value="Submit" />
	</form>
</body>
</html>
```


### Create <code>FirstServlet.java</code>

```java
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet { 

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    { 
        try { 
            response.setContentType("text/html"); 

            PrintWriter out = response.getWriter(); 

            // request.getParameter takes the value from index.html file where name is "userName" 
            String n = request.getParameter("userName"); 
            out.print("Welcome " + n); 
  
  
            /** url rewriting is used for creating a session - it will redirect  you to SecondServlet page 
                Notice that we have set the query parameter ?uname equal to the userName parameter we retrieved from the request
            **/
            out.print("<a href='SecondServlet?uname=" + n + "'>visit</a>"); 
  
            out.close(); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
} 
```

We appply URL rewriting in the FirstServlet when we pass control to the SecondServlet.
```java
out.print("<a href='SecondServlet?uname=" + n + "'>pass control to secondServlet</a>"); 
```


### Create <code>SecondServlet.java</code>

```java
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet { 
  
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    { 
        try { 
  
            response.setContentType("text/html"); 
           
            PrintWriter out = response.getWriter(); 

            // use request.getParameter() to get the value from the url that we have rewritten in  FirstServlet
            String n = request.getParameter("uname"); 
            out.print("Hello " + n); 
            
            out.close(); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
}
```



The benfit of URL rewriting is that it doesn’t depend upon cookies and will work whether cookies are enabled or disabled.  Extra form submission is not required on all pages.

### References

* [Further reading on URL Rewriting](https://www.geeksforgeeks.org/url-rewriting-using-java-servlet/)
