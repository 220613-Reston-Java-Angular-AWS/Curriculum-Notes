import { VoteComponent } from "./vote.component";

let component: VoteComponent;

// considered a set up method - meaning it will  'set up the environment to be tested'
beforeEach( () => {
component = new VoteComponent;
})

//other methods that exist
// afterEach(()=> {}) // this is considered the tear down - which removes any metadata that is no longer needed
// beforeAll(()=>{})
// afterAll(()=>{})



describe('VoteComponent', () => {

//Keep in mind that when we are testing components (aka classes)
//there is a flow we want to follow

it('should increment totalVotes when upVote is called', () => {


//Arrange - set up the 'house' of what will be tested
// let component = new VoteComponent();


//Act - invoke or use the method that you want to test n the class
component.upVote();



//Assert - set up the expected result 
expect(component.totalVotes).toBe(1);

});



it('should decrement totalVotes when downVote is called', () => {


    //Keep in mind that when we are testing components (aka classes)
    //there is a flow we want to follow
    
    //Arrange - set up the 'house' of what will be tested
    // let component = new VoteComponent();
    
    
    //Act - invoke or use the method that you want to test n the class
    component.downVote();
    
    
    
    //Assert - set up the expected result 
    expect(component.totalVotes).toBe(-1);
    
    })
    
});