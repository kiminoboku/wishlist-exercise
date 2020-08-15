# wishlist-exercise
The purpose of this project is to get familiar with some good work practices & exercise proper project design using some example application project.

## App purpose
The application we are trying to develop is a simple REST enabled service that will allow us to manage a **wishlist** attached to a specific user account. The full features list is yet to be discovered but the MVP (Minimal Viable Product) allows the user to:
* Create & Manage his own account in the service,
* Create & Manage his wishlists,
* Create & Manage items within specific wishlist.

## Ground rules
* We use `SpringBoot` for development,
* We work on `java 11`,
* We use `maven` for build management,
* Every feature should be tested `End2End`

## DoD (Definition of Done)
This section describes when a Feature within an app is in `done` state:
* A feature is covered by `End2End` tests,
* A feature is covered by Unit Tests,
* All tests are green.

## Branching model
Since we are using github as our VCS, we will be using git-flow as our default branching model.