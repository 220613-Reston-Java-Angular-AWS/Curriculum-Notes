## JSON

JSON (**J**ava**S**cript **O**bject **N**otation) is a lightweight data-interchange format. It is easy for humans to read and write. It is easy for machines to parse and generate.

JSON Object is a set of *key and value pair* enclosed within curly braces. A key is a string enclosed in quotation marks.A value can be a string, number, boolean expression, array, or object. A key value pair follows a specific syntax, with the key followed by a colon followed by the value. Key/value pairs are separated by comma. (`"name" : "Andy"`)

**Example:**
```javascript
var Book = {
"id": 110,	‬‬‬‬‬‬‬‬‬‬‬‬‬‬‬‬‬‬‬‬‬‬
"language": "Python",
"author": ["John", "Ben"]
};
```
We can store mutiple JSON objects in Arrays.

**Example:**
```javascript
var student =[ 
	
     { 
        "id":"01", 
        "name": "Tom", 
        "lastname": "Price" 
     }, 
	
     { 
        "id":"02", 
        "name": "Nick", 
        "lastname": "Thameson" 
     } 
  ] ;  
```

Some of the applications of JSON are listed below:

* Used to transmit data between the server and web application using JSON.
* JSON format helps transmit and serialize all types of structured data.
* Allows us to perform asynchronous data calls without the need to do a page refresh.
* Web services and Restful APIs use the JSON format to get public data.