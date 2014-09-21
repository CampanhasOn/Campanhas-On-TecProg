package controle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import parse.Parse;
import parse.ParseCampanha;

@WebServlet("/carregarParseCampanha")
public class LoadCampaignParse extends HttpServlet {
	
	/*
	 * Servlet to control the loading parse campaign
	 */

	// Attributes
	private static final long serialVersionUID = 5625867877274809499L;

	// Empty Constructor
	@Override
	public void init() throws ServletException {
		super.init();
	}

	// Other methods
	/*
	 * Method that makes the call load and parse controls its execution
	 * @param an HTTP request and HTTP response
	 */
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter output = response.getWriter();

		Part part = request.getPart("arquivo_linha_inicial");
		if(part != null) {
			Scanner scanner = new Scanner(part.getInputStream());
			output.println("linha inicial: " + scanner.nextLine());
			scanner.close();
		} try {
			boolean isMultpart = ServletFileUpload.isMultipartContent(request);			
			if(isMultpart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> fields = upload.parseRequest(request);

				FileItem file = null;
				int initialLine = 1;
				String fileType = "campaign";


				for(FileItem fileItem : fields) {
					if(!fileItem.isFormField()) 
						file = fileItem;
				}

				String division = ";";
				Parse parse = new ParseCampanha(fileType, "");
				parse.executarParse(file, division, initialLine);

				output.println("Parse Realizado com Sucesso!");
			}

		} catch(Exception e) {
			output.println("ERROR teste upload: " + e.getMessage());
		}
	}
}