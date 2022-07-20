//package com.pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;


 class QuestionBank {
	//question id, question description, academic year(s) and concept 
	private int questionId;
	private String questionDescription;
	private String academicYears;
	private String concept;
	

	public QuestionBank(int questionId, String questionDescription, String academicYears, String concept) {
		super();
		this.questionId = questionId;
		this.questionDescription = questionDescription;
		this.academicYears = academicYears;
		this.concept = concept;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getAcademicYears() {
		return academicYears;
	}

	public void setAcademicYears(String academicYears) {
		this.academicYears = academicYears;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	@Override
	public String toString() {
		return "QuestionBank [questionId=" + questionId + ", questionDescription=" + questionDescription
				+ ", academicYears=" + academicYears + ", concept=" + concept + "]";
	}
}


public class Program {
	private static Scanner sc = new Scanner(System.in);

	private static int menuList() {
		System.out.println("---------------------------------------------------------------------------------------");		
		System.out.println("0.Exit");
		System.out.println("1.Retrieves questions for a given year");
		System.out.println("2.Retrieves the concept having maximum questions in the question bank");
		System.out.print("Enter choice : ");
		return sc.nextInt();
	}

	public static ArrayList<QuestionBank> setAllQuestionInfo(){
		ArrayList<QuestionBank> list = new ArrayList<QuestionBank>();
		list.add(new QuestionBank(1, "Which orientation of an electric dipole in a uniform electric field would correspond to stable equilibrium ?", "2018, 2020", "Electric Charges and Fields"));
		list.add(new QuestionBank(2, "If the radius of the Gaussian surface enclosing a charge is halved, how does the electric flux through the Gaussian surface change ?", "2019, 2021", "Gaussian surface"));
		list.add(new QuestionBank(3, "Define the term electric dipole moment of a dipole. State its S.I. unit", "2016, 2020", "Electric dipole"));
		list.add(new QuestionBank(4, "In which orientation, a dipole placed in a uniform electric field is in unstable equilibrium ?", "2014, 2018, 2020", "Electric dipole"));
		list.add(new QuestionBank(5, "Why should electrostatic field be zero inside a conductor?", "2012, 2019", "Electrostatic field"));
		list.add(new QuestionBank(6, "Why must electrostatic field be normal to the surface at every point of a charged conductor?", "2012, 2018, 2021", "Electrostatic field"));
		list.add(new QuestionBank(7, "A charge ‘q’ is placed at the centre of a cube of side l. What is the electric flux passing through each face of the cube? (All India 2012)", "2015, 2020", "Electric flux"));
		list.add(new QuestionBank(8, "Depict the direction of the magnetic field lines due to a circular current carrying loop.", "2012, 2022", "Magnetic field"));
		list.add(new QuestionBank(9, "Why do the electric field lines not form closed loops?", "2013, 2015, 2020", "Electrostatic field"));
		list.add(new QuestionBank(10, "Is the electric field due to a charge configuration with total charge zero, necessarily zero? ", "2019, 2021", "Electrostatic field"));			
		return list;
	}
	
	public static void retriveQuestionForYear(ArrayList<QuestionBank> lt) {
		System.out.print("Enter year : ");
		String year = sc.next();
		ArrayList<String> list = new ArrayList<String>();
		for (QuestionBank str : lt) {
			if(str.getAcademicYears().contains(year)) {
				list.add(str.getQuestionId()+ ". " + str.getQuestionDescription());
			}
		}
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	public static void retriveConceptMaxQue(ArrayList<QuestionBank> lt) {
		TreeSet<String> set = new TreeSet<String>();
		for (QuestionBank qb : lt) {
			set.add(qb.getConcept());
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int count = 0;
		for (String s : set) {
			count = 0;
			for (QuestionBank qb : lt) {
				if(qb.getConcept().equalsIgnoreCase(s)) {
					count = count + 1;
				}
			}
			map.put(s, count);
		}
		String concept = null;
		int num = 0;
		for ( Entry<String, Integer> maps : map.entrySet()) {
			if(concept == null) {
				concept = maps.getKey();
				num = maps.getValue();
			}else {
				int n = maps.getValue();
				if(num < n) {
					concept = maps.getKey();
					num = maps.getValue();
				}
			}
		}
		System.out.println("The concept having maximum questions in the question bank : "+concept);
	}
	
	public static void main(String[] args) {
		ArrayList<QuestionBank> list = Program.setAllQuestionInfo();
		int choice;
		
		while( ( choice = Program.menuList( ) ) != 0 ) { 
			switch( choice ) { 
			case 1: 
				retriveQuestionForYear(list); 
				break;
			case 2: 
				retriveConceptMaxQue(list); 
				break;
			}
		}
	}
}
