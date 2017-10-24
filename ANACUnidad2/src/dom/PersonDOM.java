package dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Person;


public class PersonDOM {
	private String pathFile = "C:\\Users\\Texas\\eclipse-workspace\\ANACUnidad2\\src\\data\\persons.xml";
	public void add(Person data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			Element persons = document.getDocumentElement();
			//create person tag
			Element person = document.createElement("person");
			//create id tag
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			person.appendChild(id);
			//create name tag
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(data.getName()));
			person.appendChild(name);
			//create report tag
			Element report = document.createElement("report");
			report.appendChild(document.createTextNode(data.getReport()));
			person.appendChild(report);
			//create relation tag
			Element relation = document.createElement("relation");
			relation.appendChild(document.createTextNode(data.getRelation()));
			person.appendChild(relation);
			persons.appendChild(person);
			DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("person");
			for(int i=0; i < nodeList.getLength(); i++) {
				Element person = (Element)nodeList.item(i);
				if(person.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					person.getParentNode().removeChild(person);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void update(Person data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("person");
			for(int i=0; i < nodeList.getLength(); i++) {
				Element person = (Element)nodeList.item(i);
				if(person.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					person.getElementsByTagName("name").item(0).setTextContent(data.getName());
					person.getElementsByTagName("report").item(0).setTextContent(data.getReport());
					person.getElementsByTagName("relation").item(0).setTextContent(data.getRelation());
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Person findById(String id) {
		Person person = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("person");
			for(int i=0; i < nodeList.getLength(); i++) {
				Element s = (Element)nodeList.item(i);
				if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					person = new Person();
					person.setId(id);
					person.setName(s.getElementsByTagName("name").item(0).getTextContent());
					person.setReport(s.getElementsByTagName("report").item(0).getTextContent());
					person.setRelation(s.getElementsByTagName("relation").item(0).getTextContent());
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	public List<Person> getPersons(){
		List<Person> persons = new ArrayList<Person>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList = document.getElementsByTagName("person");
		for(int i=0; i < nodeList.getLength(); i++) {
			Element s = (Element)nodeList.item(i);
			Person person = new Person();
			
				person = new Person();
				person.setId(s.getElementsByTagName("id").item(0).getTextContent());
				person.setName(s.getElementsByTagName("name").item(0).getTextContent());
				person.setReport(s.getElementsByTagName("report").item(0).getTextContent());
				person.setRelation(s.getElementsByTagName("relation").item(0).getTextContent());
				persons.add(person);
			
		}
		return persons;
	}
}
