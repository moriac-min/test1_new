package foodportal.front.support;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import abc.cms.model.ThemeSourceResolver;

@Component
public class DefaultThemeSourceResolver implements ThemeSourceResolver {
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public Resource getThemeXml(String themeId) {
		return new FileSystemResource(servletContext.getRealPath("") + "/themes/" + themeId + ".xml");
	}

	@Override
	public String[] getAllThemeIds() {
		return new String[] {"default"};
	}

	@Override
	public String getResourcePath(String themeId) {
		return "/WEB-INF/jsp/";
	}
	
}
