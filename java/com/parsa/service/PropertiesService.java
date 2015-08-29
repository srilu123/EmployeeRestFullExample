/**
 * 
 */
package com.parsa.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ramesh
 *
 */
public class PropertiesService {

	public Properties getProperties() {
		Properties prop = new Properties();
		FileInputStream input = null;
		try {
			input = new FileInputStream(
					"H:\\rest_projects\\RESTfulExample\\src\\main\\resources\\config.properties");
			prop.load(input);
		} catch (IOException e) {
			System.out.println("Could not read properties file"
					+ e.getMessage());
		}
		return prop;
	}
}
