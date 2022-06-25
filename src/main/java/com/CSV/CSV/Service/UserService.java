package com.CSV.CSV.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CSV.CSV.Model.User;
import com.CSV.CSV.Repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	ArrayList<User> list= new ArrayList<User>();


	public void readDataFromFile() throws IOException {



		String line="";
		try {
			int i=0;
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/chaudhary/Downloads/faisal.csv"));
			while((line=br.readLine())!=null) {
				if(i!=0) {
					String [] data =line.split(",");
					User user = new User();
					user.setFirstName(data[0]);
					user.setLastName(data[1]);
					user.setRollNo(data[2]);
					userRepository.save(user);
					System.out.println(user);

				}
				i++;

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	// sir check this also ---------------why its not working



	public void writeEmployeesToCsv(Writer writer) {
		list  = (ArrayList<User>) userRepository.findAll();
		try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			for (User u : list) {
				csvPrinter.printRecord(u.getId(), u.getFirstName(), u.getLastName(), u.getRollNo());
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}


	//-------------------------------------------------------------------
	public void file() {
		File file = new File("C:/Users/chaudhary/Desktop/text file/faisal.txt"); 
		list  = (ArrayList<User>) userRepository.findAll();

		try {
			file.createNewFile();
			System.out.println("file created" + file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try{    
			FileWriter fw=new FileWriter("C:/Users/chaudhary/Desktop/text file/faisal.txt");    
			for(User u: list) {
				fw.write(u.getId()+","+u.getFirstName()+","+u.getLastName()+","+u.getRollNo() + System.lineSeparator());
			}    
			fw.close();    
		}catch(Exception e){System.out.println(e);}    
		System.out.println("Success...");    
	}    

}





