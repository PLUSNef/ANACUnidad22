package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.PersonDOM;
import model.Person;


/**
 * Servlet implementation class PersonController
 */
@WebServlet("/PersonController")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Person person;
       private List<Person> persons;
       private PersonDOM personDOM;
       private List<String> ids = new ArrayList<String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonController() {
        super();
        person = new Person();
        persons = new ArrayList<Person>();
        personDOM = new PersonDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn_save")!=null) {
			person.setName(request.getParameter("name"));
			person.setReport(request.getParameter("report"));
			person.setRelation(request.getParameter("relation"));
			
			/*if(person.getId()=="") {
				int id =1;
				String newId ="";
				for(Person s: persons) {
					newId = "ptr"+String.format("%03d", id++);
					if(!newId.equals(s.getId())){
						person.setId(newId);
						continue;
					}
				}*/
			
			if(person.getId()=="") {
				int id = 1;
				String newId = "ptr"+String.format("%03d",1);
				person.setId(newId);
				if(persons.size()>0) {
					ids.clear();
					for(Person s: persons) {
						ids.add(s.getId());
					}
					for(int i=0; i<ids.size(); i++) {
						newId = "ptr"+String.format("%03d",i+1);
						if(!ids.contains(newId)) {
							person.setId(newId);
							break;
						}
					}
				}
		
				
		
				personDOM.add(person);
			}else {
				personDOM.update(person);
			}
			persons = personDOM.getPersons();
			request.setAttribute("persons", persons);
			request.getRequestDispatcher("person_to_report_list.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_new")!= null) {
			person = new Person();
			request.getRequestDispatcher("person_to_report_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				String id = request.getParameter("id");
				person = personDOM.findById(id);
			}catch(Exception e) {
				person = new Person();
			}
			request.setAttribute("person", person);
			request.getRequestDispatcher("person_to_report_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!= null){
			try {
				String id = request.getParameter("id");
				personDOM.delete(id);
				persons = personDOM.getPersons();
			}catch(Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("persons", persons);
			request.getRequestDispatcher("person_to_report_list.jsp").forward(request, response);
		}else {
			persons = personDOM.getPersons();
			request.setAttribute("persons", persons);
			request.getRequestDispatcher("person_to_report_list.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
