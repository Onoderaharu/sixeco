/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.freeter.common.utils;

/**
 * 常量
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2016-11-15
 */
public class Constant {

	/** 超级管理员ID */
	public static final int SUPER_ADMIN = 1;
	/** 数据权限过滤 */
	public static final String SQL_FILTER = "sql_filter";

	public static String USERNAME;

	/**
	 * 秒杀
	 */
	public static Integer ACTIVITY_TYPE_S = 2;

	/**
	 * 团购
	 */
	public static Integer ACTIVITY_TYPE_B = 3;

	/**
	 * 秒杀活动未开始状态
	 */
	public static final Integer SECKILL_STATE_BEFORE = 0;

	/**
	 * 秒杀活动开始状态
	 */
	public static final Integer SECKILL_STATE_START = 1;
	/**
	 * 秒杀活动结束状态
	 */
	public static final Integer SECKILL_STATE_END = 2;

	/**
	 * 上架
	 */
	public static final Integer SHELVE_UP = 1;

	/**
	 * 下架
	 */
	public static final Integer SHELVE_DOWN = 0;

	public static final String COMMON_NULL = "null";

	/** 通用 -是 - 1 **/
	public static final int COMMON_YES = 1;
	
	 /** itemLevel1Name */
    public static final String ITEM_LEVEL1_NAME = "itemLevel1Name";
    /** itemLevel2Name */
    public static final String ITEM_LEVEL2_NAME = "itemLevel2Name";
    /** itemLevel3Name */
    public static final String ITEM_LEVEL3_NAME = "itemLevel3Name";
    /** itemLevel4Name */
    public static final String ITEM_LEVEL4_NAME = "itemLevel4Name";
    /** itemLevel5Name */
    public static final String ITEM_LEVEL5_NAME = "itemLevel5Name";
    /** itemLevel6Name */
    public static final String ITEM_LEVEL6_NAME = "itemLevel6Name";
    /** itemLevel7Name */
    public static final String ITEM_LEVEL7_NAME = "itemLevel7Name";
    /** level1Type */
    public static final String LEVEL1_TYPE = "level1Type";
    /** level2Type */
    public static final String LEVEL2_TYPE = "level2Type";
    /** level3Type */
    public static final String LEVEL3_TYPE = "level3Type";
    /** level4Type */
    public static final String LEVEL4_TYPE = "level4Type";
    /** level5Type */
    public static final String LEVEL5_TYPE = "level5Type";
    /** level6Type */
    public static final String LEVEL6_TYPE = "level6Type";
    /** level7Type */
    public static final String LEVEL7_TYPE = "level7Type";

	/**
	 * 菜单类型
	 */
	public enum MenuType {
		/**
		 * 目录
		 */
		CATALOG(0),
		/**
		 * 菜单
		 */
		MENU(1),
		/**
		 * 按钮
		 */
		BUTTON(2);

		private int value;

		MenuType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * 定时任务状态
	 */
	public enum ScheduleStatus {
		/**
		 * 正常
		 */
		NORMAL(0),
		/**
		 * 暂停
		 */
		PAUSE(1);

		private int value;

		ScheduleStatus(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * 云服务商
	 */
	public enum CloudService {
		/**
		 * 七牛云
		 */
		QINIU(1),
		/**
		 * 阿里云
		 */
		ALIYUN(2),
		/**
		 * 腾讯云
		 */
		QCLOUD(3);

		private int value;

		CloudService(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

}
