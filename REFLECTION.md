Final Questions Answers
1. How did you achieve functional cohesion? Which routines did you extract?
   I achieved functional cohesion which means each routine is performing a specific task only by isolating each individual task. The routines i extracted include orderSum, discountRate, sendEmail, statusMessage, dispatchNotification, processCustomer.

2. What parameter passing issues did you encounter (e.g., d modified but not returned)?
   The legacy code failed silently because Java uses strict pass-by-value semantics, meaning modifying the primitive parameter d only changed a local copy on the stack while leaving the caller's original variable untouched. 

3. How would the d update behave differently if the language used pass-by-value-result?
   In pass-by-value-result, a method works with local copies of parameters, but any changes made to those copies are copied back to the original variables when the method finishes.Therefore, assigning d = total inside the method would update the caller's original d variable with the computed total value upon exit.

Quick Quiz Answers
1. C (Procedural)
2. B (Java passes the reference to the array by value)
3. Pass by value-result
4. B (False)
5. Functional Cohesion

Exercise 2 (Naming Mistakes)
1. matrixMul()
2. writeReportToFile()
3. validateDetails()
4. medianOfSales()
5. welcomeMessage()    
