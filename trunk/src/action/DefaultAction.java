package action;

import java.io.IOException;
import java.util.Properties;

import com.opensymphony.xwork2.ActionSupport;

public class DefaultAction extends ActionSupport {

	public DefaultAction() {
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("myapp.properties"));
			String modelDir = properties.getProperty("modelDir");
			System.out.println("modelDir:" + modelDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
