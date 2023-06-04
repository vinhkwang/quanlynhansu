package com.dmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.dmt.*")
public class ApplicationContextConfig {

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/body");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
//		bundleMessageSource.setBasename("classpath:messages");
//		bundleMessageSource.setDefaultEncoding("utf-8");
//		return bundleMessageSource;
//	}

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=QuanLyKaraoke");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("Password.1");
//		return dataSource;
//	}

//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		return new JdbcTemplate(dataSource());
//	}

//	@Bean
//	public JavaMailSender getMailSender() {
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		// using gmail
//		mailSender.setHost("smtp.gmail.com");
//		mailSender.setPort(587);
//		mailSender.setUsername("shopkikiki123@gmail.com\r\n" + "");
//		mailSender.setPassword("nfalgksswonqlpid\r\n" + "");
//		mailSender.setDefaultEncoding("utf-8");
//		Properties jaProperties = new Properties();
//		jaProperties.put("mail.smtp.starttls.enable", "true");
//		jaProperties.put("mail.smtp.auth", "true");
//		jaProperties.put("mail.transport", "smtp");
//		jaProperties.put("mail.debug", "true");
//		mailSender.setJavaMailProperties(jaProperties);
//		return mailSender;
//	}

//	@Bean(name = "tilesConfigurer")
//	public TilesConfigurer getTilesConfigurer() {
//		TilesConfigurer tilesConfigurer = new TilesConfigurer();
//
//		// TilesView 3
//		tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
//
//		return tilesConfigurer;
//	}

}