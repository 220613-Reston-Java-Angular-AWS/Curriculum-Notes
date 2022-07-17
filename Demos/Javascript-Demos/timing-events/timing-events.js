
// these fucntions are going to create is going to 
//change the look or color of our html element


function changeBlue(){
    let parent = document.getElementById("parent-1");

    //set the color change to be delayed 3 second

    setTimeout(() => {

        console.log(parent);
        console.log("Please wait....");

        //apply the class bulegradient to the parent

        parent.classList.add("color-bluegradient")

    },3000);

    console.log("Done, the background should be blue")
}


//now were going to make the changeGreen function
function changeGreen(){
    let parent = document.getElementById("parent-2");

//this setTimeout is technically a callback funtion
    setTimeout( () =>{
        console.log("Please wait...")

        //apply the class greengradient

        parent.classList.add("color-greengradient")
    })
console.log("Done: The background color is green")

}