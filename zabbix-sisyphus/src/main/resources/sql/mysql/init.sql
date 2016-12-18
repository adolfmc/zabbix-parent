INSERT INTO jobs.uc_t_department (id,create_user_id,create_date,edit_user_id,edit_date,version,dep_code,dep_sum,en_name,full_path,memo,`name`,parent_dep_id) VALUES 
(1,NULL,NULL,NULL,NULL,1,NULL,NULL,'admin',NULL,NULL,'admin',1)
;

INSERT INTO jobs.uc_t_staff (id,create_user_id,create_date,edit_user_id,edit_date,version,area_tel,card_id,e_mail,gender,memo,mobile,`name`,staff_code,tel,department_id) VALUES 
(1,1,STR_TO_DATE('1970-01-01 09:00:00','%Y-%m-%d %H:%i:%s'),1,STR_TO_DATE('1970-01-01 09:00:00','%Y-%m-%d %H:%i:%s'),1,'',NULL,NULL,'',NULL,'15021008000','admin',NULL,'',1)
;

INSERT INTO jobs.uc_t_role (id,create_user_id,create_date,edit_user_id,edit_date,version,memo,`name`) VALUES 
(1,NULL,NULL,NULL,NULL,1,NULL,'admin')
;

INSERT INTO jobs.uc_t_function (id,create_user_id,create_date,edit_user_id,edit_date,version,full_path,function_code,function_sum,memo,`name`,ord,system_id,`type`,url,parent_function_id) VALUES 
(4,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'sisyphus',1,'sisyphus',NULL,NULL,4)
,(8,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'客户管理',2,'sisyphus',NULL,NULL,4)
,(9,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'风控管理',4,'sisyphus',NULL,NULL,4)
,(10,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'借款管理',3,'sisyphus',NULL,NULL,4)
,(11,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'账单管理',6,'sisyphus',NULL,NULL,4)
,(12,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'财务管理',5,'sisyphus',NULL,NULL,4)
,(13,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'客户信息',7,'sisyphus',NULL,NULL,8)
,(14,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'还款列表',13,'sisyphus',NULL,NULL,12)
,(15,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'账单列表',12,'sisyphus',NULL,NULL,11)
,(16,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'放款列表',11,'sisyphus',NULL,NULL,12)
;
INSERT INTO jobs.uc_t_function (id,create_user_id,create_date,edit_user_id,edit_date,version,full_path,function_code,function_sum,memo,`name`,ord,system_id,`type`,url,parent_function_id) VALUES 
(17,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'信审列表',10,'sisyphus',NULL,NULL,9)
,(18,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'借款列表',9,'sisyphus',NULL,NULL,10)
,(19,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'客户列表',8,'sisyphus',NULL,NULL,8)
;

INSERT INTO jobs.uc_t_role_fun (id,create_user_id,create_date,edit_user_id,edit_date,version,memo,function_id,role_id) VALUES 
(1,NULL,NULL,NULL,NULL,1,NULL,4,1)
,(2,NULL,NULL,NULL,NULL,1,NULL,8,1)
,(3,NULL,NULL,NULL,NULL,1,NULL,9,1)
,(4,NULL,NULL,NULL,NULL,1,NULL,10,1)
,(5,NULL,NULL,NULL,NULL,1,NULL,11,1)
,(6,NULL,NULL,NULL,NULL,1,NULL,12,1)
,(7,NULL,NULL,NULL,NULL,1,NULL,13,1)
,(8,NULL,NULL,NULL,NULL,1,NULL,14,1)
,(9,NULL,NULL,NULL,NULL,1,NULL,15,1)
,(10,NULL,NULL,NULL,NULL,1,NULL,16,1)
;
INSERT INTO jobs.uc_t_role_fun (id,create_user_id,create_date,edit_user_id,edit_date,version,memo,function_id,role_id) VALUES 
(11,NULL,NULL,NULL,NULL,1,NULL,17,1)
,(12,NULL,NULL,NULL,NULL,1,NULL,18,1)
,(13,NULL,NULL,NULL,NULL,1,NULL,19,1)
;

INSERT INTO jobs.uc_t_staff_role (id,create_user_id,create_date,edit_user_id,edit_date,version,memo,role_id,staff_id) VALUES 
(1,NULL,NULL,NULL,NULL,NULL,NULL,1,1)
;