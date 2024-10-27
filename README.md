
## Editor           : IntelliJ IDEA
## API Testing Tool : Postman
## Database         : H2 in-memory 
## Language         : Java

:point_right: **Spring Boot DDD(Doman Driven Design) Architecture:**

	1. Presentation Layer: (RestController)
		- The presentation layer handles the HTTP requests, 
		translates the JSON parameter to object, and authenticates
		the request and transfer it to the business layer.
		
	2. Buisness Layer: (Service)
		- The buisness layer handles all the buisness logic.
		It consists of service classes and uses services provided by 
		data access layers. It also performs authorization and 
		validation.
	
	3. Persistence Layer: (Repository)
		- The persistancee layer contains all the storage logic
		and translates business objects from and to database rows.
		
	4. Database Layer:
		- In the database layer, CRUD operations are performed.
		
 :point_right: **To Run Project:**
<br/>
  - git clone https://github.com/Shad-Alam/Product-Management.git <br/> 
  - cd Product-Management <br/>
  - Now open "ProductManagement" this folder with IntelliJ IDEA
  - Click Run Button
  
:point_right: **Testing path using Postman :**
<br/> 
  1. GET :: Get-All-Products <br/> <br/>
	http://localhost:8080/GET/products
	
  2. POST :: Add-New-Product <br/> <br/>
	http://localhost:8080/POST/products
	
	Body raw(json)
	{
		"name": "Nokia",
		"description": "Demo description",
		"price": 1250,
		"stockQuantity": 5,
		"category": "Mobile"
	}
  
  3. GET :: Get-Product-By-Id
	http://localhost:8080/GET/products/1

  4. PUT Update-Product-By-Id
	http://localhost:8080/PUT/products/1
  
	Body raw(json)
	{
		"name": "Macbook",
		"description": "Update description",
		"price": 1150,
		"stockQuantity": 32,
		"category": "Laptop"
	}
	
  5. DELETE Delete-Product-By-Id
	http://localhost:8080/DELETE/products/1

  6. PATCH Update-Sock-Quantity
	http://localhost:8080/PATCH/products/1/update-stock
	
	Body raw(json)
	{
		"stockQuantity": 32
	}
	
  7. GET Search-By-Categroy
	http://localhost:8080/CATEGORY/products/Mobile
  
  8. GET discounts-on-products
	http://localhost:8080/DISCOUNT/products/Mobile/discountAmount/30
  
  9. GET Pagination-Sorting
     http://localhost:8080/PAGINATIONSORTING/products/pageNumber/0/pageSize/2/sortBy/category/sortOrder/DESC

  
