# CS320 Summary and Reflection Report
In summary of my work done for Project One I went back and examined my testing approaches for each of the three features
and tried to clean up code that needed to be adjusted and focus on test coverage being sound and complete for each feature. 
For the contact object and contact service I went back and implemented code and tests I had developed for the task object 
and task service. This setup I was able to adjust and apply for each of the three objects and services. The objects were made 
as a constructor with the services implementing array lists to call the object/constructor to add objects into the array. Each 
of the three features services contained three functions: adding an object with unique id, deleting an object based on unique id, 
and updating object based on id.  In order to ensure that the code was technically sound I simply went down the list of requirements for both the object/constructor and each function of the service to see how to make a test annotation to cover each. For example,
on the update method in the TaskService feature I simply created a test annotation to test updating a current object in the array
list and printing the change to verify that all entries had been update but the ID by calling for a new object to be made. I was 
able to verify that a new object couldn’t be created with the same ID that already existed so the current object with that ID was 
updated with the changed parameters. Overall, the quality of my JUnit tests for Project 1 were right on track with testing 
standards. This is based on the coverages I received from each feature as follows. The contact service feature tested at a 93.2%,
task service feature at 93.7%, and the appointment services feature at 90.3%. Another way to ensure code was sound was running the
JUnit tests multiple times changing the test input to see how the test results differed. This helped me to know I was on the right
path. For instance, in my code where I test the Boolean equals method multiple times, as necessary.:
@Test public void equalsFalseTest1() {
		    Task t1 = new Task("Randomly", "Entered", "Test Answers");
		    Object obj = new Object();
		    Assert.assertNotEquals(t1, obj); }
		@Test public void equalsTrueTest() {
			Task t1 = new Task("Randomly", "Entered", "Test Answers");
		    Task t2 = new Task("Randomly", "Entered", "Test Answers");
		    Assert.assertEquals(t1, t2); }
 Here, I reviewed this test multiple times, first this way and next with the parameters set to actual different values. In the end
 this is result I wanted from the test. I preferred the test to fail in the system, which highlights errors this particular test 
 is meant to catch. For efficiencies sake I went back and made my tests for each feature as similar as possible. Taking a look at 
 the same test from multiple features shows the similar structures making things efficient and straight forward:
@Test
void testContactServiceUpdateTask() {
	TaskService services = new TaskService();
	Task a = new Task("00004", "Take out trash", "Include recyclibles");
	Task b = new Task("00005", "Clean room", "Make sure to dust all surfaces");
	Task c = new Task("00006", "Wash Clothes", "Seperate colors from whites");
		assertEquals(true, services.addTask(a));
		assertEquals(true, services.addTask(b));
		assertEquals(true, services.addTask(c));
		assertEquals(true, services.update("00004", "Take out trash", "Do not include recyclibles"));
		assertEquals(true, services.update("00006", "Wash Clothes", "Seperate colors from whites, bleach whites")); }	
@Test
void testTaskServiceUpdateTask() {
	TaskService services = new TaskService();
	Task a = new Task("00004", "Take out trash", "Include recyclibles");
	Task b = new Task("00005", "Clean room", "Make sure to dust all surfaces");
	Task c = new Task("00006", "Wash Clothes", "Seperate colors from whites");
		assertEquals(true, services.addTask(a));
		assertEquals(true, services.addTask(b));
		assertEquals(true, services.addTask(c));
		assertEquals(true, services.update("00004", "Take out trash", "Do not include recyclibles"));
		assertEquals(true, services.update("00006", "Wash Clothes", "Seperate colors from whites, bleach whites"));}	
Making sure all bases are covered when it comes to testing can help ensure you’re being efficient by not having to go back
to the drawing board because some factor was missed. There is a balance to be struck between searching to find every single
outcome and testing your code adequately and efficiently. Throughout Project 1 and developing these three features there have
been a few techniques I have employed and some that I have not. In all the features I was using specification-based techniques
to ensure that the software was doing what it was supposed to be doing. By modeling the test cases to mimic either true or 
false input I was able to tell through the JUnit testing if the software was accomplishing what it was meant to. Working to
meet specifications I also had to employ other techniques within the specification-based ones such as boundary value analysis
and decision table testing techniques. The boundary value analysis was done through the testing of “null” and “too long” 
expected inputs in the object parameters from the three features. Making sure that we were only able to input parameters for
objects within those ranges and testing to make sure those specifications were being accomplished. Decision table testing 
techniques I had tried to utilize to cover all expected inputs that may have been able to be done. Though this was more of a
technique for me to use before the development of the testing occurred. Equivalence partitioning techniques are extremely 
useful when testing large groups of information. Its utilization in other projects comes in when someone wishes to limit the
number of test cases needed to test the software in question. With the ability to partition the input and output of the software
testing you can cover a wider range of testing with fewer cases. For boundary value analysis techniques, the value is in 
partnering with equivalence portioning techniques to make sure all the bases are covered. Testing the outliers in your test 
model inputs and outputs helps make sure that a comprehensive testing of the software is being done. As for Decision table 
testing techniques, the practical use for these is keeping control of your logic within your software. Taking a look at all 
the conditions in one place can help make sense of how the work together or against one another. Contradictions are going to 
happen but if the logic doesn’t make sense when you go to test you want to make sure your tests catch these errors. 
A few of the testing techniques I did not really utilize as much as I probably should fell in the structure-based techniques. 
The basic fundamentals of the data structures I utilized I understood for the most part. However, looking at these structures 
and being able to develop tests for the structure specifically was quite difficult. The creation and utilization of flow charts
or control flow graphs I feel would have helped me be able to visualize the testing and test development better. It would have 
helped me structure the code a bit better and helped me understand what I was missing in the tests. The practical uses for flow
charts and control flow graphs are in their ability to make the development and testing process visual in other ways than simply 
the code itself. Being able to see a physical representation of the testing process and test cases is very valuable to the 
evolution of the whole process. The flow chart allows you to see the overall structure of the program being developed as well
as test cases. Then the control flow graphs dive more in depth with the code itself showing decision points and how they connect
to other decision points within the program. Having the ability to view the code in this way provides another way to fully 
understand and better develop a testing process. To conclude, if we focus on review of the developer for Project 1 I can say 
that I was not always keeping a positive or optimistic mindset. Nor did I in the role of a tester. I found testing my own work 
quite challenging. I found I utilized caution just enough as to not be at a complete standstill in development of tests, but it 
is very important to recognize how your developed code works with itself. This will allow you to make sure you cover all bases
when developing tests. However, you also want to make sure that you’re not doing double the work. I believe that for a few of 
the features in Project 1 I was testing the object in the same test suite as the service. As far as bias as a tester of my own 
work went, it was non-existent. I didn’t really think about this at the time. My lack of experience in coding in general leads 
me to think everything about my code is wrong rather than the opposite. This standpoint completely eliminates bias for the work 
process. I do feel this will be something that experienced programmers would need to be aware of and make a conscious effort not 
to let it hinder them in testing their own work. “Pride comes before the fall” as they say. Someone that thought that their math 
skills were above reproach might not think to test that particular logic within their own code for an example. A final note to 
touch upon is the importance of discipline and a dedication to quality in engineering software. I feel that time constraints 
can really plague a developer or tester. Being mindful of your timeline and the conciseness of your work is paramount to success. 
Throughout the development of these features up to Project 1 I have felt that time management was an issue. That lead to finishing
code and tests left to the last minute. This didn’t necessarily hinder functionality of the code or tests, but it was a detriment
to the cleanliness of the Project. Going forward, in order to avoid this technical debt, I plan to utilize my time more wisely and
always be conscious of making sure that I review code before and after testing. I need to make sure that the code is clean, 
annotated, and easy to understand before proceeding to the test development stage. This will ensure the entire process from A-Z
is running at top level performance and quality. 
