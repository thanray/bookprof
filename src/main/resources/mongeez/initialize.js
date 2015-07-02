//mongeez formatted javascript
//changeset system:v1_3

db.address.drop();
db.store.drop();

var adrRommen = db.address.insert({
                "_id": new ObjectId(),
                'street': 'Rommen veien',
                'postCode': 2020,
                'postCity': 'strømmen'
 })

var adr = db.address.find()[0];

 db.store.insert({
          "_id": 1,
          "name" : "Rommen skole",
          "desc" : "På rommen skole kan man låne bøker",
          "address" :  adr,
          "createdBy" : 1,
          "createdBy" : "2014-12-19T06:01:17"
          });

