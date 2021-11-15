use glassesstore;

insert into role(code,name) values('ADMIN','Quản trị');
insert into role(code,name) values('USER','Người dùng');

insert into user(username,password,fullname,status,roleid)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','tôn huế',1,1);

insert into slider(caption,content,image) values('Best Offer','New Arrivals On Sale','image5.png');
insert into slider(caption,content,image) values('Flash Deals','Get your best products','image11.png');

insert into category(name,code) values('Mắt Kính Nam','mat-kinh-nam');
insert into category(name,code) values('Mắt Kính Nữ','mat-kinh-nu');
insert into category(name,code) values('Mắt Kính Trẻ Em','mat-kinh-tre-em');

insert into product(detail,hotproduct,name,newproduct,price,sale,shortdescription,category_id,image) 
values('Mắt kính nam nữ thời trang',1,'Mắt kính nam nữ thời trang',1,99000,0,'Mắt kính nam nữ thời trang',1,"image1.png");

insert into product(detail,hotproduct,name,newproduct,price,sale,shortdescription,category_id,image) 
values('Mắt kính nam nữ thời trang',0,'Mắt kính nam nữ thời trang',0,100000,20,'Mắt kính nam nữ thời trang',1,"image2.png");

insert into product(detail,hotproduct,name,newproduct,price,sale,shortdescription,category_id,image) 
values('Mắt kính nam nữ thời trang',0,'Mắt kính nam nữ thời trang',1,150000,0,'Mắt kính nam nữ thời trang',2,"image3.png");

insert into product(detail,hotproduct,name,newproduct,price,sale,shortdescription,category_id,image) 
values('Mắt kính nam nữ thời trang',1,'Mắt kính nam nữ thời trang',0,220000,2,'Mắt kính nam nữ thời trang',3,"image4.png");


insert into product(detail,hotproduct,name,newproduct,price,sale,shortdescription,category_id,image) 
values('Mắt kính nam nữ thời trang',1,'Mắt kính nam nữ thời trang',1,330000,10,'Mắt kính nam nữ thời trang',1,"image5.png");

insert into product(detail,hotproduct,name,newproduct,price,sale,shortdescription,category_id,image) 
values('Mắt kính nam nữ thời trang',1,'Mắt kính nam nữ thời trang',1,100000,0,'Mắt kính nam nữ thời trang',3,"image6.png");

insert into product(detail,hotproduct,name,newproduct,price,sale,shortdescription,category_id,image) 
values('Mắt kính nam nữ thời trang',0,'Mắt kính nam nữ thời trang',1,99000,0,'Mắt kính nam nữ thời trang',1,"image7.png");

insert into product(detail,hotproduct,name,newproduct,price,sale,shortdescription,category_id,image) 
values('Mắt kính nam nữ thời trang',0,'Mắt kính nam nữ thời trang',0,150000,0,'Mắt kính nam nữ thời trang',2,"image8.png");

insert into product(detail,hotproduct,name,newproduct,price,sale,shortdescription,category_id,image) 
values('Mắt kính nam nữ thời trang',1,'Mắt kính nam nữ thời trang',1,220000,2,'Mắt kính nam nữ thời trang',2,"image9.png");


insert into product(detail,hotproduct,name,newproduct,price,sale,shortdescription,category_id,image) 
values('Mắt kính nam nữ thời trang',1,'Mắt kính nam nữ thời trang',1,330000,10,'Mắt kính nam nữ thời trang',1,"image10.png");











