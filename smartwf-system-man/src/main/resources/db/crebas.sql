/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/12/2 14:56:20                           */
/*==============================================================*/


drop table if exists sys_config;

drop table if exists sys_dict_data;

drop table if exists sys_log;

drop table if exists sys_organization;

drop table if exists sys_permission;

drop table if exists sys_post;

drop table if exists sys_resouce;

drop table if exists sys_role;

drop table if exists sys_role_permission;

drop table if exists sys_tenant;

drop table if exists sys_user_action;

drop table if exists sys_user_info;

drop table if exists sys_user_organization;

drop table if exists sys_user_post;

drop table if exists sys_user_role;

drop table if exists um_permission;

drop table if exists um_role;

drop table if exists um_role_permission;

drop table if exists um_user;

drop table if exists um_user_role;

/*==============================================================*/
/* Table: sys_config                                            */
/*==============================================================*/
create table sys_config
(
   id                   int not null auto_increment comment '����',
   config_code          varchar(32) comment '����',
   config_name          varchar(100) comment '����',
   config_key           varchar(100) comment '������',
   config_value         varchar(1000) comment '����ֵ',
   is_sys               tinyint comment 'ϵͳ����
            0�� 1��',
   sort                 int comment '����',
   remark               varchar(500) comment '��ע',
   tenant_id            int comment '�⻧id',
   enable               tinyint comment '�Ƿ���Ч
            0��Ч  
            1��Ч
            ',
   create_time          datetime comment '����ʱ��',
   create_user_id       int comment '������id',
   create_user_name     varchar(25) comment '����������',
   update_time          datetime comment '�޸�ʱ��',
   update_user_id       int comment '�޸���id',
   update_user_name     varchar(25) comment '�޸�������',
   primary key (id)
);

alter table sys_config comment 'ϵͳ���ñ�';

/*==============================================================*/
/* Table: sys_dict_data                                         */
/*==============================================================*/
create table sys_dict_data
(
   id                   int not null auto_increment comment '����',
   pid                  int comment '����id',
   sort                 int comment '����',
   level                int comment '��μ���',
   dict_code            varchar(32) comment '����',
   dict_name            varchar(100) comment '����',
   dict_type            tinyint comment '����',
   remark               varchar(500) comment '��ע',
   tenant_id            int comment '�⻧id',
   enable               tinyint comment '�Ƿ���Ч
            0��Ч  
            1��Ч
            ',
   create_time          datetime comment '����ʱ��',
   create_user_id       int comment '������id',
   create_user_name     varchar(25) comment '����������',
   update_time          datetime comment '�޸�ʱ��',
   update_user_id       int comment '�޸���id',
   update_user_name     varchar(25) comment '�޸�������',
   primary key (id)
);

alter table sys_dict_data comment '�ֵ����ݱ�';

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   id                   int not null auto_increment comment '����',
   log_url              varchar(50) comment '����',
   log_user             varchar(25) comment '�û�',
   log_content          varchar(250) comment '��������',
   log_json             varchar(500) comment '����',
   opration_time        datetime comment '����ʱ��',
   ip_address           varchar(50) comment 'IP��ַ',
   result               int comment '���',
   primary key (id)
);

alter table sys_log comment '������־';

/*==============================================================*/
/* Table: sys_organization                                      */
/*==============================================================*/
create table sys_organization
(
   id                   int not null auto_increment comment '����',
   pid                  int comment '����id',
   uid                  int comment '�ϼ�id',
   sort                 int comment '����',
   org_code             varchar(32) comment '��������',
   org_name             varchar(50) comment '��������',
   org_type             tinyint comment '��������',
   remark               varchar(500) comment '��ע',
   tenant_id            int comment '�⻧id',
   enable               tinyint comment '�Ƿ���Ч
            0��Ч  
            1��Ч
            ',
   level                int comment '��μ���',
   create_time          datetime comment '����ʱ��',
   create_user_id       int comment '������id',
   create_user_name     varchar(25) comment '����������',
   update_time          datetime comment '�޸�ʱ��',
   update_user_id       int comment '�޸���id',
   update_user_name     varchar(25) comment '�޸�������',
   primary key (id)
);

alter table sys_organization comment '��֯������';

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
create table sys_permission
(
   id                   int not null auto_increment comment '����',
   act_id               int comment '�����û���id',
   res_id               int comment '��Դ��id',
   tenant_id            int comment '�⻧id',
   primary key (id)
);

alter table sys_permission comment 'Ȩ�ޱ�';

/*==============================================================*/
/* Table: sys_post                                              */
/*==============================================================*/
create table sys_post
(
   id                   int not null auto_increment comment '����',
   organization_id      int comment '��֯������id',
   post_code            varchar(32) comment 'ְ�����',
   post_name            varchar(100) comment 'ְ������',
   post_type            tinyint comment 'ְ�����
            0�߹�
            1�в�
            2����
            ',
   enable               tinyint comment '�Ƿ���Ч
            0��Ч  
            1��Ч
            ',
   sort                 int comment '����',
   remark               varchar(500) comment '��ע',
   tenant_id            int comment '�⻧id',
   create_time          datetime comment '����ʱ��',
   create_user_id       int comment '������id',
   create_user_name     varchar(25) comment '����������',
   update_time          datetime comment '�޸�ʱ��',
   update_user_id       int comment '�޸���id',
   update_user_name     varchar(25) comment '�޸�������',
   primary key (id)
);

alter table sys_post comment 'ְ���';

/*==============================================================*/
/* Table: sys_resouce                                           */
/*==============================================================*/
create table sys_resouce
(
   id                   int not null auto_increment comment '����',
   pid                  int comment '����id',
   uid                  int comment '�ϼ�id',
   sort                 int comment '����',
   level                int comment '��μ���',
   res_code             varchar(32) comment '��Դ����',
   res_name             varchar(50) comment '��Դ����',
   res_type             tinyint comment '��Դ����',
   res_href             varchar(150) comment '��Դ����',
   permission           varchar(150) comment 'Ȩ�ر�ʶ',
   remark               varchar(500) comment '��ע',
   tenant_id            int comment '�⻧id',
   enable               tinyint comment '�Ƿ���Ч
            0��Ч  
            1��Ч
            ',
   create_time          datetime comment '����ʱ��',
   create_user_id       int comment '������id',
   create_user_name     varchar(25) comment '����������',
   update_time          datetime comment '�޸�ʱ��',
   update_user_id       int comment '�޸���id',
   update_user_name     varchar(25) comment '�޸�������',
   primary key (id)
);

alter table sys_resouce comment '��Դ��';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   int not null auto_increment comment '����',
   role_code            varchar(32) comment '��ɫ���',
   role_name            varchar(25) comment '��ɫ����',
   tenant_id            int comment '�⻧id',
   enable               tinyint comment '�Ƿ���Ч
            0��Ч  
            1��Ч
            ',
   sort                 int comment '����',
   remark               varchar(500) comment '��ע',
   create_time          datetime comment '����ʱ��',
   create_user_id       int comment '������id',
   create_user_name     varchar(25) comment '����������',
   update_time          datetime comment '�޸�ʱ��',
   update_user_id       int comment '�޸���id',
   update_user_name     varchar(25) comment '�޸�������',
   primary key (id)
);

alter table sys_role comment '��ɫ��';

/*==============================================================*/
/* Table: sys_role_permission                                   */
/*==============================================================*/
create table sys_role_permission
(
   id                   int not null auto_increment comment '����',
   permission_id        int comment 'Ȩ��id',
   role_id              int comment '��ɫid',
   tenant_id            int comment '�⻧id',
   primary key (id)
);

alter table sys_role_permission comment '��ɫ��Ȩ�޹�ϵ��';

/*==============================================================*/
/* Table: sys_tenant                                            */
/*==============================================================*/
create table sys_tenant
(
   id                   int not null auto_increment comment '����',
   tenant_code          varchar(32) comment '�⻧����',
   tenant_name          varchar(250) comment '�⻧����',
   enable               tinyint comment '�Ƿ���Ч
            0��Ч  
            1��Ч
            ',
   remark               varchar(500) comment '��ע',
   create_time          datetime comment '����ʱ��',
   create_user_id       int comment '������id',
   create_user_name     varchar(25) comment '����������',
   update_time          datetime comment '�޸�ʱ��',
   update_user_id       int comment '�޸���id',
   update_user_name     varchar(25) comment '�޸�������',
   primary key (id)
);

alter table sys_tenant comment '�⻧��';

/*==============================================================*/
/* Table: sys_user_action                                       */
/*==============================================================*/
create table sys_user_action
(
   id                   int not null auto_increment comment '����',
   act_code             varchar(32) comment '����',
   act_name             varchar(100) comment '����',
   permission           varchar(150) comment 'Ȩ�ر�ʶ',
   act_href             varchar(150),
   enable               tinyint comment '�Ƿ���Ч
            0��Ч  
            1��Ч
            ',
   sort                 int comment '����',
   remark               varchar(500) comment '��ע',
   tenant_id            int comment '�⻧id',
   create_time          datetime comment '����ʱ��',
   create_user_id       int comment '������id',
   create_user_name     varchar(25) comment '����������',
   update_time          datetime comment '�޸�ʱ��',
   update_user_id       int comment '�޸���id',
   update_user_name     varchar(25) comment '�޸�������',
   primary key (id)
);

alter table sys_user_action comment '�û�������';

/*==============================================================*/
/* Table: sys_user_info                                         */
/*==============================================================*/
create table sys_user_info
(
   id                   int not null auto_increment comment '����',
   user_code            varchar(32) comment '�û�����',
   login_code           varchar(25) comment '��¼�˺�',
   user_name            varchar(50) comment '�û��ǳ�',
   pwd                  varchar(32) comment '��¼����',
   email                varchar(50) comment '����',
   mobile               varchar(20) comment '�ֻ���',
   phone                varchar(20) comment '�칫�绰',
   sex                  tinyint comment '�Ա�
            0�� 1Ů',
   avatar               varchar(100) comment 'ͷ��·��',
   sign                 varchar(250) comment '����ǩ��',
   wx_openid            varchar(50) comment '΢�ź�',
   qq_openid            varchar(25) comment 'qq��',
   address              varchar(500) comment '��ַ',
   remark               varchar(500) comment '��ע',
   tenant_id            int comment '�⻧id',
   status               char(10) comment '����״̬
            0-����ͨ��
            1-������
            2-������',
   mgr_type             tinyint comment '����Ա����
            0�ǹ���Ա
            1ϵͳ����Ա
            ',
   pwd_question         varchar(50) comment '��������',
   pwd_question_answer  varchar(25) comment '���������',
   pwd_question2        varchar(50) comment '��������2',
   pwd_question_answer2 varchar(25) comment '���������2',
   pwd_question3        varchar(50) comment '��������3',
   pwd_question_answer3 varchar(25) comment '���������3',
   enable               tinyint comment '�Ƿ���Ч
            0��Ч  
            1��Ч
            ',
   create_time          datetime comment '����ʱ��',
   create_user_id       int comment '������id',
   create_user_name     varchar(25) comment '����������',
   update_time          datetime comment '�޸�ʱ��',
   update_user_id       int comment '�޸���id',
   update_user_name     varchar(25) comment '�޸�������',
   primary key (id)
);

alter table sys_user_info comment '�û����ϱ�';

/*==============================================================*/
/* Table: sys_user_organization                                 */
/*==============================================================*/
create table sys_user_organization
(
   id                   int not null auto_increment comment '����',
   user_id              int comment '�û���Դid',
   organization_id      int comment '��֯������id',
   tenant_id            int comment '�⻧id',
   primary key (id)
);

alter table sys_user_organization comment '�û���֯������';

/*==============================================================*/
/* Table: sys_user_post                                         */
/*==============================================================*/
create table sys_user_post
(
   id                   int not null auto_increment comment '����',
   user_id              int comment '�û���Դ��id',
   post_id              int comment 'ְ���id',
   tenant_id            int comment '�⻧id',
   primary key (id)
);

alter table sys_user_post comment '�û�ְ���';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   id                   int not null auto_increment comment '����',
   role_id              int comment '��ɫid',
   user_id              int comment '�û�id',
   tenant_id            int comment '�⻧id',
   primary key (id)
);

alter table sys_user_role comment '�û���ɫ��';

/*==============================================================*/
/* Table: um_permission                                         */
/*==============================================================*/
create table um_permission
(
   um_id                int not null comment '����',
   um_resource_id       varchar(50) comment '��Դid',
   um_action            varchar(100) comment '����',
   um_tenant_id2        int comment '�⻧id',
   um_module_id         int comment 'um_module_id',
   primary key (um_id)
);

alter table um_permission comment 'Ȩ�ޱ�wso2��';

/*==============================================================*/
/* Table: um_role                                               */
/*==============================================================*/
create table um_role
(
   um_id                int not null comment '����',
   um_role_name         varchar(32) comment '��ɫ����',
   um_tenant_id         int comment '�⻧id',
   um_shared_role       tinyint comment '�����ɫ',
   primary key (um_id)
);

alter table um_role comment '��ɫ��wso2��';

/*==============================================================*/
/* Table: um_role_permission                                    */
/*==============================================================*/
create table um_role_permission
(
   um_id                int not null comment '����',
   um_permission_id     int comment 'Ȩ��id',
   um_role_name         varchar(32) comment '��ɫ����',
   um_is_allowed        smallint comment '�Ƿ�����',
   um_tenant_id         int comment '�⻧id',
   um_domain_id         int comment '��ҵid',
   primary key (um_id)
);

alter table um_role_permission comment '��ɫ��Ȩ�޹�ϵ��wso2��';

/*==============================================================*/
/* Table: um_user                                               */
/*==============================================================*/
create table um_user
(
   um_id                int not null comment '����',
   um_user_name         varchar(25) comment '�û���',
   um_user_password     varchar(32) comment '����',
   um_salt_value        varchar(32) comment '��',
   um_require_change    varchar(20) comment '�Ƿ����',
   um_changed_time      datetime comment '����ʱ��',
   um_tenant_id         int comment '�⻧id',
   primary key (um_id)
);

alter table um_user comment '�û���wso2��';

/*==============================================================*/
/* Table: um_user_role                                          */
/*==============================================================*/
create table um_user_role
(
   um_id                int not null comment '����',
   um_role_id           int comment '��ɫid',
   um_user_id           int comment '�û�id',
   um_tenant_id         int comment '�⻧id',
   primary key (um_id)
);

alter table um_user_role comment '�û����ɫ��WSO2��';

