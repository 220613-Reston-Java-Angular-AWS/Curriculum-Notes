# XML - eXtensible Markup Language 
* like HTML, not a programming language but a markup language
* designed to transport and store data in a way that is both human and machine readable
* language agnostic

```XML 
<?xml version="1.0" encoding="UTF-8"?>
<students>
    <student>
        <firstName>Veronica</firstName> <lastName>Jones</lastName>
    </student>
    <student>
        <firstName>Paul</firstName> <lastName>McCormick</lastName>
    </student>
    <student>
        <firstName>Lola</firstName> <lastName>Nunez</lastName>
    </student>
</students> 
``` 
 
```javascript
{students:[
    { firstName:"Veronica", lastName:"Jones" },
    { firstName:"Paul", lastName:"McCormick" },
    { firstName:"Lola", lastName:"Nunez" }
]}
```

```JSON
{"student":[
    { "firstName":"Veronica", "lastName":"Jones" },
    { "firstName":"Paul", "lastName":"McCormick" },
    { "firstName":"Lola", "lastName":"Nunez" }
]}
```
- faster parsing  
- more compatible w/ JavaScript  
- less verbose  
- more universal (tags won't change with different developers)  


#### Well-Formed vs. Valid XML

Well Formed XML  
- Follows basic syntatic rules   
    * begins with XML declaration  
    * unique root element  
    * starting and ending tag must match  
    * elements are case sensitive  
    * elements must be properly nested  
- Well formed document is not necessarily valid  

Valid XML
- XML which follows a predefined structure  
- Validated using: 
    * Document Type Definition  
    * XML Schema Definition  
- Valid XML will also be well formed  


#### Document Type Definition (DTD)


- written in its own DTD syntax  
- define element names and relationships   
- can define range of values  
- PCDATA and CDATA - parsed character data and unparsed character data  
    - PCDATA is text that will be parsed by a parser. Tags inside the text will be treated as markup and entities will be expanded.  
    - CDATA is text that will not be parsed by a parser. Tags inside the text will not be treated as markup and entities will not be expanded.  
- can't be more specific with types  
    
#### XML Schema Definition (XSD)


- written in XML  
- can declare simple and complex types  
- can declare number and order of child elements  
- can declare default and fixed values for elements and attributes  

#### XML Namespace


- anyone can create their own markup with their own tags  
- namespace allows us to differentiate from people using the same tag name for different purposes  
- namespace declaration xmlns:prefix = "namespace"  
- unique identifier URI - so if you have a registered URL  
- doesn't necessarily have anything to do  

```XML 
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs=".../xmlSchema">
<xs:students>
    <xs:student>
        <xs:firstName>Veronica</xs:firstName> <xs:lastName>Jones</xs:lastName>
    </xs:student>
    <xs:student>
        <xs:firstName>Paul</xs:firstName> <xs:lastName>McCormick</xs:lastName>
    </xs:student>
    <xs:student>
        <xs:firstName>Lola</xs:firstName> <xs:lastName>Nunez</xs:lastName>
    </xs:student>
</xs:students> 
``` 

#### Parsing XML

**JAXP - Java API for XML Processing** 


Document Object Model (DOM) 
- loads full xml file into memory and creates a tree representation of it
- much faster for small/medium sized files because of in-memory retrieval
- can get very expensive (memory-wise) for larger files

Simple API for XML Parsing (SAX)
    - read only
    - event based - "streams" XML data without loading all of it into memory
    

#### XML Binding


**JAXB - Java and XML Binding** 

**Marshalling**: converting XML to Java Objects

**UnMarshalling**: converting Java Objects to XML