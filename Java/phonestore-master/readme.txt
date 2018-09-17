Execute the following POST requests by using the following data in body. Use Postman tool.

POST: localhost:5005/rest/category/save

{
"id":1,
"name":"Phones"
}

POST: localhost:5005/rest/manufacturer
{
"id":1,
"name":"Apple"
}

POST:localhost:5005/rest/device/import
[{
	"id": 1,
	"name": "iPhone X",
	"photoUrl": "images/phones/apple/iphone-x-2.png",
	"promoted": true,
	"price": 32233,
	"description": "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
	"category": {
		"id": 1
	},
	"manufacturer": {
		"id": 1
	}

}]