package com.blackrook.small.views.mustache;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackrook.small.exception.views.ViewProcessingException;
import com.blackrook.small.roles.ViewDriver;
import com.blackrook.small.util.SmallUtils;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheException;
import com.github.mustachejava.MustacheFactory;


/**
 * The Mustache View Driver for Small.
 * @author Matthew Tropiano
 */
public abstract class MustacheViewDriver implements ViewDriver
{
	private final MustacheFactory mustacheFactory; 
	/** The forced output MIME-Type. */
	private String mimeType;
	
	/**
	 * Creates a Mustache View Driver using the provided MustacheFactory.
	 * @param mustacheFactory the factory to use for the Mustache driver.
	 */
	public MustacheViewDriver(MustacheFactory mustacheFactory)
	{
		this.mustacheFactory = mustacheFactory;
		this.mimeType = null;
	}
	
	/**
	 * Creates a new {@link DefaultMustacheFactory} using a file root.
	 * The root file should be a directory containing your Mustache templates.
	 * @param root the file root.
	 * @return the created factory.
	 */
	public static DefaultMustacheFactory createFileMustacheFactory(File root)
	{
		return new DefaultMustacheFactory(root);
	}
	
	/**
	 * Creates a new {@link DefaultMustacheFactory} using a class path root.
	 * The root should be a directory containing your Mustache templates.
	 * @param classPathRoot the class path root.
	 * @return the created factory.
	 */
	public static DefaultMustacheFactory createClasspathMustacheFactory(String classPathRoot)
	{
		return new DefaultMustacheFactory(classPathRoot);
	}
	
	/**
	 * Sets the forced MIME-Type.
	 * @param mimeType the forced MIME-type for the output.
	 */
	public void setMimeType(String mimeType)
	{
		this.mimeType = mimeType;
	}
	
	/**
	 * Checks if this handler should process a view by its view name.
	 * If false is returned, this view driver is skipped.
	 * @param viewName the name of the view to process.
	 * @return true if so, false if not.
	 */
	protected abstract boolean acceptViewName(String viewName);
	
	@Override
	public boolean handleView(HttpServletRequest request, HttpServletResponse response, Object model, String viewName) throws ViewProcessingException
	{
		if (!acceptViewName(viewName))
			return false;

		String mime = mimeType != null ? mimeType : SmallUtils.getMIMEType(request.getServletContext(), viewName);
		try {
			Mustache mustache = mustacheFactory.compile(viewName);
			response.setContentType(mime);
			mustache.execute(response.getWriter(), model);
			return true;
		} catch (IOException e) {
			throw new ViewProcessingException("I/O error occurred!", e);
		} catch (MustacheException e) {
			throw new ViewProcessingException("Mustache error occurred!", e);
		}
	}


}
