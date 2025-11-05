# Spring CRUD
## Task 1: Retrieve a resource using PathVariable
### Requirements:
* Create a `GET` endpoint according to REST conventions.
* Use `@PathVariable` to retrieve an object based on its id.
* Return a response model (DTO).
* Return `404` if the object is not found.
## Task 2: Filter resources using RequestParam
### Requirements:
* Create a `GET` endpoint that returns a list of objects.
* Use `@RequestParam` to filter on one or more fields.
* Parameters should be optional.
* Return a list of DTO objects.
## Task 3: Create a resource
### Requirements:
* Create a `POST` endpoint according to REST conventions.
* Accept a DTO object as the request body.
* Return the created object with status code `201`.
## Task 4: Update a resource
### Requirements:
* Create a `PUT` endpoint according to REST conventions.
* Use `@PathVariable` to specify the id.
* Receive a DTO object with new values.
* Return updated response model.
* Handle cases where id does not exist (`404`).
## Task 5: Delete a resource
### Requirements:
* Create a `DELETE` endpoint according to REST conventions.
* Use `@PathVariable` to identify the object.
* Return `204` on successful deletion.
* Return `404` if the object is not found.
## Task 6: Search with multiple RequestParam
### Requirements:
* Create a `GET` endpoint that allows searching based on multiple filters via `@RequestParam`.
* Parameters can be combined (e.g. name, date range, status).
* Handle missing parameters by returning all results.
* Return a list of DTO objects that match the search criteria.
## Task 7: Combining PathVariable and RequestParam
### Requirements:
* Create a `GET` endpoint where `@PathVariable` specifies a category and `@RequestParam` filters results within the category.
* Return a list of DTO objects.
* Return `400` for invalid parameters.
## Task 8: Custom ResponseEntity handling
### Requirements:
* Use `ResponseEntity` in all controller methods.
* Set the correct HTTP status code for each type of operation.
* Include any headers (e.g. `Location` when creating).
* Return DTO objects in the body.
## Task 9: Response model with metadata
### Requirements:
* Create a response model that contains `data`, `timestamp`, and `requestId`.
* All endpoints should return this structure.
* The `timestamp` is automatically set for each response.
* `requestId` is generated uniquely per call.