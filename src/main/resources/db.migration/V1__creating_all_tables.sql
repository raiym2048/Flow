
     create table answer (id bigserial not null, answer_question varchar(255), answer_text varchar(255), primary key (id))
    ; create table answerfaq (id bigserial not null, answer varchar(255), question varchar(255), primary key (id))
    ; create table blog (customer_blog_id bigint unique, date_time timestamp(6), id bigserial not null, image varchar(255), title varchar(255), primary key (id))
    ; create table customer_blog (id bigserial not null, image varchar(255), name varchar(255), primary key (id))
    ; create table customers (id bigserial not null, image varchar(255), name varchar(255), position varchar(255), title varchar(255), primary key (id))
    ; create table experts (id bigserial not null, name varchar(255), photo varchar(255), position varchar(255), primary key (id))
    ; create table faq (id bigserial not null, header varchar(255), primary key (id))
    ; create table faq_answerfaqs (answerfaqs_id bigint not null unique, faq_id bigint not null)
    ; create table meet_experts (id bigserial not null, header varchar(255), header2 varchar(255), primary key (id))
    ; create table meet_experts_experts (experts_id bigint not null unique, meet_experts_id bigint not null)
    ; create table page2 (id bigserial not null, footer varchar(255), header varchar(255), image varchar(255), primary key (id))
    ; create table page2_bodies (page2_id bigint not null, bodies varchar(255))
    ; create table page3 (id bigserial not null, body varchar(255), header1 varchar(255), header2 varchar(255), primary key (id))
    ; create table page4 (id bigserial not null, body varchar(255), primary key (id))
    ; create table page6 (id bigserial not null, comment_text varchar(255), header varchar(255), primary key (id))
    ; create table page6_customers (customers_id bigint not null unique, page6_id bigint not null)
    ; create table page7 (id bigserial not null, body varchar(255), primary key (id))
    ; create table page8 (id bigserial not null, builder varchar(255), primary key (id))
    ; create table page8_answer (answer_id bigint not null unique, page8_id bigint not null)
    ; create table page9 (id bigserial not null, header1 varchar(255), header2 varchar(255), primary key (id))
    ; create table page9_blogs (blogs_id bigint not null unique, page9_id bigint not null)
    ; create table start_page (id bigserial not null, body1 varchar(255), body2 varchar(255), footer1 varchar(255), footer2 varchar(255), header1 varchar(255), header2 varchar(255), image1 varchar(255), image2 varchar(255), image3 varchar(255), image4 varchar(255), primary key (id))
    ; create table users (id bigserial not null, email varchar(255), password varchar(255), role varchar(255) check (role in ('ADMIN','USER')), primary key (id))
    ; alter table if exists blog add constraint FKfgo2d5ujia23wgk00ahgsvo6r foreign key (customer_blog_id) references customer_blog
    ; alter table if exists faq_answerfaqs add constraint FK7obvew8vnlk0n2k7xlwb597ak foreign key (answerfaqs_id) references answerfaq
    ; alter table if exists faq_answerfaqs add constraint FKqiy9s4097qxgbh6icwbq1ocqp foreign key (faq_id) references faq
    ; alter table if exists meet_experts_experts add constraint FKgwjdclecwtlfdw21gxsy35ok5 foreign key (experts_id) references experts
    ; alter table if exists meet_experts_experts add constraint FKr3l7ogbc5yeg9ov97rib86bh3 foreign key (meet_experts_id) references meet_experts
    ; alter table if exists page2_bodies add constraint FKjivmcx5l8xoql69np7n0oj529 foreign key (page2_id) references page2
    ; alter table if exists page6_customers add constraint FK6b4m2yrpwigvyv4lqicei5qre foreign key (customers_id) references customers
    ; alter table if exists page6_customers add constraint FKsiqpbjpbfx8t4fdhwjgx34910 foreign key (page6_id) references page6
    ; alter table if exists page8_answer add constraint FK1iums3kobx4so1yn581rca568 foreign key (answer_id) references answer
    ; alter table if exists page8_answer add constraint FKkqfnodtfgma2kfsf7hlnih8jg foreign key (page8_id) references page8
    ; alter table if exists page9_blogs add constraint FKidc45hlfxh99w1wtw1aelh3xg foreign key (blogs_id) references blog
    ; alter table if exists page9_blogs add constraint FK4j86fgauofpnybnplhnkfcjdb foreign key (page9_id) references page9;