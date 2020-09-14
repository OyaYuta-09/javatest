import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.Bean;
import bean.Today;
import dao.Dao;

@WebServlet("/UploadServlet")
@MultipartConfig(maxFileSize=1048576*1024)  // 最大1M
public class UploadServlet extends HttpServlet {
  final File uploadDir = new File("C:\\pleiades\\workspace\\2020_Kadai09\\WebContent\\photo");  // ファイル保存先
  public void init() throws ServletException {
    uploadDir.mkdir();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String view = "/WEB-INF/view/menu.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		dispatcher.forward(request, response);
	}
  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
    // ファイルの保存 ->
    Part fPart = req.getPart("file");
    String fname = this.getFileName(fPart);
    String fName = (fPart.getSubmittedFileName()).toString();
    String name = req.getParameter("name");
    HttpSession session = req.getSession();
	Today day = day();
	System.out.println(fname);
	session.setAttribute("day", day);
	Dao.insert(day,name,fname);
	ArrayList<Bean> list = Dao.selectAllStudent();
	session.setAttribute("list",list);
    save(fPart, new File(uploadDir, fName));//
    doGet(req, res);

  }
  public void save(Part in, File out) throws IOException {
    BufferedInputStream br
      = new BufferedInputStream(in.getInputStream());
    try (BufferedOutputStream bw =
      new BufferedOutputStream(new FileOutputStream(out))
    ) {
      int len = 0;
      byte[] buff = new byte[1024];
      while ((len = br.read(buff)) != -1) {
        bw.write(buff, 0, len);
      }
    }
  }

  private String getFileName(Part part) {
      String name = null;
      for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
          if (dispotion.trim().startsWith("filename")) {
              name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
              name = name.substring(name.lastIndexOf("\\") + 1);
              break;
          }
      }
      return name;
  }

  public static Today day() {
		LocalDateTime d = LocalDateTime.now();

		String year = String.valueOf(d.getYear());
		String month = String.valueOf(d.getMonth());
		int day_int = d.getDayOfMonth();
		int hour_int = d.getHour();
		int minute_int = d.getMinute();
		int second_int = d.getSecond();
		String day = valof(day_int);
		String hour = valof(hour_int);
		String minute = valof(minute_int);
		String second = valof(second_int);


		if(month.equals("JANUARY")) {
			month = "01";
		} else if(month.equals("FEBRUARY")) {
			month = "02";
		} else if(month.equals("MARCH")) {
			month = "03";
		} else if(month.equals("APRIL")) {
			month = "04";
		} else if(month.equals("MAY")) {
			month = "05";
		} else if(month.equals("JUNE")) {
			month = "06";
		} else if(month.equals("JULY")) {
			month = "07";
		} else if(month.equals("AUGUST")) {
			month = "08";
		} else if(month.equals("SEPTEMBER")) {
			month = "09";
		} else if(month.equals("OCTOBER")) {
			month = "10";
		} else if(month.equals("NOVEMBER")) {
			month = "11";
		} else if(month.equals("DECEMBER")) {
			month = "12";
		}

		System.out.println(day);
		String today = year+month+day;
		String time = hour+minute+second;
		Today all = new Today(today,time);
		return all;
	}

	public static String valof(int a) {
		String day;
		if(a < 10) {
			day = String.valueOf(a);
			day = "0"+day;
		} else {
			day = String.valueOf(a);
		}
		return day;
	}
}