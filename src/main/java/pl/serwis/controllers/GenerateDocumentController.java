package pl.serwis.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lowagie.text.DocumentException;

import pl.serwis.service.GenerateConfirmationPDF;

@Controller
public class GenerateDocumentController {

	@Autowired
	GenerateConfirmationPDF service;
	
	@RequestMapping("/serwis/generate")
	public void generatePDF(HttpServletResponse response) throws IOException
	{
		
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\plikPDF.pdf");
        InputStream in = new FileInputStream(file);
		
		response.setContentType("pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());

	}
	@RequestMapping(value = "/serwis/generate/{id}", method=RequestMethod.GET)
	public void TransactionDetails(ModelMap model, @PathVariable String id, HttpServletResponse response) throws IOException, NumberFormatException, DocumentException
	{
		service.GenerateAndDownloadRaport(Long.valueOf(id), response);
		
		
		
	}
	
	
}
