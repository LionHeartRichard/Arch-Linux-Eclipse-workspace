package myparsing.global;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import myparsing.global.model.Building;

public class Main {

	public static void main(String[] args) throws IOException {

		String address = "";
		BigDecimal area = new BigDecimal(0);
		int year = 0;
		int level = 0;

		File file = new File("/home/kein/Downloads/test/test_data");
		FileInputStream fileInput = new FileInputStream(file);

		byte[] dataByteMas = new byte[(int) file.length()];
		fileInput.read(dataByteMas);
		String text = new String(dataByteMas);
		String[] rows = text.split("\n");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Building.class)
				.buildSessionFactory();
		try {
			for (String row : rows) {
				int count = 0;
				String[] words = row.split("\t");
				for (String word : words) {
					if (word.equals("—"))
						word = "0";
					if (word.equals("Москва"))
						continue;
					if (count == 1)
						address = word;
					if (count == 2)
						area = new BigDecimal(word);
					if (count == 3)
						year = Integer.parseInt(word);
					if (count == 4)
						level = Integer.parseInt(word);
					count++;
				}
				Building building = new Building(address, area, year, level);
				Session session = factory.getCurrentSession();
				try {
					session.getTransaction().begin();
					session.persist(building);
					session.getTransaction().commit();

				} finally {
					session.close();
				}
			}
		} finally {
			factory.close();
		}
	}

}
