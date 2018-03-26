package com.flowergarden.run;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamWriter;

import org.codehaus.jettison.mapped.Configuration;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;

import com.flowergarden.json.Address;
import com.flowergarden.json.Customer;
import com.flowergarden.json.PhoneNumber;

public class RunJson {

	public static void main(String[] args) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(Customer.class);
		  
		        Unmarshaller unmarshaller = jc.createUnmarshaller();
		        Customer customer = (Customer) unmarshaller.unmarshal(new File("input.xml"));
		 
		        ArrayList<PhoneNumber> numbers = new ArrayList<PhoneNumber>();
		        numbers.add(new PhoneNumber("home", "555-123"));
		        
		        Customer customerJSON = new Customer(1, "First", "Last", 
		        		new Address("123 A Street"), numbers);
		        
		        
		        Configuration config = new Configuration();
		        MappedNamespaceConvention con = new MappedNamespaceConvention(config);
		        Writer writer = new OutputStreamWriter(System.out);
		        XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(con, writer);
		 
		        Marshaller marshaller = jc.createMarshaller();
		        marshaller.marshal(customerJSON, xmlStreamWriter);

	}

}
