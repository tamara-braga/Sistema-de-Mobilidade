package com.example;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInitialRoutes {
    public static void main(String[] args) {
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyHandler());
            xmlReader.parse("your_network_file.xml");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private FileWriter writer;
        private Random random = new Random();

        @Override
        public void startDocument() {
            try {
                writer = new FileWriter("map.rou.xml");
                writer.write("<routes>\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void endDocument() {
            try {
                writer.write("</routes>\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("edge")) {
                try {
                    int vehicleId = random.nextInt(900) + 1;
                    writer.write(String.format(
                            "    <vehicle id='vehicle%d' depart='%d' from='%s' to='%s'/>\n",
                            vehicleId, vehicleId * 2, attributes.getValue("id"), attributes.getValue("id")
                    ));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

