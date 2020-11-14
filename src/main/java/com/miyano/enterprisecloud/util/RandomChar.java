package com.miyano.enterprisecloud.util;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

/**
 * @author TeacherXue@isoftstone.com
 * @date 2018年8月13日 上午10:39:15
 * @file com.issCollege.util RandomChar.java
 * @version V1.0
 */
public class RandomChar {

	/**
	 * 获得随机的字符串
	 * 
	 * @param ln
	 *            字符串长度
	 * @param type
	 *            1 大写 2小写 3数字
	 * @return 随机字符串
	 */
	/*public static String getRandomChar(int ln, int type) {
		StringBuilder rt = new StringBuilder();
		switch (type) {
		case 1:
			for (int i = 0; i < ln; i++) {
				rt.append((char) ((int) (Math.random() * 26) + 65));
			}
			break;
		case 2:
			for (int i = 0; i < ln; i++) {
				rt.append((char) ((int) (Math.random() * 26) + 97));
			}
			break;
		case 3:
			for (int i = 0; i < ln; i++) {
				rt.append((char) ((int) (Math.random() * 10) + 48));
			}
			break;
		default:
			System.out.println("无此操作");
		}
		return rt.toString();
	}*/

	/**
	 * 获得不重复的随机字符串
	 * 
	 * @param ln
	 * @param type
	 * @return
	 */
	public static String getRandomCharNoRepeat(int ln, int type) {
		HashSet<String> set = new HashSet<String>();
		StringBuilder rt = new StringBuilder();
		switch (type) {
		case 1:
			while(set.size()<ln) {
				set.add((char) ((int) (Math.random() * 26) + 65) + "");
			}
			break;
		case 2:
			while(set.size()<ln) {
				set.add((char) ((int) (Math.random() * 26) + 97) + "");
			}
			break;
		case 3:
			while(set.size()<ln) {
				set.add((char) ((int) (Math.random() * 10) + 48) + "");
			}
			break;
		default:
			System.out.println("无此操作");
		}
		for (String string : set) {
			rt.append(string);
		}
		return rt.toString();
	}
	
	
	/**
	 * 
	 * @param ln
	 *            长度
	 * @param type
	 *            1大写 2小写 3数字
	 * @return
	 */
	public static String getRandomChar(int ln, int type) {
		String result = "";
		Random rd = new Random();
		switch (type) {
		case 1:
			for (int i = 0; i < ln; i++) {
				result += (char) (rd.nextInt(26) + 65);
			}
			break;
		case 2:
			for (int i = 0; i < ln; i++) {
				result += (char) (rd.nextInt(26) + 97);
			}
		case 3:
			for (int i = 0; i < ln; i++) {
				result += rd.nextInt(10);
			}
			break;

		default:
			break;
		}

		return result;
	}

	/**
	 * 获得指定长度的随机汉字
	 * @param ln 字符数量
	 * @return
	 */
	public static String getRandomSC(int ln) {
		String result="";
		for(int i=0;i<ln;i++) {
			result+=(char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
		}
		return result;
	}
	
	/**
	 * 获得随机的性别
	 * @return
	 */
	public static String getRandomSex(){
		Random random = new Random();
		String sex=random.nextBoolean()?"男":"女";
		return sex;
		
	}
	
	/**
	 * 传入指定的开始日期到结束日期的字符串值，得到指定范围内的随机日期
	 * @param beginDate  yyyy-MM-dd
	 * @param endDate	yyyy-MM-dd
	 * @return
	 */
	public static Date randomDate(String beginDate,String  endDate ){  

		try {  

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  

		Date start = format.parse(beginDate);//构造开始日期  

		Date end = format.parse(endDate);//构造结束日期  

		//getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。  

		if(start.getTime() >= end.getTime()){  

		return null;  

		}  

		long date = random(start.getTime(),end.getTime());  

		return new Date(date);  

		} catch (Exception e) {  

		e.printStackTrace();  

		}  

		return null;  

		}  

		private static long random(long begin,long end){  

		long rtn = begin + (long)(Math.random() * (end - begin));  

		//如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  

		if(rtn == begin || rtn == end){  

		return random(begin,end);  

		}  

		return rtn;  

		}  
		
		
		/**
		 * 获得随机的中文
		 * @return
		 */
		public static String getXingshi(){
		String xing="赵 钱 孙 李 周 吴 郑 王 冯 陈 楮 卫 蒋 沈 韩 杨 朱 秦 尤 许 何 吕 施 张 孔 曹 严 华 "
					+ "金 魏 陶 姜 戚 谢 邹 喻 柏 水 窦 章 云 苏 潘 葛 奚 范 彭 郎 鲁 韦 昌 马 苗 凤 花 方俞 任 "
					+ "袁 柳 酆 鲍 史 唐 费 廉 岑 薛 雷 贺 倪 汤 滕 殷 罗 毕 郝 邬 安 常 乐 于 时 傅 皮 卞 齐 康 "
					+ "伍 余 元 卜 顾 孟 平 黄 和 穆 萧 尹 姚 邵 湛 汪 祁 毛 禹 狄 米 贝 明 臧 计 伏 成 戴 谈 宋 "
					+ "茅 庞 熊 纪 舒 屈 项 祝 董 梁 杜 阮 蓝 闽 席 季 麻 强 贾 路 娄 危 江 童 颜 郭 梅 盛 林 刁 "
					+ "锺 徐 丘 骆 高 夏 蔡 田 樊 胡 凌 霍 虞 万 支 柯 昝 管 卢 莫 经 房 裘 缪 干 解 应 宗 丁 宣 "
					+ "贲 邓 郁 单 杭 洪 包 诸 左 石 崔 吉 钮 龚 程 嵇 邢 滑 裴 陆 荣 翁 荀 羊 於 惠 甄 麹 家 封 "
					+ "芮 羿 储 靳 汲 邴 糜 松 井 段 富 巫 乌 焦 巴 弓 牧 隗 山 谷 车 侯 宓 蓬 全 郗 班 仰 秋 仲 "
					+ "伊 宫宁 仇 栾 暴 甘 斜 厉 戎 祖 武 符 刘 景 詹 束 龙 叶 幸 司 韶 郜 黎 蓟 薄 印 宿 白 怀 "
					+ "蒲 邰 从 鄂 索 咸 籍 赖 卓 蔺 屠 蒙 池 乔 阴 郁 胥 能 苍 双 闻 莘 党 翟 谭 贡 劳 逄 姬 申 "
					+ "扶 堵 冉 宰 郦 雍 郤 璩 桑 桂 濮 牛 寿 通 边 扈 燕 冀 郏 浦 尚 农 温 别 庄 晏 柴 瞿 阎 充 "
					+ "慕 连 茹 习 宦 艾 鱼 容 向 古 易 慎 戈 廖 庾 终 暨 居 衡 步 都 耿 满 弘 匡 国 文 寇 广 禄 "
					+ "阙 东 欧 殳 沃 利 蔚 越 夔 隆 师 巩 厍 聂 晁 勾 敖 融 冷 訾 辛 阚 那 简 饶 空 曾 毋 沙 乜 "
					+ "养 鞠 须 丰 巢 关 蒯 相 查 后 荆 红 游 竺 权 逑 盖 益 桓 公 万俟 司马 上官 欧阳 夏侯 诸葛 "
					+ "闻人 东方 赫连 皇甫 尉迟 公羊 澹台 公冶 宗政 濮阳 淳于 单于 太叔 申屠 公孙 仲孙 轩辕 令狐 "
					+ "锺离 宇文 长孙 慕容 鲜于 闾丘 司徒 司空 丌官 司寇 仉 督 子车 颛孙 端木 巫马 公西 漆雕 乐正 "
					+ "壤驷 公良 拓拔 夹谷 宰父 谷梁 晋 楚 阎 法 汝 鄢 涂 钦 段干 百里 东郭 南门 呼延 归 海 羊舌 微生 "
					+ "岳 帅 缑 亢 况 后 有 琴 梁丘 左丘 东门 西门 商 牟 佘 佴 伯 赏 南宫 墨 哈 谯 笪 年 爱 阳 佟";
			String[] s = xing.split(" ");
//			System.out.println("百家姓长度："+s.length);
			Random r = new Random();
			return s[r.nextInt(s.length)];
		}

}
