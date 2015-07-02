//mongeez formatted javascript
//changeset system:v1_4

db.address.insert({
	"_id" : ObjectId("5595b8732eb6764da7f4911f"),
	"street" : "Rommen veien",
	"postCode" : 2020,
	"postCity" : "strømmen"
});

var adr = db.address.find()[0];

db.store.insert({
        "_id": new Object(),
        "name" : "Rommen skole",
        "desc" : "På rommen skole kan man låne bøker",
        "address" :  adr,
        "createdBy" : 1,
        "createdBy" : "2014-12-19T06:01:17"
        });

