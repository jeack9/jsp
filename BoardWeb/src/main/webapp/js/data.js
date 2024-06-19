/**
 * data.js
 */
const myMembers = [
    {ID: "user01", NAME: "홍길동", PHONE: "010", POINT: "90"},
    {ID: "user02", NAME: "이춘향", PHONE: "222", POINT: "40"},
    {ID: "user03", NAME: "이석훈", PHONE: "333", POINT: "100"}
];

const json = `[{"id":1,"first_name":"Steward","last_name":"Padgham","email":"spadgham0@bloglovin.com","gender":"Male","salary":6011},
{"id":2,"first_name":"Shayne","last_name":"Lammerts","email":"slammerts1@samsung.com","gender":"Female","salary":5821},
{"id":3,"first_name":"Helyn","last_name":"Kehoe","email":"hkehoe2@merriam-webster.com","gender":"Female","salary":4984},
{"id":4,"first_name":"Cathlene","last_name":"Rickman","email":"crickman3@utexas.edu","gender":"Female","salary":5263},
{"id":5,"first_name":"Penelope","last_name":"Rait","email":"prait4@sitemeter.com","gender":"Female","salary":4974},
{"id":6,"first_name":"Alyson","last_name":"Gabotti","email":"agabotti5@e-recht24.de","gender":"Female","salary":5305},
{"id":7,"first_name":"Lanny","last_name":"Wenderott","email":"lwenderott6@army.mil","gender":"Female","salary":5362},
{"id":8,"first_name":"Ofilia","last_name":"Scamal","email":"oscamal7@cocolog-nifty.com","gender":"Female","salary":3399},
{"id":9,"first_name":"Coralie","last_name":"Buston","email":"cbuston8@xinhuanet.com","gender":"Female","salary":5334},
{"id":10,"first_name":"Farris","last_name":"Richichi","email":"frichichi9@soundcloud.com","gender":"Male","salary":5947},
{"id":11,"first_name":"Sidney","last_name":"Uttridge","email":"suttridgea@mapquest.com","gender":"Male","salary":3227},
{"id":12,"first_name":"Kerianne","last_name":"Prendergrast","email":"kprendergrastb@fotki.com","gender":"Female","salary":5592},
{"id":13,"first_name":"Christabella","last_name":"Pentercost","email":"cpentercostc@paypal.com","gender":"Female","salary":7884},
{"id":14,"first_name":"Hetti","last_name":"Bampton","email":"hbamptond@360.cn","gender":"Female","salary":4682},
{"id":15,"first_name":"Joan","last_name":"Crowhurst","email":"jcrowhurste@timesonline.co.uk","gender":"Female","salary":6147}]`;

const EMPLOYEES = JSON.parse(json);
