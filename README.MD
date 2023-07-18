# Task:

There is a certain system that processes airline flights. A flight is a passenger's transportation from one point to another with possible intermediate stops. Therefore, a flight can be represented as a set of one or more elementary movements called segments. A segment is an atomic transport, which, for simplicity, will be characterized by just two attributes: departure date/time and arrival date/time.

You are required to develop a small module that will be responsible for filtering a set of flights based on various rules. There can be a large number of filtering rules, and the sets of flights can be extremely large. The rules for filtering may be dynamically selected and defined depending on the context of the filtering operation.

Design the structure of the module, create the necessary classes and interfaces. If you are familiar with JUnit, please test your code with unit tests. Do not consider a user interface; it is sufficient to output information to the console. Avoid the use of any external libraries.

The attached file "TestClasses.java" contains simplified model classes and a factory for obtaining test samples. All the code should be placed in the package "com.gridnine.testing."

For a validation run, create a public class called "Main" with the main() method. This method should output the results of processing the test set of flights to the console. To obtain the test set, use the method FlightBuilder.createFlights().

Place the following validation code inside the main() method. Exclude flights from the test set according to the following rules (each rule should have a separate output of the flight list):

Departures before the current time.

Flights with segments where the arrival date is earlier than the departure date.

Total time spent on the ground exceeds two hours (ground time is the interval between the arrival of one segment and the departure of the next segment).