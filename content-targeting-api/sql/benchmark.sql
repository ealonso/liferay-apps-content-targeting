drop database if exists liferay_62x;

create database liferay_62x character set utf8;

use liferay_62x;

source ../output/create-mysql.sql
source ../output/sample-mysql.sql
source ../output/plugin/tables-mysql.sql
source ../output/plugin/indexes-mysql.sql
source ../output/plugin/sample-mysql.sql