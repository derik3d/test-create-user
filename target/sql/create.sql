create table phone (id bigint not null, city_code integer, country_code integer, number integer, user_id varchar(255) not null, primary key (id));
create table user (useruuid varchar(255) not null, created timestamp, email varchar(255), is_active boolean, last_log_in timestamp, modified timestamp, name varchar(255), password varchar(255), token varchar(255), primary key (useruuid));
alter table user drop constraint if exists UK_ob8kqyqqgmefl0aco34akdtpe;
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
create sequence hibernate_sequence start with 1 increment by 1;
alter table phone add constraint FKb0niws2cd0doybhib6srpb5hh foreign key (user_id) references user;
