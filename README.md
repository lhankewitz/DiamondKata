This is the implementation of the Diamond Kata inspired by http://claysnow.co.uk/recycling-tests-in-tdd.

I first started with the gorilla version (write tests which stay the same most of the time).

Then I started over again with the moose version and evolving tests.

Observation:
The tests stayed the same, but the code had been refactored to the solution (not really TDD)

The moose version kept the code much simpler and the evolving tests drove the code (TDD).

So in the moose version one has also many tests, but not at the same time. Frequent checkin on green bar
is crucial when using this version to not loose the tests.
