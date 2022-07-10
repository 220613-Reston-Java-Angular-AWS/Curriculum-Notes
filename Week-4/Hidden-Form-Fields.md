## Hidden Form Fields

Hidden fields can be inserted into webpages by the server for session tracking. <br/>
These fields are not visible directly to the user but can still be viewed using the *view source* option from the browser.
Therefore, hidden fields should *not* be used as a form of security.

Hidden fields may be used to send information that is only pertinent to the server, and not the client.

A web server can send a hidden HTML form field along with a unique session ID:
```html
<input type = "hidden" name = "session_id" value = "65349">
```

This hidden field is not displayed on the browser but the value is sent to the server when the parent `<form>` element is submitted. 

The server retrieves this hidden form field value using the `request.getParameter("session_id")` method in a servlet.