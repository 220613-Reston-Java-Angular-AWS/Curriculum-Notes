# HTML-CSS QC Questions 

1. What is HTML
  + HTML stands for Hypertext Markup Language and consists of various tags to describe the content of a document - utilized as the basis for all web pages, along with CSS and JavaScript
2. What is the structure of an HTML document? List some tags. What is `<head>` used for? `<body>`?
  + Start with the doctype declaration, then `<html>`, then `<head>` and `<body>`. The head contains the metadata for the page, while the body contains the content that is rendered to the screen. Other tags: div, span, p, ul, ol, li, strong, em, table
3. What is a doctype?
  + First tag in the document - defines what type of file it is - whether html 4 or 5, etc
4. What is the tag for an ordered list? Unordered list?
  + ordered list: ol, unordered list: ul. Both use li - list items
5. What are some HTML5 tags? Why were HTML5 tags introduced?
  + HTML5 introduced semantic tags to more accurately reflect the content of the tags. Examples: `<strong>` instead of `<b>`, `<em>` instead of `<i>`, `<nav>`, `<header>`, `<footer>`, `<section>`, `<article>`, and `<aside>` instead of reusing `<div>` tags everywhere
6. Do all tags come in a pair? What are the other things inside tags called? list some.
  + No - tags either have a closing tag or are self-closing (`<tag />`). Attributes are contained within tags - examples: id, class, style, height, width, etc
7. What is the syntax for a comment in HTML?
  + `<!-- comments go in here -->`
8. Give me the HTML markup for a table.
```html
<table>
  <caption>optional</caption>
  <thead>
    <tr>
     <td>Heading 1</td><td>Heading 2</td>
   </tr>
  </thead>
   <tr>
    <td>Cell 1</td><td>Cell 2</td>
   </tr>
  <tbody>
  </tbody>
</table>
```
9. What are some tags you would use in a form?
  + Form tags: `<form>`, `<input>`, `<label>`, `<textarea>`, `<button>`, `<select>`, `<option>`
10. What is CSS? what are the different ways of styling an HTML file? Which is best? why?
  + CSS stands for Cascading Style Sheets - it is a language for styling HTML documents by specifying certain rules for layout and display in key/value pairs. There are 3 ways of styling an HTML file:
  + (1) inline - in the `style` attribute
  + (2) internal stylesheet - in the `<style>` tag in the `<head>`
  + (3) external stylesheet - using external `.css` file, use `<link>` in the `<head>`
  + External stylesheet is best practice due to separation of concerns, reusability, modularity
11. Describe the CSS box model.
  + The box model consists of margin (outermost box), then border, then padding, then content (innermost). All box sizes / formatting can be styled with CSS
12. Which way has highest priority when styles cascade: inline, internal, and external.
  + Inline has highest priority, then internal/external depending on order. Cascading rules are determined by (1) importance (`!important` flag), (2) specificity of selector (inline has no selector, highest specificity), then (3) source order.
13. Syntax for styling an element? What is a class and how to style them? What is an id? how to style? difference?
```css
div { property: value}
.class { property: value}
#id { property: value}
```
14. What if I want to select child elements, What syntax is that?
  + use direct descendant selector (`>`) or space for any level nested element
15. Can I select multiple elements at once? How?
  + yes, with a comma
16. What is a psuedo-class? What is syntax for selecting that?
  + psuedo-class selects an element in a certain state - for example, when hovered over. Use colon (`:psuedoselector`) syntax
17. What is Bootstrap?
  + Bootstrap is a CSS framework with pre-written CSS rules to easily style your page and incorporate responsive design seamlessly. Contains various utilities and components for making a great UI
18. Describe the Bootstrap grid system
  + The Bootstrap grid is divided into 12 columns. You wrap the columns in a `.row` which is in a `.container` or `.container-flex`. The columns are responsive - there are classes for different screen sizes which collapse on smaller windows-