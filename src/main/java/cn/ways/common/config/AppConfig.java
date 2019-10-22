package cn.ways.common.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhangtengchen
 * @Date: 2019/10/21 17:09
 */
@Configuration
public class AppConfig {
	@ApolloConfig(value = "application")
	private Config config;
	@ApolloConfig("logConfig")
	private Config logConfig;

	@Value("${logging.level.root}")
	private String level;

	@Autowired
	private LoggingSystem loggingSystem;

	public String getKey(){
		String defaultValue = config.getProperty("test.key", "defaultValue");
		System.out.println("defaultValue = " + defaultValue);
		return defaultValue;
	}

	public String getLoggerLevel(){
		String info = logConfig.getProperty("logging.level.root", "INFO");
		System.out.println("level = " + info);
		return info;
	}

	@ApolloConfigChangeListener("logConfig")
	private void logLevelOnChange(ConfigChangeEvent changeEvent) {
		if(changeEvent.isChanged("logging.level.root")){
			System.out.println("beforeLevel = " + level);
			level=logConfig.getProperty("logging.level.root","INFO");
			System.out.println("afterLevel = " + level);
		}
	}

	private void refreshLoggingLevels(String newlevel) {
		if(!newlevel.equals(level)){
			LogLevel levelEnum = LogLevel.valueOf(newlevel.toUpperCase());
			loggingSystem.setLogLevel("",levelEnum);
		}
	}
}
