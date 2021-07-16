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
