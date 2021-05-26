--管理员表
drop table dsms_admins;
create table dsms_admins
(id number(18) primary key,         --管理员id
 username varchar2(20) not null, --管理员用户名
 password varchar2(10) default '123456',      --管理员密码
 flag varchar2(10) default 'admin');
 
 --教练表
drop table dsms_trainers;
create table dsms_trainers
(id number(18) primary key,             --教练id
 trainer_no varchar2(10) not null,       --教练账号
 password varchar2(10) default '123456',          --教练密码
 name varchar2(20),                 --教练姓名
 gender char(1) check(gender in ('M','F')),   --教练性别
 age number(2),                   --教练年龄
 driving_years number(2),           --教练驾龄
 phone number(11),               --教练电话
 id_number varchar2(18),         --教练身份证号
 license_type varchar2(10),           --驾照类型
 license_no varchar2(18),     --驾照编号
 car_id number(18),               --所负责车辆id
 salary number(10),               --薪水 
 join_date date default sysdate,    --入职时间
 flag varchar2(10) default 'trainer',   
 comments varchar2(100));
 
--学员表
drop table dsms_trainees;
create table dsms_trainees
(id number(18) primary key,               --学员id
 trainee_no varchar2(10) not null,         --学员账号
 password varchar2(10) default '123456',            --学员密码
 name varchar2(20),                   --学员姓名
 gender char(1) check(gender in ('M','F')),     --学员性别
 age number(2),                     --学员年龄
 height number(3),                    --学员身高
 phone number(11),                    --学员电话
 address varchar2(100),                  --学员地址
 id_number varchar2(18),           --学员身份证号
 enter_date date  default sysdate,      --报名时间
 application_type varchar2(10),      --申请类型
 status varchar2(20),                 --学员状态 first、add、finish、exam1_ordered、exam1_pass、exam2_ordered、exam2_pass、exam3_ordered、exam3_pass、exam4_ordered
 trainer_id number(18)  ,   --教练id
 flag varchar2(10) default 'trainee',   
 comments varchar2(100));
 
--车辆表
drop table dsms_cars;
create table dsms_cars
(id number(18) primary key,
 trainer_id number(18)  ,   --教练id
 car_no varchar2(11),  --车牌号
 car_brand varchar2(30),    --车辆品牌
 car_type varchar2(10),     --车类型
 price number(10),        --价格
 engine_no varchar2(6),   --发动机编号
 status varchar2(20) default 'unuse',     --车辆状态 unuse，using，scraped
 buy_date date default sysdate, --购入时间
 comments varchar2(100));
 
--考试计划表 
drop table dsms_exam_plans;
create table dsms_exam_plans
(id number(18) primary key,
 plan_no varchar2(10),  --考试编号
 place varchar2(30),        --考试场地
 address varchar2(100),      --考试场地详细地址 
 exam_time date default sysdate,            --考试日期
 exam_type varchar2(10),    --考试科目
 car_type varchar2(30),     --考试车型
 people number(10),         --考试预约计划人数
 status varchar2(20) default 'new',       --状态 start,end,new
 comments varchar2(100));
 
--考试预约表
drop table dsms_exam_orders;
create table dsms_exam_orders
(id number(18) primary key,
 exam_plan_id number(18),   --考试计划id
 trainee_id number(18),     --学员id
 order_time date default sysdate,       --预约时间
 status varchar2(20));
 
--考试成绩表
drop table dsms_exam_results;
create table dsms_exam_results
(id number(18) primary key,           
 trainee_id number(18),   --学员id
 exam_plan_id number(18),   --考试计划id
 exam_score number(3),     --考试成绩
 status varchar2(20));

--财务表
drop table dsms_finances;
create table dsms_finances
(id number(18) primary key,
 item_id number(18),
 item_type varchar2(30),    --收费项目
 item_fee number(10),       --交费金额
 fee_date date default sysdate,    --交费时间
 flag varchar2(10),         --类别：学员、车辆、其它
 comments varchar2(100));
 
--日志表
drop table dsms_logs;
create table dsms_logs(
  id number(18) primary key,
  item_id number(18),
  log_event varchar(100),
  log_date date default sysdate,
  flag varchar2(10));

drop sequence dsms_admins_s;
create sequence dsms_admins_s start with 10001;

drop sequence dsms_trainers_s;
create sequence dsms_trainers_s start with 20001;

drop sequence dsms_trainees_s;
create sequence dsms_trainees_s start with 30001;

drop sequence dsms_cars_s;
create sequence dsms_cars_s start with 40001;

drop sequence dsms_exam_plans_s;
create sequence dsms_exam_plans_s start with 50001;

drop sequence dsms_exam_orders_s;
create sequence dsms_exam_orders_s start with 60001;

drop sequence dsms_exam_results_s;
create sequence dsms_exam_results_s start with 70001;

drop sequence dsms_finances_s;
create sequence dsms_finances_s start with 80001;

drop sequence dsms_logs_s;
create sequence dsms_logs_s start with 90001;