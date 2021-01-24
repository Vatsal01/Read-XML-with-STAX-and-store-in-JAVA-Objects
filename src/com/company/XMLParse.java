package com.company;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class XMLParse {

    public static void main(String[] args) {
        String fileName = "PersonalDet.xml";
       List<PersonalDetails> empList = parse(fileName);
        for (PersonalDetails emp : empList) {
            System.out.println(emp.toString());
        }
    }

    private static List<PersonalDetails> parse(String fileName){
        List<PersonalDetails> empList = new ArrayList<>();
        PersonalDetails emp = null ;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
                XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
                while (xmlEventReader.hasNext()) {
                    XMLEvent xmlEvent = xmlEventReader.nextEvent();
                    // Characters element = (Characters) xmlEvent;
                    if (xmlEvent.isStartElement()) {
                        StartElement startElement = xmlEvent.asStartElement();

                        if (startElement.getName().getLocalPart().equals("Detail")) {
                            emp = new PersonalDetails();

                            Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                            if (idAttr != null) {
                                emp.setId(Integer.parseInt(idAttr.getValue()));
                            }
                        } else if (xmlEvent.isStartElement()) {

                            if (startElement.getName().getLocalPart().equals("name")) {

                                   xmlEvent = xmlEventReader.nextEvent();
                                       emp.setName(xmlEvent.asCharacters().getData());

                            } else if (startElement.getName().getLocalPart().equals("surname")) {
                                xmlEvent = xmlEventReader.nextEvent();
                                emp.setSurname(xmlEvent.asCharacters().getData());
                            } else if (startElement.getName().getLocalPart().equals("homeaddress")) {
                                xmlEvent = xmlEventReader.nextEvent();
                                emp.setHomeaddresss(xmlEvent.asCharacters().getData());
                            } else if (startElement.getName().getLocalPart().equals("contact")) {
                                xmlEvent = xmlEventReader.nextEvent();
                                emp.setContact(xmlEvent.asCharacters().getData());
                            } else if (startElement.getName().getLocalPart().equals("job")) {
                                xmlEvent = xmlEventReader.nextEvent();
                                emp.setJob(xmlEvent.asCharacters().getData());
                            }

                            if (xmlEvent.isEndElement()) {
                                EndElement endElement = xmlEvent.asEndElement();
                                if (endElement.getName().getLocalPart().equals("Detail")) {
                                    empList.add(emp);
                                }
                            }
                        }

                    }

                }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
       catch (NullPointerException e)
             { e.printStackTrace();}
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }

    return empList;

    }
}