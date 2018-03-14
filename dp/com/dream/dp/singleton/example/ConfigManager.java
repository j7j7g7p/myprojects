package com.dream.dp.singleton.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigManager {
	/**
	 * 属性文件全名
	 * D:\workspace\section2\designpattern
	 */
	private static final String PFILE = System.getProperty("user.dir")
			+File.separator+"config/singleton.properties";
	/**
	 * 对应属性文件的文件的对象
	 */
	private File m_file = null;
	/**
	 * 属性文件的最后修改时间
	 */
	private long m_lastModifiedTime = 0;
	/**
	 * 属性文件对应的属性对象
	 */
	private Properties m_properties = null;
	/**
	 * 唯一实例
	 */
	private static ConfigManager m_instance = new ConfigManager();
	/**
	 * 私有化构造子
	 */
	private ConfigManager(){
		m_file = new File(PFILE);
		m_lastModifiedTime = m_file.lastModified();
		if(m_lastModifiedTime == 0)
			new Exception("file not exists!");
		m_properties = new Properties();
		try {
			m_properties.load(new FileInputStream(PFILE));
		} catch (IOException e) {
			System.err.println("File not exist！");
			e.printStackTrace();
		}
	}
	/**
	 * 静态工厂
	 * @return ConfigManager的单一实例
	 */
	public synchronized static ConfigManager getInstance(){
		return m_instance;
	}
	/**
	 * 读取一个特定的属性项
	 * @param 属性项的项名
	 * @param defaultVal，属性项的默认值
	 * @return 属性项的属性值（存在），默认值（如果属性项不存在）
	 */
	public final Object getConfigItem(String name,String defaultVal){
		long newtime = m_file.lastModified();
		if(newtime == 0){
			new Exception("file not exists!");
			if(m_lastModifiedTime == 0)
				System.out.println("file not exists!");
			else
				System.out.println("file is deleted!");
			return defaultVal;
		}else if (newtime > m_lastModifiedTime) {
			m_properties.clear();
			try {
				m_properties.load(new FileInputStream(PFILE));
				m_lastModifiedTime = m_file.lastModified();
			}catch (IOException e) {
				e.printStackTrace();
			}
			return m_properties.getProperty(name, defaultVal);
		}
		return m_properties.getProperty(name, defaultVal);
	}
	public static void main(String[] args) throws IOException {
		System.out.println(PFILE);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("type quit to quit!");
		do {
			System.out.println("Properties item to read:");
			String line = reader.readLine();
			if (line.equals("quit")) {
				break;
			}
			System.out.println(ConfigManager.getInstance().getConfigItem(line, "Not found"));
		} while (true);
	}
}
