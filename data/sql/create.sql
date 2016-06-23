CREATE TABLE USERS (
	id int constraint users_pk primary key,
	username varchar(60) constraint un_users_username unique,
	password varchar(255) not null,
	role varchar(15) not null,
	email varchar(150) not null
);

CREATE TABLE CATEGORIES (
	id int constraint categories_pk primary key,
	libelle varchar(60) not null
);

CREATE TABLE POSTS (
	id int constraint posts_pk primary key,
	title varchar(80) not null,
	post_date date not null default current_date,
	content blob sub_type 1,
	user_id int constraint fk_post_user references users,
	category_id int constraint fk_post_categoriy references categories
);

CREATE TABLE TAGS (
	id int constraint pk_tags primary key,
	libelle varchar(60) not null
);

CREATE TABLE TAGS_POSTS (
	post_id int constraint fk_tagsposts_post references posts,
	tags_id int constraint fk_tagsposts_tag references tags,
	constraint pk_tagsposts primary key(post_id, tags_id)
);

CREATE TABLE COMMENTAIRES (
	id int constraint pk_commentaires primary key,
	com_date date not null default current_date,
	content blob sub_type 1 not null,
	user_id int constraint fk_commentaire_user references users,
	post_id int constraint fk_commentaire_post references posts
);