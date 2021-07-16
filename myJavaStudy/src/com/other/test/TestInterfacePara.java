package com.other.test;
DROP TABLE IF EXISTS `type_definition`;
CREATE TABLE `type_definition` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `NAME` varchar(100) DEFAULT NULL COMMENT '名称',
  `number` varchar(50) DEFAULT NULL COMMENT '编号',
  `object_type` varchar(100) DEFAULT NULL COMMENT '内码',
  `description` varchar(200) DEFAULT NULL COMMENT '描述信息',
  `is_instance` int(1) DEFAULT NULL COMMENT '是否可生成实例（0,1）1表示可生成实例',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '继承id',
  `data_ref_table` varchar(50) DEFAULT NULL COMMENT '数据落地的实例表名',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `type_definition_parent_id_INDEX` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全局类型定义表';

DROP TABLE IF EXISTS `type_attribute_r`;
CREATE TABLE `type_attribute_r` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `object_type` varchar(100) DEFAULT NULL COMMENT '对象类型（区分同一个对象不同类型时标准属性不一样）',
  `attribute_definition_id` varchar(50) DEFAULT NULL COMMENT '属性定义的id，外键',
  `attribute_type` varchar(100) DEFAULT NULL COMMENT '属性类型(string,int,float,date，boolean)，默认string',
  `is_standard` int(1) DEFAULT NULL COMMENT '是否标准字段（0表示IBA属性，1表示标准字段，保存到扩展字段中，2表示基本）',
  `is_multiple` int(1) DEFAULT NULL COMMENT '是否多选值',
  `attr_column_name` varchar(100) DEFAULT NULL COMMENT '标准属性字段名(扩展字段)  (5/3/3）',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `object_attribute_definition_r_object_type_INDEX` (`object_type`),
  KEY `object_attribute_definition_r_attribute_definition_id_INDEX` (`attribute_definition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类型属性关系表';
DROP TABLE IF EXISTS `project_team_r`;
CREATE TABLE `project_team_r` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `team_id` varchar(32) NOT NULL COMMENT '团队id',
  `project_id` varchar(64) DEFAULT NULL COMMENT '项目id',
  `team_name` varchar(64) DEFAULT NULL COMMENT '团队名称',
  `team_type` varchar(64) DEFAULT NULL COMMENT '团队类型：华为团队，供应商开发团队',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  `is_sync` int(1) DEFAULT '0' COMMENT '是否将ccmp的角色成员同步，1表示已同步',
  PRIMARY KEY (`id`),
  KEY `team_id_INDEX` (`team_id`,`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目与团队关系';

-- ----------------------------
-- Table structure for supplier_color_sign
-- ----------------------------
DROP TABLE IF EXISTS `supplier_color_sign`;
CREATE TABLE `supplier_color_sign` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `part_supplier_id` varchar(32) NOT NULL COMMENT '部件项目供应商id',
  `color` varchar(32) DEFAULT NULL COMMENT '颜色',
  `number` varchar(500) DEFAULT NULL COMMENT '编码',
  `sign_physical_date` datetime DEFAULT NULL COMMENT '签实物时间',
  `sign_date` datetime DEFAULT NULL COMMENT '签样时间',
  `order_` int(20) DEFAULT NULL COMMENT '序号',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `supplier_color_sign_index` (`part_supplier_id`,`order_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商颜色签样关系表';

-- ----------------------------
-- Table structure for supplier_team_contacts
-- ----------------------------
DROP TABLE IF EXISTS `supplier_team_contacts`;
CREATE TABLE `supplier_team_contacts` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `project_id` varchar(32) NOT NULL COMMENT '项目id',
  `team_id` varchar(32) NOT NULL COMMENT '团队名称',
  `dept` varchar(100) NOT NULL COMMENT '部门',
  `position` varchar(100) NOT NULL COMMENT '岗位',
  `account` varchar(100) NOT NULL COMMENT '姓名',
  `mobile_number` varchar(25) NOT NULL COMMENT '联系方式',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `salt` varchar(100) DEFAULT NULL COMMENT '加密salt',
  `note` varchar(1000) DEFAULT NULL COMMENT '描述',
  `order_` int(20) DEFAULT NULL COMMENT '序号',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `supplier_team_id_index` (`project_id`,`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商开发团队联系人表';

-- ----------------------------
-- Table structure for team_instance
-- ----------------------------
DROP TABLE IF EXISTS `team_instance`;
CREATE TABLE `team_instance` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `team_name` varchar(500) DEFAULT NULL COMMENT '团队名称',
  `team_desc` varchar(64) DEFAULT NULL COMMENT '团队描述',
  `supplier_code` varchar(64) DEFAULT NULL COMMENT '供应商code',
  `team_template_id` varchar(64) NOT NULL COMMENT '团队模板id',
  `team_type` int(5) NOT NULL COMMENT '0 项目团队;1华为驻厂团队;2供应商团队',
  `order_` int(5) NOT NULL COMMENT '顺序',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `team_instance_id_INDEX` (`team_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队实例';

-- ----------------------------
-- Table structure for team_member_r
-- ----------------------------
DROP TABLE IF EXISTS `team_member_r`;
CREATE TABLE `team_member_r` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `team_id` varchar(32) NOT NULL COMMENT '团队id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `project_id` varchar(64) DEFAULT NULL COMMENT '项目id',
  `member_value` varchar(64) DEFAULT NULL COMMENT '值 type为时1 userid;2',
  `member_type` varchar(64) DEFAULT NULL COMMENT '值类型，1表示员工id，2表示静态组',
  `member_account` varchar(64) DEFAULT NULL COMMENT '成员工号',
  `member_name` varchar(64) DEFAULT NULL COMMENT '成员姓名',
  `is_master` int(1) DEFAULT NULL COMMENT ' 是否主责任人（0,1 ； 1表示主责任人）',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `activity_doc_template_INDEX` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队角色成员关系';

-- ----------------------------
-- Table structure for team_role_instance
-- ----------------------------
DROP TABLE IF EXISTS `team_role_instance`;
CREATE TABLE `team_role_instance` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `team_id` varchar(32) NOT NULL COMMENT '团队id',
  `role_key` varchar(64) DEFAULT NULL COMMENT '角色',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色显示名称',
  `role_key_mapping` varchar(64) NOT NULL COMMENT '角色显示名称',
  `required` int(1) NOT NULL COMMENT '是否必填',
  `order_` int(4) NOT NULL COMMENT '顺序',
  `attr_string1` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string2` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `team_role_instance_INDEX` (`team_id`,`role_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队角色';

-- ----------------------------
-- Table structure for team_role_r_template
-- ----------------------------
DROP TABLE IF EXISTS `team_role_r_template`;
CREATE TABLE `team_role_r_template` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `team_id` varchar(100) DEFAULT NULL COMMENT '团队模板id',
  `object_type` varchar(20) NOT NULL COMMENT '类型，内码',
  `role_key` varchar(50) DEFAULT NULL COMMENT '角色内码',
  `role_key_mapping` varchar(50) DEFAULT NULL COMMENT '角色映射下游系统的内码',
  `role_display` varchar(100) DEFAULT NULL COMMENT '角色显示名称',
  `default_value` varchar(50) DEFAULT NULL COMMENT '默认值',
  `value_type` int(1) DEFAULT NULL COMMENT '值类型，1表示员工号，2表示静态组',
  `is_required` int(1) DEFAULT NULL COMMENT '是否必填  （0,1）',
  `is_stationed` int(1) DEFAULT NULL COMMENT '是否驻厂（0默认否，1是驻厂）',
  `order_` int(4) NOT NULL COMMENT '顺序',
  `attr_string1` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string2` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `team_member_template_team_id_INDEX` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队角色关系模板';

-- ----------------------------
-- Table structure for team_template
-- ----------------------------
DROP TABLE IF EXISTS `team_template`;
CREATE TABLE `team_template` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '团队模板名称',
  `object_type` varchar(100) NOT NULL COMMENT '类型，内码',
  `number` varchar(100) DEFAULT NULL COMMENT '编号',
  `description` varchar(200) DEFAULT NULL COMMENT '描述信息',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `team_member_template_obj_type_INDEX` (`object_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队模板';

DROP TABLE IF EXISTS `project_instance`;
CREATE TABLE `project_instance` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '项目内部名称',
  `external_name` varchar(100) DEFAULT NULL COMMENT '项目外部名称',
  `number` varchar(100) DEFAULT NULL COMMENT '项目编号',
  `project_type` varchar(200) DEFAULT NULL COMMENT '项目类别',
  `confidentiality_level` int(1) DEFAULT NULL COMMENT '保密级别',
  `project_mode` varchar(50) DEFAULT NULL COMMENT '项目模式',
  `reference_team_object_type` varchar(50) DEFAULT NULL COMMENT '引用的项目团队模板类型',
  `type_id` varchar(50) DEFAULT NULL COMMENT '类型id',
  `plan_template_id` varchar(50) DEFAULT NULL COMMENT '计划模板id',
  `description` varchar(1000) DEFAULT NULL COMMENT '描述信息',
  `status` int(11) DEFAULT NULL COMMENT '项目状态',
  `attr_string1` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string2` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string3` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string4` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string5` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_int1` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_int2` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_int3` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_date1` datetime DEFAULT NULL COMMENT '扩展字段date',
  `attr_date2` datetime DEFAULT NULL COMMENT '展字段date',
  `attr_date3` datetime DEFAULT NULL COMMENT '展字段date',
  `attr_date4` datetime DEFAULT NULL COMMENT '展字段date',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `project_instance_template_id_index` (`type_id`),
  KEY `project_instance_plan_template_name_INDEX` (`name`),
  KEY `project_instance_plan_template_id_INDEX` (`plan_template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目实例对象';

-- ----------------------------
-- Table structure for project_instance_r
-- ----------------------------
DROP TABLE IF EXISTS `project_instance_r`;
CREATE TABLE `project_instance_r` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `project_id` varchar(50) DEFAULT NULL COMMENT '中台项目id',
  `ref_id` varchar(20) DEFAULT NULL COMMENT '关联对对象id',
  `ref_name` varchar(200) DEFAULT NULL COMMENT '关联对对象名称',
  `ref_type` varchar(100) DEFAULT NULL COMMENT '关联的类型',
  `description` varchar(100) DEFAULT NULL COMMENT '描述信息',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `project_instance_r_project_id_INDEX` (`project_id`,`ref_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目与其他系统对象的关系';

-- ----------------------------
-- Table structure for project_plan
-- ----------------------------
DROP TABLE IF EXISTS `project_plan`;
CREATE TABLE `project_plan` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `project_id` varchar(32) NOT NULL COMMENT '项目id',
  `object_type` varchar(100) DEFAULT NULL COMMENT '内码',
  `plan_template_id` varchar(32) DEFAULT NULL COMMENT '计划模板id',
  `name` varchar(100) NOT NULL COMMENT '计划名称',
  `arch_pass_date` datetime DEFAULT NULL COMMENT '架设评审通过时间',
  `start_mold_date` datetime DEFAULT NULL COMMENT '投摸时间',
  `fot_date` datetime DEFAULT NULL COMMENT 'FOT时间',
  `sv1_date` datetime DEFAULT NULL COMMENT 'SV1准出时间',
  `sv2_date` datetime DEFAULT NULL COMMENT 'SV2准出时间',
  `sv3_date` datetime DEFAULT NULL COMMENT 'SV3准出时间',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `main_plan_flag` int(1) NOT NULL COMMENT '是否主计划,一个项目只有一个主计划',
  `sample_approval_date` datetime DEFAULT NULL COMMENT '签样时间',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  `attr_string1` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string2` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string3` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string4` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string5` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_int1` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_int2` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_int3` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `part_supplier_id` varchar(500) DEFAULT NULL COMMENT '部件与供应商关系id,如果是非主计划时字段必填',
  PRIMARY KEY (`id`),
  KEY `activity_doc_template_INDEX` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目计划关系表';

-- ----------------------------
-- Table structure for project_recently_viewed
-- ----------------------------
DROP TABLE IF EXISTS `project_recently_viewed`;
CREATE TABLE `project_recently_viewed` (
  `id` varchar(32) NOT NULL,
  `oid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `type` varchar(32) DEFAULT NULL COMMENT 'product,library',
  `last_update_date` datetime DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `material_category` varchar(255) DEFAULT NULL COMMENT '物料类别',
  `deleted_flag` int(1) DEFAULT NULL COMMENT '0启用，1禁用',
  `creation_date` datetime DEFAULT NULL,
  `created_by` varchar(32) DEFAULT NULL,
  `last_updated_by` varchar(32) DEFAULT NULL,
  `tenant_code` varchar(32) DEFAULT NULL,
  `project_category` varchar(255) DEFAULT NULL COMMENT '项目类别',
  `new_projectId` varchar(255) DEFAULT NULL COMMENT '中台项目id',
  PRIMARY KEY (`id`),
  KEY `userid_index` (`user_id`),
  KEY `oid_index` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目最近浏览记录表';

-- ----------------------------
-- Table structure for project_supplier
-- ----------------------------
DROP TABLE IF EXISTS `project_supplier`;
CREATE TABLE `project_supplier` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `project_id` varchar(32) NOT NULL COMMENT '项目id',
  `object_type` varchar(100) DEFAULT NULL COMMENT '内码',
  `supplier_code` varchar(32) NOT NULL COMMENT '供应商编码',
  `supplier_name` varchar(500) DEFAULT NULL COMMENT '供应商名称',
  `order_` int(20) DEFAULT NULL COMMENT '序号',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `project_supplier_id_index` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目供应商关系表';

-- ----------------------------
-- Table structure for cmda_report_config_rule
-- ----------------------------
DROP TABLE IF EXISTS `cmda_report_config_rule`;
CREATE TABLE `cmda_report_config_rule` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `report_name` varchar(32) DEFAULT NULL COMMENT '报表名称',
  `attribute_name` varchar(200) DEFAULT NULL COMMENT '统计维度（属性名称）,多个属性逗号隔开，最多支持5个属性维度',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `type_ref` varchar(32) NOT NULL COMMENT '统计类型',
  `report_code` varchar(32) DEFAULT NULL COMMENT '规则编码',
  `container` varchar(32) DEFAULT NULL COMMENT '是否按项目统计',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_date` datetime DEFAULT NULL COMMENT '最新修改时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '修改者',
  `deleted_flag` tinyint(4) DEFAULT NULL COMMENT '是否可用，0可用，1不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报表规则配置表';

-- ----------------------------
-- Table structure for cmda_report_instance
-- ----------------------------
DROP TABLE IF EXISTS `cmda_report_instance`;
CREATE TABLE `cmda_report_instance` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `attr1_value` varchar(100) DEFAULT NULL COMMENT '维度值1',
  `attr2_value` varchar(100) DEFAULT NULL COMMENT '维度值2',
  `attr3_value` varchar(100) DEFAULT NULL COMMENT '维度值3',
  `attr4_value` varchar(100) DEFAULT NULL COMMENT '维度值4',
  `attr5_value` varchar(100) DEFAULT NULL COMMENT '维度值5',
  `attr6_value` varchar(100) DEFAULT NULL COMMENT '维度值6',
  `attr7_value` varchar(100) DEFAULT NULL COMMENT '维度值7',
  `attr8_value` varchar(100) DEFAULT NULL COMMENT '维度值8',
  `total_count` int(11) DEFAULT NULL COMMENT '数量',
  `report_config_rule_id` varchar(32) NOT NULL COMMENT '报表统计规则配置表ID',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted_flag` tinyint(4) DEFAULT NULL COMMENT '是否可用，0可用，1不可用',
  `last_update_date` datetime DEFAULT NULL COMMENT '最新修改时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '修改者',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `type_ref` varchar(32) NOT NULL COMMENT '统计类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报表统计实例';

-- ----------------------------
-- Table structure for cmda_report_task
-- ----------------------------
DROP TABLE IF EXISTS `cmda_report_task`;
CREATE TABLE `cmda_report_task` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `task_name` varchar(32) DEFAULT NULL COMMENT '任务名称',
  `report_config_rule_id` varchar(32) NOT NULL COMMENT '报表统计规则id，外键',
  `is_one` tinyint(4) DEFAULT NULL COMMENT '是否执行一次',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `frequency` int(11) DEFAULT NULL COMMENT '执行频率，单位是分钟',
  `last_execution_time` datetime DEFAULT NULL COMMENT '上次执行时间',
  `state` varchar(32) DEFAULT NULL COMMENT '状态、wait/running/discarded',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_date` datetime DEFAULT NULL COMMENT '最新修改时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '修改者',
  `deleted_flag` tinyint(4) DEFAULT NULL COMMENT '是否可用，0可用，1不可用',
  `msg` text COMMENT '记录任务的执行情况 ',
  `type_ref` varchar(32) NOT NULL COMMENT '统计类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报表规则配置表';

-- ----------------------------
-- Table structure for cmda_stringvalue_data
-- ----------------------------
DROP TABLE IF EXISTS `cmda_stringvalue_data`;
CREATE TABLE `cmda_stringvalue_data` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `component_code` varchar(100) DEFAULT NULL,
  `attribute_name` varchar(200) NOT NULL COMMENT '属性名称',
  `stringvalue` varchar(100) DEFAULT NULL COMMENT '属性值',
  `instance_type_id` varchar(32) DEFAULT NULL COMMENT '业务实例Id',
  `business_type_name` varchar(32) DEFAULT NULL COMMENT '业务类型',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `cmda_stringvalue_data_attribute_name_index` (`attribute_name`),
  KEY `cmda_stringvalue_data_instance_type_id_index` (`instance_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题实例数据';

-- ----------------------------
-- Table structure for cmda_task_info
-- ----------------------------
DROP TABLE IF EXISTS `cmda_task_info`;
CREATE TABLE `cmda_task_info` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `task_name` varchar(50) DEFAULT NULL COMMENT '任务名称',
  `task_role` varchar(30) DEFAULT NULL COMMENT '任务承担者角色',
  `task_owner` varchar(50) DEFAULT NULL COMMENT '任务所有者',
  `task_complete_by` varchar(50) DEFAULT NULL COMMENT '任务完成者',
  `task_state` varchar(20) DEFAULT NULL COMMENT '任务状态/Open/Finished',
  `ref_business_id` varchar(50) DEFAULT NULL COMMENT '关联的业务实例ID',
  `vote` varchar(50) DEFAULT NULL COMMENT '路由投票',
  `comments` varchar(1000) DEFAULT NULL COMMENT '备注',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  KEY `cmda_task_info_ref_business_id_index` (`ref_business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务表';

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for iba_attribute_instance_data
-- ----------------------------
DROP TABLE IF EXISTS `iba_attribute_instance_data`;
CREATE TABLE `iba_attribute_instance_data` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `attribute_definition_id` varchar(32) DEFAULT NULL COMMENT '属性定义的id',
  `attribute_value` varchar(500) DEFAULT NULL COMMENT '属性值',
  `attribute_value_text` text COMMENT '属性值text',
  `instance_type_id` varchar(32) DEFAULT NULL COMMENT '业务实例Id',
  `instance_type_name` varchar(100) DEFAULT NULL COMMENT '业务类型',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `iba_attribute_instance_data_attribute_definition_id_INDEX` (`attribute_definition_id`),
  KEY `iba_attribute_instance_data_instance_type_id_index` (`instance_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='iba属性实例表';

-- ----------------------------
-- Table structure for part_supplier
-- ----------------------------
DROP TABLE IF EXISTS `part_supplier`;
CREATE TABLE `part_supplier` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `project_id` varchar(32) NOT NULL COMMENT '项目id',
  `object_type` varchar(100) DEFAULT NULL COMMENT '内码',
  `project_supplier_id` varchar(32) NOT NULL COMMENT '项目供应商id',
  `part_name` varchar(64) NOT NULL COMMENT '产品部件',
  `supplier_sub_account` varchar(64) DEFAULT NULL COMMENT '供应商子账号，每行都会在GDP生成子账号',
  `cooperate_state` int(1) NOT NULL COMMENT '供应商合作状态（0正常合作；1终止合作）',
  `termination_reason` varchar(2000) DEFAULT NULL COMMENT '终止合作原因说明',
  `termination_s3` varchar(255) DEFAULT NULL COMMENT '终止合作说明附件s3',
  `group_id` varchar(64) NOT NULL COMMENT '同一行，组号相同则需要合并',
  `order_` int(20) DEFAULT NULL COMMENT '序号',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `part_supplier_index` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目部件供应商关系表';

-- ----------------------------
-- Table structure for plan_template
-- ----------------------------
DROP TABLE IF EXISTS `plan_template`;
CREATE TABLE `plan_template` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `object_type` varchar(100) DEFAULT NULL COMMENT '类型，内码',
  `name` varchar(100) NOT NULL COMMENT '计划模板名称',
  `active` int(1) DEFAULT NULL COMMENT '启用状态 0启用 1禁用',
  `version` varchar(20) DEFAULT NULL COMMENT '版本',
  `material_category` varchar(100) DEFAULT NULL COMMENT '适用物料类别',
  `project_category` varchar(100) DEFAULT NULL COMMENT '使用项目类别',
  `order_` int(20) NOT NULL COMMENT '序号',
  `attr_string1` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string2` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string3` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string4` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string5` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_int1` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_int2` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_int3` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_date1` datetime DEFAULT NULL COMMENT '扩展字段date',
  `attr_date2` datetime DEFAULT NULL COMMENT '展字段date',
  `attr_date3` datetime DEFAULT NULL COMMENT '展字段date',
  `attr_date4` datetime DEFAULT NULL COMMENT '展字段date',
  `description` varchar(200) DEFAULT NULL COMMENT '描述信息',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `plan_template_name_INDEX` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计划模板';

-- ----------------------------
-- Table structure for project_activity
-- ----------------------------
DROP TABLE IF EXISTS `project_activity`;
CREATE TABLE `project_activity` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `project_id` varchar(32) NOT NULL COMMENT '项目id',
  `object_type` varchar(100) DEFAULT NULL COMMENT '内码',
  `plan_id` varchar(32) NOT NULL COMMENT '项目计划id',
  `name` varchar(100) NOT NULL COMMENT '活动名称',
  `role_key` varchar(100) DEFAULT NULL COMMENT '任务承担角色',
  `account` varchar(20) DEFAULT NULL COMMENT '任务承担人',
  `type` varchar(100) NOT NULL COMMENT 'type  类型 （阶段、活动、事务任务...）',
  `level_` int(1) NOT NULL COMMENT '层级',
  `status` int(1) NOT NULL COMMENT '活动状态(未开启、进行中、已暂停)',
  `critical` int(1) DEFAULT NULL COMMENT '是否有风险',
  `risk_type` varchar(32) DEFAULT NULL COMMENT '风险类型',
  `risk_description` varchar(32) DEFAULT NULL COMMENT '风险描述',
  `feedback` varchar(32) DEFAULT NULL COMMENT '是否需要反馈',
  `feedback_role` varchar(255) DEFAULT NULL COMMENT '反馈角色',
  `task_closed_role` varchar(32) DEFAULT NULL COMMENT '任务关闭确认角色',
  `divisive_supplier` varchar(20) DEFAULT NULL COMMENT '是否区分供应商',
  `confidentiality_type` varchar(200) DEFAULT NULL COMMENT '保密级别',
  `close_role` varchar(200) DEFAULT NULL COMMENT '任务关闭确认角色',
  `deliverables` text COMMENT '交付件列表',
  `description` text COMMENT '任务说明',
  `ref_process` varchar(512) DEFAULT NULL COMMENT '关联流程',
  `ref_process_instance_id` varchar(64) DEFAULT NULL COMMENT '关联流程id',
  `plan_start_date` datetime DEFAULT NULL COMMENT '计划开始时间',
  `plan_finish_date` datetime DEFAULT NULL COMMENT '计划完成时间',
  `actual_start_date` datetime DEFAULT NULL COMMENT '实际开始时间',
  `actual_finish_date` datetime DEFAULT NULL COMMENT '实际完成时间',
  `order_` varchar(20) NOT NULL COMMENT '序号',
  `category_order` varchar(50) DEFAULT NULL COMMENT '目录序号 如 1-1',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父项id,关联的计划或活动id',
  `attr_string1` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string2` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string3` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string4` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string5` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_int1` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_int2` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_int3` int(11) DEFAULT NULL COMMENT '扩展字段int',
  `attr_date1` datetime DEFAULT NULL COMMENT '扩展字段date',
  `attr_date2` datetime DEFAULT NULL COMMENT '展字段date',
  `attr_date3` datetime DEFAULT NULL COMMENT '展字段date',
  `attr_date4` datetime DEFAULT NULL COMMENT '展字段date',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  `edit` int(1) DEFAULT '1' COMMENT '1:可以编辑 0：不可编辑',
  `supplier_code` varchar(32) DEFAULT NULL COMMENT '供应商编码',
  `role_key_mapping` varchar(64) DEFAULT NULL COMMENT '任务承担角色-key',
  `supplier_name` varchar(255) DEFAULT NULL COMMENT '供应商部件名称',
  `close_role_name` varchar(255) DEFAULT NULL COMMENT '反馈角色name',
  `feedback_role_name` varchar(255) DEFAULT NULL COMMENT '任务关闭确认角色name',
  PRIMARY KEY (`id`),
  KEY `project_activity_id_index` (`project_id`,`plan_id`,`status`),
  KEY `ids_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目活动表';

-- ----------------------------
-- Table structure for project_activity_doc
-- ----------------------------
DROP TABLE IF EXISTS `project_activity_doc`;
CREATE TABLE `project_activity_doc` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `project_id` varchar(32) NOT NULL COMMENT '项目id',
  `activity_id` varchar(32) NOT NULL COMMENT '关联活动id',
  `ref_doc_template_id` varchar(32) DEFAULT NULL COMMENT '参考文档模板id',
  `doc_name` text COMMENT '文档名称',
  `attachment_id` varchar(32) DEFAULT NULL COMMENT '附件表id，间接关联了s3',
  `doc_type` varchar(32) DEFAULT NULL COMMENT '1、下发文档 2、反馈文档 ',
  `ref_process` varchar(32) DEFAULT NULL COMMENT '关联流程',
  `type` varchar(32) DEFAULT NULL COMMENT '活动实例模板类型：doc 文档；url 链接',
  `ref_process_id` varchar(32) DEFAULT NULL COMMENT '关联流程id',
  `order_` int(20) DEFAULT NULL COMMENT '序号',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `attr_string1` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `attr_string2` varchar(100) DEFAULT NULL COMMENT '扩展字段string',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `project_activity_doc_INDEX` (`project_id`,`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目活动文档表';

-- ----------------------------
-- Table structure for attribute_definition
-- ----------------------------
DROP TABLE IF EXISTS `attribute_definition`;
CREATE TABLE `attribute_definition` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `code` varchar(100) DEFAULT NULL COMMENT '属性code',
  `object_type` varchar(100) DEFAULT NULL COMMENT '类型，默认Attribute',
  `name_zh` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `name_en` varchar(100) DEFAULT NULL COMMENT '英文描述',
  `description` varchar(200) DEFAULT NULL COMMENT '描述信息',
  `tenant_code` varchar(32) NOT NULL COMMENT '租户',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `created_by` varchar(32) NOT NULL COMMENT '创建人',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) NOT NULL COMMENT '更新人',
  `deleted_flag` int(1) NOT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `attribute_definition_code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全局属性定义表';

-- ----------------------------
-- Table structure for cmda_business_type_config
-- ----------------------------
DROP TABLE IF EXISTS `cmda_business_type_config`;
CREATE TABLE `cmda_business_type_config` (
  `id` varchar(50) NOT NULL,
  `business_type` varchar(50) DEFAULT NULL COMMENT '业务类型',
  `service_name` varchar(50) DEFAULT NULL COMMENT 'service类名',
  `businessCode` varchar(50) DEFAULT NULL COMMENT '业务codeCode',
  `general_service_name` varchar(50) DEFAULT NULL COMMENT '通用逻辑处理类',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` int(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  `description` varchar(2000) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`),
  KEY `cmda_business_type_config_business_type_INDEX` (`business_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务配置service类';

-- ----------------------------
-- Table structure for cmda_category
-- ----------------------------
DROP TABLE IF EXISTS `cmda_category`;
CREATE TABLE `cmda_category` (
  `id` varchar(32) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父节点id',
  `category_type` varchar(32) DEFAULT NULL COMMENT '目录结构树类型',
  `category_name` varchar(32) DEFAULT NULL COMMENT '节点名称',
  `category_name_en` varchar(32) DEFAULT NULL COMMENT '节点英文名称',
  `category_level` varchar(100) DEFAULT NULL COMMENT '节点层级',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` int(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='目录分类树形表';

-- ----------------------------
-- Table structure for cmda_category_template_r
-- ----------------------------
DROP TABLE IF EXISTS `cmda_category_template_r`;
CREATE TABLE `cmda_category_template_r` (
  `id` varchar(32) NOT NULL,
  `category_id` varchar(32) DEFAULT NULL COMMENT '分类id',
  `template_id` varchar(32) DEFAULT NULL COMMENT '模板id，如果是配置平台的则模板code',
  `template_name` varchar(32) DEFAULT NULL COMMENT '模板名称',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` int(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类节点模板关系形表';

-- ----------------------------
-- Table structure for cmda_config_enum
-- ----------------------------
DROP TABLE IF EXISTS `cmda_config_enum`;
CREATE TABLE `cmda_config_enum` (
  `id` varchar(32) NOT NULL,
  `enum_code` varchar(32) DEFAULT NULL COMMENT '枚举编码',
  `enum_name` varchar(32) DEFAULT NULL COMMENT '枚举名称',
  `en_name` varchar(32) DEFAULT NULL COMMENT '枚举英文名称',
  `group_name` varchar(100) DEFAULT NULL COMMENT '分组名称，可以为空',
  `enum_desc` varchar(32) DEFAULT NULL COMMENT '描述',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` int(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='枚举表';

-- ----------------------------
-- Table structure for cmda_config_enum_values_r
-- ----------------------------
DROP TABLE IF EXISTS `cmda_config_enum_values_r`;
CREATE TABLE `cmda_config_enum_values_r` (
  `id` varchar(32) NOT NULL,
  `enum_code` varchar(32) DEFAULT NULL COMMENT '枚举编码',
  `enum_value` varchar(32) DEFAULT NULL COMMENT '值编码',
  `enum_name` varchar(32) DEFAULT NULL COMMENT '值名称',
  `enum_value_desc` varchar(32) DEFAULT NULL COMMENT '说明',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='枚举表';

-- ----------------------------
-- Table structure for cmda_config_obj_header
-- ----------------------------
DROP TABLE IF EXISTS `cmda_config_obj_header`;
CREATE TABLE `cmda_config_obj_header` (
  `id` varchar(32) NOT NULL,
  `obj_type` varchar(250) NOT NULL COMMENT '对象类型',
  `template_id` varchar(200) DEFAULT NULL COMMENT '模板id',
  `real_name` varchar(32) DEFAULT NULL COMMENT '对外显示的名称（界面值）',
  `alias_name` varchar(32) DEFAULT NULL COMMENT '存储名称（存到对象表名称,字段attr）',
  `real_code` varchar(32) DEFAULT NULL COMMENT '对象属性field',
  `description` varchar(32) DEFAULT NULL COMMENT '描述',
  `outer_id` varchar(32) DEFAULT NULL COMMENT '外部数据component_id，如：配置属性id值',
  `outer_form_id` varchar(32) DEFAULT NULL COMMENT '外部数据form_id，如：配置表单值',
  `herf_url` varchar(100) DEFAULT NULL COMMENT '字段是超链接时，有值',
  `order_` int(2) DEFAULT NULL COMMENT '对象顺序用来调整界面显示用',
  `show_flag` int(2) DEFAULT NULL COMMENT '用户是否已勾选',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` int(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `cmda_config_obj_header_obj_type_INDEX` (`id`,`obj_type`,`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置对象头表';

-- ----------------------------
-- Table structure for cmda_config_obj_type
-- ----------------------------
DROP TABLE IF EXISTS `cmda_config_obj_type`;
CREATE TABLE `cmda_config_obj_type` (
  `id` varchar(32) NOT NULL,
  `obj_type` varchar(250) NOT NULL COMMENT '对象类型编码(相同模板他table_code不同obj_type不同，obj_code不同obj_type可相同)',
  `template_id` varchar(200) DEFAULT NULL COMMENT '模板id',
  `base_code` varchar(32) DEFAULT NULL COMMENT '对应配置平台的basecardid，逗号分隔',
  `table_code` varchar(32) DEFAULT NULL COMMENT '对应配置平台的form_id',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '对象父id',
  `description` varchar(32) DEFAULT NULL COMMENT '描述',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` int(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `cmda_config_obj_type_INDEX` (`id`,`obj_type`,`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='对象类型表';

-- ----------------------------
-- Table structure for cmda_obj_instance
-- ----------------------------
DROP TABLE IF EXISTS `cmda_obj_instance`;
CREATE TABLE `cmda_obj_instance` (
  `id` varchar(32) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父id，当有父子层级的时候有值',
  `obj_level` int(2) NOT NULL COMMENT '层级，第一层level为1，',
  `instance_id` varchar(64) DEFAULT NULL COMMENT '配置平台实例id或内部实例id',
  `obj_name` varchar(32) DEFAULT NULL COMMENT '对象实例名称',
  `obj_type` varchar(250) NOT NULL COMMENT '对象类型',
  `template_id` varchar(200) DEFAULT NULL COMMENT '模板id',
  `category_id` varchar(32) DEFAULT NULL COMMENT '节点id',
  `oid` varchar(32) DEFAULT NULL COMMENT '对象id',
  `number` varchar(64) DEFAULT NULL COMMENT '对象编码',
  `order_` int(11) DEFAULT NULL COMMENT '顺序',
  `attr1` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr2` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr3` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr4` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr5` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr6` varchar(500) DEFAULT NULL COMMENT '属性',
  `attr7` varchar(500) DEFAULT NULL COMMENT '属性',
  `attr8` varchar(500) DEFAULT NULL COMMENT '属性',
  `attr9` varchar(500) DEFAULT NULL COMMENT '属性',
  `attr10` varchar(500) DEFAULT NULL COMMENT '属性',
  `attr11` varchar(500) DEFAULT NULL COMMENT '属性',
  `attr12` varchar(500) DEFAULT NULL COMMENT '属性',
  `attr13` varchar(500) DEFAULT NULL COMMENT '属性',
  `attr14` text COMMENT '属性',
  `attr15` text COMMENT '属性',
  `attr16` text COMMENT '属性',
  `attr17` text COMMENT '属性',
  `attr18` text COMMENT '属性',
  `attr19` text COMMENT '属性',
  `attr20` text COMMENT '属性',
  `attr21` text COMMENT '属性',
  `attr22` text COMMENT '属性',
  `attr23` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr24` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr25` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr26` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr27` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr28` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr29` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr30` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr31` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr32` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr33` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr34` varchar(255) DEFAULT NULL COMMENT '属性',
  `attr35` varchar(255) DEFAULT NULL COMMENT '属性',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` int(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `cmda_obj_instance_attr_INDEX` (`attr1`,`attr2`,`attr3`,`attr4`),
  KEY `cmda_obj_instance_instance_id_INDEX` (`id`,`instance_id`,`template_id`,`category_id`,`oid`,`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置出的对象实例表';

-- ----------------------------
-- Table structure for cmda_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `cmda_operation_log`;
CREATE TABLE `cmda_operation_log` (
  `id` varchar(32) NOT NULL,
  `instance_id` varchar(64) NOT NULL COMMENT '实例id',
  `oid` varchar(100) DEFAULT NULL COMMENT '对象id',
  `number` varchar(100) DEFAULT NULL COMMENT '编码',
  `node_id` varchar(100) DEFAULT NULL COMMENT '节点id',
  `node_name` varchar(100) DEFAULT NULL COMMENT '节点名称',
  `action` varchar(512) DEFAULT NULL COMMENT '动作',
  `operator` varchar(100) DEFAULT NULL COMMENT '操作人UserCN',
  `comment` varchar(1000) DEFAULT NULL COMMENT '节点id',
  `attr1` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `attr2` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `attr3` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `attr4` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `attr5` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` int(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `cmda_operation_log_INDEX` (`id`,`instance_id`,`oid`,`number`,`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志表';

-- ----------------------------
-- Table structure for cmda_problem_focus
-- ----------------------------
DROP TABLE IF EXISTS `cmda_problem_focus`;
CREATE TABLE `cmda_problem_focus` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `instance_id` varchar(200) DEFAULT NULL COMMENT '项目Id',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `problem_id` varchar(64) DEFAULT NULL COMMENT '问题id',
  `focus_user_id` varchar(64) DEFAULT NULL COMMENT '关注人userId',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  `project_id` varchar(64) DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`id`),
  KEY `cmda_problem_focus_problem_id_index` (`problem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我关注的问题';

-- ----------------------------
-- Table structure for cmda_problem_instance
-- ----------------------------
DROP TABLE IF EXISTS `cmda_problem_instance`;
CREATE TABLE `cmda_problem_instance` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `problem_number` varchar(32) DEFAULT NULL COMMENT '问题编码',
  `project_id` varchar(100) DEFAULT NULL COMMENT '项目Id',
  `project_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `problem_type` varchar(32) DEFAULT NULL COMMENT '问题类型',
  `target_state` varchar(32) DEFAULT NULL COMMENT '问题生命周期状态',
  `process_state` varchar(30) DEFAULT NULL COMMENT '流程状态',
  `process_id` varchar(50) DEFAULT NULL,
  `ref_id` varchar(64) DEFAULT NULL,
  `ref_name` varchar(100) DEFAULT NULL COMMENT '关联名称',
  `problem_discovery_phase` varchar(50) DEFAULT NULL COMMENT '问题发现阶段',
  `problem_original_source` varchar(32) DEFAULT NULL COMMENT '问题的原始来源',
  `problem_raiser` varchar(300) DEFAULT NULL COMMENT '问题提出人',
  `severity` varchar(32) DEFAULT NULL COMMENT '问题严重程度',
  `expected_resolution_date` date DEFAULT NULL COMMENT '期望解决日期',
  `brief_description` varchar(500) DEFAULT NULL COMMENT '简要描述',
  `detail_description` varchar(200) DEFAULT NULL COMMENT '详细描述',
  `hand_suggestions` varchar(500) DEFAULT NULL COMMENT '处理建议',
  `hand_suggestions_img` varchar(500) DEFAULT NULL COMMENT '修改建议图片说明',
  `duplicated_flag` tinyint(1) DEFAULT NULL COMMENT '是否重复问题',
  `reproblem_no` varchar(50) DEFAULT NULL,
  `finished_change_flag` tinyint(4) DEFAULT NULL COMMENT '是否完成更改',
  `issue_review_conclusion` varchar(500) DEFAULT NULL COMMENT '问题评审结论',
  `issue_review_conclusion_img` varchar(500) DEFAULT NULL COMMENT '问题评审结论图片说明',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除(0:未删除；1:已删除)',
  PRIMARY KEY (`id`),
  KEY `cmda_problem_instance_project_id_index` (`project_id`),
  KEY `cmda_problem_instance_problem_number_index` (`problem_number`),
  KEY `cmda_problem_instance_ref_id_index` (`ref_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题实例数据';

-- ----------------------------
-- Table structure for cmda_problem_tracking
-- ----------------------------
DROP TABLE IF EXISTS `cmda_problem_tracking`;
CREATE TABLE `cmda_problem_tracking` (
  `id` varchar(64) DEFAULT NULL COMMENT '主键',
  `instanceId` varchar(32) DEFAULT NULL COMMENT '关联的问题ID',
  `content` varchar(200) DEFAULT NULL COMMENT 'key',
  `tracking_order` int(10) DEFAULT NULL COMMENT 'value',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `last_update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `deleted_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除(false:未删除；true:已删除)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题进展跟踪';

-- ----------------------------
-- Table structure for cmda_report_attributes
-- ----------------------------
DROP TABLE IF EXISTS `cmda_report_attributes`;
CREATE TABLE `cmda_report_attributes` (
  `attribute_discription` varchar(100) DEFAULT NULL COMMENT '属性描述信息',
  `id` varchar(32) NOT NULL COMMENT '主键',
  `attribute_name` varchar(32) DEFAULT NULL COMMENT '属性名称',
  `is_standard_attribute` tinyint(4) DEFAULT NULL COMMENT '是否标准属性',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted_flag` tinyint(4) DEFAULT NULL COMMENT '是否可用，0可用，1不可用',
  `last_update_date` datetime DEFAULT NULL COMMENT '最新修改时间',
  `last_updated_by` varchar(32) DEFAULT NULL COMMENT '修改者',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报表属性集合表';
/**
 *
 */
public class TestInterfacePara {

	interface Extendbroadable {
		public void inPut();
	}

	static class KeyBroad implements Extendbroadable {

		@Override
		public void inPut() {
			// TODO Auto-generated method stub
			System.out
					.println("this is KeyBroad class, implements Extendbroadable");
		}
	}

	static class NetCardBroad implements Extendbroadable {

		@Override
		public void inPut() {
			// TODO Auto-generated method stub
			System.out
					.println("this is NetBroad class, implements Extendbroadable");
		}

	}

	static class CheckBroad {
		public void getMainMessage(Extendbroadable ext) {
			ext.inPut();
		}
	}
	public static void main(String []arg)  {
		KeyBroad kb=new KeyBroad();    
		NetCardBroad ncb=new NetCardBroad();    
		CheckBroad cb=new CheckBroad();    
		cb.getMainMessage(kb);    
		cb.getMainMessage(ncb); 
	}
}
