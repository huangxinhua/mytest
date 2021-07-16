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
