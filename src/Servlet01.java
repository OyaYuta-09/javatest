

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Bean;
import bean.Today;
import dao.Dao;

/**
 * Servlet implementation class Servlet01
 */
@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpSehttps://job.rikunabi.com/contents/entrysheet/3508/rvlet()
	 */
	public Servlet01() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String comment = request.getParameter("comment");
		if(name != null && comment != null) {
			HttpSession session = request.getSession();
			Today day = day();
			session.setAttribute("day", day);
			Dao.insert(day,name,comment);
			//insert文
		}

		HttpSession session = request.getSession();
		ArrayList<Bean> list = Dao.selectAllStudent();
		session.setAttribute("list",list);
		request.setAttribute("list", list);
		String view = "/WEB-INF/view/menu.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		//request.getSession();

		//session.setAttribute(引数);
		//if
		//insert

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
